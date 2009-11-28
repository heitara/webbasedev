package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.bean.UserSearchCondition;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.exception.LogicException;

public interface IUserLoginBusinessLogic {

	public void checkUserLogin(LoginUser loginUser) throws LogicException;

	public List<LoginUser> getLoginUserList(UserSearchCondition condition);

	public int updateLoginUser(LoginUser loginUser);

	public void addLoginUser(LoginUser loginUser);
	
	public boolean isExists(String userId);
	
	public LoginUser getLoginUserByUserId(String userId);
	
}
