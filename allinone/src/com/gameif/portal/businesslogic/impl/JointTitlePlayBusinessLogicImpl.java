package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IJointTitlePlayBusinessLogic;
import com.gameif.portal.dao.IJointPlayHistDao;
import com.gameif.portal.entity.JointPlayHist;

public class JointTitlePlayBusinessLogicImpl extends BaseBusinessLogic implements IJointTitlePlayBusinessLogic {

	private static final long serialVersionUID = 5404743047758769861L;
	
	private IJointPlayHistDao jointPlayHistDao;

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist
	 */
	@Transactional
	public void savePlayHist(JointPlayHist jointPlayHist) {

		jointPlayHist.setPlayDate(new Date());
		
		jointPlayHistDao.save(jointPlayHist);
	}

	public void setJointPlayHistDao(IJointPlayHistDao jointPlayHistDao) {
		this.jointPlayHistDao = jointPlayHistDao;
	}
}
