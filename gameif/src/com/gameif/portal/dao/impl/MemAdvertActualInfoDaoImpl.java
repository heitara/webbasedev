package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemAdvertActualInfoDao;
import com.gameif.portal.entity.MemAdvertActualInfo;

public class MemAdvertActualInfoDaoImpl extends
		AbstractBaseDao<MemAdvertActualInfo, MemAdvertActualInfo> implements
		IMemAdvertActualInfoDao {

	@Override
	public MemAdvertActualInfo selectMemAdvertActualInfoByMemNum(Long memNum) {
		return (MemAdvertActualInfo) (getSqlMapClientTemplate().queryForObject(namespace + ".selectMemAdvertActualInfoByMemNum", memNum));
	}

}
