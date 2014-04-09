package com.gameif.payment.dao;

import java.math.BigDecimal;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.TicketModelDetail;
import com.gameif.payment.entity.TicketModelMst;

public interface ITicketModelDetailDao extends IBaseDao<TicketModelDetail, TicketModelDetail> {
	
	public Integer selectSumPersonCount(TicketModelMst model);
	public BigDecimal selectActpoint(TicketModelMst model, Integer randomCount);

}
