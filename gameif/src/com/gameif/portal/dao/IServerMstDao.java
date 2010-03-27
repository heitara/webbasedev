package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.ServerMst;

public interface IServerMstDao extends IBaseDao<ServerMst, ServerMst> {

	public ServerMst selectServerByDomain(String domain);
	public ServerMst selectForUpdate(ServerMst serverMst);
	public List<ServerMst> selectValidServerList();
	public List<ServerMst> selectValidServerListByTitle(Integer titleId);
	public List<ServerMst> selectServerListByTitleAndProvider(ServerMst serverMst);

}
