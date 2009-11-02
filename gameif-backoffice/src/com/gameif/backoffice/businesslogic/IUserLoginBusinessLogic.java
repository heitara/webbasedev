package com.gameif.backoffice.businesslogic;

import com.gameif.backoffice.entity.LoginUser;
import com.gameif.common.exception.LogicException;

public interface IUserLoginBusinessLogic {
	
	public void checkUserLogin(LoginUser loginUser) throws LogicException;

}
