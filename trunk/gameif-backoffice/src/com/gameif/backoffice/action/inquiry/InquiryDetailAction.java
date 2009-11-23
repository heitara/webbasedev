package com.gameif.backoffice.action.inquiry;

import com.gameif.backoffice.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.entity.InquiryInfo;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;

public class InquiryDetailAction extends ModelDrivenActionSupport<InquiryInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1189376431979991358L;
	
	private IInquiryInfoBusinessLogic inquiryInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private BackOfficeProperties backOfficeProperties;
	
	/**
	 * 問合せ編集画面へ案内する
	 * @return 問合せ編集画面
	 */
	public String inputEdit() {
		
		this.setModel(inquiryInfoBusinessLogic.getInquiryInfo(this.getModel()));
		if (this.getModel() == null) {

			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		
		return "inputEdit";
	}
	
	/**
	 * 問合せを回答する
	 * @return 問合せ編集画面
	 */
	public String reply() {
		try {
			
			inquiryInfoBusinessLogic.replyInquiryInfo(this.getModel());
			
		} catch (DataNotExistsException dnex) {
	
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ dnex.getMessage());
	
			addFieldError("errMessage", getText("common.dataNotExist"));
	
			return "inputEdit";
	
		} catch (LogicException lgex) {
	
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());
	
			return "warning";
		}
		return "inputEdit";
	}

	/**
	 * @return the inquiryInfoBusinessLogic
	 */
	public IInquiryInfoBusinessLogic getInquiryInfoBusinessLogic() {
		return inquiryInfoBusinessLogic;
	}

	/**
	 * @param inquiryInfoBusinessLogic the inquiryInfoBusinessLogic to set
	 */
	public void setInquiryInfoBusinessLogic(
			IInquiryInfoBusinessLogic inquiryInfoBusinessLogic) {
		this.inquiryInfoBusinessLogic = inquiryInfoBusinessLogic;
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic the masterInfoBusinessLogic to set
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
	 * @param backOfficeProperties the backOfficeProperties to set
	 */
	public void setBackOfficeProperties(BackOfficeProperties backOfficeProperties) {
		this.backOfficeProperties = backOfficeProperties;
	}

}
