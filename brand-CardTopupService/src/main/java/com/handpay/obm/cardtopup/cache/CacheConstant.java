/*
 * @(#)CacheConstant.java        1.0 2015-11-18
 *
 * Copyright (c) 2007-2015 Shanghai Handpay IT, Co., Ltd.
 * 16/F, 889 YanAn Road. W., Shanghai, China
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of 
 * Shanghai Handpay IT Co., Ltd. ("Confidential Information").  
 * You shall not disclose such Confidential Information and shall use 
 * it only in accordance with the terms of the license agreement you 
 * entered into with Handpay.
 */

package com.handpay.obm.cardtopup.cache;

/**
 * Class description goes here.
 * 
 * @version 1.0 2015-11-18
 * @author "lmbao"
 * @history
 * 
 */
public class CacheConstant {

	/** ������Ч�ڣ�1t */
	public static final Integer ONE_DAY = 86400;
	
	/** ������Ч�ڣ�1h */
	public static final Integer ONE_HOUR = 3600;
	
	/** ������Ʒ����Key */
	public static final String CACHE_PREFIX = "/cardTopupLock:";

	/** ������Ʒ����Key */
	public static final String KEY_2CMDSE = "2CMdse";
	
	/** BBC��Ʒ����Key */
	public static final String KEY_2BMDSE = "2BMdse";
	
	/** ֧����ʽ����Key */
	public static final String KEY_BACKEND = "BackendID";
	
	/** �Ϳ���������Key */
	public static final String KEY_GCHANNEL = "GChannel";
	
	/** �Ϳ��̻�����Key */
	public static final String KEY_GMERCH = "GMerch";

	/** �Ϳ��̻�����Key */
	public static final String KEY_GMERCH_ALL = "GMerchAll";
	
	/** �Ϳ��̻�����Key */
	public static final String KEY_PAYPWD_EXIST = "GPayPwdExist";
	
	/** �Ϳ������Key */
	public static final String KEY_ACTIVITY = "GActivity:all";
}
