package com.gameif.portal.dao;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {

	/**
	 * 会員番号でロック状態で会員情報を取得する。
	 * @param memNum 会員番号
	 * @return　MemberInfo
	 */
	public MemberInfo selectForUpdate(Long memNum);
	
	/**
	 * アカウントＩＤで会員情報を取得する。
	 * @param memId アカウントＩＤ
	 * @return　MemberInfo
	 */
	public MemberInfo selectByMemId(String memId);
	
	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * @param searchCondition
	 * @return
	 */
	public int selectCountByIPAndTime(ComSearchCondition searchCondition);
	
	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * @param memId
	 * @return
	 */
	public int selectCountByMemId(String memId);
	
	/**
	 * 指定したニックネームの件数を検索する。
	 * @param nickName
	 * @return
	 */
	public int selectCountByNickName(String nickName);
	
	/**
	 * 指定したパソコンメールの件数を検索する。
	 * @param mailPc
	 * @return
	 */
	public int selectCountByMailPc(String mailPc);
}
