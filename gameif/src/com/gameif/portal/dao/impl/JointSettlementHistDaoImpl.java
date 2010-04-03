package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IJointSettlementHistDao;
import com.gameif.portal.entity.JointSettlementHist;
import com.gameif.portal.entity.MySettlementHist;

public class JointSettlementHistDaoImpl extends AbstractBaseDao<JointSettlementHist, JointSettlementHist>
implements IJointSettlementHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MySettlementHist> selectSettlementHistListByMemNum(Long memNum) {
		
		return (List<MySettlementHist>)getSqlMapClientTemplate().queryForList(namespace + ".selectSettlementHistListByMemNum", memNum);
	}

}
