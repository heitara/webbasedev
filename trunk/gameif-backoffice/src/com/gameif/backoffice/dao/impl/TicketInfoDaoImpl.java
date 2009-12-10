package com.gameif.backoffice.dao.impl;

import java.util.HashMap;

import com.gameif.backoffice.dao.ITicketInfoDao;
import com.gameif.backoffice.entity.TicketInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class TicketInfoDaoImpl extends AbstractBaseDao<TicketInfo, TicketInfo> implements ITicketInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public TicketInfo selectForUpdate(Long memNum, Integer ticketId) {

		HashMap params = new HashMap();
		params.put("memNum", memNum);
		params.put("ticketId", ticketId);
		
		return (TicketInfo)getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", params);
	}

}
