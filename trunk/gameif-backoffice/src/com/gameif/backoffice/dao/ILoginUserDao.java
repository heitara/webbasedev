package com.gameif.backoffice.dao;

import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.dao.IBaseDao;

public interface ILoginUserDao extends IBaseDao<LoginUser, LoginUser> {
	
	public LoginUser selectByUserIdAndPwd(LoginUser loginUser);

}
