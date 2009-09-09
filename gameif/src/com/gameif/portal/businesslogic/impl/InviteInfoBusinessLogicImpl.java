package com.gameif.portal.businesslogic.impl;

import java.util.List;

import com.gameif.common.bean.KeyValueInfo;
import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.dao.IInviteTemplateDao;
import com.gameif.portal.entity.InviteInfo;

public class InviteInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IInviteInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243826666019070444L;

	private IInviteInfoDao inviteInfoDao;

	private IInviteTemplateDao inviteTemplateDao;

	/**
	 * @param inviteInfoDao
	 *            the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @param inviteTemplateDao
	 *            the inviteTemplateDao to set
	 */
	public void setInviteTemplateDao(IInviteTemplateDao inviteTemplateDao) {
		this.inviteTemplateDao = inviteTemplateDao;
	}

	/**
	 * @param inviteInfoDao
	 */
	public void saveInviteInfo(InviteInfo inviteInfo) {
		
		/** 複数送信先の場合、メールアドレースを「,」で分割 */
		String[] mailToList = inviteInfo.getInviteMailTo().split(",");
		
		InviteInfo newInviteInfo = new InviteInfo();
		for (int i=0; i < mailToList.length; i++) {
			newInviteInfo = inviteInfo;
			newInviteInfo.setInviteMailTo(mailToList[i]);
			inviteInfoDao.save(newInviteInfo);
		}
	}

}
