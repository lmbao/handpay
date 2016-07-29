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

	/** 缓存有效期：1t */
	public static final Integer ONE_DAY = 86400;
	
	/** 缓存有效期：1h */
	public static final Integer ONE_HOUR = 3600;
	
	/** 核心商品缓存Key */
	public static final String CACHE_PREFIX = "/cardTopupLock:";

	/** 核心商品缓存Key */
	public static final String KEY_2CMDSE = "2CMdse";
	
	/** BBC商品缓存Key */
	public static final String KEY_2BMDSE = "2BMdse";
	
	/** 支付方式缓存Key */
	public static final String KEY_BACKEND = "BackendID";
	
	/** 油卡渠道缓存Key */
	public static final String KEY_GCHANNEL = "GChannel";
	
	/** 油卡商户缓存Key */
	public static final String KEY_GMERCH = "GMerch";

	/** 油卡商户缓存Key */
	public static final String KEY_GMERCH_ALL = "GMerchAll";
	
	/** 油卡商户缓存Key */
	public static final String KEY_PAYPWD_EXIST = "GPayPwdExist";
	
	/** 油卡活动缓存Key */
	public static final String KEY_ACTIVITY = "GActivity:all";
}
