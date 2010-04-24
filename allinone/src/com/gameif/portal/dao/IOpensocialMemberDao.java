package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.OpensocialMember;

public interface IOpensocialMemberDao extends IBaseDao<OpensocialMember, OpensocialMember> {

	public OpensocialMember selectForUpdate(Long memNum);
	public OpensocialMember selectByMemIdAndProviderId(String memId, String providerId);
	public OpensocialMember selectForUpdateByMemIdAndProviderId(String memId, String providerId);

}
