package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberInfoForMixi;

public interface IMemberInfoForMixiDao extends IBaseDao<MemberInfoForMixi, MemberInfoForMixi> {
	
	public MemberInfoForMixi selectForUpdateByMemId(String memId);
	public MemberInfoForMixi selectForUpdate(Long memNum);

}
