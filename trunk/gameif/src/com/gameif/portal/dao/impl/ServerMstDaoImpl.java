package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IServerMstDao;
import com.gameif.portal.entity.ServerMst;

public class ServerMstDaoImpl extends
	AbstractBaseDao<ServerMst, ServerMst> implements IServerMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerMst> selectValidServerList() {
		
		return getSqlMapClientTemplate().queryForList(namespace + ".selectValidServerList", null);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerMst> selectValidServerListByTitle(Integer titleId) {
		
		return getSqlMapClientTemplate().queryForList(namespace + ".selectValidServerListByTitle", titleId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerMst> selectValidServerListForMixiByTitle(Integer titleId) {
		
		return getSqlMapClientTemplate().queryForList(namespace + ".selectValidServerListForMixiByTitle", titleId);
	}
	
	@Override
	public ServerMst selectServerByDomain(String domain) {
		
		return (ServerMst)getSqlMapClientTemplate().queryForObject(namespace + ".selectServerByDomain", domain);
	}

	@Override
	public ServerMst selectForUpdate(ServerMst serverMst) {
		
		return (ServerMst)getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", serverMst);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ServerMst> selectServersListForMixi(Integer titleId) {
		
		return getSqlMapClientTemplate().queryForList(namespace + ".selectServersListForMixi", titleId);
	}
}
