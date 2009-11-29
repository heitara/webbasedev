package com.gameif.backoffice.action.inquiryMailTemplate;

import java.util.List;

import com.gameif.backoffice.businesslogic.IInquiryMailTemplateBusinessLogic;
import com.gameif.backoffice.entity.InquirySendmailTemplate;
import com.gameif.common.action.ModelDrivenActionSupport;

public class InquiryMailTemplateAction extends ModelDrivenActionSupport<InquirySendmailTemplate> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8105065148897686343L;

	private IInquiryMailTemplateBusinessLogic inquiryMailTemplateBusinessLogic;
	
	private List<InquirySendmailTemplate> inquiryTemplateList;
	private List<Integer> selectedTemplateList;
	
	public String inputList() {
		return "inputList";
	}
	
	/**
	 * 検索条件によって、問合せ返信テンプレートを取得する
	 * @return 一覧画面
	 */
	public String search() {
		setInquiryTemplateList(inquiryMailTemplateBusinessLogic.searchInquiryTemplateList(this.getModel()));
		if (getInquiryTemplateList() == null || getInquiryTemplateList().size() == 0) {
			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		return "inputList";
	}
	
	/**
	 * 選択したテンプレートを削除する
	 * @return
	 */
	public String delete() {
		inquiryMailTemplateBusinessLogic.deleteInquiryTemplateList(getSelectedTemplateList());
		return "inputList";
	}
	
	public String inputAdd() {
		return "inputAdd";
	}
	
	/**
	 * 問合せ返信テンプレート情報をDBに登録する
	 * @return
	 */
	public String create() {
		inquiryMailTemplateBusinessLogic.createInquiryMailTemplate(this.getModel());
		addFieldError("errMessage", getText("common.saveSuccess"));
		return "inputAdd";
	}
	
	public String inputEdit() {
		this.setModel(inquiryMailTemplateBusinessLogic.getInquiryMailTemplate(this.getModel()));
		return "inputEdit";
	}
	
	public String update() {
		inquiryMailTemplateBusinessLogic.updateInquiryMailTemplate(this.getModel());
		return "inputEdit";
	}

	/**
	 * @return the inquiryTemplateList
	 */
	public List<InquirySendmailTemplate> getInquiryTemplateList() {
		return inquiryTemplateList;
	}

	/**
	 * @param inquiryTemplateList the inquiryTemplateList to set
	 */
	public void setInquiryTemplateList(
			List<InquirySendmailTemplate> inquiryTemplateList) {
		this.inquiryTemplateList = inquiryTemplateList;
	}

	/**
	 * @return the inquiryMailTemplateBusinessLogic
	 */
	public IInquiryMailTemplateBusinessLogic getInquiryMailTemplateBusinessLogic() {
		return inquiryMailTemplateBusinessLogic;
	}

	/**
	 * @param inquiryMailTemplateBusinessLogic the inquiryMailTemplateBusinessLogic to set
	 */
	public void setInquiryMailTemplateBusinessLogic(
			IInquiryMailTemplateBusinessLogic inquiryMailTemplateBusinessLogic) {
		this.inquiryMailTemplateBusinessLogic = inquiryMailTemplateBusinessLogic;
	}

	/**
	 * @return the selectedTemplateList
	 */
	public List<Integer> getSelectedTemplateList() {
		return selectedTemplateList;
	}

	/**
	 * @param selectedTemplateList the selectedTemplateList to set
	 */
	public void setSelectedTemplateList(List<Integer> selectedTemplateList) {
		this.selectedTemplateList = selectedTemplateList;
	}

}
