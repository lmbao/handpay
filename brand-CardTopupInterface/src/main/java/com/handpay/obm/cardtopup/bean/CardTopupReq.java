/*
 * @(#)CardTopupReq.java        1.0 2016-1-28
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
 * 充值请求参数
 * 
 * @version 1.0 2016-1-28
 * @author "lmbao"
 * @history
 * 
 */
public class CardTopupReq implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 757707146208653691L;

	/**
	 * 业务订单号
	 */
	private String bizOrderId;
	/**
	 * 业务订单时间
	 */
	private String bizOrderTime;
	/**
	 * 充值金额 (单位：元)
	 */
	private Integer topupAmount;
	/**
	 * 充值类型(1-中石化; 2-中石油)
	 */
	private String topupType;
	/**
	 * 充值账户 (油卡卡号)
	 */
	private String topupAccount;

	public String getTopupType() {
		return topupType;
	}

	public void setTopupType(String topupType) {
		this.topupType = topupType;
	}

	public Integer getTopupAmount() {
		return topupAmount;
	}

	public void setTopupAmount(Integer topupAmount) {
		this.topupAmount = topupAmount;
	}

	public String getTopupAccount() {
		return topupAccount;
	}

	public void setTopupAccount(String topupAccount) {
		this.topupAccount = topupAccount;
	}

	public String getBizOrderId() {
		return bizOrderId;
	}

	public void setBizOrderId(String bizOrderId) {
		this.bizOrderId = bizOrderId;
	}

	public String getBizOrderTime() {
		return bizOrderTime;
	}

	public void setBizOrderTime(String bizOrderTime) {
		this.bizOrderTime = bizOrderTime;
	}

}
