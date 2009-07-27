package com.gameif.portal.businesslogic.impl;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.entity.MemberInfo;

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
		if (memberInfo.getNewPwd().equals(memberInfo.getConfirmPwd())) {
			return memberInfoDao.updatePwd(memberInfo);
		}
		return -1;
	}

	/**
	 * get the detail member info
	 */
	@Transactional
	public MemberInfo showDetail(MemberInfo memberInfo) {
		return memberInfoDao.selectByKey(memberInfo);
	}

	@Transactional
	public int updateMemberInfo(MemberInfo memberInfo) {
		return memberInfoDao.update(memberInfo);
	}

}
