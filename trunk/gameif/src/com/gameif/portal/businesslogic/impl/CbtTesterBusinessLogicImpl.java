package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.ICbtTesterBusinessLogic;
import com.gameif.portal.dao.ICbtTesterDao;
import com.gameif.portal.entity.CbtTester;
import com.gameif.portal.util.ContextUtil;

public class CbtTesterBusinessLogicImpl extends BaseBusinessLogic implements
ICbtTesterBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5036068437035517952L;
	
	private ICbtTesterDao cbtTesterDao;

	/**
	 * CBTテスターテーブルに登録する
	 */
	@Override
	public void saveCbtTester(CbtTester cbtTester) {
		
		cbtTesterDao.deleteByKey(cbtTester);
		
		cbtTester.setMemNum(ContextUtil.getMemberNo());
		
		cbtTesterDao.save(cbtTester);
	}

	/**
	 * @return the cbtTesterDao
	 */
	public ICbtTesterDao getCbtTesterDao() {
		return cbtTesterDao;
	}

	/**
	 * @param cbtTesterDao the cbtTesterDao to set
	 */
	public void setCbtTesterDao(ICbtTesterDao cbtTesterDao) {
		this.cbtTesterDao = cbtTesterDao;
	}

}
