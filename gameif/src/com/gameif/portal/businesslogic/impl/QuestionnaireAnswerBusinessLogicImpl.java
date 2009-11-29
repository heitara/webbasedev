package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IQuestionnaireAnswerBusinessLogic;
import com.gameif.portal.dao.IQuestionnaireAnswerDao;
import com.gameif.portal.dao.IQuestionnaireMstDao;
import com.gameif.portal.entity.QuestionnaireAnswer;
import com.gameif.portal.entity.QuestionnaireMst;
import com.gameif.portal.util.ContextUtil;

public class QuestionnaireAnswerBusinessLogicImpl extends BaseBusinessLogic implements IQuestionnaireAnswerBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7171891997603664736L;
	
	private IQuestionnaireMstDao questionnaireMstDao;
	private IQuestionnaireAnswerDao questionnaireAnswerDao;

	/**
	 * アンケート番号により、画面内容を取得する
	 * @return アンケートマスタ情報
	 */
	@Override
	public QuestionnaireMst getquestionnaireMst(Integer questionNo) {
		QuestionnaireMst questionnaireMst = new QuestionnaireMst();
		questionnaireMst.setQuestionNo(questionNo);
		return questionnaireMstDao.selectByKey(questionnaireMst);
	}
	
	/**
	 * 該当ユーザー既に回答しましたかどうかのチェック
	 * @param questionNo　アンケート番号
	 * @return　true：回答しました、false：まだです
	 */
	public Boolean IsDataExist(Integer questionNo) {
		Boolean isExist = false;
		
		QuestionnaireAnswer questionnaireAnswer = new QuestionnaireAnswer();
		
		questionnaireAnswer.setMemNum(ContextUtil.getMemberNo());
		questionnaireAnswer.setQuestionNo(questionNo);
		
		questionnaireAnswer = questionnaireAnswerDao.selectByKey(questionnaireAnswer);
		if (questionnaireAnswer != null) {
			isExist = true;
		}
		return isExist;
	}

	@Transactional
	@Override
	public void createQuestionnaireAnswer(QuestionnaireAnswer questionnaireAnswer) {
		
		questionnaireAnswer.setMemNum(ContextUtil.getMemberNo());
		questionnaireAnswer.setAnswerDate(new Date());
		questionnaireAnswer.setQuestion11Db(makemultipleSelect(questionnaireAnswer.getQuestion11()));
		questionnaireAnswer.setQuestion12Db(makemultipleSelect(questionnaireAnswer.getQuestion12()));
		questionnaireAnswer.setQuestion13Db(makemultipleSelect(questionnaireAnswer.getQuestion13()));
		questionnaireAnswer.setQuestion14Db(makemultipleSelect(questionnaireAnswer.getQuestion14()));
		questionnaireAnswer.setQuestion15Db(makemultipleSelect(questionnaireAnswer.getQuestion15()));
		questionnaireAnswer.setQuestion16Db(makemultipleSelect(questionnaireAnswer.getQuestion16()));
		questionnaireAnswer.setQuestion17Db(makemultipleSelect(questionnaireAnswer.getQuestion17()));
		questionnaireAnswer.setQuestion18Db(makemultipleSelect(questionnaireAnswer.getQuestion18()));
		questionnaireAnswer.setQuestion19Db(makemultipleSelect(questionnaireAnswer.getQuestion19()));
		questionnaireAnswer.setQuestion20Db(makemultipleSelect(questionnaireAnswer.getQuestion20()));
		
		questionnaireAnswerDao.save(questionnaireAnswer);
		
	}
	
	private Integer makemultipleSelect(Integer[] checkedValue) {
		if (checkedValue == null || checkedValue.length == 0) {
			return null;
		}
		Integer value = 0;
		for (int i = 0; i < checkedValue.length; i++) {
			value = value | checkedValue[i];
		}
		return value;
	}

	/**
	 * @param questionnaireMstDao the questionnaireMstDao to set
	 */
	public void setQuestionnaireMstDao(IQuestionnaireMstDao questionnaireMstDao) {
		this.questionnaireMstDao = questionnaireMstDao;
	}

	/**
	 * @param questionnaireAnswerDao the questionnaireAnswerDao to set
	 */
	public void setQuestionnaireAnswerDao(
			IQuestionnaireAnswerDao questionnaireAnswerDao) {
		this.questionnaireAnswerDao = questionnaireAnswerDao;
	}

}
