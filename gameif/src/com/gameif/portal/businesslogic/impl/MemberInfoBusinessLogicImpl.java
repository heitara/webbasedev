package com.gameif.portal.businesslogic.impl;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IMemberLoginInfoDao;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMemberInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1903255586967518866L;

	private IMemberInfoDao memberInfoDao;

	private IMemberLoginInfoDao memberLoginInfoDao;

	/**
	 * @param memberInfoDao
	 *            the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	/**
	 * @param memberLoginInfoDao
	 *            the memberLoginInfoDao to set
	 */
	public void setMemberLoginInfoDao(IMemberLoginInfoDao memberLoginInfoDao) {
		this.memberLoginInfoDao = memberLoginInfoDao;
	}

	public int changePwd(MemberInfo memberInfo) {
		if (memberInfo.getNewPwd().equals(memberInfo.getConfirmPwd())) {
			return memberInfoDao.updatePwd(memberInfo);
		}
		return -1;
	}

	public void saveMemberInfo(MemberInfo memberInfo) {
		memberInfoDao.save(memberInfo);
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

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * 
	 * @param clientIp
	 * @param checkTime
	 * @return
	 */
	public int countMembersByIPInTime(String clientIp, int checkTime) {

		ComSearchCondition searchCondition = new ComSearchCondition();
		searchCondition.setClientIp(clientIp);
		searchCondition.setCheckTime(checkTime);

		return memberLoginInfoDao.selectCountByIPAndTime(searchCondition);
	}

}
