package com.gameif.payment.dao;

import java.math.BigDecimal;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.Settlement;

public interface ISettlementDao extends IBaseDao<Settlement, Settlement> {

	public BigDecimal selectAmountByMonth(String paymentMethod, String clientId, String userId);

}
