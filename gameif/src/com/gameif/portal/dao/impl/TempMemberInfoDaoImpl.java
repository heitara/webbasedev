package com.gameif.portal.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ITempMemberInfoDao;
import com.gameif.portal.entity.TempMemberInfo;

public class TempMemberInfoDaoImpl extends
		AbstractBaseDao<TempMemberInfo, TempMemberInfo> implements
		ITempMemberInfoDao {

	/**
	 * 有効な臨時会員情報を検索する
	 * 
	 * @param memNum 臨時会員番号
	 * @param authKey 臨時キー
	 * @param invalidHour 失効時間（単位：時間）
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TempMemberInfo selectValidInfoForUpdate(Long memNum, String authKey, Integer invalidHour) {

		HashMap params = new HashMap();

		params.put("memNum", memNum);
		params.put("authKey", authKey);
		params.put("invalidHour", invalidHour);

		return (TempMemberInfo) getSqlMapClientTemplate().queryForObject(namespace + ".selectValidInfoForUpdate", params);
	}

	/**
	 * 有効な臨時会員情報を削除する
	 * 
	 * @param memNum 臨時会員番号
	 */
	@Override
	public Integer deleteByKey(Long memNum) {

		return getSqlMapClientTemplate().delete(namespace + ".deleteByKey", memNum);
	}

	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * 
	 * @param memId アカウントＩＤ
	 * @param invalidHour 失効時間（単位：時間）
	 * @param createdIp 登録IP
	 * @return 件数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int selectValidCountByMemId(String memId, Integer invalidHour, String createdIp) {

		HashMap params = new HashMap();

		params.put("memId", memId);
		params.put("invalidHour", invalidHour);
		params.put("createdIp", createdIp);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectValidCountByMemId", params));
	}

	/**
	 * 指定したニックネームの件数を検索する。
	 * 
	 * @param nickName ニックネーム
	 * @param invalidHour 失効時間（単位：時間）
	 * @param createdIp 登録IP
	 * @return 件数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int selectValidCountByNickName(String nickName, Integer invalidHour, String createdIp) {

		HashMap params = new HashMap();

		params.put("nickName", nickName);
		params.put("invalidHour", invalidHour);
		params.put("createdIp", createdIp);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectValidCountByNickName", params));
	}

	/**
	 * 指定したパソコンメールの件数を検索する。
	 * 
	 * @param mailPc メールアドレス
	 * @param invalidHour 失効時間（単位：時間）
	 * @param createdIp 登録IP
	 * @return 件数
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int selectValidCountByMailPc(String mailPc, Integer invalidHour, String createdIp) {

		HashMap params = new HashMap();

		params.put("mailPc", mailPc);
		params.put("invalidHour", invalidHour);
		params.put("createdIp", createdIp);

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectValidCountByMailPc", params));
	}

	/**
	 * 期限切れデータを削除する
	 * @param invalidHour 失効期限（単位：時間）
	 * @return 件数
	 */
	@Override
	public Integer deleteInvalidData(Integer invalidHour) {

		return getSqlMapClientTemplate().delete(namespace + ".deleteInvalidData", invalidHour);
	}

}
