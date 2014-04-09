package com.gameif.payment.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ITicketUseHistDao;
import com.gameif.payment.entity.MyTicketUseHist;
import com.gameif.payment.entity.TicketUseHist;

public class TicketUseHistDaoImpl extends AbstractBaseDao<TicketUseHist, TicketUseHist> implements ITicketUseHistDao {

	/**
	 * 現時点で、ポイントの平均値を計算する
	 */
	@Override
	public BigDecimal selectAvgPoint(Integer ticketId) {

		return (BigDecimal)(getSqlMapClientTemplate().queryForObject(namespace + ".selectAvgPoint", ticketId));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MyTicketUseHist> selectMyUseHistList(Long memNum) {

		return (List<MyTicketUseHist>)(getSqlMapClientTemplate().queryForList(namespace + ".selectMyUseHistList", memNum));
	}

}
