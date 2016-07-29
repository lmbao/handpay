/*
 * @(#)WaitTopupOrder.java        1.0 2016-2-3
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

package com.handpay.obm.cardtopup.bean;

import java.io.Serializable;

/**
 * ¥˝≥‰ø®√‹
 * 
 * @version 1.0 2016-2-3
 * @author "lmbao"
 * @history
 * 
 */
public class WaitTopupOrder implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4477390799579744309L;
	/** ¥˙≥‰∂©µ•∫≈ */
	private Integer orderid;
	/** ±ª≥‰÷µICø® */
	private String account;
	/** ≥‰÷µø®∫≈ */
	private String cardno;
	/** ≥‰÷µø®√‹ */
	private String cardpwd;
	/** ¿©’π1 */
	private String recext1;
	/** ¿©’π2 */
	private String recext2;

	public Integer getOrderid() {
		return orderid;
	}

	public void setOrderid(Integer orderid) {
		this.orderid = orderid;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCardpwd() {
		return cardpwd;
	}

	public void setCardpwd(String cardpwd) {
		this.cardpwd = cardpwd;
	}

	public String getRecext1() {
		return recext1;
	}

	public void setRecext1(String recext1) {
		this.recext1 = recext1;
	}

	public String getRecext2() {
		return recext2;
	}

	public void setRecext2(String recext2) {
		this.recext2 = recext2;
	}

}
