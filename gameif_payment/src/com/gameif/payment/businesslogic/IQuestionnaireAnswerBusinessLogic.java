package com.gameif.payment.businesslogic;

import com.gameif.payment.entity.QuestionnaireAnswer;
import com.gameif.payment.entity.QuestionnaireMst;

public interface IQuestionnaireAnswerBusinessLogic {
	
	public QuestionnaireMst getquestionnaireMst(Integer questionNo);
	public Boolean IsDataExist(Integer questionNo);
	public void createQuestionnaireAnswer(QuestionnaireAnswer questionnaireAnswer);

}
