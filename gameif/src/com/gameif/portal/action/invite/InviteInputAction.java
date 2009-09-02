package com.gameif.portal.action.invite;

import java.util.ArrayList;
import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.bean.KeyValueInfo;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.entity.InviteInfo;

public class InviteInputAction extends ModelDrivenActionSupport<InviteInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2224587269669764464L;

	private List<KeyValueInfo> listInviteTitle;
	private List<KeyValueInfo> listInviteTemplate;

	private IInviteInfoBusinessLogic inviteInfoBusinessLogic;

	/**
	 * @return the listInviteTitle
	 */
	public List<KeyValueInfo> getListInviteTitle() {
		return listInviteTitle;
	}

	/**
	 * @param listInviteTitle
	 *            the listInviteTitle to set
	 */
	public void setListInviteTitle(List<KeyValueInfo> listInviteTitle) {
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

	public String create() {
		inviteInfoBusinessLogic.saveInviteInfo(this.getModel());
		return SUCCESS;
	}

	public String inpute() {

		setListInviteTitle(getTitleList());
		setListInviteTemplate(getInviteTemplateList(""));

		return INPUT;
	}

	private List<KeyValueInfo> getTitleList() {
		List<KeyValueInfo> list = new ArrayList<KeyValueInfo>();
		KeyValueInfo info = new KeyValueInfo();

		info.setKey("00");
		info.setValue(" ");

		list.add(info);
		
		info = new KeyValueInfo();
		info.setKey("01");
		info.setValue("創世伝説");

		list.add(info);

		info = new KeyValueInfo();
		info.setKey("02");
		info.setValue("武林三国");

		list.add(info);

		return list;

	}

	private List<KeyValueInfo> getInviteTemplateList(String titleId) {
		List<KeyValueInfo> list = new ArrayList<KeyValueInfo>();
		KeyValueInfo info = new KeyValueInfo();

		info.setKey("00");
		info.setValue(" ");

		list.add(info);

		info = new KeyValueInfo();
		info.setKey("01");
		info.setValue("ここに面白いゲームがあります。");

		list.add(info);

		info = new KeyValueInfo();

		info.setKey("02");
		info.setValue("ゲームイフに登録してみてね。");

		list.add(info);

		return list;

	}
}
