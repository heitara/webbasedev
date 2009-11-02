package com.gameif.backoffice.businesslogic.impl;

import java.util.List;

import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.dao.IFunctionMstDao;
import com.gameif.backoffice.entity.FunctionMst;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class MasterInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMasterInfoBusinessLogic {


	/**
	 * 
	 */
	private static final long serialVersionUID = 3389126393403993641L;
	
	private IFunctionMstDao functionMstDao;

	@Override
	public List<FunctionMst> getAllFunctionList() {
		return functionMstDao.selectAll(null);
	}

	/**
	 * @return the functionMstDao
	 */
	public IFunctionMstDao getFunctionMstDao() {
		return functionMstDao;
	}

	/**
	 * @param functionMstDao the functionMstDao to set
	 */
	public void setFunctionMstDao(IFunctionMstDao functionMstDao) {
		this.functionMstDao = functionMstDao;
	}
	
}
