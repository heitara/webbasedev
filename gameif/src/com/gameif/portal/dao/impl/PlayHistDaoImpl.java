package com.gameif.portal.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IPlayHistDao;
import com.gameif.portal.entity.MyServer;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayHist;

public class PlayHistDaoImpl extends
	AbstractBaseDao<PlayHist, PlayHist> implements IPlayHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTitle> selectTitlesOnlyPlay(Long memNum) {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectTitlesOnlyPlay", memNum);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTitle> selectTitlesWithPlay(Long memNum) {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectTitlesWithPlay", memNum);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyServer> selectServersOnlyPlay(Long memNum, Integer titleId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectServersOnlyPlay", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyServer> selectServersWithPlay(Long memNum, Integer titleId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectServersWithPlay", params);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer selectPlayHistCount(Long memNum, Integer titleId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectPlayHistCount", params);
	}
}