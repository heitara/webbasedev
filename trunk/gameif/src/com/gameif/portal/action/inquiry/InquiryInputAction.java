package com.gameif.portal.action.inquiry;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.InquiryInfo;
import com.gameif.portal.entity.MemberInfo;

public class InquiryInputAction extends ModelDrivenActionSupport<InquiryInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8550721373586405191L;

	private IInquiryInfoBusinessLogic inquiryInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

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
	 * @return the memberInfoBusinessLogic
	 */
	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}

	/**
	 * @param memberInfoBusinessLogic the memberInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
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
		// 会員問合せの会員番号
		getModel().setMemNum(ContextUtil.getMemberNo());
		
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMemNum(getModel().getMemNum());
		// 会員番号により、会員情報を取得する
		memberInfo = memberInfoBusinessLogic.getMemberInfo(memberInfo);
		if (memberInfo != null) {
			// メールアドレスを紹介者のメールアドレスに設定する
			getModel().setUserMailadd(memberInfo.getMailPc());
		}
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
