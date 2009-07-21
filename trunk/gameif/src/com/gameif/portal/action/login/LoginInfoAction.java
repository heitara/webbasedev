package com.gameif.portal.action.login;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.ILoginInfoBusinessLogic;
import com.gameif.portal.entity.LoginInfo;

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

	public String execute() {

		LoginInfo result = loginInfoBusinessLogic.checkLoginInfo(this
				.getModel());

		if (result != null) {
			return SUCCESS;
		} else {
			addActionError("Your MemberId or Password are not right! Please try again!");
			return INPUT;
		}
	}

}
