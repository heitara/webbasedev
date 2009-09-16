package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IPlayHistDao;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayHist;

public class PlayHistDaoImpl extends
	AbstractBaseDao<PlayHist, PlayHist> implements IPlayHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTitle> selectTitlesOnlyPlay(Long memNum) {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectTitlesOnlyPlay", null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTitle> selectTitlesWithPlay(Long memNum) {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectTitlesWithPlay", null);
	}
}