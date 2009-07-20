package com.gameif.portal.businesslogic.login;

import com.gameif.portal.entity.login.LoginInfo;

public interface ILoginInfoBusinessLogic {

	public LoginInfo checkLoginInfo(LoginInfo ui);

	public void saveMemberInfo(LoginInfo loginInfo);

	public int changePwd(LoginInfo loginInfo);
}
