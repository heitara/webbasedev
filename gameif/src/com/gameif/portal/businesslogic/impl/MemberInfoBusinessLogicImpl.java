package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.HashMap;

import org.apache.struts2.ServletActionContext;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.AuthorityException;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.DataUpdatedException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.common.util.ContextUtil;
import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.IMemberLoginInfoDao;
import com.gameif.portal.dao.ITempPwdInfoDao;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.MemberLoginInfo;
import com.gameif.portal.entity.TempPwdInfo;

public class MemberInfoBusinessLogicImpl extends BaseBusinessLogic implements IMemberInfoBusinessLogic {

	private static final long serialVersionUID = -1903255586967518866L;

	private IMemberInfoDao memberInfoDao;
	private IMemberLoginInfoDao memberLoginInfoDao;
	private TemplateMailer templateMailer;
	private ITempPwdInfoDao tempPwdInfoDao;
	private IInviteInfoDao inviteInfoDao;

	/**
	 * 会員情報を登録する。
	 * @param memberInfo 会員情報（新規登録時必要な項目が格納されていること）
	 */
	@Transactional
	@Override
	public void saveMemberInfo(MemberInfo memberInfo, String inviteId) {
		
		// アカウントＩＤとメールアドレスは小文字に変換、両辺スペース削除
		memberInfo.setMemId(memberInfo.getMemId().trim().toLowerCase());
		memberInfo.setMailPc(memberInfo.getMailPc().trim().toLowerCase());
		// ニックネームは両辺スペース削除
		memberInfo.setNickName(memberInfo.getNickName().trim());

		// 会員種別：ゲームイフ会員
		memberInfo.setMemKindCd(PortalConstants.MemberKindCd.GAMEIF);
		// 会員属性：通常会員
		memberInfo.setMemAtbtCd(PortalConstants.MemberAtbtCd.NORMAL);
		// 会員有効区別：有効会員
		memberInfo.setMemValidYNCd(PortalConstants.MemberValidYNCd.VALID);
		// メルマガ対象：対象会員
		memberInfo.setMailmagObjCd(PortalConstants.YES);

		// パスワードと秘密質問をMD5アルゴリズムで暗号化する。
		memberInfo.setMemPwd(SecurityUtil.getMD5String(memberInfo.getMemPwd()));
		memberInfo.setAnswer(SecurityUtil.getMD5String(memberInfo.getAnswer()));
		
		memberInfo.setEntryDate(new Date());
		memberInfo.setEntryIp(ServletActionContext.getRequest().getRemoteAddr());
		memberInfo.setLastUpdateDate(memberInfo.getEntryDate());
		memberInfo.setLastUpdateIp(memberInfo.getEntryIp());
		
		// 会員情報を登録する。
		memberInfoDao.save(memberInfo);

		// 会員番号取得のため、アカウントＩＤで会員情報を検索する。
		MemberInfo newMemberInfo = memberInfoDao.selectByMemId(memberInfo.getMemId());

		// 会員ログイン情報を登録する。
		MemberLoginInfo memberLoginInfo = new MemberLoginInfo();
		memberLoginInfo.setMemNum(newMemberInfo.getMemNum());
		memberLoginInfo.setMemId(newMemberInfo.getMemId());
		memberLoginInfo.setNickName(newMemberInfo.getNickName());
		memberLoginInfo.setMemPwd(newMemberInfo.getMemPwd());
		memberLoginInfo.setMemValidYNCd(newMemberInfo.getMemValidYNCd());
		memberLoginInfoDao.save(memberLoginInfo);

		// 友達紹介する場合、紹介情報を更新する
		updateInviteInfo(inviteId, newMemberInfo);

		// お知らせメールを送信する。
		HashMap<String, String> props = new HashMap<String, String>();
		props.put("memId", memberInfo.getMemId());
		props.put("nickName", memberInfo.getNickName());
		templateMailer.sendAsyncMail(memberInfo.getMailPc(), "createMember", props);
	}

	/**
	 * 紹介情報を更新する
	 * @param inviteId 紹介情報Id
	 * @param memberInfo 会員情報（新規登録会員）
	 */
	private void updateInviteInfo(String inviteId, MemberInfo memberInfo) {
		
		// 友達紹介する場合、紹介情報を更新する
		if (inviteId == null || inviteId.trim().length() == 0) {
			return;
		}
		
		// 該当紹介情報をロックする
		InviteInfo inviteInfo = inviteInfoDao.selectForUpdate(Long.parseLong(inviteId));
		if (inviteInfo != null && inviteInfo.getFriendCreateDate() == null) {
			// 登録済み
			inviteInfo.setInviteStatus(PortalConstants.InviteStatus.REGISTERED);
			// 登録日
			inviteInfo.setFriendCreateDate(memberInfo.getEntryDate());
			inviteInfo.setLastUpdateDate(memberInfo.getEntryDate());
			inviteInfo.setLastUpdateUser(memberInfo.getMemNum().toString());
			
			// 紹介情報を更新する
			inviteInfoDao.update(inviteInfo);
		}
		
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
		oldMemberInfo.setMailPc(memberInfo.getMailPc());
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

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン関連情報が変更された場合、会員ログイン情報を更新する。
		if (!oldMemberInfo.getMemId().equals(memberInfo.getMemId())
				|| !oldMemberInfo.getMemPwd().equals(memberInfo.getMemPwd())
				|| !oldMemberInfo.getNickName().equals(memberInfo.getNickName())
				|| !oldMemberInfo.getMemValidYNCd().equals(memberInfo.getMemValidYNCd())) {
			
			updateLoginInfoByMemberInfo(oldMemberInfo);
		}

		// お知らせメールを送信する。
		HashMap<String, String> props = new HashMap<String, String>();		
		props.put("memId", oldMemberInfo.getMemId());
		props.put("nickName", oldMemberInfo.getNickName());		
		templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "updateMemberInfo", props);
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

		// お知らせメールを送信する。
		HashMap<String, String> props = new HashMap<String, String>();		
		props.put("memId", oldMemberInfo.getMemId());
		props.put("nickName", oldMemberInfo.getNickName());		
		templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "updatePassword", props);
	}

	/**
	 * 会員を退会させる。
	 * @param memberInfo 会員情報（会員番号が格納されていること）
	 * @throws LogicException 存在しない異常
	 */
	@Transactional
	@Override
	public void withdraw(MemberInfo memberInfo) throws LogicException {

		// 存在性チェック、行ロックをかけて既存会員情報を検索する。
		MemberInfo oldMemberInfo = getMemberInfoWithCheck(memberInfo, false);
		
		oldMemberInfo.setMemValidYNCd(PortalConstants.MemberValidYNCd.WITHDRAW);
		oldMemberInfo.setWithdrawDate(new Date());
		oldMemberInfo.setWithdrawIp(ContextUtil.getClientIP());
		oldMemberInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン情報を更新する。
		updateLoginInfoByMemberInfo(oldMemberInfo);

		// お知らせメールを送信する。
		HashMap<String, String> props = new HashMap<String, String>();		
		props.put("memId", oldMemberInfo.getMemId());
		props.put("nickName", oldMemberInfo.getNickName());		
		templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "withdraw", props);
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

		return memberInfoDao.selectCountByMemId(memId);
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

		return memberInfoDao.selectCountByNickName(nickName);
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

		return memberInfoDao.selectCountByNickName(nickName, memberNum);
	}

	/**
	 * 指定したメールアドレスを使っている会員数を取得する。
	 * @param mailPc メールアドレス
	 * @return 指定したメールアドレスの使用者数
	 */
	@Override
	public int countMembersByMailPc(String mailPc) {

		return memberInfoDao.selectCountByMailPc(mailPc);
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

		return memberInfoDao.selectCountByMailPc(mailPc, memberNum);
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
		if(newTempPwdInfo.getCreatedDate().compareTo(new Date(now.getTime() - 30 * 60 * 1000)) < 0) {
			throw new LogicException("Tempory password id out of date.");
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
		MemberInfo oldMemberInfo = getMemberInfoWithCheck(memberInfo, false);
		
		oldMemberInfo.setMemPwd(SecurityUtil.getMD5String(memberInfo.getMemPwd()));
		oldMemberInfo.setLastUpdateDate(new Date());
		oldMemberInfo.setLastUpdateIp(ContextUtil.getClientIP());
		oldMemberInfo.setLastUpdateUser(memberInfo.getMemNum().toString());

		// 会員情報を更新する。
		memberInfoDao.update(oldMemberInfo);

		// 会員ログイン情報を更新する。
		updateLoginInfoByMemberInfo(oldMemberInfo);

		// お知らせメールを送信する。
		HashMap<String, String> props = new HashMap<String, String>();		
		props.put("memId", oldMemberInfo.getMemId());
		props.put("nickName", oldMemberInfo.getNickName());		
		templateMailer.sendAsyncMail(oldMemberInfo.getMailPc(), "updatePassword", props);
		
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
	
}