package com.gameif.portal.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ITicketInfoDao;
import com.gameif.portal.entity.MyTicket;
import com.gameif.portal.entity.TicketInfo;

public class TicketInfoDaoImpl extends AbstractBaseDao<TicketInfo, TicketInfo> implements ITicketInfoDao {

	/**
	 * チケット情報を検索する
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MyTicket> selectMyTicketList(Long memNum) {

		return (List<MyTicket>)getSqlMapClientTemplate().queryForList(namespace + ".selectMyTicketList", memNum);
	}

	@SuppressWarnings("unchecked")
	@Override
	public TicketInfo selectForUpdate(Long memNum, Integer ticketId) {

		HashMap params = new HashMap();
		params.put("memNum", memNum);
		params.put("ticketId", ticketId);
		
		return (TicketInfo)getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", params);
	}

}
