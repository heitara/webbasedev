package com.gameif.backoffice.action.invite;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.entity.InviteListInfo;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.common.action.ModelDrivenActionSupport;

public class InviteControlAction extends ModelDrivenActionSupport<InviteSearchCondition> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;
	
	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private BackOfficeProperties backOfficeProperties;

	private List<String> selectedInviteList;
	private List<InviteListInfo> inviteList;

	/**
	 * 
	 */
	public String input() {
		return INPUT;
	}
	
	/**
	 * 友達紹介情報を検索する
	 * @return
	 */
	public String search() {
		if (this.getModel().getInviteType().equals(BackofficeConstants.InviteType.LINK)) {
			
			setInviteList(inviteInfoBusinessLogic.getInviteLinkList(this.getModel()));
			
		} else if (this.getModel().getInviteType().equals(BackofficeConstants.InviteType.MAIL)) {
			
			setInviteList(inviteInfoBusinessLogic.getInviteMailList(this.getModel()));
		}
		
		if (getInviteList() == null || getInviteList().size() == 0) {
			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		return INPUT;
	}
	
	/**
	 * 一括承認を行う
	 * @return
	 */
	public String approve() {
		if (this.getModel().getInviteType().equals(BackofficeConstants.InviteType.MAIL)) {
			
			inviteInfoBusinessLogic.updateInviteInfo(getSelectedInviteList(), BackofficeConstants.ApproveStatus.APPROVED);
			
		} else if (this.getModel().getInviteType().equals(BackofficeConstants.InviteType.LINK)) {
			
			inviteInfoBusinessLogic.updateInviteLink(getSelectedInviteList(), BackofficeConstants.ApproveStatus.APPROVED);
		}
		search();
		return INPUT;
	}
	
	/**
	 * 一括却下を行う
	 * @return
	 */
	public String reject() {
		if (this.getModel().getInviteType().equals(BackofficeConstants.InviteType.MAIL)) {
			
			inviteInfoBusinessLogic.updateInviteInfo(getSelectedInviteList(), BackofficeConstants.ApproveStatus.REJECTED);
			
		} else if (this.getModel().getInviteType().equals(BackofficeConstants.InviteType.LINK)) {
			
			inviteInfoBusinessLogic.updateInviteLink(getSelectedInviteList(), BackofficeConstants.ApproveStatus.REJECTED);
		}
		search();
		return INPUT;
	}
	
	/**
	 * @return the backOfficeProperties
	 */
	public BackOfficeProperties getBackOfficeProperties() {
		return backOfficeProperties;
	}

	/**
	 * @param backOfficeProperties the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

	/**
	 * @return the inviteInfoBusinessLogic
	 */
	public IInviteInfoBusinessLogic getInviteInfoBusinessLogic() {
		return inviteInfoBusinessLogic;
	}

	/**
	 * @param inviteInfoBusinessLogic the inviteInfoBusinessLogic to set
	 */
	public void setInviteInfoBusinessLogic(
			IInviteInfoBusinessLogic inviteInfoBusinessLogic) {
		this.inviteInfoBusinessLogic = inviteInfoBusinessLogic;
	}

	/**
	 * @return the selectedInviteList
	 */
	public List<String> getSelectedInviteList() {
		return selectedInviteList;
	}

	/**
	 * @param selectedInviteList the selectedInviteList to set
	 */
	public void setSelectedInviteList(List<String> selectedInviteList) {
		this.selectedInviteList = selectedInviteList;
	}

	/**
	 * @return the inviteList
	 */
	public List<InviteListInfo> getInviteList() {
		return inviteList;
	}

	/**
	 * @param inviteList
	 *            the inviteList to set
	 */
	public void setInviteList(List<InviteListInfo> inviteList) {
		this.inviteList = inviteList;
	}

}
