package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.OpensocialInvite;

public interface IOpensocialInviteDao extends IBaseDao<OpensocialInvite, OpensocialInvite> {

	public OpensocialInvite selectMyInviteForUpdate(OpensocialInvite invite);
	public OpensocialInvite selectLastInviteBeforePlayForUpdate(OpensocialInvite invite);

}
