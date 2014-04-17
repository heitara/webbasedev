package com.gameif.payment.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.payment.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.payment.dao.IPointMstDao;
import com.gameif.payment.entity.PointMst;

public class MasterInfoBusinessLogicImpl extends BaseBusinessLogic implements IMasterInfoBusinessLogic {

	private static final long serialVersionUID = -105096134811999134L;

	private IPointMstDao pointMstDao;

	@Override
	public PointMst getPointMstByKey(Integer pointId) {
		
		PointMst pointMst = new PointMst();
		pointMst.setPointId(pointId);
		
		return pointMstDao.selectByKey(pointMst);
	}

	/**
	 * @param pointMstDao the pointMstDao to set
	 */
	public void setPointMstDao(IPointMstDao pointMstDao) {
		this.pointMstDao = pointMstDao;
	}
}
