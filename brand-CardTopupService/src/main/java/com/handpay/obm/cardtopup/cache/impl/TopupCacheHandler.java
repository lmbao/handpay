/*
 * @(#)GascardCacheExecutor.java        1.0 2015-12-31
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

package com.handpay.obm.cardtopup.cache.impl;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.handpay.framework.cache.client.exception.CacheClientException;
import com.handpay.framework.cache.client.executor.CacheExecutor;
import com.handpay.framework.locks.DistributedLockFactory;
import com.handpay.framework.locks.MutexLock;
import static com.handpay.obm.cardtopup.cache.CacheConstant.*;

import com.handpay.obm.cardtopup.cache.ICacheCallback;
import com.handpay.obm.cardtopup.cache.ICacheHandler;

/**
 * »º´æ´¦ÀíÆ÷
 * 
 * @version 1.0 2015-12-31
 * @author "lmbao"
 * @history
 * 
 */
@Service
public class TopupCacheHandler implements ICacheHandler {

	private static final Logger logger = LoggerFactory.getLogger(TopupCacheHandler.class);

	@Autowired
	private CacheExecutor cache;
	@Autowired
	private DistributedLockFactory lockFactory;

	@Override
	public <T> T cacheAndGet(String cacheKey, final ICacheCallback<T> callback) {
		return cacheAndGet(cacheKey, ONE_DAY, callback);
	}

	@Override
	public <T> T cacheAndGet(String cacheKey, Integer expireSeconds, final ICacheCallback<T> callback) {

		T t = cacheGet(cacheKey);
		if (t != null)
			return t;

		MutexLock lock = lockFactory.buildMutexLock(CACHE_PREFIX + cacheKey);
		boolean getLock = lock.tryLock(5, TimeUnit.SECONDS);
		try {
			t = cacheGet(cacheKey); // get again
			if (t == null) {
				t = callback.execute();
				if (t != null)
					cacheSet(cacheKey, t, expireSeconds);
			}
			return t;
		} finally {
			if (getLock)
				lock.unlock();
			lock = null;
		}
	}

	@Override
	public <T> T cacheAndGetMapEntry(String cacheKey, String cacheMapKey, ICacheCallback<T> callback) {
		return cacheAndGetMapEntry(cacheKey, cacheMapKey, ONE_DAY, callback);
	}

	@Override
	public <T> T cacheAndGetMapEntry(String cacheKey, String cacheMapKey, Integer expireSeconds,
			ICacheCallback<T> callback) {

		T t = cacheGetMapEntry(cacheKey, cacheMapKey);
		if (t != null)
			return t;

		MutexLock lock = lockFactory.buildMutexLock(CACHE_PREFIX + cacheKey + cacheMapKey);
		boolean getLock = lock.tryLock(5, TimeUnit.SECONDS);
		try {
			t = cacheGetMapEntry(cacheKey, cacheMapKey); // get again
			if (t == null) {
				t = callback.execute();
				if (t != null)
					cacheSetMapEntry(cacheKey, cacheMapKey, t, expireSeconds);
			}
			return t;
		} finally {
			if (getLock)
				lock.unlock();
			lock = null;
		}
	}

	private <T> T cacheGet(String cacheKey) {
		T t = null;
		try {
			t = cache.get(cacheKey);
		} catch (CacheClientException e) {
			logger.error("cache get error:" + cacheKey, e);
		}
		return t;
	}

	private <T> T cacheGetMapEntry(String cacheKey, String cacheMapKey) {
		T t = null;
		try {
			t = cache.getMapEntry(cacheKey, cacheMapKey);
		} catch (CacheClientException e) {
			logger.error("cache getMapEntry error:" + cacheKey + cacheMapKey, e);
		}
		return t;
	}

	private <T> void cacheSet(String cacheKey, T t, Integer expireSeconds) {
		try {
			cache.set(cacheKey, t, expireSeconds);
		} catch (CacheClientException e) {
			logger.error("cache set error:" + cacheKey, e);
		}
	}

	private <T> void cacheSetMapEntry(String cacheKey, String cacheMapKey, T t, Integer expireSeconds) {
		try {
			cache.setMapEntry(cacheKey, cacheMapKey, t, expireSeconds);
		} catch (CacheClientException e) {
			logger.error("cache setMapEntry error:" + cacheKey + cacheMapKey, e);
		}
	}

}
