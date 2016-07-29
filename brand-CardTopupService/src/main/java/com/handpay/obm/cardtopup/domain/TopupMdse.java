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
	/** ��ֵ���� (1-��ʯ��; 2-��ʯ��) */
	private String topupType;
	/** ��ֵ��� (��λ��Ԫ) */
	private String topupAmount;
	/** ������Ʒ���� */
	private String cardMdse;
	/** ״̬ (1-����; 2-������) */
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
