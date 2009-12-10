package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IServicePointUseHistDao;
import com.gameif.portal.entity.MySPUseHist;
import com.gameif.portal.entity.ServicePointUseHist;

public class ServicePointUseHistDaoImpl extends AbstractBaseDao<ServicePointUseHist, ServicePointUseHist> implements IServicePointUseHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySPUseHist> selectMyUseHistList(Long memNum) {

		return (List<MySPUseHist>)getSqlMapClientTemplate().queryForList(namespace + ".selectMyUseHistList", memNum);
	}

}
