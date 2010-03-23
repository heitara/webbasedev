package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemAdvertActualInfoDao;
import com.gameif.portal.entity.MemAdvertActualInfo;

public class MemAdvertActualInfoDaoImpl extends
		AbstractBaseDao<MemAdvertActualInfo, MemAdvertActualInfo> implements
		IMemAdvertActualInfoDao {

	@Override
	public int selectMemAdvertActualInfoByMemNum(Long memNum) {
		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectMemAdvertActualInfoByMemNum", memNum));
	}

}
