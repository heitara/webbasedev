package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.TempMemberInfo;

public interface ITempMemberInfoDao extends IBaseDao<TempMemberInfo, TempMemberInfo> {
	
	public TempMemberInfo selectValidTempMemberInfo(Long memNum, String authKey, Integer invalidMinute);
	public Integer deleteByKey(Long memNum);
	
	/**
	 * 期限切れデータを削除する
	 * @param invalidMinute 失効期限（単位：分）
	 * @return
	 */
	public Integer deleteInvalidData(Integer invalidMinute);
	
	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * 
	 * @param memId
	 *            アカウントＩＤ
	 * @param invalidMinute
	 *            失効期限（単位：分）
	 * @return 件数
	 */
	public int selectValidCountByMemId(String memId, Integer invalidMinute);

	/**
	 * 指定したニックネームの件数を検索する。
	 * 
	 * @param nickName
	 *            ニックネーム
	 * @param invalidMinute
	 *            失効期限（単位：分）
	 * @return 件数
	 */
	public int selectValidCountByNickName(String nickName, Integer invalidMinute);
	
	/**
	 * 指定したパソコンメールの件数を検索する。
	 * 
	 * @param mailPc
	 *            メールアドレス
	 * @param invalidMinute
	 *            失効期限（単位：分）
	 * @return 件数
	 */
	public int selectValidCountByMailPc(String mailPc, Integer invalidMinute);

}
