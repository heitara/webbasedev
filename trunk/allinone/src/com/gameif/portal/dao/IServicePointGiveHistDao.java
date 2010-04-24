package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MySPGiveHist;
import com.gameif.portal.entity.ServicePointGiveHist;

public interface IServicePointGiveHistDao extends IBaseDao<ServicePointGiveHist, ServicePointGiveHist> {
	
	public List<MySPGiveHist> selectMyGiveHistList(Long memNum);

}
