package com.gameif.backoffice.dao.impl;

import com.gameif.backoffice.dao.ILoginUserDao;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class LoginUserDaoImpl extends
	AbstractBaseDao<LoginUser, LoginUser> implements ILoginUserDao {

	@Override
	public LoginUser selectByUserIdAndPwd(LoginUser loginUser) {
			
		return (LoginUser)getSqlMapClientTemplate().queryForObject(namespace + ".selectByUserIdAndPwd", loginUser);
	}

}
