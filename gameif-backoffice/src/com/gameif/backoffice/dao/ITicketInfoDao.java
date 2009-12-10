package com.gameif.backoffice.dao;

import com.gameif.backoffice.entity.TicketInfo;
import com.gameif.common.dao.IBaseDao;

public interface ITicketInfoDao extends IBaseDao<TicketInfo, TicketInfo> {
	public TicketInfo selectForUpdate(Long memNum, Integer ticketId);

}
