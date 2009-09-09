package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.TitleMst;

public class TitleMstDaoImpl extends
	AbstractBaseDao<TitleMst, TitleMst> implements ITitleMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TitleMst> selectValidTitleList() {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectValidTitleList");
	}
}
