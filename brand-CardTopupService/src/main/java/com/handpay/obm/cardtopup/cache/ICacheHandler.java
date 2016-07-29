/*
 * @(#)IGascardCacheExecutor.java        1.0 2015-12-31
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
 * 高效缓存处理接口
 * 
 * @version 1.0 2015-12-31
 * @author "lmbao"
 * @history
 * 
 */
public interface ICacheHandler {

	/**
	 * 缓存{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()}结果，默认缓存时间为1天
	 * 
	 * @param cacheKey
	 *            缓存Key
	 * @param callback
	 *            回调接口
	 * @return 缓存结果
	 */
	<T> T cacheAndGet(String cacheKey, ICacheCallback<T> callback);

	/**
	 * 缓存{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()}结果
	 * 
	 * @param cacheKey
	 *            缓存Key
	 * @param expireSeconds
	 *            缓存时间，单位秒
	 * @param callback
	 *            回调接口
	 * @return 缓存结果
	 */
	<T> T cacheAndGet(String cacheKey, Integer expireSeconds, ICacheCallback<T> callback);

	/**
	 * 使用MapEntry缓存{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()}
	 * 结果，默认缓存时间为1天
	 * 
	 * @param cacheKey
	 *            缓存Key
	 * @param cacheMapKey
	 *            缓存MapEntry.Key
	 * @param callback
	 *            回调接口
	 * @return 缓存结果
	 */
	<T> T cacheAndGetMapEntry(String cacheKey, String cacheMapKey, ICacheCallback<T> callback);

	/**
	 * 使用MapEntry缓存{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()} 结果
	 * 
	 * @param cacheKey
	 *            缓存Key
	 * @param cacheMapKey
	 *            缓存MapEntry.Key
	 * @param expireSeconds
	 *            缓存时间，单位秒
	 * @param callback
	 *            回调接口
	 * @return 缓存结果
	 */
	<T> T cacheAndGetMapEntry(String cacheKey, String cacheMapKey, Integer expireSeconds, ICacheCallback<T> callback);
}
