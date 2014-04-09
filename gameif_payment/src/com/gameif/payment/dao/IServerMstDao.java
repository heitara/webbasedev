package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.ServerMst;

public interface IServerMstDao extends IBaseDao<ServerMst, ServerMst> {

	public List<ServerMst> selectValidServerList();
	public List<ServerMst> selectValidServerListByTitle(Integer titleId);
	public List<ServerMst> selectServerListByTitleAndProvider(ServerMst serverMst);

}
