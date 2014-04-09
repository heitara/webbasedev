package com.gameif.payment.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MemberLoginHist;

public interface IMemberLoginHistDao extends IBaseDao<MemberLoginHist, MemberLoginHist> {
	
	public Integer selectCountByEntryIp(String entryIp, Long memNum);

}
