/*
 * @(#)TopupMdseServiceImpl.java        1.0 2016-2-1
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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handpay.obm.cardtopup.cache.ICacheCallback;
import com.handpay.obm.cardtopup.cache.ICacheHandler;
import com.handpay.obm.cardtopup.domain.TopupMdse;
import com.handpay.obm.cardtopup.mapper.TopupMdseMapper;
import com.handpay.obm.cardtopup.service.ITopupMdseService;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-2-1
 * @author "lmbao"
 * @history
 * 
 */
@Service
public class TopupMdseServiceImpl implements ITopupMdseService {

	@Autowired
	private ICacheHandler cacheHandler;
	@Autowired
	private TopupMdseMapper mdseMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.handpay.obm.cardtopup.service.ITopupMdseService#findByTopupAmount
	 * (java.lang.String, java.lang.Integer)
	 */
	@Override
	public TopupMdse findByTopupAmount(final String topupType, final Integer topupAmount) {

		return cacheHandler.cacheAndGet("topupMdse", new ICacheCallback<TopupMdse>() {
			@Override
			public TopupMdse execute() {
				return mdseMapper.selectByTopupAmount(topupType, topupAmount);
			}
		});
	}

}
