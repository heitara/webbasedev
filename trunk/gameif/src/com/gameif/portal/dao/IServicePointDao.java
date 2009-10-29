package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.ServicePoint;

public interface IServicePointDao extends IBaseDao<ServicePoint, ServicePoint> {
	
	public ServicePoint selectBalanceByTitleAndMemnum(ServicePoint oldServicePoint);

}
