package com.gameif.portal.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MySPInfo;
import com.gameif.portal.entity.ServicePoint;

public interface IServicePointDao extends IBaseDao<ServicePoint, ServicePoint> {
	
	public ServicePoint selectForUpdate(ServicePoint servicePoint);
	public List<MySPInfo> selectMyServicePointList(Long memNum);
	public BigDecimal selectBalanceByTitle(Integer titleId, Long memNum);

}
