package com.gameif.portal.dao.impl;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemberLoginInfoDao;
import com.gameif.portal.entity.MemberLoginInfo;

public class MemberLoginInfoDaoImpl extends
		AbstractBaseDao<MemberLoginInfo, MemberLoginInfo> implements
		IMemberLoginInfoDao {

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * 
	 * @param searchCondition
	 * @return
	 */
	@Override
	public int selectCountByIPAndTime(ComSearchCondition searchCondition) {
		return (Integer) (getSqlMapClientTemplate().queryForObject(
				namespace + ".selectCountByIPAndTime", searchCondition));
	}

}
