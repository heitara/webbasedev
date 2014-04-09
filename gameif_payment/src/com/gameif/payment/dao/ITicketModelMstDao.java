package com.gameif.payment.dao;

import java.math.BigDecimal;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.TicketModelMst;

public interface ITicketModelMstDao extends IBaseDao<TicketModelMst, TicketModelMst> {
	
	public TicketModelMst selectByAvgPoint(Integer ticketId, BigDecimal avgPoint);

}
