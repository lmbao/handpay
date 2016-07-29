/*
 * @(#)ITopupMdseService.java        1.0 2016-2-1
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

package com.handpay.obm.cardtopup.service;

import com.handpay.obm.cardtopup.domain.TopupMdse;

/**
 * Class description goes here.
 *
 * @version 	1.0 2016-2-1
 * @author		"lmbao"
 * @history	
 *		
 */
public interface ITopupMdseService {

	TopupMdse findByTopupAmount(String bizType, Integer topupAmount);
}
