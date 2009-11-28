package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.bean.UserSearchCondition;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.dao.IBaseDao;

public interface ILoginUserDao extends IBaseDao<LoginUser, LoginUser> {

	public LoginUser selectByUserIdAndPwd(LoginUser loginUser);

	public List<LoginUser> selectByUserSearchCondition(
			UserSearchCondition condition);

}
