package com.gameif.portal.action.invite;

import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.helper.PortalProperties;

public class InviteHistAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6176002968758148538L;

	private List<InviteInfo> listInviteHist;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private PortalProperties portalProperties;

	private String inviteStatusSelect;
	
	private List<Long> selectedInvites;

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
	 * @param selectedInvites the selectedInvites to set
	 */
	public void setSelectedInvites(List<Long> selectedInvites) {
		this.selectedInvites = selectedInvites;
	}

	/**
	 * 友達紹介履歴画面に案内する。
	 * 
	 * @return 友達紹介履歴画面
	 */
	public String show() {
		setListInviteHist(inviteInfoBusinessLogic
				.selectInviteHistByMemNum(inviteStatusSelect));
		return INPUT;
	}

	/**
	 * 選択した友達に再送信する
	 * 
	 * @return
	 */
	public String sendMail() {
		
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
		
		// 選択した紹介情報を削除する
		inviteInfoBusinessLogic.deleteInviteInfo(getSelectedInvites());
		
		return "deleteSuccess";
	}

}