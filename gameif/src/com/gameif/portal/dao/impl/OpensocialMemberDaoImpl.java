package com.gameif.portal.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IOpensocialMemberDao;
import com.gameif.portal.entity.OpensocialMember;

public class OpensocialMemberDaoImpl extends AbstractBaseDao<OpensocialMember, OpensocialMember> implements IOpensocialMemberDao {

	@SuppressWarnings("unchecked")
	@Override
	public OpensocialMember selectByMemIdAndProviderId(String memId, String providerId) {

		HashMap params = new HashMap();
		params.put("memId", memId);
		params.put("providerId", providerId);

		return (OpensocialMember)(getSqlMapClientTemplate().queryForObject(namespace + ".selectByMemIdAndProviderId", params));
	}

	@SuppressWarnings("unchecked")
	@Override
	public OpensocialMember selectForUpdateByMemIdAndProviderId(String memId, String providerId) {

		HashMap params = new HashMap();
		params.put("memId", memId);
		params.put("providerId", providerId);
		
		return (OpensocialMember)(getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdateByMemIdAndProviderId", params));
	}
	
	@Override
	public OpensocialMember selectForUpdate(Long memNum) {

		return (OpensocialMember)(getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", memNum));
	}

}
