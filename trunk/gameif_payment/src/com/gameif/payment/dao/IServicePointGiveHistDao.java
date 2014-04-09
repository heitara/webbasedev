package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MySPGiveHist;
import com.gameif.payment.entity.ServicePointGiveHist;

public interface IServicePointGiveHistDao extends IBaseDao<ServicePointGiveHist, ServicePointGiveHist> {
	
	public List<MySPGiveHist> selectMyGiveHistList(Long memNum);

}
