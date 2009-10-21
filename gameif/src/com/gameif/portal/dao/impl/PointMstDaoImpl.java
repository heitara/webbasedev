package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IPointMstDao;
import com.gameif.portal.entity.PointMst;

public class PointMstDaoImpl extends AbstractBaseDao<PointMst, PointMst>
		implements IPointMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PointMst> selectValidPointListByServer(Integer serverId) {
		return getSqlMapClientTemplate().queryForList(namespace + ".selectValidPointListByServer", serverId);
	}

}
