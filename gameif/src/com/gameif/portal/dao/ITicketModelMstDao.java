package com.gameif.portal.dao;

import java.math.BigDecimal;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.TicketModelMst;

public interface ITicketModelMstDao extends IBaseDao<TicketModelMst, TicketModelMst> {
	
	public TicketModelMst selectByAvgPoint(Integer ticketId, BigDecimal avgPoint);

}
