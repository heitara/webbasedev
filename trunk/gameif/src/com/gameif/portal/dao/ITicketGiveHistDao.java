package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MyTicketGiveHist;
import com.gameif.portal.entity.TicketGiveHist;

public interface ITicketGiveHistDao extends IBaseDao<TicketGiveHist, TicketGiveHist> {
	public List<MyTicketGiveHist> selectMyGiveHistList(Long memNum);

}
