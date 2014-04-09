package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MyTicket;
import com.gameif.payment.entity.TicketInfo;

public interface ITicketInfoDao extends IBaseDao<TicketInfo, TicketInfo> {
	
	public List<MyTicket> selectMyTicketList(Long memNum);
	public TicketInfo selectForUpdate(Long memNum, Integer ticketId);

}
