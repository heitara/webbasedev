package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.util.ContextUtil;

public class InviteInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IInviteInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7243826666019070444L;

	private IInviteInfoDao inviteInfoDao;
	private TemplateMailer templateMailer;
	private ITitleMstDao titleMstDao;
	
	private Integer deleDays;
	private Integer maxMailCount;

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
	 * @return the titleMstDao
	 */
	public ITitleMstDao getTitleMstDao() {
		return titleMstDao;
	}

	/**
	 * @param titleMstDao the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	/**
	 * @return the deleDays
	 */
	public Integer getDeleDays() {
		return deleDays;
	}

	/**
	 * @param deleDays the deleDays to set
	 */
	public void setDeleDays(Integer deleDays) {
		this.deleDays = deleDays;
	}
	
	/**
	 * @return the maxMailCount
	 */
	public Integer getMaxMailCount() {
		return maxMailCount;
	}

	/**
	 * @param maxMailCount the maxMailCount to set
	 */
	public void setMaxMailCount(Integer maxMailCount) {
		this.maxMailCount = maxMailCount;
	}

	/**
	 * 友達紹介情報を登録する。
	 * 
	 * @param inviteInfoDao
	 */
	@Transactional
	public void saveInviteInfo(InviteInfo inviteInfo, Map<String, String> mailToList) throws LogicException {

		// 最大送信件数のチェック
		if (mailToList.size() > getMaxMailCount()) {
			throw new OutOfMaxCountException("mail list is Out of max count!");
		}
		
		// 招待時間
		Date inviteDate = new Date();
		
		inviteInfo.setInviteDate(inviteDate);
		inviteInfo.setMemNum(ContextUtil.getMemberNo());
		// 本日にの送信件数を検索する
		Integer count = inviteInfoDao.selectCountByMemNumInTime(inviteInfo);
		// 最大送信件数のチェック
		if (getMaxMailCount() < (count + mailToList.size())) {
			throw new OutOfMaxCountException("mail list is Out of max count!");
		}

		String titleName = titleMstDao.selectNameById(inviteInfo.getTitleId());
		
		InviteInfo newInviteInfo = null;
		for(Map.Entry<String, String> mailTo : mailToList.entrySet()) {
			
			newInviteInfo = new InviteInfo();

			newInviteInfo.setMemNum(ContextUtil.getMemberNo());
			// 紹介者のメールアドレス
			newInviteInfo.setInviteMailFrom(inviteInfo.getInviteMailFrom());
			// 友達のメールアドレス
			newInviteInfo.setInviteMailTo(mailTo.getKey());
			// 招待データ
			newInviteInfo.setInviteDate(inviteDate);
			// 招待メッセージ
			newInviteInfo.setInviteMsg(inviteInfo.getInviteMsg());
			// タイトル
			newInviteInfo.setTitleId(inviteInfo.getTitleId());
			// 友達の名前
			newInviteInfo.setFriendName(mailTo.getValue());
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
			props.put("name", newInviteInfo.getFriendName());
			// 紹介するゲーム
			props.put("titleName", titleName);
			// データID
			props.put("inviteId", newInviteInfo.getInviteId().toString());
			// 招待メッセージ
			props.put("inviteMsg",newInviteInfo.getInviteMsg());
			// 差出人の名前
			props.put("nickName",ContextUtil.getNickName());
			// 差出人
			props.put("mailFrom",newInviteInfo.getInviteMailFrom());
			// 招待メールを送信する
			templateMailer.sendAsyncMail(newInviteInfo.getInviteMailTo(), "inviteFriend", props, true);
		}
		// ロジック削除されたデータを削除する
		inviteInfoDao.deleteInvalidInvite(ContextUtil.getMemberNo(), getDeleDays());
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

	/**
	 * 紹介情報を再送信する。
	 * 
	 * @param inviteList 選択した紹介情報ID
	 */
	@Transactional
	@Override
	public void sendMailAgain(List<Long> inviteList) {
		InviteInfo inviteInfo = new InviteInfo();
		// 招待時間
		Date inviteDate = new Date();
		
		String titleName = titleMstDao.selectNameById(inviteInfo.getTitleId());
		
		for (int i = 0; i < inviteList.size(); i++) {
			
			inviteInfo.setInviteId(inviteList.get(i));
			inviteInfo = inviteInfoDao.selectByKey(inviteInfo);
			if (inviteInfo == null) {
				continue;
			}

			// 招待データ
			inviteInfo.setInviteDate(inviteDate);
			// 友達登録ステータス
			inviteInfo
					.setInviteStatus(PortalConstants.InviteStatus.NO_RESPONSE);
			// 削除フラグ
			inviteInfo.setDeleteFlag(PortalConstants.DeleteFlag.NORMAL);
			inviteInfo.setLastUpdateDate(inviteDate);
			inviteInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

			inviteInfoDao.update(inviteInfo);

			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 友達の名前
			props.put("name", inviteInfo.getFriendName());
			// 紹介するゲーム
			props.put("titleName", titleName);
			// データID
			props.put("inviteId", inviteInfo.getInviteId().toString());
			// 招待メッセージ
			props.put("inviteMsg",inviteInfo.getInviteMsg());
			// 差出人
			props.put("mailFrom",inviteInfo.getInviteMailFrom());
			templateMailer.sendAsyncMail(inviteInfo.getInviteMailTo(), "inviteFriend", props, true);
			
		}
	}

	/**
	 * 選択した紹介情報を削除する
	 * 
	 * @param inviteList 選択した紹介情報ID
	 */
	@Transactional
	@Override
	public void deleteInviteInfo(List<Long> inviteList) {
		InviteInfo inviteInfo = new InviteInfo();
		// 招待時間
		Date inviteDate = new Date();
		
		for (int i = 0; i < inviteList.size(); i++) {
			
			inviteInfo.setInviteId(inviteList.get(i));
			inviteInfo = inviteInfoDao.selectByKey(inviteInfo);
			if (inviteInfo == null) {
				continue;
			}

			// 削除フラグ
			inviteInfo.setDeleteFlag(PortalConstants.DeleteFlag.DELETEED);
			inviteInfo.setLastUpdateDate(inviteDate);
			inviteInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

			inviteInfoDao.update(inviteInfo);
			
		}
	}

}
