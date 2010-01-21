package com.gameif.backoffice.dao.impl;

import com.gameif.backoffice.dao.IMemberInfoDao;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class MemberInfoDaoImpl extends AbstractBaseDao<MemberInfo, MemberInfo> implements IMemberInfoDao {

	@Override
	public MemberInfo selectByMemId(String memId) {
		return (MemberInfo) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectByMemId", memId);
	}

	@Override
	public MemberInfo selectByMemIdForUpdate(String memId) {

		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace+ ".selectByMemIdForUpdate", memId));
	}

}
