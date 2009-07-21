package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.LoginInfo;

public interface ILoginInfoDao extends IBaseDao<LoginInfo, LoginInfo> {
	public int updatePwd(LoginInfo loginInfo);
}
