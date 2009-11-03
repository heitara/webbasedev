package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.entity.ServicePoint;

public class ServicePointDaoImpl extends
		AbstractBaseDao<ServicePoint, ServicePoint> implements IServicePointDao {

	@Override
	public ServicePoint selectByTitleAndMemnumForUpdate(
			ServicePoint oldServicePoint) {
		
		return (ServicePoint) getSqlMapClientTemplate().queryForObject(namespace + ".selectByTitleAndMemnumForUpdate", oldServicePoint);
	}

}
