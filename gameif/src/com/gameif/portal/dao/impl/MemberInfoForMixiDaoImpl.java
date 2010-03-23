package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemberInfoForMixiDao;
import com.gameif.portal.entity.MemberInfoForMixi;

public class MemberInfoForMixiDaoImpl extends AbstractBaseDao<MemberInfoForMixi, MemberInfoForMixi>
			implements IMemberInfoForMixiDao {

	@Override
	public MemberInfoForMixi selectForUpdateByMemId(String memId) {

		return (MemberInfoForMixi)(getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdateByMemId", memId));
	}
	
	@Override
	public MemberInfoForMixi selectForUpdate(Long memNum) {

		return (MemberInfoForMixi) (getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", memNum));
	}

}
