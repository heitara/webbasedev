package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.entity.MySPGiveHist;
import com.gameif.portal.entity.ServicePointGiveHist;

public class ServicePointGiveHistDaoImpl extends AbstractBaseDao<ServicePointGiveHist, ServicePointGiveHist> implements IServicePointGiveHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySPGiveHist> selectMyGiveHistList(Long memNum) {

		return (List<MySPGiveHist>)getSqlMapClientTemplate().queryForList(namespace + ".selectMyGiveHistList", memNum);
	}

}
