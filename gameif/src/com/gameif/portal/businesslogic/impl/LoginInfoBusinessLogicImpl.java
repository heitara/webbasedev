package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.ILoginInfoBusinessLogic;
import com.gameif.portal.dao.ILoginInfoDao;
import com.gameif.portal.entity.LoginInfo;

public class LoginInfoBusinessLogicImpl extends BaseBusinessLogic implements
		ILoginInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502359588504218332L;
	private ILoginInfoDao loginInfoDao;

	/**
	 * @param loginInfoDao
	 *            the loginInfoDao to set
	 */
	public void setLoginInfoDao(ILoginInfoDao loginInfoDao) {
		this.loginInfoDao = loginInfoDao;
	}

	public LoginInfo checkLoginInfo(LoginInfo loginInfo) {

		return loginInfoDao.selectByKey(loginInfo);
	}

	public void saveMemberInfo(LoginInfo memberInfo) {
		loginInfoDao.save(memberInfo);
	}

	public int changePwd(LoginInfo member) {
		if (member.getNewpwd().equals(member.getConfirmpwd())) {
			return loginInfoDao.updatePwd(member);
		}
		return -1;
	}

}
