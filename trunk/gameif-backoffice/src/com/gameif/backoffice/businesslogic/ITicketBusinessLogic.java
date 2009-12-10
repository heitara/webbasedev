package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.entity.TicketGiveHist;
import com.gameif.backoffice.entity.TicketMst;
import com.gameif.common.exception.LogicException;

public interface ITicketBusinessLogic {
	
	public List<TicketMst> getTicketListByTitleId(Integer titleId);
	public void giveTicket(TicketGiveHist ticketGiveHist, String memId) throws LogicException;

}
