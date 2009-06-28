package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMemberInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7502359588504218332L;
	private IMemberInfoDao memberInfoDao;

	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public MemberInfo checkLoginInfo(MemberInfo memberInfo) {

		return memberInfoDao.selectByKey(memberInfo);
	}

	public void saveMemberInfo(MemberInfo memberInfo) {
		memberInfoDao.save(memberInfo);
	}

}
