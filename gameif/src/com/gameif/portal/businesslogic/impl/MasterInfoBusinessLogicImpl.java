package com.gameif.portal.businesslogic.impl;

import java.util.List;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.dao.IDivisionMstDao;
import com.gameif.portal.dao.IOccupationMstDao;
import com.gameif.portal.dao.IQuestionMstDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.DivisionMst;
import com.gameif.portal.entity.OccupationMst;
import com.gameif.portal.entity.QuestionMst;
import com.gameif.portal.entity.TitleMst;

public class MasterInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IMasterInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -105096134811999134L;

	private IDivisionMstDao divisionMstDao;
	private IOccupationMstDao occupationMstDao;
	private IQuestionMstDao questionMstDao;
	private ITitleMstDao titleMstDao;

	/**
	 * @param divisionMstDao
	 *            the divisionMstDao to set
	 */
	public void setDivisionMstDao(IDivisionMstDao divisionMstDao) {
		this.divisionMstDao = divisionMstDao;
	}

	/**
	 * @param occupationMstDao
	 *            the occupationMstDao to set
	 */
	public void setOccupationMstDao(IOccupationMstDao occupationMstDao) {
		this.occupationMstDao = occupationMstDao;
	}

	/**
	 * @param questionMstDao
	 *            the questionMstDao to set
	 */
	public void setQuestionMstDao(IQuestionMstDao questionMstDao) {
		this.questionMstDao = questionMstDao;
	}

	/**
	 * @param titleMstDao
	 *            the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	@Override
	public List<DivisionMst> selectAllDivisionMst() {
		return divisionMstDao.selectAll(null);
	}

	@Override
	public List<OccupationMst> selectAllOccupationList() {
		return occupationMstDao.selectAll(null);
	}

	@Override
	public List<QuestionMst> selectAllQuestionList() {
		return questionMstDao.selectAll(null);
	}

	@Override
	public List<TitleMst> selectValidTitleList() {
		return titleMstDao.selectValidTitleList();
	}

}
