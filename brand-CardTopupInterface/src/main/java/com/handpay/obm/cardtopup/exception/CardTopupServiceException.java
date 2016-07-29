/*
 * @(#)CardTopupServiceException.java        1.0 2016-1-28
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

package com.handpay.obm.cardtopup.exception;

import com.handpay.obm.common.exception.ObmBaseException;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-1-28
 * @author "lmbao"
 * @history
 * 
 */
public class CardTopupServiceException extends ObmBaseException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7502373494860336131L;

	public CardTopupServiceException(String errorCode, String errorMsg) {
		super(errorCode, errorMsg);
	}

	public CardTopupServiceException(String errorCode, String errorMsg, Throwable e) {
		super(errorCode, errorMsg, e);
	}
}
