package com.gameif.backoffice.action.user;

import com.gameif.backoffice.businesslogic.IAuthorityBusinessLogic;
import com.gameif.backoffice.businesslogic.IUserLoginBusinessLogic;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.action.ModelDrivenActionSupport;

public class UserInfoDetailAction extends ModelDrivenActionSupport<LoginUser> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6386272793191635913L;

	private IUserLoginBusinessLogic userLoginBusinessLogic;

	/**
	 * 権限マスタ処理ロジック
	 */
	private IAuthorityBusinessLogic authorityBusinessLogic;

	public String input() {
		return INPUT;
	}

	public String initEdit() {
		// ユーザIDが未入力の場合
		if (this.getModel().getUserId() == null
				|| this.getModel().getUserId().isEmpty()) {
			addActionError(getText("common.dataNotExist"));
			return "list";
		}
		// ログインユーザ情報を取得
		LoginUser loginUser = userLoginBusinessLogic.getLoginUserByUserId(this
				.getModel().getUserId());
		// ログインユーザ情報がない場合
		if (loginUser == null) {
			addActionError(getText("common.dataNotExist"));
			return "list";
		}

		this.setModel(loginUser);

		return "inputEdit";
	}

	public String update() {
		int rtn = userLoginBusinessLogic.updateLoginUser(this.getModel());

		if (rtn != 1) {

		}
		return INPUT;
	}

	public String add() {
		userLoginBusinessLogic.addLoginUser(this.getModel());
		return INPUT;
	}

	/**
	 * @param userLoginBusinessLogic
	 *            the userLoginBusinessLogic to set
	 */
	public void setUserLoginBusinessLogic(
			IUserLoginBusinessLogic userLoginBusinessLogic) {
		this.userLoginBusinessLogic = userLoginBusinessLogic;
	}

	/**
	 * @return the authorityBusinessLogic
	 */
	public IAuthorityBusinessLogic getAuthorityBusinessLogic() {
		return authorityBusinessLogic;
	}

	/**
	 * @param authorityBusinessLogic
	 *            the authorityBusinessLogic to set
	 */
	public void setAuthorityBusinessLogic(
			IAuthorityBusinessLogic authorityBusinessLogic) {
		this.authorityBusinessLogic = authorityBusinessLogic;
	}

}
