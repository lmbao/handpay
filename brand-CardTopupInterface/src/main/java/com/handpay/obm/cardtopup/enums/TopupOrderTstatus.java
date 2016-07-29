/*
 * @(#)TopupOrderStatus.java        1.0 2016-1-29
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

package com.handpay.obm.cardtopup.enums;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-1-29
 * @author "lmbao"
 * @history
 * 
 */
public enum TopupOrderTstatus {

	SUCCESS("00"), FAIL("01"), PROCESSING("02");

	private String code;

	private TopupOrderTstatus(String code) {
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
