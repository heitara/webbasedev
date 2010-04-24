package com.gameif.portal.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MyTicketUseHist;
import com.gameif.portal.entity.TicketUseHist;

public interface ITicketUseHistDao extends IBaseDao<TicketUseHist, TicketUseHist> {
	
	public BigDecimal selectAvgPoint(Integer ticketId);
	public List<MyTicketUseHist> selectMyUseHistList(Long memNum);

}
