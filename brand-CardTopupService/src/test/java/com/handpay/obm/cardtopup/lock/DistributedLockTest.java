/*
 * @(#)DistributedLockTest.java        1.0 2016-2-1
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

package com.handpay.obm.cardtopup.lock;

import static com.handpay.obm.cardtopup.cache.CacheConstant.CACHE_PREFIX;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.handpay.framework.locks.DistributedLockFactory;
import com.handpay.framework.locks.MutexLock;

/**
 * Class description goes here.
 * 
 * @version 1.0 2016-2-1
 * @author "lmbao"
 * @history
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-test.xml" })
public class DistributedLockTest {

	@Autowired
	private DistributedLockFactory lockFactory;

	@Test
	public void testTimeout() {

		
	}
}
