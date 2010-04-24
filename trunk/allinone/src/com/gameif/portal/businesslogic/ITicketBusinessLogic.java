package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.MyTicket;
import com.gameif.portal.entity.MyTicketGiveHist;
import com.gameif.portal.entity.MyTicketUseHist;

public interface ITicketBusinessLogic {
	
	public List<MyTicket> getMyTicketList();
	public int useTicket(Integer ticketId, Integer titleId) throws LogicException;
	public List<MyTicketUseHist> getMyUseHistList();
	public List<MyTicketGiveHist> getMyGiveHistList();

}
