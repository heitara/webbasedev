package com.gameif.portal.action.inquiry;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.InquiryInfo;

public class InquiryInputAction extends ModelDrivenActionSupport<InquiryInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8550721373586405191L;

	private IInquiryInfoBusinessLogic inquiryInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

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
	 * その他問合せ画面に案内する。
	 * 
	 * @return その他問合せ画面
	 */
	public String input() {
		return INPUT;
	}

	/**
	 * データを問合せテーブルに登録する
	 * 
	 * @return
	 */
	public String create() {
		this.getModel().setInquiryType(PortalConstants.InquiryType.OTHER);
		inquiryInfoBusinessLogic.saveInquiryInfo(this.getModel());
		return SUCCESS;
	}
}
