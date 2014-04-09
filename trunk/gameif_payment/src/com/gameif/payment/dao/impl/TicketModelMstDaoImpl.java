package com.gameif.payment.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ITicketModelMstDao;
import com.gameif.payment.entity.TicketModelMst;

public class TicketModelMstDaoImpl extends AbstractBaseDao<TicketModelMst, TicketModelMst> implements ITicketModelMstDao {

	/**
	 * チケットIDと現時点の平均ポイントにより、模型マスタを
	 */
	@SuppressWarnings("unchecked")
	@Override
	public TicketModelMst selectByAvgPoint(Integer ticketId, BigDecimal avgPoint) {

		HashMap params = new HashMap();
		params.put("ticketId", ticketId);
		params.put("avgPoint", avgPoint);
		
		return (TicketModelMst)(getSqlMapClientTemplate().queryForObject(namespace + ".selectByAvgPoint", params));
	}

}
