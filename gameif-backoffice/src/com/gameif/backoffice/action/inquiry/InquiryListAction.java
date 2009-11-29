package com.gameif.backoffice.action.inquiry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.backoffice.bean.InquirySearchCondition;
import com.gameif.backoffice.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.entity.InquiryInfo;
import com.gameif.backoffice.helper.BackOfficeProperties;

public class InquiryListAction extends ModelDrivenActionSupport<InquirySearchCondition> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8550721373586405191L;

	private IInquiryInfoBusinessLogic inquiryInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private BackOfficeProperties backOfficeProperties;
	
	private List<InquiryInfo> inquiryList;
	private List<Long> selectedInquiryList;
	
	/**
	 * 問合せ一覧画面へ案内する
	 * @return 問合せ一覧画面
	 */
	public String input() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = new Date();
//		try {
//			this.getModel().setInquiryStartDate(df.parse(df.format(now)));
//			this.getModel().setInquiryEndDate(df.parse(df.format(now)));
//		} catch (Exception ex) {
//			logger.error(ex);
//		}
		this.getModel().setInquiryStartDate(now);
		this.getModel().setInquiryEndDate(now);
		return INPUT;
	}
	
	public String search() {
		setInquiryList(inquiryInfoBusinessLogic.searchInquiryList(this.getModel()));
		if (getInquiryList() == null || getInquiryList().size() < 1) {
			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		return SUCCESS;
	}
	
	public String delete() {
		
		// 選択した問合せ情報を削除する
		inquiryInfoBusinessLogic.deleteInquiryInfo(getSelectedInquiryList());
		
		return INPUT;
	}
	
	public String clear() {
		setInquiryList(null);
		Date now = new Date();
		this.getModel().setInquiryStartDate(now);
		this.getModel().setInquiryEndDate(now);
		this.getModel().setInquiryType(null);
		this.getModel().setInquiryKindCode(null);
		this.getModel().setCorrespondStatus(9999);
		this.getModel().setUserMailadd(null);
		this.getModel().setInquiryObject(null);
		return INPUT;
	}

	/**
	 * @param inquiryInfoBusinessLogic
	 *            the inquiryInfoBusinessLogic to set
	 */
	public void setInquiryInfoBusinessLogic(
			IInquiryInfoBusinessLogic inquiryInfoBusinessLogic) {
		this.inquiryInfoBusinessLogic = inquiryInfoBusinessLogic;
	}

	/**
	 * 
	 * @return
	 */
	public IInquiryInfoBusinessLogic getInquiryInfoBusinessLogic() {
		return inquiryInfoBusinessLogic;
	}

	/**
	 * 
	 * @return
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic
	 *            the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * @return the backOfficeProperties
	 */
	public BackOfficeProperties getBackOfficeProperties() {
		return backOfficeProperties;
	}

	/**
	 * @param backOfficeProperties
	 *            the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(
			BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

	/**
	 * @return the inquiryList
	 */
	public List<InquiryInfo> getInquiryList() {
		return inquiryList;
	}

	/**
	 * @param inquiryList the inquiryList to set
	 */
	public void setInquiryList(List<InquiryInfo> inquiryList) {
		this.inquiryList = inquiryList;
	}

	/**
	 * @return the selectedInquiryList
	 */
	public List<Long> getSelectedInquiryList() {
		return selectedInquiryList;
	}

	/**
	 * @param selectedInquiryList the selectedInquiryList to set
	 */
	public void setSelectedInquiryList(List<Long> selectedInquiryList) {
		this.selectedInquiryList = selectedInquiryList;
	}
	
}
