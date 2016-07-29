/*
 * @(#)ICardTopupDubboService.java        1.0 2016-1-28
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

package com.handpay.obm.cardtopup.dubbo;

import java.util.List;

import com.handpay.obm.cardtopup.bean.CardTopupReq;
import com.handpay.obm.cardtopup.bean.CardTopupRes;
import com.handpay.obm.cardtopup.bean.WaitTopupOrder;

/**
 * ��ת��ƽ̨�ӿ�
 * 
 * @version 1.0 2016-1-28
 * @author "lmbao"
 * @history
 * 
 */
public interface ICardTopupDubboService {

	/**
	 * ��ֵ����
	 * 
	 * @param req
	 */
	CardTopupRes topup(CardTopupReq req);

	/**
	 * ��ѯ��ֵ��Ϣ
	 * 
	 * @param bizOrderId
	 *            ҵ�񶩵���
	 * @param bizOrderTime
	 *            ҵ�񶩵�ʱ��
	 */
	CardTopupRes query(String bizOrderId, String bizOrderTime);

	/**
	 * ȡ���ӿ�
	 * 
	 * @param rechUnitId
	 *            ��ֵ��Ԫ
	 * @param orderNum
	 *            ��������
	 * @return
	 */
	List<WaitTopupOrder> getWaitTopupOrders(String rechUnitId, int orderNum);
}
