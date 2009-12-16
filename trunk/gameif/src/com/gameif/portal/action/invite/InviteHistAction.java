package com.gameif.portal.action.invite;

import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.MyInviteLink;
import com.gameif.portal.helper.PortalProperties;
import com.gameif.portal.util.ContextUtil;

public class InviteHistAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6176002968758148538L;

	private List<InviteInfo> listInviteHist;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private IMaintenanceBusinessLogic maintenanceBusinessLogic;
	private PortalProperties portalProperties;

	private String inviteStatusSelect;
	
	private List<Long> selectedInvites;
	private List<MyInviteLink> inviteLinkHistList;
	private Long inviteId;
	private Long memNum;
	private Long childMemNum;

	/**
	 * @return the portalProperties
	 */
	public PortalProperties getPortalProperties() {
		return portalProperties;
	}

	/**
	 * @param portalProperties the portalProperties to set
	 */
	public void setPortalProperties(PortalProperties portalProperties) {
		this.portalProperties = portalProperties;
	}

	/**
	 * @return the listInviteHist
	 */
	public List<InviteInfo> getListInviteHist() {
		return listInviteHist;
	}

	/**
	 * @param listInviteHist
	 *            the listInviteHist to set
	 */
	public void setListInviteHist(List<InviteInfo> listInviteHist) {
		this.listInviteHist = listInviteHist;
	}

	/**
	 * @param inviteInfoBusinessLogic
	 *            the inviteInfoBusinessLogic to set
	 */
	public void setInviteInfoBusinessLogic(
			IInviteInfoBusinessLogic inviteInfoBusinessLogic) {
		this.inviteInfoBusinessLogic = inviteInfoBusinessLogic;
	}

	/**
	 * @return the inviteInfoBusinessLogic
	 */
	public IInviteInfoBusinessLogic getInviteInfoBusinessLogic() {
		return inviteInfoBusinessLogic;
	}

	/**
	 * @return the maintenanceBusinessLogic
	 */
	public IMaintenanceBusinessLogic getMaintenanceBusinessLogic() {
		return maintenanceBusinessLogic;
	}

	/**
	 * @param maintenanceBusinessLogic the maintenanceBusinessLogic to set
	 */
	public void setMaintenanceBusinessLogic(
			IMaintenanceBusinessLogic maintenanceBusinessLogic) {
		this.maintenanceBusinessLogic = maintenanceBusinessLogic;
	}

	/**
	 * @return the inviteStatusSelect
	 */
	public String getInviteStatusSelect() {
		return inviteStatusSelect;
	}

	/**
	 * @param inviteStatusSelect
	 *            the inviteStatusSelect to set
	 */
	public void setInviteStatusSelect(String inviteStatusSelect) {
		this.inviteStatusSelect = inviteStatusSelect;
	}

	/**
	 * @return the selectedInvites
	 */
	public List<Long> getSelectedInvites() {
		return selectedInvites;
	}

	/**
	 * @return the inviteLinkHistList
	 */
	public List<MyInviteLink> getInviteLinkHistList() {
		return inviteLinkHistList;
	}

	/**
	 * @param inviteLinkHistList the inviteLinkHistList to set
	 */
	public void setInviteLinkHistList(List<MyInviteLink> inviteLinkHistList) {
		this.inviteLinkHistList = inviteLinkHistList;
	}

	/**
	 * @param selectedInvites the selectedInvites to set
	 */
	public void setSelectedInvites(List<Long> selectedInvites) {
		this.selectedInvites = selectedInvites;
	}

	/**
	 * @return the inviteId
	 */
	public Long getInviteId() {
		return inviteId;
	}

	/**
	 * @param inviteId the inviteId to set
	 */
	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
	}

	/**
	 * @return the memNum
	 */
	public Long getMemNum() {
		return memNum;
	}

	/**
	 * @param memNum the memNum to set
	 */
	public void setMemNum(Long memNum) {
		this.memNum = memNum;
	}

	/**
	 * @return the childMemNum
	 */
	public Long getChildMemNum() {
		return childMemNum;
	}

	/**
	 * @param childMemNum the childMemNum to set
	 */
	public void setChildMemNum(Long childMemNum) {
		this.childMemNum = childMemNum;
	}

	/**
	 * メールで友達紹介履歴画面に案内する。
	 * 
	 * @return メールで友達紹介履歴画面
	 */
	public String showMail() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.INVITE_MAIL)) {
			return "maintenance";
		}
		setListInviteHist(inviteInfoBusinessLogic.selectInviteHistByMemNum(inviteStatusSelect));
		return "showMail";
	}

	/**
	 * リンクで友達紹介履歴画面に案内する。
	 * 
	 * @return リンクで友達紹介履歴画面
	 */
	public String showLink() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.INVITE_LINK)) {
			return "maintenance";
		}
		setInviteLinkHistList(inviteInfoBusinessLogic.selectLinkMembersByMemNum(ContextUtil.getMemberNo()));
		return "showLink";
	}

	/**
	 * 選択した友達に再送信する
	 * 
	 * @return
	 */
	public String sendMail() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.INVITE_MAIL)) {
			return "maintenance";
		}
		
		// 選択した友達に再送信する
		inviteInfoBusinessLogic.sendMailAgain(getSelectedInvites());
		
		return "sendMailSuccess";
	}

	/**
	 * 選択した紹介情報を削除する
	 * 
	 * @return
	 */
	public String delete() {
		if (maintenanceBusinessLogic.maintenanceCheckByFunctionCd(PortalConstants.FunctionCode.INVITE_MAIL)) {
			return "maintenance";
		}
		
		// 選択した紹介情報を削除する
		inviteInfoBusinessLogic.deleteInviteInfo(getSelectedInvites());
		
		return "deleteSuccess";
	}
	
	/**
	 * メールで紹介の場合、承認かどうかを判定する
	 * @return
	 */
	public String checkMailStatus() {
		try {
			inviteInfoBusinessLogic.checkMailStatus(getInviteId());
		} catch (LogicException lgex) {
	
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
	
			return "warning";
		}
		return "showMail";
	}

	
	/**
	 * リンクで紹介の場合、承認かどうかを判定する
	 * @return
	 */
	public String checkLinkStatus() {
		try {
			inviteInfoBusinessLogic.checkLinkStatus(getMemNum(), getChildMemNum());
		} catch (LogicException lgex) {
	
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
	
			return "warning";
		}
		return "showLink";
	}

}
