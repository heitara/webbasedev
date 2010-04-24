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
	public List<ServerMst> selectServerListByTitleAndProvider(ServerMst serverMst) {
		
		return getSqlMapClientTemplate().queryForList(namespace + ".selectServersListByTitleAndProvider", serverMst);
	}
}
