package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IOpensocialInviteDao;
import com.gameif.portal.entity.OpensocialInvite;

public class OpensocialInviteDaoImpl extends AbstractBaseDao<OpensocialInvite, OpensocialInvite> implements IOpensocialInviteDao {

	@Override
	public OpensocialInvite selectMyInviteForUpdate(OpensocialInvite invite) {
		return (OpensocialInvite) getSqlMapClientTemplate().queryForObject(
			namespace + ".getMyInviteForUpdate", invite);
	}
	
	@Override
	public OpensocialInvite selectLastInviteBeforePlayForUpdate(OpensocialInvite invite) {
		return (OpensocialInvite) getSqlMapClientTemplate().queryForObject(
			namespace + ".getLastInviteBeforePlayForUpdate", invite);
	}
}