package com.gameif.portal.dao.login;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {
	public int updatePwd(MemberInfo memberInfo);
}
