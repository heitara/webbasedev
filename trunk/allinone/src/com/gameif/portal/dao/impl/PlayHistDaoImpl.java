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
	public Integer selectPlayHistCount(Long memNum, Integer titleId, Integer serverId) {
		
		HashMap params = new HashMap();
		
		params.put("memNum", memNum);
		params.put("titleId", titleId);
		params.put("serverId", serverId);
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectPlayHistCount", params);
	}

	@Override
	public Integer selectPlayDaysByMemNum(Long memNum) {
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectPlayDaysByMemNum", memNum);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Integer selectMemCountByIp(String playIp, Long memNum, Integer limitDays, Integer titleId, Integer serverId) {
		
		HashMap params = new HashMap();
		
		params.put("playIp", playIp);
		params.put("memNum", memNum);
		params.put("limitDays", limitDays);
		params.put("titleId", titleId);
		params.put("serverId", serverId);
		
		return (Integer) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectMemCountByIp", params);
	}
}