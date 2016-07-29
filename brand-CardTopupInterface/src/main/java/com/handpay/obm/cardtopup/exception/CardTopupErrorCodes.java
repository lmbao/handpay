/*
 * @(#)CardTopupErrorCodes.java        1.0 2016-1-29
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

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-1-29
 * @author "lmbao"
 * @history
 * 
 */
public class CardTopupErrorCodes {
	/**
	 * 系统异常
	 */
	public static final String E_SYS_9999 = "9999";
	/**
	 * 商品不可用
	 */
	public static final String E_MDSE_0101 = "0101";
	/**
	 * 订单失败
	 */
	public static final String E_ORDER_0201 = "0201";
	/**
	 * 未找到订单
	 */
	public static final String E_ORDER_0202 = "0202";
	/**
	 * 等待队列满
	 */
	public static final String E_QUEUE_0909 = "0909";
}
