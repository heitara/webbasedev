package com.gameif.payment.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ITempPwdInfoDao;
import com.gameif.payment.entity.TempPwdInfo;

public class TempPwdInfoDaoImpl extends
		AbstractBaseDao<TempPwdInfo, TempPwdInfo> implements ITempPwdInfoDao {

	/**
	 * 会員番号より、臨時パスワード情報を削除する。
	 * 
	 * @param memNum
	 *            会員番号
	 * @return 削除された件数
	 */
	@Override
	public Integer deleteByMemNum(Long memNum) {

		return (Integer) (getSqlMapClientTemplate().delete(namespace
				+ ".deleteByMemNum", memNum));
	}

	/**
	 * 会員番号と臨時キーより、臨時パスワード情報を取得する。
	 * 
	 * @param tempPwdInfo
	 *            臨時パスワード情報（会員番号と臨時キーを含む）
	 * @return 臨時パスワード情報
	 */
	@Override
	public TempPwdInfo selectByMemNumAndTempKey(TempPwdInfo tempPwdInfo) {

		return (TempPwdInfo) (getSqlMapClientTemplate().queryForObject(
				namespace + ".selectByMemNumAndTempKey", tempPwdInfo));
	}

}
