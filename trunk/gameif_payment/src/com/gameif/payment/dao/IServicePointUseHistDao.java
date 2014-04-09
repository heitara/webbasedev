package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MySPUseHist;
import com.gameif.payment.entity.ServicePointUseHist;

public interface IServicePointUseHistDao extends IBaseDao<ServicePointUseHist, ServicePointUseHist> {
	public List<MySPUseHist> selectMyUseHistList(Long memNum);

}
