/*
 * @(#)TopupOrderServiceImpl.java        1.0 2016-1-29
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

package com.handpay.obm.cardtopup.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.handpay.core.common.util.DateUtils;
import com.handpay.framework.cache.client.exception.CacheClientException;
import com.handpay.framework.cache.client.executor.CacheExecutor;
import com.handpay.obm.cardtopup.bean.CardTopupReq;
import com.handpay.obm.cardtopup.domain.TopupOrder;
import com.handpay.obm.cardtopup.enums.TopupOrderTstatus;
import com.handpay.obm.cardtopup.enums.TopupOrderTstep;
import com.handpay.obm.cardtopup.exception.CardTopupErrorCodes;
import com.handpay.obm.cardtopup.exception.CardTopupServiceException;
import com.handpay.obm.cardtopup.mapper.TopupOrderMapper;
import com.handpay.obm.cardtopup.service.ITopupOrderService;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-1-29
 * @author "lmbao"
 * @history
 * 
 */
@Service
public class TopupOrderServiceImpl implements ITopupOrderService {
	private static final Logger logger = LoggerFactory.getLogger(TopupOrderServiceImpl.class);

	private static final String ORA_00001 = "ORA-00001";
	@Autowired
	private CacheExecutor cache;
	@Autowired
	private TopupOrderMapper orderMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.service.ITopupOrderService#save(com.handpay
	 * .obm.cardtopup.domain.TopupOrder)
	 */
	@Override
	@Transactional
	public TopupOrder save(CardTopupReq req) {
		// 1. 校验重复订单
		String key = "BizOrder:" + req.getBizOrderId() + req.getBizOrderTime();
		boolean notexists = true;
		try {
			notexists = cache.nxSet(key, "1", 60); // cache 60 second
		} catch (CacheClientException e) {
			logger.error("cache error: ", e);
		}
		if (!notexists) {
			return this.findByBizOrder(req.getBizOrderId(), req.getBizOrderTime());
		}

		TopupOrder order = new TopupOrder();
		int record = 0;
		// 2. 保存订单
		try {
			order.setId(orderMapper.getIdSeq());
			order.setOrderTime(DateUtils.getCurrentDate());
			order.setTstatus(TopupOrderTstatus.PROCESSING.getCode());
			order.setTstep(TopupOrderTstep.INIT.getCode());
			record = orderMapper.insert(order);
		} catch (Throwable e) {
			for (;;) {
				Throwable next = e.getCause();
				if (next == null) {
					if (e.getMessage().contains(ORA_00001)) { // 违反唯一约束条件
						return this.findByBizOrder(req.getBizOrderId(), req.getBizOrderTime());
					}
					break;
				}
				e = next;
			}
			logger.error("$monitor-gascard: insert order error: ", e);
			try {
				cache.del(key);
			} catch (CacheClientException e1) {
				logger.error("cache error: ", e1);
			}
			throw new CardTopupServiceException(CardTopupErrorCodes.E_ORDER_0201, "订单生成失败");
		}
		if (record != 1) {
			throw new CardTopupServiceException(CardTopupErrorCodes.E_ORDER_0201, "订单生成失败");
		}
		return order;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.service.ITopupOrderService#findByBizOrder(java
	 * .lang.String, java.lang.String)
	 */
	@Override
	public TopupOrder findByBizOrder(String bizOrderId, String bizOrderTime) {
		return orderMapper.selectByBizOrder(bizOrderId, bizOrderTime);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.service.ITopupOrderService#findInitOrders(int)
	 */
	@Override
	public List<TopupOrder> findInitOrders(int limit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void updateById(TopupOrder order) {
		// TODO Auto-generated method stub
		orderMapper.updateById(order);
	}

}
