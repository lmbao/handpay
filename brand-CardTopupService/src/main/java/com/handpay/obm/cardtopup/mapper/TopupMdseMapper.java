package com.handpay.obm.cardtopup.mapper;

import org.apache.ibatis.annotations.Param;

import com.handpay.obm.cardtopup.domain.TopupMdse;

public interface TopupMdseMapper {

	TopupMdse selectByTopupAmount(@Param("topupType") String topupType, @Param("topupAmount") Integer topupAmount);
}