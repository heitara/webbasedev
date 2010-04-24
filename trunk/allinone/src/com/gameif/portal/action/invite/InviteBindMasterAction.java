package com.gameif.portal.action.invite;

import java.util.List;

import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.entity.InviteTemplateMst;

public class InviteBindMasterAction {
	private Integer titleId;
	private Integer inviteTemplateId;
	private List<InviteTemplateMst> tempList;
	private String inviteMsg;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	public String bindInviteTemplate() {
		tempList = masterInfoBusinessLogic.getInviteTemplateByTitleId(titleId);
		return "success";
	}
	
	public String changeInviteMsg() {
		InviteTemplateMst mst = masterInfoBusinessLogic.getInviteTemplateByKey(inviteTemplateId);
		inviteMsg = mst.getInviteTemplateMsg();
		return "success";
	}

	/**
	 * @return the titleId
	 */
	public Integer getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId
	 *            the titleId to set
	 */
	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the inviteTemplateId
	 */
	public Integer getInviteTemplateId() {
		return inviteTemplateId;
	}

	/**
	 * @param inviteTemplateId the inviteTemplateId to set
	 */
	public void setInviteTemplateId(Integer inviteTemplateId) {
		this.inviteTemplateId = inviteTemplateId;
	}

	/**
	 * @return the inviteMsg
	 */
	public String getInviteMsg() {
		return inviteMsg;
	}

	/**
	 * @param inviteMsg the inviteMsg to set
	 */
	public void setInviteMsg(String inviteMsg) {
		this.inviteMsg = inviteMsg;
	}

	/**
	 * @return the tempList
	 */
	public List<InviteTemplateMst> getTempList() {
		return tempList;
	}

	/**
	 * @param tempList
	 *            the tempList to set
	 */
	public void setTempList(List<InviteTemplateMst> tempList) {
		this.tempList = tempList;
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic
	 *            the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

}
