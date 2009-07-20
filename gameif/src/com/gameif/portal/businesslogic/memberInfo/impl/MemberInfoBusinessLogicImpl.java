package com.gameif.portal.businesslogic.memberInfo.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.memberInfo.IMemberInfoBusinessLogic;
import com.gameif.portal.dao.memberInfo.IMemberInfoDao;
import com.gameif.portal.entity.memberInfo.MemberInfo;

public class MemberInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMemberInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1903255586967518866L;

	private IMemberInfoDao memberInfoDao;

	/**
	 * @param memberInfoDao
	 *            the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	public void saveMemberInfo(MemberInfo memberInfo) {
		memberInfoDao.save(memberInfo);
	}

	public int changePwd(MemberInfo memberInfo) {
		if (memberInfo.getNewpwd().equals(memberInfo.getConfirmpwd())) {
			return memberInfoDao.updatePwd(memberInfo);
		}
		return -1;
	}

	@Override
	public MemberInfo showDetail(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateMemberInfo(MemberInfo memberInfo) {
		// TODO Auto-generated method stub
		return 0;
	}

}
