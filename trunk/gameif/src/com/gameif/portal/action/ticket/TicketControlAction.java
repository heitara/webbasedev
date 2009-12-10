package com.gameif.portal.action.ticket;

import java.util.List;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.ITicketBusinessLogic;
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
	
	private List<MyTicket> ticketList;
	private Integer ticketId;
	private Integer titleId;
	private List<MyTicketUseHist> useHistList;
	private List<MyTicketGiveHist> giveHistList;

	/**
	 * チケット情報画面へ案内する
	 * 
	 * @return チケット情報画面
	 */
	public String inputList() {
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
		try {
			ticketBusinessLogic.useTicket(this.getTicketId(), this.getTicketId());
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
		setUseHistList(ticketBusinessLogic.getMyUseHistList());
		return "inputUseList";
	}
	
	/**
	 * サービスポイント付与履歴画面へ案内する
	 * @return サービスポイント付与履歴画面
	 */
	public String inputGiveList() {
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

}
