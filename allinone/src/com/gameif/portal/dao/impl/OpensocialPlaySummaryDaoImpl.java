package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IOpensocialPlaySummaryDao;
import com.gameif.portal.entity.OpensocialPlaySummary;

public class OpensocialPlaySummaryDaoImpl extends
	AbstractBaseDao<OpensocialPlaySummary, OpensocialPlaySummary> implements IOpensocialPlaySummaryDao {

	@Override
	public OpensocialPlaySummary selectForUpdate(OpensocialPlaySummary playSummary) {

		return (OpensocialPlaySummary) (getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", playSummary));
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<OpensocialPlaySummary> selectByMemNumAndTitleId(OpensocialPlaySummary playSummary) {

		return (List<OpensocialPlaySummary>) (getSqlMapClientTemplate().queryForList(namespace + ".selectByMemNumAndTitleId", playSummary));
	}
}