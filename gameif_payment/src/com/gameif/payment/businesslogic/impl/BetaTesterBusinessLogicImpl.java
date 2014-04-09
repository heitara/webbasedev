package com.gameif.payment.businesslogic.impl;

import java.util.List;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.payment.businesslogic.IBetaTesterBusinessLogic;
import com.gameif.payment.constants.PortalConstants;
import com.gameif.payment.dao.IBetaTesterDao;
import com.gameif.payment.dao.ITitleMstDao;
import com.gameif.payment.entity.BetaTester;
import com.gameif.payment.entity.MyTitle;

public class BetaTesterBusinessLogicImpl extends BaseBusinessLogic implements IBetaTesterBusinessLogic {

	private static final long serialVersionUID = -5036068437035517952L;
	
	private IBetaTesterDao betaTesterDao;
	private ITitleMstDao titleMstDao;

	/**
	 * βテスターテーブルに登録する
	 */
	@Override
	public void saveBetaTester(BetaTester betaTester) {
		
		if (betaTesterDao.selectByKey(betaTester.getMemNum(), betaTester.getTitleId()) == null) {

			betaTester.setElectStatus(PortalConstants.ElectStatus.NOT_ELECTED);			
			betaTesterDao.save(betaTester);
		}
	}
	/**
	 * βテスターを取得する
	 */
	@Override
	public BetaTester getBetaTester(Integer titleId, Long memNum) {
		
		return betaTesterDao.selectByKey(memNum, titleId);
	}

	/**
	 * 募集中のタイトルを取得する
	 */
	@Override
	public List<MyTitle> getMyBetaTestTitleList(Long memNum) {
		
		return betaTesterDao.selectMyBetaTestTitleList(memNum);
	}

	/**
	 * @return the betaTesterDao
	 */
	public IBetaTesterDao getBetaTesterDao() {
		return betaTesterDao;
	}

	/**
	 * @param betaTesterDao the betaTesterDao to set
	 */
	public void setBetaTesterDao(IBetaTesterDao betaTesterDao) {
		this.betaTesterDao = betaTesterDao;
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
