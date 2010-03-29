package com.gameif.portal.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IJointMemberDao;
import com.gameif.portal.entity.JointMember;

public class JointMemberDaoImpl extends AbstractBaseDao<JointMember, JointMember> implements IJointMemberDao {

	@SuppressWarnings("unchecked")
	@Override
	public JointMember selectByMemIdAndProviderId(String memId, String providerId) {

		HashMap params = new HashMap();
		params.put("memId", memId);
		params.put("providerId", providerId);

		return (JointMember)(getSqlMapClientTemplate().queryForObject(namespace + ".selectByMemIdAndProviderId", params));
	}

	@SuppressWarnings("unchecked")
	@Override
	public JointMember selectForUpdateByMemIdAndProviderId(String memId, String providerId) {

		HashMap params = new HashMap();
		params.put("memId", memId);
		params.put("providerId", providerId);
		
		return (JointMember)(getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdateByMemIdAndProviderId", params));
	}
	
	@Override
	public JointMember selectForUpdate(Long memNum) {

		return (JointMember)(getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", memNum));
	}

}
