package com.gameif.payment.dao.impl;

import java.math.BigDecimal;
import java.util.HashMap;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.ISettlementDao;
import com.gameif.payment.entity.Settlement;

public class SettlementDaoImpl extends AbstractBaseDao<Settlement, Settlement>
	implements ISettlementDao {

	@SuppressWarnings("unchecked")
	@Override
	public BigDecimal selectAmountByMonth(String paymentMethod, String clientId, String userId) {
		
		@SuppressWarnings("rawtypes")
		HashMap params = new HashMap();
		
		params.put("paymentMethod", paymentMethod);
		params.put("clientId", clientId);
		params.put("userId", userId);
		
		return (BigDecimal)getSqlMapClientTemplate().queryForObject(namespace + ".selectAmountByMonth", params);
	}
}
