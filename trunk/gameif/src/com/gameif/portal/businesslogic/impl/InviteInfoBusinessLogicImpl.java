package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.entity.InviteInfo;
import com.opensymphony.xwork2.ActionContext;

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
	 * @param inviteInfoDao
	 */
	@Transactional
	public void saveInviteInfo(InviteInfo inviteInfo) {

		/** 複数送信先の場合、メールアドレースを「,」で分割 */
		String[] mailToList = inviteInfo.getInviteMailTo().replace("\r\n", "\n")
				.split("\n");
		Date inviteDate = new Date();

		InviteInfo newInviteInfo = null;
		for (int i = 0; i < mailToList.length; i++) {
			
			newInviteInfo = new InviteInfo();
			
			newInviteInfo.setMemNum((Long) ActionContext.getContext()
					.getSession().get("memNum"));
			// 紹介者のメールアドレス
			newInviteInfo.setInviteMailFrom(inviteInfo.getInviteMailFrom());
			// 友達のメールアドレス
			newInviteInfo.setInviteMailTo(mailToList[i]);
			// 招待データ
			newInviteInfo.setInviteDate(inviteDate);
			// 招待メッセージ
			newInviteInfo.setInviteMsg(inviteInfo.getInviteMsg());
			// タイトル
			newInviteInfo.setTitleId(inviteInfo.getTitleId());
			// 友達登録ステータス
			newInviteInfo.setInviteStatus(PortalConstants.InviteStatus.NO_RESPONSE);
			newInviteInfo.setFriendCreateDate(null);
			newInviteInfo.setCreatedDate(inviteDate);
			newInviteInfo.setLastUpdateDate(inviteDate);
			
			inviteInfoDao.save(newInviteInfo);
		}
	}

}
