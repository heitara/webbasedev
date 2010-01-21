package com.gameif.backoffice.action.invite;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.common.action.ModelDrivenActionSupport;

public class InviteApproveAction extends ModelDrivenActionSupport<InviteSearchCondition> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;
	
	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private BackOfficeProperties backOfficeProperties;

	private List<Long> selectedInviteList;
	private List<MemberInfo> inviteList;

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
		setInviteList(inviteInfoBusinessLogic.getInviteList(this.getModel()));
		
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
		inviteInfoBusinessLogic.updateInviteInfo(getSelectedInviteList(), BackofficeConstants.ApproveStatus.APPROVED);
		return "finished";
	}
	
	/**
	 * 一括却下を行う
	 * @return
	 */
	public String reject() {
		inviteInfoBusinessLogic.updateInviteInfo(getSelectedInviteList(), BackofficeConstants.ApproveStatus.REJECTED);
		return "finished";
	}
	
	public String giveTicket() {
		inviteInfoBusinessLogic.giveTicket(getSelectedInviteList());
		return "finished";
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
	public List<Long> getSelectedInviteList() {
		return selectedInviteList;
	}

	/**
	 * @param selectedInviteList the selectedInviteList to set
	 */
	public void setSelectedInviteList(List<Long> selectedInviteList) {
		this.selectedInviteList = selectedInviteList;
	}

	/**
	 * @return the inviteList
	 */
	public List<MemberInfo> getInviteList() {
		return inviteList;
	}

	/**
	 * @param inviteList
	 *            the inviteList to set
	 */
	public void setInviteList(List<MemberInfo> inviteList) {
		this.inviteList = inviteList;
	}

}
