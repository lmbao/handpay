/*
 * @(#)TopupMdse.java        1.0 2016-1-29
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

package com.handpay.obm.cardtopup.domain;

/**
 * TopupMdse
 * 
 * @version 1.0 2016-1-29
 * @author "lmbao"
 * @history
 * 
 */
public class TopupMdse {

	private Integer id;
	/** 充值类型 (1-中石化; 2-中石油) */
	private String topupType;
	/** 充值金额 (单位：元) */
	private String topupAmount;
	/** 卡库商品代码 */
	private String cardMdse;
	/** 状态 (1-可用; 2-不可用) */
	private String status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTopupType() {
		return topupType;
	}

	public void setTopupType(String topupType) {
		this.topupType = topupType;
	}

	public String getTopupAmount() {
		return topupAmount;
	}

	public void setTopupAmount(String topupAmount) {
		this.topupAmount = topupAmount;
	}

	public String getCardMdse() {
		return cardMdse;
	}

	public void setCardMdse(String cardMdse) {
		this.cardMdse = cardMdse;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
