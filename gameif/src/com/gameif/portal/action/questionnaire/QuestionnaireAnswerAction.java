package com.gameif.portal.action.questionnaire;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IQuestionnaireAnswerBusinessLogic;
import com.gameif.portal.entity.QuestionnaireAnswer;
import com.gameif.portal.entity.QuestionnaireMst;

public class QuestionnaireAnswerAction  extends ModelDrivenActionSupport<QuestionnaireAnswer> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6521852373506683845L;
	
	private IQuestionnaireAnswerBusinessLogic questionnaireAnswerBusinessLogic;
	
	private String htmlContents;
	
	/**
	 * アンケート画面へ案内する
	 * @return アンケート画面
	 */
	public String input() {
		// アンケート番号により、画面のアンケート内容を表示する
		QuestionnaireMst questionnaireMst = questionnaireAnswerBusinessLogic.getquestionnaireMst(this.getModel().getQuestionNo());
		if (questionnaireMst == null) {
			logger.warn("questionnaireMst does not exist.");
			return "warning";
		}
		setHtmlContents(questionnaireMst.getHtmlContents());
		
		return INPUT;
	}
	
	/**
	 * アンケートをsubmitする
	 * @return
	 */
	public String create() {
		// 該当ユーザー既に回答しましたかどうかのチェック
		if (questionnaireAnswerBusinessLogic.IsDataExist(this.getModel().getQuestionNo())) {
			addFieldError("errMessage", getText("questionnaire.dataExist"));
			return INPUT;
		}
		// アンケートをsubmitする
		questionnaireAnswerBusinessLogic.createQuestionnaireAnswer(this.getModel());
		return SUCCESS;
	}

	/**
	 * @param questionnaireAnswerBusinessLogic the questionnaireAnswerBusinessLogic to set
	 */
	public void setQuestionnaireAnswerBusinessLogic(
			IQuestionnaireAnswerBusinessLogic questionnaireAnswerBusinessLogic) {
		this.questionnaireAnswerBusinessLogic = questionnaireAnswerBusinessLogic;
	}

	/**
	 * @return the htmlContents
	 */
	public String getHtmlContents() {
		return htmlContents;
	}

	/**
	 * @param htmlContents the htmlContents to set
	 */
	public void setHtmlContents(String htmlContents) {
		this.htmlContents = htmlContents;
	}

}
