package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IPlayGuarantyDao;
import com.gameif.portal.entity.PlayGuaranty;

public class PlayGuarantyDaoImpl extends AbstractBaseDao<PlayGuaranty, PlayGuaranty> implements IPlayGuarantyDao {

	@Override
	public Integer selectGuarantyByMenNum(Long memNum) {
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectGuarantyByMenNum", memNum);
	}

}
