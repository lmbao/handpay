/*
 * @(#)IGascardCacheCallback.java        1.0 2015-12-31
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
 * ����ص��ӿ�
 * 
 * @version 1.0 2015-12-31
 * @author "lmbao"
 * @history
 * 
 */
public interface ICacheCallback<T> {

	/**
	 * ����ص��ӿ�ִ�з���
	 * 
	 * @return �軺��Ľ��
	 */
	T execute();
}
