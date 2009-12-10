package com.gameif.backoffice.action.ticket;

import java.util.List;

import com.gameif.backoffice.businesslogic.ITicketBusinessLogic;
import com.gameif.backoffice.entity.TicketMst;

public class TicketBindMasterAction {
	private Integer titleId;
	private List<TicketMst> ticketList;
	
	private ITicketBusinessLogic ticketBusinessLogic;
	
	public String bindTicketMst() {
		ticketList = ticketBusinessLogic.getTicketListByTitleId(titleId);
		return "success";
	}

	/**
	 * @return the titleId
	 */
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the ticketList
	 */
	public List<TicketMst> getTicketList() {
		return ticketList;
	}

	/**
	 * @param ticketList the ticketList to set
	 */
	public void setTicketList(List<TicketMst> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * @param ticketBusinessLogic the ticketBusinessLogic to set
	 */
	public void setTicketBusinessLogic(ITicketBusinessLogic ticketBusinessLogic) {
		this.ticketBusinessLogic = ticketBusinessLogic;
	}

}
