package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.IPointMstDao;
import com.gameif.backoffice.entity.PointMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class PointMstDaoImpl extends AbstractBaseDao<PointMst, PointMst>
		implements IPointMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PointMst> selectPointListByTitle(Integer titleId) {
		return getSqlMapClientTemplate().queryForList(namespace + ".selectPointListByTitle", titleId);
	}

}
