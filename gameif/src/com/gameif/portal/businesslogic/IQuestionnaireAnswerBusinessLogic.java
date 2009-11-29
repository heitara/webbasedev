package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.QuestionnaireAnswer;
import com.gameif.portal.entity.QuestionnaireMst;

public interface IQuestionnaireAnswerBusinessLogic {
	
	public QuestionnaireMst getquestionnaireMst(Integer questionNo);
	public Boolean IsDataExist(Integer questionNo);
	public void createQuestionnaireAnswer(QuestionnaireAnswer questionnaireAnswer);

}
