package com.gameif.payment.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IPointMstDao;
import com.gameif.payment.entity.PointMst;

public class PointMstDaoImpl extends AbstractBaseDao<PointMst, PointMst>
		implements IPointMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<PointMst> selectValidPointListByTitle(Integer titleId) {
		return getSqlMapClientTemplate().queryForList(namespace + ".selectValidPointListByTitle", titleId);
	}

}
