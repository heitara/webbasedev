package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.common.helper.TemplateMailer;
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
	private TemplateMailer templateMailer;

	/**
	 * @param inviteInfoDao
	 *            the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @return the templateMailer
	 */
	public TemplateMailer getTemplateMailer() {
		return templateMailer;
	}

	/**
	 * @param templateMailer the templateMailer to set
	 */
	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}

	/**
	 * 友達紹介情報を登録する。
	 * 
	 * @param inviteInfoDao
	 */
	@Transactional
	public void saveInviteInfo(InviteInfo inviteInfo) throws LogicException {

		// 複数友達の場合、メールアドレースを「,」で分割 
		String[] mailToList = inviteInfo.getInviteMailTo().trim().replace("\r\n", "\n").split("\n");
		
		// 招待時間
		Date inviteDate = new Date();
		
		inviteInfo.setInviteDate(inviteDate);
		inviteInfo.setMemNum(ContextUtil.getMemberNo());
		// 本日にの送信件数を検索する
		Integer count = inviteInfoDao.selectCountByMemNumInTime(inviteInfo);
		// 最大送信件数のチェック
		if (10 < (count + mailToList.length)) {
			throw new OutOfMaxCountException("mail list is Out of max count!");
		}

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
			newInviteInfo
					.setInviteStatus(PortalConstants.InviteStatus.NO_RESPONSE);
			// 削除フラグ
			newInviteInfo.setDeleteFlag(PortalConstants.DeleteFlag.NORMAL);

			newInviteInfo.setCreatedDate(inviteDate);
			newInviteInfo.setCreatedUser(ContextUtil.getMemberNo().toString());
			newInviteInfo.setLastUpdateDate(inviteDate);
			newInviteInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

			inviteInfoDao.save(newInviteInfo);

			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 友達の名前
			props.put("name", "");
			// 紹介するゲーム
			props.put("titleName", newInviteInfo.getTitleId().toString());
			// データID
			props.put("inviteId", newInviteInfo.getInviteId().toString());
			// 招待メッセージ
			props.put("inviteMsg",newInviteInfo.getInviteMsg());
			// 差出人
			props.put("mailFrom",newInviteInfo.getInviteMailFrom());
			templateMailer.sendAsyncMail(newInviteInfo.getInviteMailTo(), "inviteFriend", props);
		}
		// days: select from XMl
		// inviteInfoDao.deleteInvalidInvite(ContextUtil.getMemberNo(), days);
		inviteInfoDao.deleteInvalidInvite(ContextUtil.getMemberNo(),
				new Integer(2));
	}

	/**
	 * 紹介者IDより、友達紹介履歴を取得する。
	 * 
	 * @param inviteStatus
	 */
	@Override
	public List<InviteInfo> selectInviteHistByMemNum(String inviteStatus) {
		InviteInfo condition = new InviteInfo();
		condition.setMemNum(ContextUtil.getMemberNo());
		condition.setInviteStatus(inviteStatus);

		return inviteInfoDao.selectInviteHistByMemNum(condition);
	}

}
