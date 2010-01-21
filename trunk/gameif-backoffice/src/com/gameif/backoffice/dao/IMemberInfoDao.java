package com.gameif.backoffice.dao;

import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.common.dao.IBaseDao;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {
	
	public MemberInfo selectByMemId(String memId);
	public MemberInfo selectByMemIdForUpdate(String memId);
}
