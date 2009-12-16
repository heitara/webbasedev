package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberLoginHist;

public interface IMemberLoginHistDao extends IBaseDao<MemberLoginHist, MemberLoginHist> {
	
	public Integer selectCountByEntryIp(String entryIp, Long memNum);

}
