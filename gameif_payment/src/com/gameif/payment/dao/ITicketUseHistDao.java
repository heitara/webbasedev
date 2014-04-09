package com.gameif.payment.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MyTicketUseHist;
import com.gameif.payment.entity.TicketUseHist;

public interface ITicketUseHistDao extends IBaseDao<TicketUseHist, TicketUseHist> {
	
	public BigDecimal selectAvgPoint(Integer ticketId);
	public List<MyTicketUseHist> selectMyUseHistList(Long memNum);

}
