package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MySPUseHist;
import com.gameif.portal.entity.ServicePointUseHist;

public interface IServicePointUseHistDao extends IBaseDao<ServicePointUseHist, ServicePointUseHist> {
	public List<MySPUseHist> selectMyUseHistList(Long memNum);

}
