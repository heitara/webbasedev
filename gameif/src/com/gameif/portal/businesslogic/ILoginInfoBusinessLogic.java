package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.LoginInfo;

public interface ILoginInfoBusinessLogic {

	public LoginInfo checkLoginInfo(LoginInfo ui);

	public void saveMemberInfo(LoginInfo loginInfo);

	public int changePwd(LoginInfo loginInfo);
}
