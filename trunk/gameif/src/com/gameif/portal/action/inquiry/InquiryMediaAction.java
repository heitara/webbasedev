package com.gameif.portal.action.inquiry;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.InquiryInfo;

public class InquiryMediaAction extends ModelDrivenActionSupport<InquiryInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1208021505653308732L;
	
	private IInquiryInfoBusinessLogic inquiryInfoBusinessLogic;

	/**
	 * @param inquiryInfoBusinessLogic
	 *            the inquiryInfoBusinessLogic to set
	 */
	public void setInquiryInfoBusinessLogic(
			IInquiryInfoBusinessLogic inquiryInfoBusinessLogic) {
		this.inquiryInfoBusinessLogic = inquiryInfoBusinessLogic;
	}

	/**
	 * その他問合せ画面に案内する。
	 * @return その他問合せ画面
	 */
	public String inputMedia() {
		
		return "inputMedia";
	}

	/**
	 * データを問合せテーブルに登録する
	 * @return
	 */
	public String createMedia() {
		this.getModel().setInquiryType(PortalConstants.InquiryType.MEDIA);
		inquiryInfoBusinessLogic.saveInquiryInfo(this.getModel());
		return SUCCESS;
	}

}
