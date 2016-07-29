/*
 * @(#)CardTopupDubboServiceImpl.java        1.0 2016-1-28
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

package com.handpay.obm.cardtopup.dubbo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.dubbo.config.annotation.Service;
import com.handpay.obm.cardtopup.bean.CardTopupReq;
import com.handpay.obm.cardtopup.bean.CardTopupRes;
import com.handpay.obm.cardtopup.bean.WaitTopupOrder;
import com.handpay.obm.cardtopup.biz.ICardTopupService;
import com.handpay.obm.cardtopup.dubbo.ICardTopupDubboService;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-1-28
 * @author "lmbao"
 * @history
 * 
 */
@Service(version = "1.0.0")
public class CardTopupDubboServiceImpl implements ICardTopupDubboService {

	@Autowired
	private ICardTopupService cardTopupService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.dubbo.ICardTopupDubboService#topup(com.handpay
	 * .obm.cardtopup.bean.CardTopupReq)
	 */
	@Override
	public CardTopupRes topup(CardTopupReq req) {
		return cardTopupService.topup(req);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.dubbo.ICardTopupDubboService#query(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public CardTopupRes query(String bizOrderId, String bizOrderTime) {
		return cardTopupService.query(bizOrderId, bizOrderTime);
	}

	@Override
	public List<WaitTopupOrder> getWaitTopupOrders(String rechUnitId, int orderNum) {
		return cardTopupService.getWaitTopupOrders(rechUnitId, orderNum);
	}

}
