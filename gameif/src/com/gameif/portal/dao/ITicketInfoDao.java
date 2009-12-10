package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MyTicket;
import com.gameif.portal.entity.TicketInfo;

public interface ITicketInfoDao extends IBaseDao<TicketInfo, TicketInfo> {
	
	public List<MyTicket> selectMyTicketList(Long memNum);
	public TicketInfo selectForUpdate(Long memNum, Integer ticketId);

}
