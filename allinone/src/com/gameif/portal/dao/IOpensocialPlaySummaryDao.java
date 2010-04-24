package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.OpensocialPlaySummary;

public interface IOpensocialPlaySummaryDao extends IBaseDao<OpensocialPlaySummary, OpensocialPlaySummary> {

	public OpensocialPlaySummary selectForUpdate(OpensocialPlaySummary playSummary);

	public List<OpensocialPlaySummary> selectByMemNumAndTitleId(OpensocialPlaySummary playSummary);
}