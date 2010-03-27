package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialTitlePlayBusinessLogic;
import com.gameif.portal.dao.IOpensocialPlayHistDao;
import com.gameif.portal.entity.OpensocialPlayHist;

public class OpensocialTitlePlayBusinessLogicImpl extends BaseBusinessLogic implements IOpensocialTitlePlayBusinessLogic {

	private static final long serialVersionUID = 5404743047758769861L;
	
	private IOpensocialPlayHistDao opensocialPlayHistDao;

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist
	 */
	@Transactional
	public void savePlayHist(OpensocialPlayHist opensocialPlayHist) {

		opensocialPlayHist.setPlayDate(new Date());
		
		opensocialPlayHistDao.save(opensocialPlayHist);
	}

	public void setOpensocialPlayHistDao(IOpensocialPlayHistDao opensocialPlayHistDao) {
		
		this.opensocialPlayHistDao = opensocialPlayHistDao;
	}
}
