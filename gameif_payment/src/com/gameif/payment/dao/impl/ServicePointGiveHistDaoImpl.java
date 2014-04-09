package com.gameif.payment.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IServicePointGiveHistDao;
import com.gameif.payment.entity.MySPGiveHist;
import com.gameif.payment.entity.ServicePointGiveHist;

public class ServicePointGiveHistDaoImpl extends AbstractBaseDao<ServicePointGiveHist, ServicePointGiveHist> implements IServicePointGiveHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySPGiveHist> selectMyGiveHistList(Long memNum) {

		return (List<MySPGiveHist>)getSqlMapClientTemplate().queryForList(namespace + ".selectMyGiveHistList", memNum);
	}

}
