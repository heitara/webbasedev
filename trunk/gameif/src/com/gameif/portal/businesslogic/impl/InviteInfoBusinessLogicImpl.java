package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
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
	 * 友達紹介情報を登録する。
	 * @param inviteInfoDao
	 */
	@Transactional
	public void saveInviteInfo(InviteInfo inviteInfo) {

		/** 複数友達の場合、メールアドレースを「,」で分割 */
		String[] mailToList = inviteInfo.getInviteMailTo().replace("\r\n", "\n")
				.split("\n");
		Date inviteDate = new Date();

		InviteInfo newInviteInfo = null;
		for (int i = 0; i < mailToList.length; i++) {
			
			newInviteInfo = new InviteInfo();
			
			newInviteInfo.setMemNum(ContextUtil.getMemberNo());
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
			// 削除フラグ
			newInviteInfo.setDeleteFlag(PortalConstants.DeleteFlag.NORMAL);
			
			newInviteInfo.setCreatedDate(inviteDate);
			newInviteInfo.setCreatedUser(ContextUtil.getAccountId());
			newInviteInfo.setLastUpdateDate(inviteDate);
			newInviteInfo.setLastUpdateUser(ContextUtil.getAccountId());
			
			inviteInfoDao.save(newInviteInfo);
		}
		// days: select from XMl
//		inviteInfoDao.deleteInvalidInvite(ContextUtil.getMemberNo(), days);
		inviteInfoDao.deleteInvalidInvite(ContextUtil.getMemberNo(), new Integer(2));
	}

	/**
	 * 紹介者IDより、友達紹介履歴を取得する。
	 * @param memNum
	 */
	@Override
	public List<InviteInfo> selectInviteHistByMemNum() {
		return inviteInfoDao.selectInviteHistByMemNum(ContextUtil.getMemberNo());
	}

}
