package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.ITitleMstDao;
import com.gameif.backoffice.entity.TitleMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class TitleMstDaoImpl extends AbstractBaseDao<TitleMst, TitleMst> implements ITitleMstDao {

	@Override
	public String selectNameById(Integer titileId) {
		return (String)this.getSqlMapClientTemplate().queryForObject(namespace + ".selectNameById", titileId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TitleMst> selectValidTitleList() {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectValidTitleList", null);
	}
}
