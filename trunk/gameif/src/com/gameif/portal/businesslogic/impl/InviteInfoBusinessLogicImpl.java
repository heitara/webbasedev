package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfDateException;
import com.gameif.common.exception.OutOfMaxCountException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.dao.IInviteLinkDao;
import com.gameif.portal.dao.IInviteLinkHistDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IMemberLoginHistDao;
import com.gameif.portal.dao.IPlayHistDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.InviteLink;
import com.gameif.portal.entity.InviteLinkHist;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.MyInviteLink;
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
	private IInviteLinkDao inviteLinkDao;
	private IInviteLinkHistDao inviteLinkHistDao;
	private IMemberInfoDao memberInfoDao;
	private IMemberLoginHistDao memberLoginHistDao;
	private IPlayHistDao playHistDao;

	private Integer deleDays;
	private Integer maxMailCount;
	private String inviteUrl;
	private Integer playCount;

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
	 * @param templateMailer
	 *            the templateMailer to set
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
	 * @param inviteLinkDao the inviteLinkDao to set
	 */
	public void setInviteLinkDao(IInviteLinkDao inviteLinkDao) {
		this.inviteLinkDao = inviteLinkDao;
	}

	/**
	 * @param titleMstDao
	 *            the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	/**
	 * @param inviteLinkHistDao the inviteLinkHistDao to set
	 */
	public void setInviteLinkHistDao(IInviteLinkHistDao inviteLinkHistDao) {
		this.inviteLinkHistDao = inviteLinkHistDao;
	}

	/**
	 * @param memberInfoDao the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}

	/**
	 * @param memberLoginHistDao the memberLoginHistDao to set
	 */
	public void setMemberLoginHistDao(IMemberLoginHistDao memberLoginHistDao) {
		this.memberLoginHistDao = memberLoginHistDao;
	}

	/**
	 * @param playHistDao the playHistDao to set
	 */
	public void setPlayHistDao(IPlayHistDao playHistDao) {
		this.playHistDao = playHistDao;
	}

	/**
	 * @return the deleDays
	 */
	public Integer getDeleDays() {
		return deleDays;
	}

	/**
	 * @param deleDays
	 *            the deleDays to set
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
	 * @param maxMailCount
	 *            the maxMailCount to set
	 */
	public void setMaxMailCount(Integer maxMailCount) {
		this.maxMailCount = maxMailCount;
	}

	/**
	 * @return the inviteUrl
	 */
	public String getInviteUrl() {
		return inviteUrl;
	}

	/**
	 * @param inviteUrl
	 *            the inviteUrl to set
	 */
	public void setInviteUrl(String inviteUrl) {
		this.inviteUrl = inviteUrl;
	}

	/**
	 * @return the playCount
	 */
	public Integer getPlayCount() {
		return playCount;
	}

	/**
	 * @param playCount the playCount to set
	 */
	public void setPlayCount(Integer playCount) {
		this.playCount = playCount;
	}

	/**
	 * 友達紹介情報を登録する。
	 * 
	 * @param inviteInfoDao
	 */
	@Transactional
	public void saveInviteInfo(InviteInfo inviteInfo,
			Map<String, String> mailToList) throws LogicException {

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
		for (Map.Entry<String, String> mailTo : mailToList.entrySet()) {

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
			newInviteInfo.setInviteStatus(PortalConstants.InviteStatus.NO_RESPONSE);
			// 削除フラグ
			newInviteInfo.setDeleteFlag(PortalConstants.DeleteFlag.NORMAL);
			// 承認ステータス
			newInviteInfo.setApproveStatus(PortalConstants.ApproveStatus.NO_APPROVE);
			// 親のクッキーを設定する
			newInviteInfo.setParentCookie(PortalConstants.INVITE_COOKIE_VALUE);
			// 子のクッキーを設定する
			newInviteInfo.setChildCookie(null);

			newInviteInfo.setCreatedDate(inviteDate);
			newInviteInfo.setCreatedUser(ContextUtil.getMemberNo().toString());
			newInviteInfo.setLastUpdateDate(inviteDate);
			newInviteInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

			inviteInfoDao.save(newInviteInfo);

			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 差出人の名前
			props.put("nickName", ContextUtil.getNickName());
			// 差出人
			props.put("mailFrom", newInviteInfo.getInviteMailFrom());
			// 紹介するゲーム
			props.put("titleName", titleName);
			// データID
			props.put(PortalConstants.Key.SEURE_PARAM_KEY, SecurityUtil.encodeParam(new StringBuffer()
								.append("inviteId=")
								.append(newInviteInfo.getInviteId().toString())
								.toString()));
			// タイトルID
			props.put("title", newInviteInfo.getTitleId().toString());
			// 招待メッセージ
			props.put("inviteMsg", newInviteInfo.getInviteMsg());
			// 送信
			templateMailer.sendAsyncMail(newInviteInfo.getInviteMailTo(), "inviteFriend", props, true);
		}
		
		ContextUtil.setInviteCookie(PortalConstants.INVITE_COOKIE_VALUE);
		
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
	 * @param inviteList
	 *            選択した紹介情報ID
	 */
	@Transactional
	@Override
	public void sendMailAgain(List<Long> inviteList) {
		InviteInfo inviteInfo = new InviteInfo();
		// 招待時間
		Date inviteDate = new Date();

		String titleName = "";

		for (int i = 0; i < inviteList.size(); i++) {

			inviteInfo.setInviteId(inviteList.get(i));
			inviteInfo = inviteInfoDao.selectByKey(inviteInfo);
			if (inviteInfo == null) {
				continue;
			}

			// 招待データ
			inviteInfo.setInviteDate(inviteDate);
			// 友達登録ステータス
			inviteInfo.setInviteStatus(PortalConstants.InviteStatus.NO_RESPONSE);
			// 削除フラグ
			inviteInfo.setDeleteFlag(PortalConstants.DeleteFlag.NORMAL);
			// 承認ステータス
			inviteInfo.setApproveStatus(PortalConstants.ApproveStatus.NO_APPROVE);
			// 親のクッキーを設定する
			inviteInfo.setParentCookie(PortalConstants.INVITE_COOKIE_VALUE);
			// 子のクッキーを設定する
			inviteInfo.setChildCookie(null);
			inviteInfo.setLastUpdateDate(inviteDate);
			inviteInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

			inviteInfoDao.update(inviteInfo);
			
			titleName = titleMstDao.selectNameById(inviteInfo.getTitleId());

			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 差出人の名前
			props.put("nickName", ContextUtil.getNickName());
			// 差出人
			props.put("mailFrom", inviteInfo.getInviteMailFrom());
			// 紹介するゲーム
			props.put("titleName", titleName);
			// データID
			props.put(PortalConstants.Key.SEURE_PARAM_KEY, SecurityUtil.encodeParam(new StringBuffer()
							.append("inviteId=")
							.append(inviteInfo.getInviteId().toString())
							.toString()));
			// タイトルID
			props.put("title", inviteInfo.getTitleId().toString());
			// 招待メッセージ
			props.put("inviteMsg", inviteInfo.getInviteMsg());
			
			templateMailer.sendAsyncMail(inviteInfo.getInviteMailTo(), "inviteFriend", props, true);

		}
		
		ContextUtil.setInviteCookie(PortalConstants.INVITE_COOKIE_VALUE);
	}

	/**
	 * 選択した紹介情報を削除する
	 * 
	 * @param inviteList
	 *            選択した紹介情報ID
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

	/**
	 * 招待リンクを生成して、招待情報をDBに登録する
	 * 
	 * @param titleId
	 *            紹介するゲームID
	 */
	@Transactional
	@Override
	public String createMemInviteLink(Integer titleId) {

		String LinkUrl = "";

		InviteLink inviteLink = inviteLinkDao.selectByMemNum(ContextUtil.getMemberNo());
		if (inviteLink == null) {
			inviteLink = new InviteLink();

			// リンクキー：「10桁長さ（会員番号を16進の文字列に変換する）」+「5桁ランダムキー」
			String linkKey = ContextUtil.getMemberNo().toHexString(10).concat(SecurityUtil.getRandomAuthKey(5));
			inviteLink.setMemNum(ContextUtil.getMemberNo());
			inviteLink.setLinkKey(linkKey);
			inviteLink.setCreatedDate(new Date());
			inviteLink.setCookie(ContextUtil.getInviteCookie());

			inviteLinkDao.save(inviteLink);
		}
		
		if (titleId == null) {
			titleId = 0;
		}
		// 認証キーをエンコード
		String enc = SecurityUtil.encodeParam(new StringBuffer().
							append("linkKey=").
							append(inviteLink.getLinkKey())
							.toString());
		
		// 招待するリンクを生成する
		LinkUrl = new StringBuffer().append(getInviteUrl())
					.append("?").append(PortalConstants.Key.SEURE_PARAM_KEY).append("=")
					.append(enc)
					.append("&title=")
					.append(titleId.toString())
					.toString();
		
		ContextUtil.setInviteCookie(PortalConstants.INVITE_COOKIE_VALUE);
		
		return LinkUrl;
	}

	/**
	 * 会員番号より、該当会員がリンクで招待した友達を検索する
	 * @param memNum 会員番号
	 * @return 友達リスト
	 */
	@Override
	public List<MyInviteLink> selectLinkMembersByMemNum(Long memNum) {
		return inviteLinkHistDao.selectLinkMembersByMemNum(memNum);
	}

	@Transactional
	@Override
	public void checkMailStatus(Long inviteId) throws LogicException {
		
		// 紹介情報を検索する
		InviteInfo inviteInfo = inviteInfoDao.selectForUpdate(inviteId);
		if (inviteInfo == null) {
			
			// データが存在しない
			throw new OutOfDateException("InviteInfo Data does not exist.");
			
		}
		
		// 同じIPが存在する場合、「承認待ち」状態に変更し、手動的に承認を行う
		// 紹介された友達のゲームプレイ日数が指定日数により小さい場合、「承認待ち」状態に変更し、手動的に承認を行う
		// 紹介された友達のゲームプレイ日数が指定日数により小さい場合、「承認待ち」状態に変更し、手動的に承認を行う
		if (checkEntryIp(inviteInfo.getChildMemNum()) || 
			checkPlayCount(inviteInfo.getChildMemNum()) ||
			checkMailCookie(inviteInfo)) {
			// 「承認済」に変更する
			inviteInfo.setApproveStatus(PortalConstants.ApproveStatus.APPROVING);
		} else {

			// 「承認待ち」に変更する
			inviteInfo.setApproveStatus(PortalConstants.ApproveStatus.APPROVED);
		}
		
		inviteInfo.setLastUpdateDate(new Date());
		inviteInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		inviteInfoDao.update(inviteInfo);
		
	}

	@Transactional
	@Override
	public void checkLinkStatus(Long memNum, Long childMemNum) throws LogicException {
		
		InviteLinkHist inviteLinkHist = inviteLinkHistDao.selectForUpdate(memNum, childMemNum);
		if (inviteLinkHist == null) {
			
			// データが存在しない
			throw new OutOfDateException("InviteLinkHist Data does not exist.");
			
		}
		
		// 同じIPが存在する場合、「承認待ち」状態に変更し、手動的に承認を行う
		// 紹介された友達のゲームプレイ日数が指定日数により小さい場合、「承認待ち」状態に変更し、手動的に承認を行う
		// 紹介された友達のゲームプレイ日数が指定日数により小さい場合、「承認待ち」状態に変更し、手動的に承認を行う
		if (checkEntryIp(inviteLinkHist.getChildMemNum()) || 
			checkPlayCount(inviteLinkHist.getChildMemNum()) ||
			checkLinkCookie(inviteLinkHist)) {
			// 「承認済」に変更する
			inviteLinkHist.setApproveStatus(PortalConstants.ApproveStatus.APPROVING);
		} else {

			// 「承認待ち」に変更する
			inviteLinkHist.setApproveStatus(PortalConstants.ApproveStatus.APPROVED);
		}
		
		inviteLinkHistDao.update(inviteLinkHist);
		
	}
	
	/**
	 * 紹介された友達の登録IPが既にログイン履歴テーブルに存在かどうかのチェック
	 * @param childMemNum　紹介された友達の会員番号
	 * @return false:存在しない、true:存在する（手動的に承認を行う）
	 */
	private Boolean checkEntryIp(Long childMemNum) {
		Boolean bRtn = false;
		
		MemberInfo member = new MemberInfo();
		member.setMemNum(childMemNum);
		member = memberInfoDao.selectByKey(member);
		if (member == null) {
			return true;
		}
		
		Integer count = memberLoginHistDao.selectCountByEntryIp(member.getEntryIp(), member.getMemNum());
		if (count > 0) {
			bRtn = true;
		}
		
		return bRtn;
	}
	
	/**
	 * 紹介された友達のゲームプレイ日数をチェックする
	 * @param childMemNum　紹介された友達の	会員番号
	 * @return false:自動的に承認する、true:手動的に承認を行う
	 */
	private Boolean checkPlayCount(Long childMemNum) {
		Boolean bRtn = false;
		
		Integer count = playHistDao.selectPlayDaysByMemNum(childMemNum);
		if (count < playCount) {
			bRtn = true;
		}
		
		return bRtn;
	}
	
	/**
	 * メールで紹介の場合、クッキーの値をチェックする
	 * @param inviteInfo
	 * @return false:自動的に承認する、true:手動的に承認を行う
	 */
	private Boolean checkMailCookie(InviteInfo inviteInfo) {
		Boolean bRtn = false;
		
		// 紹介者のクッキーがNULLではない場合、「承認待ち」状態に変更し、手動的に承認を行う
		// 現時点で、紹介のクッキーと紹介する時のクッキーが違う場合、「承認待ち」状態に変更し、手動的に承認を行う
		if (inviteInfo.getChildCookie() != null || 
			inviteInfo.getParentCookie() == null ||
			!inviteInfo.getParentCookie().equals(ContextUtil.getInviteCookie())) {
			bRtn = true;
		}
		return bRtn;
		
	}
	
	/**
	 * リンクで紹介の場合、クッキーの値をチェックする
	 * @param inviteLinkHist リンクで紹介履歴情報
	 * @return false:自動的に承認する、true:手動的に承認を行う
	 */
	private Boolean checkLinkCookie(InviteLinkHist inviteLinkHist) {
		Boolean bRtn = false;
		
		InviteLink inviteLink = inviteLinkDao.selectByMemNum(inviteLinkHist.getMemNum());
		if (inviteLink == null) {
			return true;
		}
		
		// 紹介者のクッキーがNULLではない場合、「承認待ち」状態に変更し、手動的に承認を行う
		// 現時点で、紹介のクッキーと紹介する時のクッキーが違う場合、「承認待ち」状態に変更し、手動的に承認を行う
		if (inviteLinkHist.getCookie() != null ||
			inviteLink.getCookie() == null ||
			!inviteLink.getCookie().equals(ContextUtil.getInviteCookie())) {
			bRtn = true;
		}
		
		return bRtn;
	}

}
