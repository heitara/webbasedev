package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.JointMember;

public interface IJointMemberDao extends IBaseDao<JointMember, JointMember> {

	public JointMember selectForUpdate(Long memNum);
	public JointMember selectByMemIdAndProviderId(String memId, String providerId);
	public JointMember selectForUpdateByMemIdAndProviderId(String memId, String providerId);

}
