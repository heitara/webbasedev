package com.gameif.portal.action.login;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.login.ILoginInfoBusinessLogic;
import com.gameif.portal.entity.login.LoginInfo;

public class LoginInfoAction extends ModelDrivenActionSupport<LoginInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171926714928924158L;

	private ILoginInfoBusinessLogic loginInfoBusinessLogic;

	/**
	 * @param loginInfoBusinessLogic
	 *            the loginInfoBusinessLogic to set
	 */
	public void setLoginInfoBusinessLogic(
			ILoginInfoBusinessLogic loginInfoBusinessLogic) {
		this.loginInfoBusinessLogic = loginInfoBusinessLogic;
	}

	public String login() {

		LoginInfo result = loginInfoBusinessLogic.checkLoginInfo(this
				.getModel());

		if (result != null) {
			return SUCCESS;
		} else {
			addActionError("Your MemberId or Password are not right! Please try again!");
			return INPUT;
		}
	}

	public String reget() {
		return "reget";
	}

	public String creat() {
		return "new";
	}

	public String changePwd() {
		return "changePwd";
	}

	public String updatePwd() {
		int rtn = loginInfoBusinessLogic.changePwd(this.getModel());
		if (rtn != 0) {
			addActionError("Some errors was happened when update Password!");
			return "relogin";
		} else {
			return SUCCESS;
		}
	}

}
