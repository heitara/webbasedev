package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.OpensocialPlayHist;

public interface IOpensocialPlayHistDao extends IBaseDao<OpensocialPlayHist, OpensocialPlayHist> {

	public Integer selectPlayHistCount(Long memNum, Integer titleId, Integer serverId);
}

