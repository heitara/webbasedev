package com.gameif.portal.action.invite;

import java.util.ArrayList;
import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.bean.KeyValueInfo;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;

public class InviteHistAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6176002968758148538L;

	private List<InviteInfo> listInviteHist;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;

	private List<KeyValueInfo> inviteStatusList;

	private String inviteStatusSelect;

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
	 * @return the inviteStatusList
	 */
	public List<KeyValueInfo> getInviteStatusList() {
		this.inviteStatusList = new ArrayList<KeyValueInfo>();
		KeyValueInfo kvi = new KeyValueInfo();
		kvi.setKey("99");
		kvi.setValue("全て");

		this.inviteStatusList.add(kvi);

		kvi = new KeyValueInfo();
		kvi.setKey("0");
		kvi.setValue("応答無し");
		this.inviteStatusList.add(kvi);

		kvi = new KeyValueInfo();
		kvi.setKey("1");
		kvi.setValue("会員登録済");
		this.inviteStatusList.add(kvi);

		return inviteStatusList;
	}

	/**
	 * @param inviteStatusList
	 *            the inviteStatusList to set
	 */
	public void setInviteStatusList(List<KeyValueInfo> inviteStatusList) {
		this.inviteStatusList = inviteStatusList;
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
		// TODO:再送信機能まだ実装しない
		return SUCCESS;
	}

	/**
	 * 選択した友達を削除する
	 * 
	 * @return
	 */
	public String delete() {
		// TODO:削除機能まだ実装しない
		return SUCCESS;
	}

}
