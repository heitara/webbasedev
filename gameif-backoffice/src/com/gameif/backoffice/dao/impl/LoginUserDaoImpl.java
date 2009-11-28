package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.bean.UserSearchCondition;
import com.gameif.backoffice.dao.ILoginUserDao;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class LoginUserDaoImpl extends AbstractBaseDao<LoginUser, LoginUser>
		implements ILoginUserDao {

	@Override
	public LoginUser selectByUserIdAndPwd(LoginUser loginUser) {

		return (LoginUser) getSqlMapClientTemplate().queryForObject(
				namespace + ".selectByUserIdAndPwd", loginUser);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LoginUser> selectByUserSearchCondition(
			UserSearchCondition condition) {
		return getSqlMapClientTemplate().queryForList(
				namespace + ".selectByUserSearchCondition", condition);
	}

}
