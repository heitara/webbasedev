package com.gameif.portal.action.ticket;

import java.util.List;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.businesslogic.IServicePointBusinessLogic;
import com.gameif.portal.businesslogic.ITicketBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MySPInfo;
import com.gameif.portal.entity.MyTicket;
import com.gameif.portal.entity.MyTicketGiveHist;
import com.gameif.portal.entity.MyTicketUseHist;
import com.gameif.portal.util.ContextUtil;

public class TicketControlAction extends BaseActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = -681752908371642208L;

	private ITicketBusinessLogic ticketBusinessLogic;
	private IServicePointBusinessLogic servicePointBusinessLogic;
	private IMaintenanceBusinessLogic maintenanceBusinessLogic;
	
	private List<MyTicket> ticketList;
	private Integer ticketId;
	private Integer titleId;
	private List<MyTicketUseHist> useHistList;
	private List<MyTicketGiveHist> giveHistList;
	private Integer point;
	private List<MySPInfo> servicePointList;
	

	/**
	 * チケット情報画面へ案内する
	 * 
	 * @return チケット情報画面
	 */
	public String inputList() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.TICKET)) {
			return "maintenance";
		}
		
		setServicePointList(servicePointBusinessLogic.getMyServicePointList());
		// チケット情報を検索する
		setTicketList(ticketBusinessLogic.getMyTicketList());
		if (getTicketList() == null || getTicketList().size() == 0) {
			addFieldError("errMessage", getText("ticketList.dataNotExist"));
		}
		return "inputList";
	}

	/**
	 * チケットを使用する
	 * 
	 * @return
	 */
	public String use() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.TICKET)) {
			return "maintenance";
		}
		
		try {
			point = ticketBusinessLogic.useTicket(this.getTicketId(), this.getTitleId());
		} catch (DataNotExistsException dneEx) {
			// メンテナンス
			addFieldError("errMessage", getText("ticket.dataNotExist"));
			return "inputGet";
		} catch (LogicException lgex) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
			return "warning";

		}
		return "finishedUse";
	}

	
	/**
	 * サービスポイント消費履歴画面へ案内する
	 * @return サービスポイント消費履歴画面
	 */
	public String inputUseList() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.TICKET)) {
			return "maintenance";
		}
		
		setUseHistList(ticketBusinessLogic.getMyUseHistList());
		return "inputUseList";
	}
	
	/**
	 * サービスポイント付与履歴画面へ案内する
	 * @return サービスポイント付与履歴画面
	 */
	public String inputGiveList() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.TICKET)) {
			return "maintenance";
		}
		
		setGiveHistList(ticketBusinessLogic.getMyGiveHistList());
		return "inputGiveList";
	}
	
	/**
	 * @param ticketBusinessLogic
	 *            the ticketBusinessLogic to set
	 */
	public void setTicketBusinessLogic(ITicketBusinessLogic ticketBusinessLogic) {
		this.ticketBusinessLogic = ticketBusinessLogic;
	}

	/**
	 * @param servicePointBusinessLogic the servicePointBusinessLogic to set
	 */
	public void setServicePointBusinessLogic(IServicePointBusinessLogic servicePointBusinessLogic) {
		this.servicePointBusinessLogic = servicePointBusinessLogic;
	}

	/**
	 * @param maintenanceBusinessLogic the maintenanceBusinessLogic to set
	 */
	public void setMaintenanceBusinessLogic(
			IMaintenanceBusinessLogic maintenanceBusinessLogic) {
		this.maintenanceBusinessLogic = maintenanceBusinessLogic;
	}

	/**
	 * @return the ticketList
	 */
	public List<MyTicket> getTicketList() {
		return ticketList;
	}

	/**
	 * @param ticketList the ticketList to set
	 */
	public void setTicketList(List<MyTicket> ticketList) {
		this.ticketList = ticketList;
	}

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
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
	 * @return the useHistList
	 */
	public List<MyTicketUseHist> getUseHistList() {
		return useHistList;
	}

	/**
	 * @param useHistList the useHistList to set
	 */
	public void setUseHistList(List<MyTicketUseHist> useHistList) {
		this.useHistList = useHistList;
	}

	/**
	 * @return the giveHistList
	 */
	public List<MyTicketGiveHist> getGiveHistList() {
		return giveHistList;
	}

	/**
	 * @param giveHistList the giveHistList to set
	 */
	public void setGiveHistList(List<MyTicketGiveHist> giveHistList) {
		this.giveHistList = giveHistList;
	}

	/**
	 * @return the point
	 */
	public Integer getPoint() {
		return point;
	}

	/**
	 * @param point the point to set
	 */
	public void setPoint(Integer point) {
		this.point = point;
	}

	/**
	 * @return the servicePointList
	 */
	public List<MySPInfo> getServicePointList() {
		return servicePointList;
	}

	/**
	 * @param servicePointList the servicePointList to set
	 */
	public void setServicePointList(List<MySPInfo> servicePointList) {
		this.servicePointList = servicePointList;
	}

}
