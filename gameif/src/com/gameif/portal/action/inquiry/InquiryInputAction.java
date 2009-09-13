package com.gameif.portal.action.inquiry;

import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IInquiryInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.InquiryInfo;
import com.gameif.portal.entity.InquiryKindMst;
import com.gameif.portal.entity.TitleMst;

public class InquiryInputAction extends ModelDrivenActionSupport<InquiryInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8550721373586405191L;

	private IInquiryInfoBusinessLogic inquiryInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	private List<TitleMst> listValidTitle;
	private List<InquiryKindMst> listInquiryKind;

	/**
	 * @param inquiryInfoBusinessLogic
	 *            the inquiryInfoBusinessLogic to set
	 */
	public void setInquiryInfoBusinessLogic(
			IInquiryInfoBusinessLogic inquiryInfoBusinessLogic) {
		this.inquiryInfoBusinessLogic = inquiryInfoBusinessLogic;
	}

	/**
	 * @return the listValidTitle
	 */
	public List<TitleMst> getListValidTitle() {
		return listValidTitle;
	}

	/**
	 * @param listValidTitle the listValidTitle to set
	 */
	public void setListValidTitle(List<TitleMst> listValidTitle) {
		this.listValidTitle = listValidTitle;
	}

	/**
	 * @return the listInquiryKind
	 */
	public List<InquiryKindMst> getListInquiryKind() {
		return listInquiryKind;
	}

	/**
	 * @param listInquiryKind the listInquiryKind to set
	 */
	public void setListInquiryKind(List<InquiryKindMst> listInquiryKind) {
		this.listInquiryKind = listInquiryKind;
	}

	/**
	 * @param masterInfoBusinessLogic the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * その他問合せ画面に案内する。
	 * @return その他問合せ画面
	 */
	public String input() {
		// 初期化処理
		// 現時点で有効なタイトルを取得する
		this.setListValidTitle(masterInfoBusinessLogic.selectValidTitleList());
		// 問合せ種類を取得する
		this.setListInquiryKind(masterInfoBusinessLogic.selectAllInquiryKindList());
		
		return INPUT;
	}

	/**
	 * データを問合せテーブルに登録する
	 * @return
	 */
	public String create() {
		this.getModel().setInquiryType(PortalConstants.InquiryType.OTHER);
		inquiryInfoBusinessLogic.saveInquiryInfo(this.getModel());
		return SUCCESS;
	}
}
