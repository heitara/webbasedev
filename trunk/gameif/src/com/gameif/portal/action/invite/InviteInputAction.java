package com.gameif.portal.action.invite;

import java.util.ArrayList;
import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.bean.KeyValueInfo;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.TitleMst;

public class InviteInputAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;

	private List<TitleMst> listInviteTitle;
	private List<KeyValueInfo> listInviteTemplate;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	/**
	 * @return the listInviteTitle
	 */
	public List<TitleMst> getListInviteTitle() {
		return listInviteTitle;
	}

	/**
	 * @param listInviteTitle
	 *            the listInviteTitle to set
	 */
	public void setListInviteTitle(List<TitleMst> listInviteTitle) {
		this.listInviteTitle = listInviteTitle;
	}

	/**
	 * @return the listInviteTemplate
	 */
	public List<KeyValueInfo> getListInviteTemplate() {
		return listInviteTemplate;
	}

	/**
	 * @param listInviteTemplate
	 *            the listInviteTemplate to set
	 */
	public void setListInviteTemplate(List<KeyValueInfo> listInviteTemplate) {
		this.listInviteTemplate = listInviteTemplate;
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
	 * @param masterInfoBusinessLogic the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * 友達紹介画面に案内する。
	 * @return 友達紹介入力画面
	 */
	public String input() {
		setListInviteTitle(masterInfoBusinessLogic.getValidTitleList());
		setListInviteTemplate(getInviteTemplateList(""));

		return INPUT;
	}

	/**
	 * データを友達紹介テーブルに登録する
	 * @return　登録完了画面
	 */
	public String create() {
		inviteInfoBusinessLogic.saveInviteInfo(this.getModel());
		return SUCCESS;
	}

	private List<KeyValueInfo> getInviteTemplateList(String titleId) {
		List<KeyValueInfo> list = new ArrayList<KeyValueInfo>();
		KeyValueInfo info = new KeyValueInfo();

		info.setKey("00");
		info.setValue(" ");

		list.add(info);

		info = new KeyValueInfo();
		info.setKey("01");
		info.setValue("test01");

		list.add(info);

		info = new KeyValueInfo();

		info.setKey("02");
		info.setValue("test02");

		list.add(info);

		return list;

	}
}
