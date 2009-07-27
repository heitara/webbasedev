package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.LoginInfo;

public interface ILoginInfoBusinessLogic {

	public LoginInfo checkLoginInfo(LoginInfo ui);

	public int changePwd(LoginInfo loginInfo);
}
