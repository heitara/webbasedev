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
		
		// 複数選択項目
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
		
		// 備考項目
		Integer len = 800;
		questionnaireAnswer.setRemarks1(subString(questionnaireAnswer.getRemarks1(), len));
		questionnaireAnswer.setRemarks2(subString(questionnaireAnswer.getRemarks2(), len));
		questionnaireAnswer.setRemarks3(subString(questionnaireAnswer.getRemarks3(), len));
		questionnaireAnswer.setRemarks4(subString(questionnaireAnswer.getRemarks4(), len));
		questionnaireAnswer.setRemarks5(subString(questionnaireAnswer.getRemarks5(), len));
		questionnaireAnswer.setRemarks6(subString(questionnaireAnswer.getRemarks6(), len));
		questionnaireAnswer.setRemarks7(subString(questionnaireAnswer.getRemarks7(), len));
		questionnaireAnswer.setRemarks8(subString(questionnaireAnswer.getRemarks8(), len));
		questionnaireAnswer.setRemarks9(subString(questionnaireAnswer.getRemarks9(), len));
		questionnaireAnswer.setRemarks10(subString(questionnaireAnswer.getRemarks10(), len));
		questionnaireAnswer.setRemarks11(subString(questionnaireAnswer.getRemarks11(), len));
		questionnaireAnswer.setRemarks12(subString(questionnaireAnswer.getRemarks12(), len));
		questionnaireAnswer.setRemarks13(subString(questionnaireAnswer.getRemarks13(), len));
		questionnaireAnswer.setRemarks14(subString(questionnaireAnswer.getRemarks14(), len));
		questionnaireAnswer.setRemarks15(subString(questionnaireAnswer.getRemarks15(), len));
		questionnaireAnswer.setRemarks16(subString(questionnaireAnswer.getRemarks16(), len));
		questionnaireAnswer.setRemarks17(subString(questionnaireAnswer.getRemarks17(), len));
		questionnaireAnswer.setRemarks18(subString(questionnaireAnswer.getRemarks18(), len));
		questionnaireAnswer.setRemarks19(subString(questionnaireAnswer.getRemarks19(), len));
		questionnaireAnswer.setRemarks20(subString(questionnaireAnswer.getRemarks20(), len));
		questionnaireAnswer.setQuestion21(subString(questionnaireAnswer.getQuestion21(), len));
		questionnaireAnswer.setQuestion22(subString(questionnaireAnswer.getQuestion22(), len));
		questionnaireAnswer.setQuestion23(subString(questionnaireAnswer.getQuestion23(), len));
		questionnaireAnswer.setQuestion24(subString(questionnaireAnswer.getQuestion24(), len));
		questionnaireAnswer.setQuestion25(subString(questionnaireAnswer.getQuestion25(), len));
		
		questionnaireAnswerDao.save(questionnaireAnswer);
		
	}
	
	private Integer makemultipleSelect(Integer[] checkedValue) {
		if (checkedValue == null || checkedValue.length == 0) {
			return null;
		}
		Integer value = 0;
		for (int i = 0; i < checkedValue.length; i++) {
			value = value | (int)(Math.pow(2, checkedValue[i] - 1));
		}
		return value;
	}
	
	/**
	 * 指定長さの文字列を返します
	 * @param origin 元の文字列
	 * @param len 指定長さ
	 * @return 新しい文字列
	 */
	private String subString(String origin, Integer len) {
		
		if (origin == null || origin.trim().length() == 0) {
			return "";
		}
		
		byte[] strByte = origin.getBytes();
		int strLen = strByte.length;
		if (len >= strLen) {
			return origin;
		}
		
		int count = 0;
		for (int i = 0; i < len; i++) {
			int value = (int) strByte[i];
			if (value < 0) {
				count++;
			}
		}
		if (count % 2 != 0) {
			len = (len == 1) ? len + 1 : len - 1;
		}
		return new String(strByte, 0, len);
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
