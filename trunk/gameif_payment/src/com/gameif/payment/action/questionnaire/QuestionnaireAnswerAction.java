package com.gameif.payment.action.questionnaire;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.payment.businesslogic.IQuestionnaireAnswerBusinessLogic;
import com.gameif.payment.entity.QuestionnaireAnswer;
import com.gameif.payment.entity.QuestionnaireMst;

public class QuestionnaireAnswerAction  extends ModelDrivenActionSupport<QuestionnaireAnswer> {

	private static final long serialVersionUID = 6521852373506683845L;
	
	private IQuestionnaireAnswerBusinessLogic questionnaireAnswerBusinessLogic;
	
	private String htmlContents;
	private boolean hasDblError;
	
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
			hasDblError = true;
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

	public boolean isHasDblError() {
		return hasDblError;
	}

	public void setHasDblError(boolean hasDblError) {
		this.hasDblError = hasDblError;
	}

}
