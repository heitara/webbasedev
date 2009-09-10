package com.gameif.portal.helper;

import java.util.Map;

public class PortalProperties {
	
	/** 秘密質問リスト*/
	private Map<String, String> questionList;
	
	/** アクションタイトルマップ */
	private Map<String, String> actionTitles;

	public Map<String, String> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Map<String, String> questionList) {
		this.questionList = questionList;
	}

	public Map<String, String> getActionTitles() {
		return actionTitles;
	}

	public void setActionTitles(Map<String, String> actionTitles) {
		this.actionTitles = actionTitles;
	}
}
