package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ITicketGiveHistDao;
import com.gameif.portal.entity.MyTicketGiveHist;
import com.gameif.portal.entity.TicketGiveHist;

public class TicketGiveHistDaoImpl extends AbstractBaseDao<TicketGiveHist, TicketGiveHist> implements ITicketGiveHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTicketGiveHist> selectMyGiveHistList(Long memNum) {

		return (List<MyTicketGiveHist>)(getSqlMapClientTemplate().queryForList(namespace + ".selectMyGiveHistList", memNum));
	}

}
