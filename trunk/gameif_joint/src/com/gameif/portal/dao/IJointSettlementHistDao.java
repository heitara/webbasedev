package com.gameif.portal.dao;

import java.math.BigDecimal;
import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.JointSettlementHist;
import com.gameif.portal.entity.MySettlementHist;

public interface IJointSettlementHistDao extends IBaseDao<JointSettlementHist, JointSettlementHist> {

	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum);

	public BigDecimal selectAmountByMonth(String settlementCode, Long memNum);

}
