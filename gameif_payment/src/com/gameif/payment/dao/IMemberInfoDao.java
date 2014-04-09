package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MemberInfo;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {

	/**
	 * 会員番号でロック状態で会員情報を取得する。
	 * 
	 * @param memNum
	 *            会員番号
	 * @return　会員情報
	 */
	public MemberInfo selectForUpdate(Long memNum);

	/**
	 * アカウントＩＤで会員情報を取得する。
	 * 
	 * @param memId
	 *            アカウントＩＤ
	 * @return　会員情報
	 */
	public MemberInfo selectByMemId(String memId);

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * 
	 * @param clientIP
	 *            クライアントＩＰ
	 * @param checkTime
	 *            チェックする時間
	 * @return 件数
	 */
	public int selectCountByIPAndTime(String clientIP, Integer checkTime);

	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * 
	 * @param memId
	 *            アカウントＩＤ
	 * @return 件数
	 */
	public int selectCountByMemId(String memId);

	/**
	 * 指定したアカウントＩＤの件数を検索する。 <br/>
	 * 会員番号を指定した場合、その会員は対象外とする。
	 * 
	 * @param memId
	 *            アカウントＩＤ
	 * @param memNum
	 *            会員番号
	 * @return 件数
	 */
	public int selectCountByMemId(String memId, Long memNum);

	/**
	 * 指定したニックネームの件数を検索する。
	 * 
	 * @param nickName
	 *            ニックネーム
	 * @return 件数
	 */
	public int selectCountByNickName(String nickName);

	/**
	 * 指定したニックネームの件数を検索する。 <br/>
	 * 会員番号を指定した場合、その会員は対象外とする。
	 * 
	 * @param nickName
	 *            ニックネーム
	 * @param memNum
	 *            会員番号
	 * @return 件数
	 */
	public int selectCountByNickName(String nickName, Long memNum);

	/**
	 * 指定したパソコンメールの件数を検索する。
	 * 
	 * @param mailPc
	 *            メールアドレス
	 * @return 件数
	 */
	public int selectCountByMailPc(String mailPc);

	/**
	 * 指定したパソコンメールの件数を検索する。 <br/>
	 * 会員番号を指定した場合、その会員は対象外とする。
	 * 
	 * @param mailPc
	 *            メールアドレス
	 * @param memNum
	 *            会員番号
	 * @return 件数
	 */
	public int selectCountByMailPc(String mailPc, Long memNum);

	/**
	 * メールアドレス、秘密質問、答えにより、会員情報を検索する。
	 * 
	 * @param memberinfo
	 *            会員情報
	 * @return　件数
	 */
	public MemberInfo selectForPwdReget(MemberInfo memberinfo);
	
	/**
	 * 会員番号とIDにより、会員情報を検索する
	 * @param memberInfo
	 * @return 会員情報
	 */
	public MemberInfo selectByNumAndIDForUpdate(MemberInfo memberInfo);
}
