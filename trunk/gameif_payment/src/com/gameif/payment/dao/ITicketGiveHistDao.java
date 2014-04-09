package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MyTicketGiveHist;
import com.gameif.payment.entity.TicketGiveHist;

public interface ITicketGiveHistDao extends IBaseDao<TicketGiveHist, TicketGiveHist> {
	public List<MyTicketGiveHist> selectMyGiveHistList(Long memNum);

}
