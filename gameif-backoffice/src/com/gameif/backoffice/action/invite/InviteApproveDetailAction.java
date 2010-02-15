package com.gameif.backoffice.action.invite;

import java.util.List;

import com.gameif.backoffice.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.backoffice.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.MyInviteInfo;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.common.action.ModelDrivenActionSupport;

public class InviteApproveDetailAction extends
		ModelDrivenActionSupport<MemberInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2801109228956162822L;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private BackOfficeProperties backOfficeProperties;

	private List<MyInviteInfo> inviteLinkHistList;
	private List<MyInviteInfo> inviteHistList;

	private List<String> selectedInviteList;
	private List<String> selectedInviteLink;

	/**
	 * 画面初期化
	 */
	public String input() {
		// 紹介者の情報を取得する
		this.setModel(memberInfoBusinessLogic.getMemberInfoByMemNum(this.getModel().getMemNum()));
		// メールで紹介する情報を取得する
		setInviteHistList(inviteInfoBusinessLogic.selectInviteHistByMemNum(this.getModel().getMemNum()));
		// リンクで紹介する情報を取得する
		setInviteLinkHistList(inviteInfoBusinessLogic.selectLinkMembersByMemNum(this.getModel().getMemNum()));
		
		return INPUT;
	}
	
	public String approve() {
		inviteInfoBusinessLogic.updateInviteInfoWithMemNum(selectedInviteList, selectedInviteLink, 
												BackofficeConstants.ApproveStatus.APPROVED, this.getModel().getMemNum());
		return SUCCESS;
	}
	
	public String reject() {
		inviteInfoBusinessLogic.updateInviteInfoWithMemNum(selectedInviteList, selectedInviteLink, 
				BackofficeConstants.ApproveStatus.REJECTED, this.getModel().getMemNum());
		return SUCCESS;
	}

	public String reserve() {
		inviteInfoBusinessLogic.updateInviteInfoWithMemNum(selectedInviteList, selectedInviteLink, 
				BackofficeConstants.ApproveStatus.RESERVE, this.getModel().getMemNum());
		return SUCCESS;
	}
	
	/**
	 * @return the inviteInfoBusinessLogic
	 */
	public IInviteInfoBusinessLogic getInviteInfoBusinessLogic() {
		return inviteInfoBusinessLogic;
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
	 * @return the memberInfoBusinessLogic
	 */
	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}

	/**
	 * @param memberInfoBusinessLogic
	 *            the memberInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	/**
	 * @return the backOfficeProperties
	 */
	public BackOfficeProperties getBackOfficeProperties() {
		return backOfficeProperties;
	}

	/**
	 * @param backOfficeProperties
	 *            the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(
			BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

	/**
	 * @return the inviteLinkHistList
	 */
	public List<MyInviteInfo> getInviteLinkHistList() {
		return inviteLinkHistList;
	}

	/**
	 * @param inviteLinkHistList
	 *            the inviteLinkHistList to set
	 */
	public void setInviteLinkHistList(List<MyInviteInfo> inviteLinkHistList) {
		this.inviteLinkHistList = inviteLinkHistList;
	}

	/**
	 * @return the inviteHistList
	 */
	public List<MyInviteInfo> getInviteHistList() {
		return inviteHistList;
	}

	/**
	 * @param inviteHistList
	 *            the inviteHistList to set
	 */
	public void setInviteHistList(List<MyInviteInfo> inviteHistList) {
		this.inviteHistList = inviteHistList;
	}

	/**
	 * @return the selectedInviteList
	 */
	public List<String> getSelectedInviteList() {
		return selectedInviteList;
	}

	/**
	 * @param selectedInviteList
	 *            the selectedInviteList to set
	 */
	public void setSelectedInviteList(List<String> selectedInviteList) {
		this.selectedInviteList = selectedInviteList;
	}

	/**
	 * @return the selectedInviteLink
	 */
	public List<String> getSelectedInviteLink() {
		return selectedInviteLink;
	}

	/**
	 * @param selectedInviteLink
	 *            the selectedInviteLink to set
	 */
	public void setSelectedInviteLink(List<String> selectedInviteLink) {
		this.selectedInviteLink = selectedInviteLink;
	}

}
