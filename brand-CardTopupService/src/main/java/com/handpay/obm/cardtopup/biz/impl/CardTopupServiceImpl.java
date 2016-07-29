/*
 * @(#)CardTopupServiceImpl.java        1.0 2016-1-29
 *
 * Copyright (c) 2007-2016 Shanghai Handpay IT, Co., Ltd.
 * 16/F, 889 YanAn Road. W., Shanghai, China
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * Shanghai Handpay IT Co., Ltd. ("Confidential Information").  
 * You shall not disclose such Confidential Information and shall use 
 * it only in accordance with the terms of the license agreement you 
 * entered into with Handpay.
 */

package com.handpay.obm.cardtopup.biz.impl;

import static com.handpay.obm.cardtopup.cache.CacheConstant.ONE_DAY;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.dubbo.config.annotation.Reference;
import com.google.common.collect.Lists;
import com.handpay.card.core.dubbo.service.ICardDubboClientService;
import com.handpay.card.core.service.CardException;
import com.handpay.card.core.service.bean.CardInfoBean;
import com.handpay.card.core.service.bean.MdseOrderReqBean;
import com.handpay.card.core.service.bean.MdseOrderResBean;
import com.handpay.core.common.util.DateUtils;
import com.handpay.core.common.util.MD5;
import com.handpay.framework.cache.client.exception.CacheClientException;
import com.handpay.framework.cache.client.executor.CacheExecutor;
import com.handpay.obm.cardtopup.bean.CardTopupReq;
import com.handpay.obm.cardtopup.bean.CardTopupRes;
import com.handpay.obm.cardtopup.bean.WaitTopupOrder;
import com.handpay.obm.cardtopup.biz.ICardTopupService;
import com.handpay.obm.cardtopup.domain.TopupCard;
import com.handpay.obm.cardtopup.domain.TopupMdse;
import com.handpay.obm.cardtopup.domain.TopupOrder;
import com.handpay.obm.cardtopup.enums.TopupMdseStatus;
import com.handpay.obm.cardtopup.enums.TopupOrderTstep;
import com.handpay.obm.cardtopup.exception.CardTopupErrorCodes;
import com.handpay.obm.cardtopup.exception.CardTopupServiceException;
import com.handpay.obm.cardtopup.service.ITopupCardService;
import com.handpay.obm.cardtopup.service.ITopupMdseService;
import com.handpay.obm.cardtopup.service.ITopupOrderService;
import com.handpay.obm.cardtopup.utils.AESUtil;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-1-29
 * @author "lmbao"
 * @history
 * 
 */
@Service
public class CardTopupServiceImpl implements ICardTopupService {

	private static final Logger logger = LoggerFactory.getLogger(CardTopupServiceImpl.class);

	private static final String PREPARE_QUEUE = "prepareQueue";
	private static final String CARD_ENCRYPT_KEY = "ctu-ck";

	private static final ExecutorService cardThreadPool = Executors.newSingleThreadExecutor();

	@Value("${cardtopup.maxWaitSize}")
	private Long maxWaitSize;
	@Value("${cardtopup.aesKey}")
	private String aesKey;

	@Autowired
	private ITopupMdseService mdseService;
	@Autowired
	private ITopupOrderService orderService;
	@Autowired
	private ITopupCardService cardService;

	@Autowired
	private CacheExecutor cache;

	@Reference(version = "1.0.0", registry = "mallzk")
	private ICardDubboClientService cardClientService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.service.ICardTopupService#delivery(com.handpay
	 * .obm.cardtopup.bean.CardTopupReq)
	 */
	@Override
	@Transactional
	public CardTopupRes topup(CardTopupReq req) {

		// 1. 查询商品库存
		// FIXME 暂无面值拆分
		TopupMdse mdse = mdseService.findByTopupAmount(req.getTopupType(), req.getTopupAmount());
		if (mdse == null) {
			throw new CardTopupServiceException(CardTopupErrorCodes.E_SYS_9999, "不支持的充值金额");
		}
		if (StringUtils.equals(mdse.getStatus(), TopupMdseStatus.DISABLED.getCode())) {
			throw new CardTopupServiceException(CardTopupErrorCodes.E_MDSE_0101, "商品暂不可用");
		}

		// FIXME 是否要控制总量
		try {
			long waitSize = cache.listLength(PREPARE_QUEUE);
			if (waitSize >= maxWaitSize) {
				throw new CardTopupServiceException(CardTopupErrorCodes.E_QUEUE_0909, "等待队列已满");
			}
		} catch (CacheClientException e) {
			logger.error("cache error: ", e);
		}

		// 2. 落地订单
		TopupOrder order = orderService.save(req);

		CardTopupRes res = new CardTopupRes();
		BeanUtils.copyProperties(order, res);
		res.setTopupOrderId(order.getId());

		// 3. 准备卡密
		cardThreadPool.submit(new PrepareCardThread(mdse, order));

		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.service.ICardTopupService#query(java.lang.String
	 * , java.lang.String)
	 */
	@Override
	public CardTopupRes query(String bizOrderId, String bizOrderTime) {

		TopupOrder order = orderService.findByBizOrder(bizOrderId, bizOrderTime);
		if (order == null) {
			throw new CardTopupServiceException(CardTopupErrorCodes.E_ORDER_0202, "未找到订单");
		}

		CardTopupRes res = new CardTopupRes();
		BeanUtils.copyProperties(order, res);
		return res;
	}

	private class PrepareCardThread implements Runnable {

		private final TopupMdse mdse;
		private final TopupOrder order;

		public PrepareCardThread(TopupMdse mdse, TopupOrder order) {
			this.mdse = mdse;
			this.order = order;
		}

		@Override
		public void run() {

			String userId = "brand-voucher";
			String userpws = "123456";

			// 3. 获取卡密
			order.getBizOrderId();

			String mdseCode = mdse.getCardMdse();
			String num = "1"; // 不拆单时，数量固定为1

			int id = cardService.getIdSeq();
			String sporderId = String.valueOf(id);
			String sporderTime = DateUtils.getCurrentDate();
			String sign = new MD5().getMD5ofStr(userId + userpws + mdseCode + num + sporderId + sporderTime)
					.toUpperCase();

			MdseOrderReqBean req = new MdseOrderReqBean(userId, userpws, mdseCode, num, sporderId, sporderTime, sign);

			MdseOrderResBean res = null;

			try {
				res = cardClientService.delivery(req);
				System.out.println(res);
			} catch (CardException e) {
				logger.error("get cards error: ", e);
			}
			if (res == null) {
				// ...
			}

			// 4. 卡密存储
			TopupCard topupCard = new TopupCard();
			topupCard.setId(id);
			topupCard.setCreateTime(sporderTime);
			topupCard.setCardMdse(mdseCode);
			topupCard.setOrderId(id); // 使用TopupCard.id作为代充服务订单
			topupCard.setCardOrderId(res.getCardOrderId());
			CardInfoBean card = null;
			if (res.getList().size() == 1) {
				card = res.getList().get(0);
				// topupCard.setCardNo(card.getCardNo());
				// try {
				// topupCard.setCardPwd(DesUtils.des3Encrypt(card.getPswd(),
				// CARD_ENCRYPT_KEY));
				// } catch (Exception e) {
				// logger.error("pwd encrypt error: ", e);
				// }
			}
			topupCard.setCost(new BigDecimal(res.getAmount()).divide(new BigDecimal(100)).setScale(2));
			cardService.save(topupCard);

			TopupOrder update = new TopupOrder();
			update.setId(order.getId());
			update.setTstep(TopupOrderTstep.GET_CARD.getCode());
			update.setRemark(order.getRemark() + "获取卡密");
			if (card != null)
				update.setCtime(card.getDeliveryTime());
			orderService.updateById(update);

			// 5. 添加到待充值队列
			WaitTopupOrder waitTopup = new WaitTopupOrder();
			waitTopup.setOrderid(order.getId());
			waitTopup.setAccount(order.getTopupAccount());
			if (card != null) {
				waitTopup.setCardno(card.getCardNo());
				waitTopup.setCardpwd(AESUtil.aesEncrypt(card.getPswd(), aesKey));
			}
			try {
				cache.listAppend(PREPARE_QUEUE, waitTopup, ONE_DAY);
			} catch (CacheClientException e) {
				logger.error("cache error: ", e);
			}
		}
	}

	@Override
	public List<WaitTopupOrder> getWaitTopupOrders(String rechUnitId, int orderNum) {

		List<WaitTopupOrder> result = Lists.newArrayList();
		for (int i = 0; i < orderNum; i++) {
			try {
				WaitTopupOrder o = cache.listPopHead(PREPARE_QUEUE);
				if (o != null) {
					result.add(o);
				}
				TopupOrder update = new TopupOrder();
				update.setRechUnitId(rechUnitId);
				update.setStartTtime(DateUtils.getCurrentDate());
				update.setId(o.getOrderid());
				orderService.updateById(update);
			} catch (CacheClientException e) {
				logger.error("cache error: ", e);
			}
		}

		return result;
	}

	public Long getMaxWaitSize() {
		return maxWaitSize;
	}

	public void setMaxWaitSize(Long maxWaitSize) {
		this.maxWaitSize = maxWaitSize;
	}

	public String getAesKey() {
		return aesKey;
	}

	public void setAesKey(String aesKey) {
		this.aesKey = aesKey;
	}

}
