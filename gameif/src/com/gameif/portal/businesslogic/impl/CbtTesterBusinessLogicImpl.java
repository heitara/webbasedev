package com.gameif.portal.businesslogic.impl;

import java.util.List;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.ICbtTesterBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.ICbtTesterDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.CbtTester;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.util.ContextUtil;

public class CbtTesterBusinessLogicImpl extends BaseBusinessLogic implements
ICbtTesterBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5036068437035517952L;
	
	private ICbtTesterDao cbtTesterDao;
	private ITitleMstDao titleMstDao;

	/**
	 * CBTテスターテーブルに登録する
	 */
	@Override
	public void saveCbtTester(CbtTester cbtTester) {
		
		cbtTester.setMemNum(ContextUtil.getMemberNo());
		cbtTester.setElectStatus(PortalConstants.ElectStatus.NOT_ELECTED);
		
		cbtTesterDao.save(cbtTester);
	}

	/**
	 * 募集中のタイトルを取得する
	 */
	@Override
	public List<MyTitle> getCbtTitleList(Long memNum) {
		
		return titleMstDao.selectCBTTitleList(memNum);
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

	/**
	 * @return the titleMstDao
	 */
	public ITitleMstDao getTitleMstDao() {
		return titleMstDao;
	}

	/**
	 * @param titleMstDao the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

}
