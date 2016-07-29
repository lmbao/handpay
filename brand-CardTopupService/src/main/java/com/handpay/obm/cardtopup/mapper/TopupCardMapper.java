package com.handpay.obm.cardtopup.mapper;

import com.handpay.obm.cardtopup.domain.TopupCard;

public interface TopupCardMapper {

	int getIdSeq();

	int insert(TopupCard domain);

}