package com.gameif.portal.businesslogic;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoBusinessLogic {

	/**
	 * 会員情報を登録する。
	 * @param memNum 臨時会員情報の会員番号
	 * @param authKey 臨時キー
	 */
	@Transactional
	public Long saveMemberInfo(Long memNum, String authKey) throws LogicException;

	/**
	 * 臨時会員情報を登録する。
	 * @param memberInfo 会員情報（新規登録時必要な項目が格納されていること）
	 * @param inviteId 友達紹介ID（友達紹介から登録場合）
	 * @param advertNum 広告番号（アフィリエイト登録場合）
	 */
	@Transactional
	public void saveTempMemberInfo(MemberInfo memberInfo, String inviteId, Integer advertNum);

	/**
	 * 会員パスワードを変更する。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	public void changePasswd(MemberInfo memberInfo) throws LogicException;

	/**
	 * 会員パスワードを変更する。
	 * <br/>旧いパスワードが指定されると、一致チェックを行う。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @param oldPassword 旧いパスワード
	 * @throws LogicException 存在しない異常、排他異常、またはパスワード変更権限異常
	 */
	@Transactional
	public void changePasswd(MemberInfo memberInfo, String oldPassword) throws LogicException;
	
	/**
	 * 会員を退会させる。
	 * @param memberInfo 会員情報（会員番号が格納されていること）
	 * @throws LogicException 存在しない異常
	 */
	@Transactional
	public void withdraw(MemberInfo memberInfo) throws LogicException;

	/**
	 * 会員情報でログイン情報を更新する。
	 * @param memberInfo　会員情報
	 */
	@Transactional
	public void updateMemberInfo(MemberInfo memberInfo) throws LogicException;

	/**
	 * 会員情報を変更する。
	 * @param memberInfo 会員情報（会員番号と更新する項目が格納されていること）
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	public MemberInfo getMemberInfo(MemberInfo memberInfo);

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * @param clientIp クライアントＩＰ
	 * @param checkTime チェックする期間（秒単位）
	 * @return 同ＩＰで登録したユーザ数
	 */
	public int countMembersByIPInTime(String clientIp, int checkTime);

	/**
	 * 指定したアカウントＩＤを使っている会員数を取得する。
	 * @param memId アカウントＩＤ
	 * @return 指定したアカウントＩＤの使用者数
	 */
	public int countMembersByMemId(String memId);

	/**
	 * 指定したアカウントＩＤを使っている会員数を取得する。
	 * <br/>会員番号を指定した場合、その会員は対象外とする。
	 * @param memId アカウントＩＤ象外とする。
	 * @param memNum 会員番号
	 * @return 指定したアカウントＩＤの使用者数
	 */
	public int countMembersByMemId(String memId, Long memNum);

	/**
	 * 指定したニックネームを使っている会員数を取得する。
	 * @param nickName ニックネーム
	 * @return 指定したニックネームの使用者数
	 */
	public int countMembersByNickName(String nickName);

	/**
	 * 指定したニックネームを使っている会員数を取得する。
	 * <br/>会員番号を指定した場合、その会員は対象外とする。
	 * @param nickName ニックネーム
	 * @param memNum 会員番号
	 * @return 指定したニックネームの使用者数
	 */
	public int countMembersByNickName(String nickName, Long memNum);

	/**
	 * 指定したメールアドレスを使っている会員数を取得する。
	 * @param mailPc メールアドレス
	 * @return 指定したメールアドレスの使用者数
	 */
	public int countMembersByMailPc(String mailPC);

	/**
	 * 指定したメールアドレスを使っている会員数を取得する。
	 * <br/>会員番号を指定した場合、その会員は対象外とする。
	 * @param mailPc メールアドレス
	 * @param memNum 会員番号
	 * @return 指定したメールアドレスの使用者数
	 */
	public int countMembersByMailPc(String mailPC, Long memNum);

	/**
	 * パスワード再設定機能で会員パスワードを変更する。
	 * @param memberInfo 会員情報（会員番号、新しいパスワードが格納されていること）
	 * @param tempKey 臨時キー
	 * @throws LogicException 存在しない異常、または排他異常
	 */
	public void changeTempPwd(MemberInfo memberInfo, String tempKey) throws LogicException;
}
