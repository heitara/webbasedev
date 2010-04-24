package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialTitlePlayBusinessLogic;
import com.gameif.portal.dao.IOpensocialPlayHistDao;
import com.gameif.portal.dao.IOpensocialPlaySummaryDao;
import com.gameif.portal.entity.OpensocialPlayHist;
import com.gameif.portal.entity.OpensocialPlaySummary;
import com.gameif.portal.util.ContextUtil;

public class OpensocialTitlePlayBusinessLogicImpl extends BaseBusinessLogic implements IOpensocialTitlePlayBusinessLogic {

	private static final long serialVersionUID = 5404743047758769861L;
	
	private IOpensocialPlayHistDao opensocialPlayHistDao;
	private IOpensocialPlaySummaryDao opensocialPlaySummaryDao;

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist
	 */
	@Transactional
	public void savePlayHist(OpensocialPlayHist opensocialPlayHist) {
		
		OpensocialPlaySummary playSummary = new OpensocialPlaySummary();
		
		playSummary.setMemNum(opensocialPlayHist.getMemNum());
		playSummary.setTitleId(opensocialPlayHist.getTitleId());
		playSummary.setServerId(opensocialPlayHist.getServerId());
		
		OpensocialPlaySummary playSummaryFromDB = opensocialPlaySummaryDao.selectForUpdate(playSummary);
		
		if (playSummaryFromDB == null) {
			
			playSummary.setFirstPlayDate(new Date());
			playSummary.setFirstPlayIp(ContextUtil.getClientIP());
			playSummary.setPlayCount(0);
			
			opensocialPlaySummaryDao.save(playSummary);
			
		} else {
			
			playSummaryFromDB.setLastPlayDate(new Date());
			playSummaryFromDB.setLastPlayIp(ContextUtil.getClientIP());
			playSummaryFromDB.setPlayCount(playSummaryFromDB.getPlayCount().intValue() + 1);
			
			opensocialPlaySummaryDao.update(playSummaryFromDB);
		}

		opensocialPlayHist.setPlayDate(new Date());
		
		opensocialPlayHistDao.save(opensocialPlayHist);
	}

	public void setOpensocialPlayHistDao(IOpensocialPlayHistDao opensocialPlayHistDao) {
		
		this.opensocialPlayHistDao = opensocialPlayHistDao;
	}

	public void setOpensocialPlaySummaryDao(IOpensocialPlaySummaryDao opensocialPlaySummaryDao) {
		
		this.opensocialPlaySummaryDao = opensocialPlaySummaryDao;
	}
}