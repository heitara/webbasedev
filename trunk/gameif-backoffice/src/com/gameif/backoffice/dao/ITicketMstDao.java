package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.TicketMst;
import com.gameif.common.dao.IBaseDao;

public interface ITicketMstDao extends IBaseDao<TicketMst, TicketMst> {
	public List<TicketMst> selectTicketListByTitleId(Integer titleId);

}
