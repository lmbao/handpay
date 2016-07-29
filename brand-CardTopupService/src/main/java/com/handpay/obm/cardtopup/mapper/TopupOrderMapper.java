package com.handpay.obm.cardtopup.mapper;

import org.apache.ibatis.annotations.Param;

import com.handpay.obm.cardtopup.domain.TopupOrder;

public interface TopupOrderMapper {

	int getIdSeq();

	int insert(TopupOrder domain);

	TopupOrder selectByBizOrder(@Param("bizOrderId") String bizOrderId, @Param("bizOrderTime") String bizOrderTime);

	int updateById(TopupOrder domain);
}