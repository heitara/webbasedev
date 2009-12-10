package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.entity.MySPInfo;
import com.gameif.portal.entity.ServicePoint;

public class ServicePointDaoImpl extends AbstractBaseDao<ServicePoint, ServicePoint> implements IServicePointDao {

	@Override
	public ServicePoint selectForUpdate(ServicePoint servicePoint) {
		
		return (ServicePoint) getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", servicePoint);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MySPInfo> selectMyServicePointList(Long memNum) {

		return (List<MySPInfo>)getSqlMapClientTemplate().queryForList(namespace + ".selectMyServicePointList", memNum);
	}

}
