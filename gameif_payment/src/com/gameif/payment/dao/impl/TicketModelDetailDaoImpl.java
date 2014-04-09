package com.gameif.payment.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ITicketModelDetailDao;
import com.gameif.payment.entity.TicketModelDetail;
import com.gameif.payment.entity.TicketModelMst;

public class TicketModelDetailDaoImpl extends AbstractBaseDao<TicketModelDetail, TicketModelDetail> implements ITicketModelDetailDao {

	@Override
	public Integer selectSumPersonCount(TicketModelMst model) {

		return (Integer)(getSqlMapClientTemplate().queryForObject(namespace + ".selectSumPersonCount", model));
	}

	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal selectActpoint(TicketModelMst model, Integer randomCount) {

		HashMap params = new HashMap();
		params.put("modelId", model.getModelId());
		params.put("limitPointLower", model.getLimitPointLower());
		params.put("limitPointUpper", model.getLimitPointUpper());
		params.put("randomCount", randomCount);
		
		return (BigDecimal)(getSqlMapClientTemplate().queryForObject(namespace + ".selectActpoint", params));
	}

}
