package com.gameif.portal.action.menu;

import java.util.ArrayList;
import java.util.List;

import com.gameif.common.bean.KeyValueInfo;

public class MainMenu {
	private List<KeyValueInfo> listQuestion;

	/**
	 * @return the listQuestion
	 */
	public List<KeyValueInfo> getListQuestion() {
		return listQuestion;
	}

	/**
	 * @param listQuestion
	 *            the listQuestion to set
	 */
	public void setListQuestion(List<KeyValueInfo> listQuestion) {
		this.listQuestion = listQuestion;
	}

	public String create() {
		this.setListQuestion(getQuestionList());
		return "new_member_input";
	}

	public String inquiry() {
		return "inquiry_input";
	}

	public String events() {
		return "events_list";
	}

	public String home() {
		return "back_home";
	}

	private List<KeyValueInfo> getQuestionList() {
		List<KeyValueInfo> infos = new ArrayList<KeyValueInfo>();

		KeyValueInfo info = new KeyValueInfo();

		info.setKey("00");
		info.setValue(" ");

		infos.add(info);

		info = new KeyValueInfo();
		info.setKey("11");
		info.setValue("test11");

		infos.add(info);

		info = new KeyValueInfo();
		info.setKey("12");
		info.setValue("test12");

		infos.add(info);

		return infos;
	}
}
