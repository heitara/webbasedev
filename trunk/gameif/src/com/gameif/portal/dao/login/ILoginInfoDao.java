package com.gameif.portal.dao.login;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.login.LoginInfo;

public interface ILoginInfoDao extends IBaseDao<LoginInfo, LoginInfo> {
	public int updatePwd(LoginInfo loginInfo);
}
