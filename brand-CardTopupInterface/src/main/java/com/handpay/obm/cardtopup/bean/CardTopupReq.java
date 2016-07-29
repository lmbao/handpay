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
 * ��ֵ�������
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
	 * ҵ�񶩵���
	 */
	private String bizOrderId;
	/**
	 * ҵ�񶩵�ʱ��
	 */
	private String bizOrderTime;
	/**
	 * ��ֵ��� (��λ��Ԫ)
	 */
	private Integer topupAmount;
	/**
	 * ��ֵ����(1-��ʯ��; 2-��ʯ��)
	 */
	private String topupType;
	/**
	 * ��ֵ�˻� (�Ϳ�����)
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
