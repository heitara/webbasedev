package com.gameif.backoffice.action.inquiry;

import com.gameif.backoffice.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
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
	
	private String titleName;
	private String inquiryKindName;
	private String nickName;
	
	/**
	 * 問合せ編集画面へ案内する
	 * @return 問合せ編集画面
	 */
	public String inputEdit() {
		
		this.setModel(inquiryInfoBusinessLogic.getInquiryInfo(this.getModel()));
		if (this.getModel() == null) {

			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		
		setTitleName(inquiryInfoBusinessLogic.getTitleNameById(this.getModel().getTitleId()));
		setInquiryKindName(inquiryInfoBusinessLogic.getInquiryKindNameByCd(this.getModel().getInquiryKindCode()));
		setNickName(this.getModel().getUserName());
		
		return "inputEdit";
	}
	
	/**
	 * 問合せを回答する(対応済に)
	 * @return 問合せ編集画面
	 */
	public String reply() {
		try {

			this.getModel().setCorrespondStatus(BackofficeConstants.CorrespondStatus.CORRESPONDED);
			inquiryInfoBusinessLogic.replyInquiryInfo(this.getModel(), getNickName());
			
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
		
		addFieldError("errMessage", getText("inquiry.replySuccess"));
		
		return SUCCESS;
	}
	
	/**
	 * 問合せを回答する(対応中に)
	 * @return 問合せ編集画面
	 */
	public String reserve() {
		try {
			this.getModel().setCorrespondStatus(BackofficeConstants.CorrespondStatus.IN_CORRESPOND);
			inquiryInfoBusinessLogic.replyInquiryInfo(this.getModel(), getNickName());
			
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
		addFieldError("errMessage", getText("inquiry.replySuccess"));
		return SUCCESS;
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

	/**
	 * @return the titleName
	 */
	public String getTitleName() {
		return titleName;
	}

	/**
	 * @param titleName the titleName to set
	 */
	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	/**
	 * @return the inquiryKindName
	 */
	public String getInquiryKindName() {
		return inquiryKindName;
	}

	/**
	 * @param inquiryKindName the inquiryKindName to set
	 */
	public void setInquiryKindName(String inquiryKindName) {
		this.inquiryKindName = inquiryKindName;
	}

	/**
	 * @return the nickName
	 */
	public String getNickName() {
		return nickName;
	}

	/**
	 * @param nickName the nickName to set
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

}
