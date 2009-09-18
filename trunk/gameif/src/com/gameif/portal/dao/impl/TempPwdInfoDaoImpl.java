package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ITempPwdInfoDao;
import com.gameif.portal.entity.TempPwdInfo;

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

}
