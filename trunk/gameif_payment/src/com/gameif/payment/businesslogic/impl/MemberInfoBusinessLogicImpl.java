package com.gameif.payment.businesslogic.impl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.AuthorityException;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.DataUpdatedException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfDateException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.common.util.SecurityUtil;
import com.gameif.payment.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.dao.IAdvertAgencyMstDao;
import com.gameif.payment.dao.IAdvertMstDao;
import com.gameif.payment.dao.IInviteInfoDao;
import com.gameif.payment.dao.IInviteLinkDao;
import com.gameif.payment.dao.IInviteLinkHistDao;
import com.gameif.payment.dao.IMemAdvertActualInfoDao;
import com.gameif.payment.dao.IMemberInfoDao;
import com.gameif.payment.dao.IMemberLoginInfoDao;
import com.gameif.payment.dao.IMemberWithdrawInfoDao;
import com.gameif.payment.dao.ITempMemberInfoDao;
import com.gameif.payment.dao.ITempPwdInfoDao;
import com.gameif.payment.entity.AdvertAgencyMst;
import com.gameif.payment.entity.AdvertMst;
import com.gameif.payment.entity.InviteInfo;
import com.gameif.payment.entity.InviteLink;
import com.gameif.payment.entity.InviteLinkHist;
import com.gameif.payment.entity.MemAdvertActualInfo;
import com.gameif.payment.entity.MemberInfo;
import com.gameif.payment.entity.MemberLoginInfo;
import com.gameif.payment.entity.MemberWithdrawInfo;
import com.gameif.payment.entity.TempMemberInfo;
import com.gameif.payment.entity.TempPwdInfo;
import com.gameif.payment.helper.PaymentProperties;
import com.gameif.payment.util.ContextUtil;

public class MemberInfoBusinessLogicImpl extends BaseBusinessLogic implements IMemberInfoBusinessLogic {

	private static final long serialVersionUID = -1903255586967518866L;
	
	private final static Log logger = LogFactory.getLog(MemberInfoBusinessLogicImpl.class);

	private IMemberInfoDao memberInfoDao;
	private IMemberLoginInfoDao memberLoginInfoDao;
	private TemplateMailer templateMailer;
	private ITempPwdInfoDao tempPwdInfoDao;
	private IInviteInfoDao inviteInfoDao;
	private ITempMemberInfoDao tempMemberInfoDao;
	private IAdvertAgencyMstDao advertAgencyMstDao;
	private IMemAdvertActualInfoDao memAdvertActualInfoDao;
	private IAdvertMstDao advertMstDao;
	private IInviteLinkDao inviteLinkDao;
	private IInviteLinkHistDao inviteLinkHistDao;
	private IMemberWithdrawInfoDao memberWithdrawInfoDao;
	
	private Integer pwdRegetInvalidHour;
	private Integer loginInvalidHour;
	private PaymentProperties paymentProperties;

	
	/**
	 * 会員情報を登録する。
	 * @param memNum 臨時会員情報の会員番号
	 * @param authKey 臨時キー
	 */
	@Transactional
	@Override
	public Long saveMemberInfo(Long memNum, String authKey) throws LogicException {
		
		TempMemberInfo tempMemberInfo = tempMemberInfoDao.selectValidInfoForUpdate(memNum, authKey, loginInvalidHour);
		
		if (tempMemberInfo == null) {
			
			// データが存在しない
			throw new OutOfDateException("Data not exists Or Data is out of date.");
		}

		AdvertMst advert = getAdvertMst(tempMemberInfo.getAdvertNum());
		
		MemberInfo memberInfo = new MemberInfo();
		
		memberInfo.setMemId(tempMemberInfo.getMemId());
		memberInfo.setNickName(tempMemberInfo.getNickName().trim());
		memberInfo.setMemPwd(tempMemberInfo.getMemPwd());
		memberInfo.setMailPc(tempMemberInfo.getMailPc());
		
		// 会員情報を登録する。
		saveMemberInfoOnly(memberInfo, advert);
		
		// 会員ログイン情報を登録する。
		saveMemberLoginInfoOnly(memberInfo);

		// 会員広告募集実績を登録する。
		saveAdvertActualInfo(memberInfo, advert);
		
		// 会員仮登録情報を削除する。
		deleteTempMemberInfo(memberInfo);

		// 会員登録のお知らせメールを送信する。
		sendRegMemberMail(memberInfo);
		
		// 友達紹介紹介状態を更新する。
		updateInviteInfo(memberInfo, tempMemberInfo.getInviteId(), tempMemberInfo.getLinkKey(), tempMemberInfo.getTitleId());
		
		return memberInfo.getMemNum();
	}

	/**
	 * OpenID会員情報を登録する。
	 * @param memberInfo 会員情報
	 * @param inviteId 友達紹介ID
	 * @param advertNum 広告番号
	 * @param linkKey リンク紹介キー
	 * @param titleId　タイトルID
	 * @return 会員番号
	 * @throws LogicException
	 */
	@Transactional
	@Override
	public Long saveOpenIDMemberInfo(MemberInfo memberInfo, Long inviteId, Integer advertNum, String linkKey, Integer titleId) {
		
		AdvertMst advert = getAdvertMst(advertNum);
		
		memberInfo.setMemPwd("*");

		// 会員情報を登録する。
		saveMemberInfoOnly(memberInfo, advert);
		
		// 会員ログイン情報を登録する。
		saveMemberLoginInfoOnly(memberInfo);

		// 会員広告募集実績を登録する。
		saveAdvertActualInfo(memberInfo, advert);
		
		// 会員仮登録情報を削除する。
		deleteTempMemberInfo(memberInfo);

		// 会員登録のお知らせメールを送信する。
		sendRegMemberMail(memberInfo);
		
		// 友達紹介紹介状態を更新する。
		updateInviteInfo(memberInfo, inviteId, linkKey, titleId);
		
		return memberInfo.getMemNum();
	}
	
	/**
	 * 広告情報を検索する。
	 * @param advertNum 広告番号
	 * @return 広告情報
	 * @throws LogicException
	 */
	private AdvertMst getAdvertMst(Integer advertNum) {

		AdvertMst advert = null;
		
		if (advertNum != null) {
			
			// 広告代理マスタの存在性チェック
			advert = advertMstDao.selectAdvertByKey(advertNum);
		}
		
		return advert;
	}
	
	/**
	 * 会員情報を登録する。
	 * @param memberInfo 会員情報
	 * @param advert 広告
	 * @throws LogicException
	 */
	private void saveMemberInfoOnly(MemberInfo memberInfo, AdvertMst advert) {
				
		// 会員属性：通常会員
		memberInfo.setMemAtbtCd(PortalConstants.MemberAtbtCd.NORMAL);
		// 会員種別：ゲームイフ会員　或いは　アフィリエイト広告会員
		memberInfo.setMemKindCd(advert == null ? PortalConstants.MemberKindCd.GAMEIF : getMemKindByAdvertNum(advert.getAdvertNum()));
		// 会員有効区別：有効会員
		memberInfo.setMemValidYNCd(PortalConstants.MemberValidYNCd.VALID);
		// メルマガ対象：対象会員
		memberInfo.setMailmagObjCd(PortalConstants.YES);
		// メルマガ配信希望
		memberInfo.setMailmagReqCd(PortalConstants.YES);
		
		memberInfo.setEntryDate(new Date());
		memberInfo.setEntryIp(ContextUtil.getClientIP());
		memberInfo.setLastUpdateDate(memberInfo.getEntryDate());
		memberInfo.setLastUpdateIp(memberInfo.getEntryIp());
		
		// 会員情報を登録する。
		memberInfoDao.save(memberInfo);

		// 会員番号取得のため、アカウントＩＤで会員情報を検索する。
		MemberInfo entriedMemberInfo = memberInfoDao.selectByMemId(memberInfo.getMemId());
		
		memberInfo.setMemNum(entriedMemberInfo.getMemNum());
	}

	/**
	 * 会員ＩＤより会員情報を取得する。
	 * @param memId 会員ID
	 * @return 会員情報
	 */
	@Override
	public MemberInfo getMemberInfoByMemId(String memId) {

		return memberInfoDao.selectByMemId(memId);
	}
	
	/**
	 * 会員ログイン情報を登録する。
	 * @param memberInfo 会員情報
	 * @throws LogicException
	 */
	private void saveMemberLoginInfoOnly(MemberInfo memberInfo) {

		MemberLoginInfo memberLoginInfo = new MemberLoginInfo();
		
		memberLoginInfo.setMemNum(memberInfo.getMemNum());
		memberLoginInfo.setMemId(memberInfo.getMemId());
		memberLoginInfo.setNickName(memberInfo.getNickName());
		memberLoginInfo.setMemPwd(memberInfo.getMemPwd());
		memberLoginInfo.setMemValidYNCd(memberInfo.getMemValidYNCd());

		// 会員ログイン情報を登録する。
		memberLoginInfoDao.save(memberLoginInfo);
	}
	
	/**
	 * 会員仮登録情報を削除する。
	 * @param memberInfo 会員情報
	 * @throws LogicException
	 */
	private void deleteTempMemberInfo(MemberInfo memberInfo) {
		
		tempMemberInfoDao.deleteByKey(memberInfo.getMemNum());
	}
	
	/**
	 * 会員登録広告実績情報を登録する。
	 * @param memberInfo 会員情報
	 * @param advert 広告
	 * @throws LogicException
	 */
	private void saveAdvertActualInfo(MemberInfo memberInfo, AdvertMst advert) {

		if (advert != null) {
			
			MemAdvertActualInfo memAdvertActualInfo = new MemAdvertActualInfo();
			
			memAdvertActualInfo.setMemNum(memberInfo.getMemNum());
			memAdvertActualInfo.setAdvertNum(advert.getAdvertNum());
			memAdvertActualInfo.setMemLoginDate(memberInfo.getEntryDate());
			memAdvertActualInfo.setMemLoginIp(memberInfo.getEntryIp());
			
			// 会員広告募集実績テーブルに登録する
			memAdvertActualInfoDao.save(memAdvertActualInfo);
		}
	}
	
	/**
	 * 会員登録メールを送信する。
	 * @param memberInfo 会員情報
	 */
	private void sendRegMemberMail(MemberInfo memberInfo) {

		HashMap<String, String> props = new HashMap<String, String>();
		props.put("memId", memberInfo.getMemId());
		props.put("nickName", memberInfo.getNickName());
		
		// 会員登録お知らせメールを送信する。
		templateMailer.sendAsyncMail(memberInfo.getMailPc(), "createMember", props);
	}
	
	/**
	 * 友達紹介関連情報を更新する。
	 * @param memberInfo 会員情報
	 * @param inviteId 友達紹介ID
	 * @param linkKey リンク紹介キー
	 * @param titleId タイトルID
	 */
	private void updateInviteInfo(MemberInfo memberInfo, Long inviteId, String linkKey, Integer titleId) {

		Long parentMemNumMail = null;
		Long parentMemNumLink = null;
		
		// メールで友達紹介する場合、紹介情報を更新する
		parentMemNumMail = updateInviteInfo(inviteId, memberInfo);
		
		// リンクで友達紹介する場合、紹介情報を保存する
		parentMemNumLink = saveMemInviteLinkHist(linkKey, titleId, memberInfo);
		
		try {
			
			MemberInfo parentMember = null;
			
			if (parentMemNumMail != null && parentMemNumLink == null) {
				
				parentMember = new MemberInfo();
				parentMember.setMemNum(parentMemNumMail);
				parentMember = memberInfoDao.selectByKey(parentMember);
				
			} else if (parentMemNumMail == null && parentMemNumLink != null) {

				parentMember = new MemberInfo();
				parentMember.setMemNum(parentMemNumLink);
				parentMember = memberInfoDao.selectByKey(parentMember);
				
			} else if (parentMemNumMail != null && parentMemNumLink != null){

				parentMember = new MemberInfo();
				parentMember.setMemNum(parentMemNumMail);
				parentMember = memberInfoDao.selectByKey(parentMember);
			}
			
			if (parentMember != null) {
				
				HashMap<String, String> propsLogin = new HashMap<String, String>();
				propsLogin.put("parentNickName", parentMember.getNickName());
				propsLogin.put("childNickName", memberInfo.getNickName());

				// 友達紹介者に会員登録お知らせメールを送信する。
				templateMailer.sendAsyncMail(parentMember.getMailPc(), "friendLogin", propsLogin);
			}
			
		} catch (Exception ex) {
			
			logger.error("error has occurred in sending createMember or friendLogin mail. ", ex);
		}
	}
	
	/**
	 * 広告番号より、広告代理店の区別を取得する。
	 * @param advertNum 広告番号
	 * @return 広告代理店の区別
	 */
	private String getMemKindByAdvertNum(Integer advertNum) {
		
		String memKindCd = PortalConstants.MemberKindCd.GAMEIF;
		
		// 広告番号より、広告代理店の区別を取得する
		AdvertAgencyMst advertAgency = advertAgencyMstDao.selectByAdvertNum(advertNum);
		if (advertAgency != null) {
			memKindCd = advertAgency.getAdvertAgencyType();
		}
		
		return memKindCd;
	}

	/**
	 * 紹介情報を更新する
	 * @param inviteId 紹介情報Id
	 * @param memberInfo 会員情報（新規登録会員）
	 */
	private Long updateInviteInfo(Long inviteId, MemberInfo memberInfo) {
		Long parentMemNum = null;
		
		// 友達紹介する場合、紹介情報を更新する
		if (inviteId == null || inviteId.toString().trim().length() == 0) {
			return parentMemNum;
		}
		
		// 該当紹介情報をロックする
		InviteInfo inviteInfo = inviteInfoDao.selectForUpdate(inviteId);
		
		if (inviteInfo != null && inviteInfo.getFriendCreateDate() == null) {
			parentMemNum = inviteInfo.getMemNum();
			// 登録済み
			inviteInfo.setInviteStatus(PortalConstants.InviteStatus.REGISTERED);
			// 登録日
			inviteInfo.setFriendCreateDate(memberInfo.getEntryDate());
			// 子の会員番号を設定する
			inviteInfo.setChildMemNum(memberInfo.getMemNum());
			// 承認状態：「未承認」
			inviteInfo.setApproveStatus(PortalConstants.ApproveStatus.NO_APPROVE);
			//　紹介された友達は登録時に、紹介のクッキーを取得する
			inviteInfo.setChildCookie(ContextUtil.getInviteCookie());
			inviteInfo.setLastUpdateDate(memberInfo.getEntryDate());
			inviteInfo.setLastUpdateUser(memberInfo.getMemNum().toString());
			
			// 紹介情報を更新する
			inviteInfoDao.update(inviteInfo);
		}
		
		return parentMemNum;
	}

	/**
	 * リンクで友達紹介する場合、紹介情報を保存する
	 * @param tempMemberInfo 臨時会員情報
	 * @param memberInfo 会員情報（新規登録会員）
	 */
	private Long saveMemInviteLinkHist(String linkKey, Integer titleId, MemberInfo memberInfo) {
		Long parentMemNum = null;
		
		if (linkKey == null || linkKey.toString().trim().length() == 0) {
			return parentMemNum;
		}
		
		// リンク情報を検索する
		InviteLink inviteLink = inviteLinkDao.selectByLinkKey(linkKey);
		if (inviteLink != null) {
			parentMemNum = inviteLink.getMemNum();
			
			InviteLinkHist inviteLinkHist = new InviteLinkHist();
			inviteLinkHist.setMemNum(inviteLink.getMemNum());
			inviteLinkHist.setChildMemNum(memberInfo.getMemNum());
			inviteLinkHist.setTitleId(titleId);
			// 承認状態：「未承認」
			inviteLinkHist.setApproveStatus(PortalConstants.ApproveStatus.NO_APPROVE);
			//　紹介された友達は登録時に、紹介のクッキーを取得する
			inviteLinkHist.setCookie(ContextUtil.getInviteCookie());
			// 申請時の父のクッキー値を「null」に設定する
			inviteLinkHist.setApproveCookie(null);
			
			// リンクで友達履歴を登録する
			inviteLinkHistDao.save(inviteLinkHist);
		}
		
		return parentMemNum;
	}

	/**
	 * 会員情報を変更する。
	 * @param memberInfo 会員情報（会員番号と更新する項目が格納されていること）
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	@Transactional
	@Override
	public void updateMemberInfo(MemberInfo memberInfo) throws LogicException {

		// 存在性と排他性チェック、行ロックをかけて既存会員情報を検索する。
		MemberInfo oldMemberInfo = getMemberInfoWithCheck(memberInfo);
		
		// 画面から取得した変更項目を設定する。変更項目に増減がある場合、下記を修正すること。
		oldMemberInfo.setNickName(memberInfo.getNickName());
		oldMemberInfo.setMailPc(memberInfo.getMailPc().trim().toLowerCase());
		oldMemberInfo.setKanjiFname(memberInfo.getKanjiFname());
		oldMemberInfo.setKanjiLname(memberInfo.getKanjiLname());
		oldMemberInfo.setKanaFname(memberInfo.getKanaFname());
		oldMemberInfo.setKanaLname(memberInfo.getKanaLname());
		oldMemberInfo.setSexCd(memberInfo.getSexCd());
		oldMemberInfo.setBirthYmd(memberInfo.getBirthYmd());
		oldMemberInfo.setOccupCd(memberInfo.getOccupCd());
		oldMemberInfo.setDivisCd(memberInfo.getDivisCd());
		oldMemberInfo.setCityName(memberInfo.getCityName());
		oldMemberInfo.setBuildingName(memberInfo.getBuildingName());
		oldMemberInfo.setTelNum(memberInfo.getTelNum());		
		oldMemberInfo.setMailmagReqCd(memberInfo.getMailmagReqCd());
		oldMemberInfo.setLastUpdateDate(new Date());
		oldMemberInfo.setLastUpdateIp(ContextUtil.getClientIP());
		oldMemberInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		// メルマガ配信希望
		oldMemberInfo.setMailmagReqCd(memberInfo.getMailmagReqCd());

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン関連情報が変更された場合、会員ログイン情報を更新する。
		if (!oldMemberInfo.getMemId().equals(memberInfo.getMemId())
				|| !oldMemberInfo.getMemPwd().equals(memberInfo.getMemPwd())
				|| !oldMemberInfo.getNickName().equals(memberInfo.getNickName())
				|| !oldMemberInfo.getMemValidYNCd().equals(memberInfo.getMemValidYNCd())) {
			
			updateLoginInfoByMemberInfo(oldMemberInfo);
		}

		try {
			// お知らせメールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();		
			props.put("memId", oldMemberInfo.getMemId());
			props.put("nickName", oldMemberInfo.getNickName());		
			templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "updateMemberInfo", props);
		} catch (Exception ex) {
			logger.error("error has occurred in sending updateMemberInfo mail. ", ex);
		}
	}

	/**
	 * 会員パスワードを変更する。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	@Override
	public void changePasswd(MemberInfo memberInfo) throws LogicException {

		changePasswd(memberInfo, null);
	}

	/**
	 * 会員パスワードを変更する。
	 * <br/>旧いパスワードが指定されると、一致チェックを行う。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @param oldPassword 旧いパスワード
	 * @throws LogicException 存在しない異常、排他異常、またはパスワード変更権限異常
	 */
	@Transactional
	@Override
	public void changePasswd(MemberInfo memberInfo, String oldPassword) throws LogicException {

		// 存在性と排他性チェック、行ロックをかけて既存会員情報を検索する。
		MemberInfo oldMemberInfo = getMemberInfoWithCheck(memberInfo);
		
		if (oldPassword != null && !SecurityUtil.getMD5String(oldPassword).equals(oldMemberInfo.getMemPwd())) {
			
			throw new AuthorityException("old password is failed.");
		}
		
		oldMemberInfo.setMemPwd(SecurityUtil.getMD5String(memberInfo.getMemPwd()));
		oldMemberInfo.setLastUpdateDate(new Date());
		oldMemberInfo.setLastUpdateIp(ContextUtil.getClientIP());
		oldMemberInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン情報を更新する。
		updateLoginInfoByMemberInfo(oldMemberInfo);

		try {
			// お知らせメールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();		
			props.put("memId", oldMemberInfo.getMemId());
			props.put("nickName", oldMemberInfo.getNickName());		
			templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "updatePassword", props);
		} catch (Exception ex) {
			logger.error("error has occurred in sending updatePassword mail. ", ex);
		}
	}

	/**
	 * 会員を退会させる。
	 * @param memberInfo 会員情報（会員番号が格納されていること）
	 * @throws LogicException 存在しない異常
	 */
	@Transactional
	@Override
	public void withdraw(MemberInfo memberInfo, MemberWithdrawInfo withdrawInfo) throws LogicException {

		// 存在性チェック、行ロックをかけて既存会員情報を検索する。
		MemberInfo oldMemberInfo = getMemberInfoWithCheck(memberInfo, false);
		
		Date now = new Date();
		
		oldMemberInfo.setMemValidYNCd(PortalConstants.MemberValidYNCd.WITHDRAW);
		oldMemberInfo.setWithdrawDate(now);
		oldMemberInfo.setWithdrawIp(ContextUtil.getClientIP());
		oldMemberInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		oldMemberInfo.setLastUpdateDate(now);
		oldMemberInfo.setLastUpdateIp(ContextUtil.getClientIP());

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン情報を更新する。
		updateLoginInfoByMemberInfo(oldMemberInfo);
		
		withdrawInfo.setMemNum(oldMemberInfo.getMemNum());
		withdrawInfo.setWithdrawDate(now);
		withdrawInfo.setWithdrawReasonDb(makeWithdrawReason(withdrawInfo.getWithdrawReason()));
		// 退会情報を登録する
		memberWithdrawInfoDao.save(withdrawInfo);

		try {
			// お知らせメールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			props.put("nickName", oldMemberInfo.getNickName());			
			props.put("memId", oldMemberInfo.getMemId());	
			templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "withdrawMember", props);
		} catch (Exception ex) {
			logger.error("error has occurred in sending withdraw mail. ", ex);
		}
	}
	
	/**
	 * 退会原因を計算する(ビットごとのOR演算を行う)
	 * @param checkedValue
	 * @return
	 */
	private Integer makeWithdrawReason(Integer[] checkedValue) {
		if (checkedValue == null || checkedValue.length == 0) {
			return null;
		}
		Integer value = 0;
		for (int i = 0; i < checkedValue.length; i++) {
			value = value | (int)(Math.pow(2, checkedValue[i] - 1));
		}
		return value;
	}

	/**
	 * 存在性チェックをかけて会員情報を取得する。<br/>
	 * 検索時、会員情報に行ロックをかける。
	 * @param memberInfo　検索条件のなる会員情報（会員番号が格納されていること）
	 * @return 会員情報
	 * @throws LogicException 存在しない異常
	 */
	private MemberInfo getMemberInfoWithCheck(MemberInfo memberInfo) throws LogicException {
		
		return getMemberInfoWithCheck(memberInfo, true);
	}

	/**
	 * 存在性チェックと排他性チェックをかけて会員情報を取得する。<br/>
	 * 検索時、会員情報に行ロックをかける。
	 * @param memberInfo　検索条件のなる会員情報（会員番号、排他性チェックの場合はバージョン番号も格納されている）
	 * @param checkVersion　排他性チェックをかけるかの指定
	 * @return 会員情報
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	private MemberInfo getMemberInfoWithCheck(MemberInfo memberInfo, boolean checkVersion) throws LogicException {
		
		MemberInfo oldMemberinfo = memberInfoDao.selectForUpdate(memberInfo.getMemNum());		
		
		if (oldMemberinfo == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		if (checkVersion && !oldMemberinfo.getVersionNo().equals(memberInfo.getVersionNo())) {

			// 排他性異常（他者に更新された）
			throw new DataUpdatedException("Data updated by the other.");
		}
		
		return oldMemberinfo;		
	}
	
	/**
	 * 会員情報でログイン情報を更新する。
	 * @param memberInfo　会員情報
	 */
	private void updateLoginInfoByMemberInfo(MemberInfo memberInfo) {
		
		MemberLoginInfo memberLoginInfo = new MemberLoginInfo();
		
		memberLoginInfo.setMemNum(memberInfo.getMemNum());
		memberLoginInfo.setMemId(memberInfo.getMemId());
		memberLoginInfo.setMemPwd(memberInfo.getMemPwd());
		memberLoginInfo.setNickName(memberInfo.getNickName());
		memberLoginInfo.setMemValidYNCd(memberInfo.getMemValidYNCd());
		
		memberLoginInfoDao.update(memberLoginInfo);
	}

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * @param clientIp クライアントＩＰ
	 * @param checkTime チェックする期間（秒単位）
	 * @return 同ＩＰで登録したユーザ数
	 */
	@Override
	public int countMembersByIPInTime(String clientIp, int checkTime) {

		return memberInfoDao.selectCountByIPAndTime(clientIp, checkTime);
	}
	
	/**
	 * 指定したアカウントＩＤを使っている会員数を取得する。
	 * @param memId アカウントＩＤ
	 * @return 指定したアカウントＩＤの使用者数
	 */
	@Override
	public int countMembersByMemId(String memId) {

		int count = 0;
		count = tempMemberInfoDao.selectValidCountByMemId(memId, loginInvalidHour, ContextUtil.getClientIP());
		if (count > 0) {
			return count;
		}
		count = count + memberInfoDao.selectCountByMemId(memId);
		return count;
	}
	
	/**
	 * 指定したアカウントＩＤを使っている会員数を取得する。
	 * <br/>会員番号を指定した場合、その会員は対象外とする。
	 * @param memId アカウントＩＤ象外とする。
	 * @param memNum 会員番号
	 * @return 指定したアカウントＩＤの使用者数
	 */
	@Override
	public int countMembersByMemId(String memId, Long memberNum) {

		return memberInfoDao.selectCountByMemId(memId, memberNum);
	}

	/**
	 * 指定したニックネームを使っている会員数を取得する。
	 * @param nickName ニックネーム
	 * @return 指定したニックネームの使用者数
	 */
	@Override
	public int countMembersByNickName(String nickName) {

		int count = 0;
		count = tempMemberInfoDao.selectValidCountByNickName(nickName, loginInvalidHour, ContextUtil.getClientIP());
		if (count > 0) {
			return count;
		}
		count = count + memberInfoDao.selectCountByNickName(nickName);
		return count;
	}

	/**
	 * 指定したニックネームを使っている会員数を取得する。
	 * <br/>会員番号を指定した場合、その会員は対象外とする。
	 * @param nickName ニックネーム
	 * @param memNum 会員番号
	 * @return 指定したニックネームの使用者数
	 */
	@Override
	public int countMembersByNickName(String nickName, Long memberNum) {

		int count = 0;
		count = tempMemberInfoDao.selectValidCountByNickName(nickName, loginInvalidHour, ContextUtil.getClientIP());
		if (count > 0) {
			return count;
		}
		count = count + memberInfoDao.selectCountByNickName(nickName, memberNum);
		return count;
	}

	/**
	 * 指定したメールアドレスを使っている会員数を取得する。
	 * @param mailPc メールアドレス
	 * @return 指定したメールアドレスの使用者数
	 */
	@Override
	public int countMembersByMailPc(String mailPc) {

		int count = 0;
		count = tempMemberInfoDao.selectValidCountByMailPc(mailPc, loginInvalidHour, ContextUtil.getClientIP());
		if (count > 0) {
			return count;
		}
		count = count + memberInfoDao.selectCountByMailPc(mailPc);
		return count;
	}

	/**
	 * 指定したメールアドレスを使っている会員数を取得する。
	 * <br/>会員番号を指定した場合、その会員は対象外とする。
	 * @param mailPc メールアドレス
	 * @param memNum 会員番号
	 * @return 指定したメールアドレスの使用者数
	 */
	@Override
	public int countMembersByMailPc(String mailPc, Long memberNum) {

		int count = 0;
		count = tempMemberInfoDao.selectValidCountByMailPc(mailPc, loginInvalidHour, ContextUtil.getClientIP());
		if (count > 0) {
			return count;
		}
		count = count + memberInfoDao.selectCountByMailPc(mailPc, memberNum);
		return count;
	}

	/**
	 * パスワード再設定機能で会員パスワードを変更する。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @param tempKey 臨時キー
	 */
	@Override
	public void changeTempPwd(MemberInfo memberInfo, String tempKey) throws LogicException {

		// 臨時パスワードが存在かどうかのチェック
		TempPwdInfo tempPwdInfo = new TempPwdInfo();
		tempPwdInfo.setMemNum(memberInfo.getMemNum());
		tempPwdInfo.setTempKey(tempKey);
		TempPwdInfo newTempPwdInfo = tempPwdInfoDao.selectByMemNumAndTempKey(tempPwdInfo);
		
		if (newTempPwdInfo == null) {
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		// 臨時キーが期限きれかどうかのチェック
		Date now = new Date();
		
		if(newTempPwdInfo.getCreatedDate().compareTo(new Date(now.getTime() - getPwdRegetInvalidHour() * 60 * 60 * 1000)) < 0) {
			
			throw new OutOfDateException("Tempory password id out of date.");
		}
		
		// パスワードを変更する
		changeTempPwdTrans(memberInfo);
		
		// 該当会員に対して、残っているレコードを削除する。
		tempPwdInfoDao.deleteByMemNum(memberInfo.getMemNum());
	}
	/**
	 * 会員パスワードを変更する。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	@Transactional
	private void changeTempPwdTrans(MemberInfo memberInfo) throws LogicException {

		// 存在性と排他性チェック、行ロックをかけて既存会員情報を検索する。
		MemberInfo oldMemberInfo = memberInfoDao.selectByNumAndIDForUpdate(memberInfo);		
		
		if (oldMemberInfo == null) {
			
			// データが存在しない
			throw new DataNotExistsException("Data not exists.");
		}
		
		oldMemberInfo.setMemPwd(SecurityUtil.getMD5String(memberInfo.getMemPwd()));
		oldMemberInfo.setLastUpdateDate(new Date());
		oldMemberInfo.setLastUpdateIp(ContextUtil.getClientIP());
		oldMemberInfo.setLastUpdateUser(memberInfo.getMemNum().toString());

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン情報を更新する。
		updateLoginInfoByMemberInfo(oldMemberInfo);

		try {
			// お知らせメールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();		
			props.put("memId", oldMemberInfo.getMemId());
			props.put("nickName", oldMemberInfo.getNickName());		
			templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "updatePassword", props);
		} catch (Exception ex) {
			logger.error("error has occurred in sending updateTempPassword mail. ", ex);
		}
	}

	@Override
	public MemAdvertActualInfo getMemAdvertActualInfoByMemNum(Long memNum) {
		
		return memAdvertActualInfoDao.selectMemAdvertActualInfoByMemNum(memNum);
	}
	
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		
		this.memberInfoDao = memberInfoDao;
	}

	public void setMemberLoginInfoDao(IMemberLoginInfoDao memberLoginInfoDao) {
		
		this.memberLoginInfoDao = memberLoginInfoDao;
	}

	public MemberInfo getMemberInfo(MemberInfo memberInfo) {
		
		return memberInfoDao.selectByKey(memberInfo);
	}

	public void setTemplateMailer(TemplateMailer templateMailer) {
		
		this.templateMailer = templateMailer;
	}

	/**
	 * @param tempPwdInfoDao the tempPwdInfoDao to set
	 */
	public void setTempPwdInfoDao(ITempPwdInfoDao tempPwdInfoDao) {
		this.tempPwdInfoDao = tempPwdInfoDao;
	}

	/**
	 * @param inviteInfoDao the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @param advertAgencyMstDao the advertAgencyMstDao to set
	 */
	public void setAdvertAgencyMstDao(IAdvertAgencyMstDao advertAgencyMstDao) {
		this.advertAgencyMstDao = advertAgencyMstDao;
	}

	/**
	 * @param memAdvertActualInfoDao the memAdvertActualInfoDao to set
	 */
	public void setMemAdvertActualInfoDao(
			IMemAdvertActualInfoDao memAdvertActualInfoDao) {
		this.memAdvertActualInfoDao = memAdvertActualInfoDao;
	}

	/**
	 * @param advertMstDao the advertMstDao to set
	 */
	public void setAdvertMstDao(IAdvertMstDao advertMstDao) {
		this.advertMstDao = advertMstDao;
	}

	/**
	 * @param inviteLinkDao the inviteLinkDao to set
	 */
	public void setInviteLinkDao(IInviteLinkDao inviteLinkDao) {
		this.inviteLinkDao = inviteLinkDao;
	}

	/**
	 * @param inviteLinkHistDao the inviteLinkHistDao to set
	 */
	public void setInviteLinkHistDao(IInviteLinkHistDao inviteLinkHistDao) {
		this.inviteLinkHistDao = inviteLinkHistDao;
	}

	/**
	 * @return the pwdRegetInvalidHour
	 */
	public Integer getPwdRegetInvalidHour() {
		return pwdRegetInvalidHour;
	}

	/**
	 * @param pwdRegetInvalidHour the pwdRegetInvalidHour to set
	 */
	public void setPwdRegetInvalidHour(Integer pwdRegetInvalidHour) {
		this.pwdRegetInvalidHour = pwdRegetInvalidHour;
	}

	/**
	 * @return the loginInvalidHour
	 */
	public Integer getLoginInvalidHour() {
		return loginInvalidHour;
	}

	/**
	 * @param loginInvalidHour the loginInvalidHour to set
	 */
	public void setLoginInvalidHour(Integer loginInvalidHour) {
		this.loginInvalidHour = loginInvalidHour;
	}

	/**
	 * @param tempMemberInfoDao the tempMemberInfoDao to set
	 */
	public void setTempMemberInfoDao(ITempMemberInfoDao tempMemberInfoDao) {
		this.tempMemberInfoDao = tempMemberInfoDao;
	}

	/**
	 * @return the paymentProperties
	 */
	public PaymentProperties getPaymentProperties() {
		return paymentProperties;
	}

	/**
	 * @param paymentProperties the paymentProperties to set
	 */
	public void setPaymentProperties(PaymentProperties paymentProperties) {
		this.paymentProperties = paymentProperties;
	}

	/**
	 * @param memberWithdrawInfoDao the memberWithdrawInfoDao to set
	 */
	public void setMemberWithdrawInfoDao(
			IMemberWithdrawInfoDao memberWithdrawInfoDao) {
		this.memberWithdrawInfoDao = memberWithdrawInfoDao;
	}
	
}