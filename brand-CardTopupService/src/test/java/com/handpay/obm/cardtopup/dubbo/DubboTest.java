/*
 * @(#)DubboServiceTest.java        1.0 2015-12-7
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

package com.handpay.obm.cardtopup.dubbo;

import org.junit.Test;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.rpc.service.EchoService;
import com.handpay.obm.cardtopup.bean.CardTopupRes;

/**
 * Class description goes here.
 * 
 * @version 1.0 2015-12-7
 * @author "lmbao"
 * @history
 * 
 */
public class DubboTest {

	private ICardTopupDubboService service;

	private void init() {
		// 当前应用配置
		ApplicationConfig application = new ApplicationConfig();
		application.setName("test");

		// 连接注册中心配置
		// RegistryConfig registry = new RegistryConfig();
		// registry.setAddress("10.48.171.179:2131");
		// registry.setUsername("aaa");
		// registry.setPassword("bbb");

		// 注意：ReferenceConfig为重对象，内部封装了与注册中心的连接，以及与服务提供方的连接

		// 引用远程服务
		ReferenceConfig<ICardTopupDubboService> reference = new ReferenceConfig<ICardTopupDubboService>(); // 此实例很重，封装了与注册中心的连接以及与提供者的连接，请自行缓存，否则可能造成内存和连接泄漏
		reference.setApplication(application);
		// reference.setRegistry(registry); // 多个注册中心可以用setRegistries()
		reference.setInterface(ICardTopupDubboService.class);
		// reference.setVersion("1.0.0");
		reference
				.setUrl("dubbo://10.48.193.97:20880/com.handpay.obm.cardtopup.dubbo.ICardTopupDubboService?version=1.0.0"); // 点对点直连

		// 和本地bean一样使用xxxService
		service = reference.get(); // 注意：此代理对象内部封装了所有通讯细节，对象较重，请缓存复用
	}

	@Test
	public void testEcho() {
		init();

		EchoService echoService = (EchoService) service; // 强制转型为EchoService
		String status = (String) echoService.$echo("OK"); // 回声测试可用性
		assert (status.equals("OK"));
		System.out.println("test over.");
	}

	@Test
	public void testQuery() {
		init();

		CardTopupRes res = service.query("2", "20160314100000");
		System.out.println(res);
	}
}
