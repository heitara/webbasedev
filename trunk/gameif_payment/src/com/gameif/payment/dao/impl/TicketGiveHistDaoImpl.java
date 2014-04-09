package com.gameif.payment.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ITicketGiveHistDao;
import com.gameif.payment.entity.MyTicketGiveHist;
import com.gameif.payment.entity.TicketGiveHist;

public class TicketGiveHistDaoImpl extends AbstractBaseDao<TicketGiveHist, TicketGiveHist> implements ITicketGiveHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTicketGiveHist> selectMyGiveHistList(Long memNum) {

		return (List<MyTicketGiveHist>)(getSqlMapClientTemplate().queryForList(namespace + ".selectMyGiveHistList", memNum));
	}

}
