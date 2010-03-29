package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.JointPlayHist;

public interface IJointPlayHistDao extends IBaseDao<JointPlayHist, JointPlayHist> {

	public Integer selectPlayHistCount(Long memNum, Integer titleId, Integer serverId);
}

