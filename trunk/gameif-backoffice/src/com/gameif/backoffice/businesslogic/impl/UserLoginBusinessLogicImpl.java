package com.gameif.backoffice.businesslogic.impl;

import java.util.List;

import com.gameif.backoffice.bean.UserSearchCondition;
import com.gameif.backoffice.businesslogic.IUserLoginBusinessLogic;
import com.gameif.backoffice.dao.ILoginUserDao;
import com.gameif.backoffice.entity.LoginUser;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.util.SecurityUtil;

public class UserLoginBusinessLogicImpl extends BaseBusinessLogic implements
IUserLoginBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7282088976424213285L;
	
	private ILoginUserDao loginUserDao;

	/**
	 * ユーザログインを行う
	 */
	@Override
	public void checkUserLogin(LoginUser loginUser) throws LogicException {
		loginUser.setPassword(SecurityUtil.getMD5String(loginUser.getPassword()));
		LoginUser newLoginUser = loginUserDao.selectByUserIdAndPwd(loginUser);
		
		if (newLoginUser == null) {
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		ContextUtil.setUserId(newLoginUser.getUserId());
		ContextUtil.setNickName(newLoginUser.getNickName());
	}

	/**
	 * @return the loginUserDao
	 */
	public ILoginUserDao getLoginUserDao() {
		return loginUserDao;
	}

	/**
	 * @param loginUserDao the loginUserDao to set
	 */
	public void setLoginUserDao(ILoginUserDao loginUserDao) {
		this.loginUserDao = loginUserDao;
	}

	@Override
	public List<LoginUser> getLoginUserList(UserSearchCondition condition) {
		return loginUserDao.selectByUserSearchCondition(condition);
	}

	@Override
	public void addLoginUser(LoginUser loginUser) {
		loginUserDao.save(loginUser);
	}

	@Override
	public int updateLoginUser(LoginUser loginUser) {
		return loginUserDao.update(loginUser);
	}

	@Override
	public boolean isExists(String userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoginUser getLoginUserByUserId(String userId) {
		LoginUser entity = new LoginUser();
		entity.setUserId(userId);
		
		return loginUserDao.selectByKey(entity);
	}
	
	

}

