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

	private String kaptcha;

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
	 * 
	 * @return
	 */
	public String getKaptcha() {
		return kaptcha;
	}

	/**
	 * 
	 * @param kaptcha
	 */
	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
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
	 * その他問合せ画面に案内する。
	 * 
	 * @return その他問合せ画面
	 */
	public String inputMedia() {

		return "inputMedia";
	}

	/**
	 * 会員問合せ画面に案内する。
	 * @return その他問合せ画面
	 */
	public String inputMember() {
		
		return "inputMember";
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

	/**
	 * データを問合せテーブルに登録する
	 * 
	 * @return
	 */
	public String createMedia() {
		this.getModel().setInquiryType(PortalConstants.InquiryType.MEDIA);
		inquiryInfoBusinessLogic.saveInquiryInfo(this.getModel());
		return SUCCESS;
	}

	/**
	 * データを問合せテーブルに登録する
	 * @return
	 */
	public String createMem() {
		this.getModel().setInquiryType(PortalConstants.InquiryType.MEMBER);
		inquiryInfoBusinessLogic.saveInquiryInfo(this.getModel());
		return SUCCESS;
	}
}