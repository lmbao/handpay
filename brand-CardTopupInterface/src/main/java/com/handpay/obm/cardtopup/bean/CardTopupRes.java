/*
 * @(#)CardTopupRes.java        1.0 2016-1-28
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
import java.math.BigDecimal;

/**
 * ��ֵ���
 * 
 * @version 1.0 2016-1-28
 * @author "lmbao"
 * @history
 * 
 */
public class CardTopupRes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6797697510165710418L;

	/**
	 * ҵ�񶩵���
	 */
	private String bizOrderId;
	/**
	 * ҵ�񶩵�ʱ��
	 */
	private String bizOrderTime;
	/**
	 * ��ֵ������
	 */
	private Integer topupOrderId;
	/**
	 * ��ֵ���ʱ��
	 */
	private String finishTime;
	/**
	 * �ɱ��� (��λ��Ԫ)
	 */
	private BigDecimal cost;
	/**
	 * ��ֵ״̬ (00-��ֵ�ɹ�; 01-��ֵʧ��; 02-��ֵ��)
	 */
	private String status;

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public Integer getTopupOrderId() {
		return topupOrderId;
	}

	public void setTopupOrderId(Integer topupOrderId) {
		this.topupOrderId = topupOrderId;
	}

	public String getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(String finishTime) {
		this.finishTime = finishTime;
	}
}
