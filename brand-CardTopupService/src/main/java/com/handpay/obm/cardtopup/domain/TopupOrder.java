/*
 * @(#)TopupOrder.java        1.0 2016-1-29
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
public class TopupOrder {

	private Integer id;
	private String orderTime;
	private String bizOrderId;
	private String bizOrderTime;
	private Integer topupAmount;
	private String topupType;
	private String topupAccount;
	private String tstatus;
	private Integer tstep;
	private String ctime;
	private String rechUnitId;
	private String startTtime;
	private String finishTtime;
	private String remark;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
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

	public Integer getTopupAmount() {
		return topupAmount;
	}

	public void setTopupAmount(Integer topupAmount) {
		this.topupAmount = topupAmount;
	}

	public String getTopupType() {
		return topupType;
	}

	public void setTopupType(String topupType) {
		this.topupType = topupType;
	}

	public String getTopupAccount() {
		return topupAccount;
	}

	public void setTopupAccount(String topupAccount) {
		this.topupAccount = topupAccount;
	}

	public String getTstatus() {
		return tstatus;
	}

	public void setTstatus(String tstatus) {
		this.tstatus = tstatus;
	}

	public Integer getTstep() {
		return tstep;
	}

	public void setTstep(Integer tstep) {
		this.tstep = tstep;
	}

	public String getCtime() {
		return ctime;
	}

	public void setCtime(String ctime) {
		this.ctime = ctime;
	}

	public String getRechUnitId() {
		return rechUnitId;
	}

	public void setRechUnitId(String rechUnitId) {
		this.rechUnitId = rechUnitId;
	}

	public String getStartTtime() {
		return startTtime;
	}

	public void setStartTtime(String startTtime) {
		this.startTtime = startTtime;
	}

	public String getFinishTtime() {
		return finishTtime;
	}

	public void setFinishTtime(String finishTtime) {
		this.finishTtime = finishTtime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
