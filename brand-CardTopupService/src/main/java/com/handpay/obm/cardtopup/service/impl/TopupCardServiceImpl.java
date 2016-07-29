/*
 * @(#)TopupCardServiceImpl.java        1.0 2016-2-2
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
import org.springframework.transaction.annotation.Transactional;

import com.handpay.obm.cardtopup.domain.TopupCard;
import com.handpay.obm.cardtopup.mapper.TopupCardMapper;
import com.handpay.obm.cardtopup.service.ITopupCardService;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-2-2
 * @author "lmbao"
 * @history
 * 
 */
@Service
public class TopupCardServiceImpl implements ITopupCardService {

	@Autowired
	private TopupCardMapper cardMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.handpay.obm.cardtopup.service.ITopupCardService#getIdSeq()
	 */
	@Override
	public int getIdSeq() {
		return cardMapper.getIdSeq();
	}

	@Override
	@Transactional
	public void save(TopupCard topupCard) {
		cardMapper.insert(topupCard);
	}

}
