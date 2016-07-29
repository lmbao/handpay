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
 * ��Ч���洦��ӿ�
 * 
 * @version 1.0 2015-12-31
 * @author "lmbao"
 * @history
 * 
 */
public interface ICacheHandler {

	/**
	 * ����{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()}�����Ĭ�ϻ���ʱ��Ϊ1��
	 * 
	 * @param cacheKey
	 *            ����Key
	 * @param callback
	 *            �ص��ӿ�
	 * @return ������
	 */
	<T> T cacheAndGet(String cacheKey, ICacheCallback<T> callback);

	/**
	 * ����{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()}���
	 * 
	 * @param cacheKey
	 *            ����Key
	 * @param expireSeconds
	 *            ����ʱ�䣬��λ��
	 * @param callback
	 *            �ص��ӿ�
	 * @return ������
	 */
	<T> T cacheAndGet(String cacheKey, Integer expireSeconds, ICacheCallback<T> callback);

	/**
	 * ʹ��MapEntry����{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()}
	 * �����Ĭ�ϻ���ʱ��Ϊ1��
	 * 
	 * @param cacheKey
	 *            ����Key
	 * @param cacheMapKey
	 *            ����MapEntry.Key
	 * @param callback
	 *            �ص��ӿ�
	 * @return ������
	 */
	<T> T cacheAndGetMapEntry(String cacheKey, String cacheMapKey, ICacheCallback<T> callback);

	/**
	 * ʹ��MapEntry����{@link com.handpay.obm.cardtopup.cache.ICacheCallback#callback()} ���
	 * 
	 * @param cacheKey
	 *            ����Key
	 * @param cacheMapKey
	 *            ����MapEntry.Key
	 * @param expireSeconds
	 *            ����ʱ�䣬��λ��
	 * @param callback
	 *            �ص��ӿ�
	 * @return ������
	 */
	<T> T cacheAndGetMapEntry(String cacheKey, String cacheMapKey, Integer expireSeconds, ICacheCallback<T> callback);
}
