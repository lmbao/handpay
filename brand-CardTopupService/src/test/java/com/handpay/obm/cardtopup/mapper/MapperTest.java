package com.handpay.obm.cardtopup.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.handpay.core.common.util.DateUtils;
import com.handpay.obm.cardtopup.domain.TopupOrder;
import com.handpay.obm.cardtopup.enums.TopupOrderTstatus;
import com.handpay.obm.cardtopup.enums.TopupOrderTstep;
import com.handpay.obm.cardtopup.mapper.TopupOrderMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring-application-test.xml" })
public class MapperTest {

	@Autowired
	private TopupOrderMapper orderMapper;

	@Test
	public void testOrderInsert() {
		TopupOrder order = new TopupOrder();
		Integer id = orderMapper.getIdSeq();
		System.out.println("--------" + id);
		order.setId(id);
		order.setBizOrderId("test100" + id);
		order.setBizOrderTime(DateUtils.getCurrentDate());
		order.setOrderTime(DateUtils.getCurrentDate());
		order.setTopupAmount(100);
		order.setTopupType("1");
		order.setTopupAccount("100118291823747594");
		order.setTstatus(TopupOrderTstatus.PROCESSING.getCode());
		order.setTstep(TopupOrderTstep.INIT.getCode());
		int result = orderMapper.insert(order);
		System.out.println("========" + result);
	}

	@Test
	public void testOrderQuery() {
		TopupOrder order = orderMapper.selectByBizOrder("1", "test100100010");
		System.out.println("========" + new Gson().toJson(order));
	}
}
