package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.TempMemberInfo;

public interface ITempMemberInfoDao extends IBaseDao<TempMemberInfo, TempMemberInfo> {
	
	public TempMemberInfo selectValidInfoForUpdate(Long memNum, String authKey, Integer invalidHour);
	public Integer deleteByKey(Long memNum);
	
	/**
	 * 期限切れデータを削除する
	 * @param invalidHour 失効期限（単位：時間）
	 * @return
	 */
	public Integer deleteInvalidData(Integer invalidHour);
	
	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * 
	 * @param memId アカウントＩＤ
	 * @param invalidHour 失効期限（単位：時間）
	 * @param createdIp 登録IP
	 * @return 件数
	 */
	public int selectValidCountByMemId(String memId, Integer invalidHour, String createdIp);

	/**
	 * 指定したニックネームの件数を検索する。
	 * 
	 * @param nickName ニックネーム
	 * @param invalidHour 失効期限（単位：時間）
	 * @param createdIp 登録IP
	 * @return 件数
	 */
	public int selectValidCountByNickName(String nickName, Integer invalidHour, String createdIp);
	
	/**
	 * 指定したパソコンメールの件数を検索する。
	 * 
	 * @param mailPc メールアドレス
	 * @param invalidHour 失効期限（単位：時間）
	 * @param createdIp 登録IP
	 * @return 件数
	 */
	public int selectValidCountByMailPc(String mailPc, Integer invalidHour, String createdIp);

}
