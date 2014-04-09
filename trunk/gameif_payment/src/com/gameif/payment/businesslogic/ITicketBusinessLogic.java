package com.gameif.payment.businesslogic;

import java.util.List;

import com.gameif.common.exception.LogicException;
import com.gameif.payment.entity.MyTicket;
import com.gameif.payment.entity.MyTicketGiveHist;
import com.gameif.payment.entity.MyTicketUseHist;

public interface ITicketBusinessLogic {
	
	public List<MyTicket> getMyTicketList();
	public int useTicket(Integer ticketId, Integer titleId) throws LogicException;
	public List<MyTicketUseHist> getMyUseHistList();
	public List<MyTicketGiveHist> getMyGiveHistList();

}
