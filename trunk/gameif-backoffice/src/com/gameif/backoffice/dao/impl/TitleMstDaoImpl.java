package com.gameif.backoffice.dao.impl;

import com.gameif.backoffice.dao.ITitleMstDao;
import com.gameif.backoffice.entity.TitleMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class TitleMstDaoImpl extends AbstractBaseDao<TitleMst, TitleMst> implements ITitleMstDao {

	@Override
	public String selectNameById(Integer titileId) {
		return (String)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectNameById", titileId);
	}
}
