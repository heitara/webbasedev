package com.gameif.backoffice.action.ticket;

import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.businesslogic.ITicketBusinessLogic;
import com.gameif.backoffice.entity.TicketGiveHist;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.common.action.ModelDrivenActionSupport;

public class TicketControlAction extends ModelDrivenActionSupport<TicketGiveHist> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5159903144930396898L;
	
	private ITicketBusinessLogic ticketBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private BackOfficeProperties backOfficeProperties;
	
	private String memId;
	private Integer titleId;
	private Integer giveType;
	private String memNumList;
	
	public String inputGive() {
		return "inputGive";
	}
	
	public String give() {
		if (getGiveType().equals(1)) {
			ticketBusinessLogic.giveTicketByMemNum(this.getModel(), getMemNumList());
		} else if (getGiveType().equals(2)) {
			ticketBusinessLogic.giveTicketByMemId(this.getModel(), getMemId());
		}
		return "finishedGive";
	}

	/**
	 * @param ticketBusinessLogic the ticketBusinessLogic to set
	 */
	public void setTicketBusinessLogic(ITicketBusinessLogic ticketBusinessLogic) {
		this.ticketBusinessLogic = ticketBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param backOfficeProperties the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

	/**
	 * @return the backOfficeProperties
	 */
	public BackOfficeProperties getBackOfficeProperties() {
		return backOfficeProperties;
	}

	/**
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
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
	 * @return the giveType
	 */
	public Integer getGiveType() {
		return giveType;
	}

	/**
	 * @param giveType the giveType to set
	 */
	public void setGiveType(Integer giveType) {
		this.giveType = giveType;
	}

	/**
	 * @return the memNumList
	 */
	public String getMemNumList() {
		return memNumList;
	}

	/**
	 * @param memNumList the memNumList to set
	 */
	public void setMemNumList(String memNumList) {
		this.memNumList = memNumList;
	}

}
