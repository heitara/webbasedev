package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.entity.InviteInfo;

public class InviteInfoBusinessLogicImpl extends BaseBusinessLogic implements
IInviteInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243826666019070444L;


	private IInviteInfoDao inviteInfoDao;

	/**
	 * @param inviteInfoDao
	 *            the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 *  @param inviteInfoDao
	 */
	public void saveInviteInfo(InviteInfo inviteInfo) {
		inviteInfoDao.save(inviteInfo);
	}

}
