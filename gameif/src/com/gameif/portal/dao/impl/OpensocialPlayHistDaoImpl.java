package com.gameif.portal.dao.impl;

import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IOpensocialPlayHistDao;
import com.gameif.portal.entity.OpensocialPlayHist;

public class OpensocialPlayHistDaoImpl extends
	AbstractBaseDao<OpensocialPlayHist, OpensocialPlayHist> implements IOpensocialPlayHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public Integer selectPlayHistCount(Long memNum, Integer titleId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectPlayHistCount", params);
	}

}