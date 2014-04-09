package com.gameif.payment.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IMemberLoginHistDao;
import com.gameif.payment.entity.MemberLoginHist;

public class MemberLoginHistDaoImpl extends AbstractBaseDao<MemberLoginHist, MemberLoginHist> implements IMemberLoginHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public Integer selectCountByEntryIp(String entryIp, Long memNum) {
		HashMap params = new HashMap();
		params.put("entryIp", entryIp);
		params.put("memNum", memNum);
		
		return (Integer)getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByEntryIp", params);
	}

}
