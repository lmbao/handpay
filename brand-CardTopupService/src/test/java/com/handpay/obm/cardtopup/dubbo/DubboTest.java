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
		// ��ǰӦ������
		ApplicationConfig application = new ApplicationConfig();
		application.setName("test");

		// ����ע����������
		// RegistryConfig registry = new RegistryConfig();
		// registry.setAddress("10.48.171.179:2131");
		// registry.setUsername("aaa");
		// registry.setPassword("bbb");

		// ע�⣺ReferenceConfigΪ�ض����ڲ���װ����ע�����ĵ����ӣ��Լ�������ṩ��������

		// ����Զ�̷���
		ReferenceConfig<ICardTopupDubboService> reference = new ReferenceConfig<ICardTopupDubboService>(); // ��ʵ�����أ���װ����ע�����ĵ������Լ����ṩ�ߵ����ӣ������л��棬�����������ڴ������й©
		reference.setApplication(application);
		// reference.setRegistry(registry); // ���ע�����Ŀ�����setRegistries()
		reference.setInterface(ICardTopupDubboService.class);
		// reference.setVersion("1.0.0");
		reference
				.setUrl("dubbo://10.48.193.97:20880/com.handpay.obm.cardtopup.dubbo.ICardTopupDubboService?version=1.0.0"); // ��Ե�ֱ��

		// �ͱ���beanһ��ʹ��xxxService
		service = reference.get(); // ע�⣺�˴�������ڲ���װ������ͨѶϸ�ڣ�������أ��뻺�渴��
	}

	@Test
	public void testEcho() {
		init();

		EchoService echoService = (EchoService) service; // ǿ��ת��ΪEchoService
		String status = (String) echoService.$echo("OK"); // �������Կ�����
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
