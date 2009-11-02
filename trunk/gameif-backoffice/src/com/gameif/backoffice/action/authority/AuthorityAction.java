package com.gameif.backoffice.action.authority;

import java.util.List;

import com.gameif.backoffice.bean.AuthorityInfo;
import com.gameif.backoffice.businesslogic.IAuthorityBusinessLogic;
import com.gameif.backoffice.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.entity.AuthorityDetailMst;
import com.gameif.backoffice.entity.AuthorityMst;
import com.gameif.backoffice.helper.BackOfficeProperties;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;

public class AuthorityAction extends ModelDrivenActionSupport<AuthorityInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4669606649644400422L;

	private BackOfficeProperties backOfficeProperties;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IAuthorityBusinessLogic authorityBusinessLogic;

	private String memberLevel;
	private String inquiryLevel;
	private String inviteLevel;
	private String campaignLevel;
	private String servicePointLevel;
	private String salesLevel;
	
	private List<AuthorityMst> authorityList;
	private List<String> selectedAuthoritys;

	/**
	 * 権限追加画面に案内する
	 * 
	 * @return　権限追加画面
	 */
	public String inputAdd() {
		return "inputAdd";
	}

	/**
	 * 権限情報を登録する
	 * @return
	 */
	public String create() {
		// 権限明細を作る
		makeAuthorityDetail();
		// 権限情報を登録する
		authorityBusinessLogic.createAuthorityInfo(this.getModel());
		
		addFieldError("errMessage", getText("common.saveSuccess"));
		
		return "inputAdd";
	}
	
	/**
	 * 権限明細を作る
	 */
	private void makeAuthorityDetail() {
		AuthorityDetailMst authorityDetail = new AuthorityDetailMst();
		
		Integer count = masterInfoBusinessLogic.getAllFunctionList().size();
		String functionCode = null;
		for (int i = 0; i < count; i++) {
			
			functionCode = masterInfoBusinessLogic.getAllFunctionList().get(i).getFunctionCode();
			authorityDetail.setFunctionCode(functionCode);
			
			if (functionCode.equals(BackofficeConstants.FunctionCode.MEMBER)) {
				authorityDetail.setAuthorityLevel(getMemberLevel());
				
			} else if (functionCode.equals(BackofficeConstants.FunctionCode.INQUIRY)) {
				authorityDetail.setAuthorityLevel(getInquiryLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.INVITE)) {
				authorityDetail.setAuthorityLevel(getInviteLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.CAMPAIGN)) {
				authorityDetail.setAuthorityLevel(getCampaignLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.SERVICE_POINT)) {
				authorityDetail.setAuthorityLevel(getServicePointLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.SALES)) {
				authorityDetail.setAuthorityLevel(getSalesLevel());
			}
			
			this.getModel().getAuthorityDetails().add(authorityDetail);
		}
		
	}

	/**
	 * 権限更新画面に案内する
	 * 
	 * @return　権限更新画面
	 */
	public String inputEdit() {
		try {
			
			this.setModel(authorityBusinessLogic.getAuthorityinfoByCode(this.getModel().getAuthority().getAuthorityCode()));
			
			setAuthorityDetail();
			
		} catch (DataNotExistsException ahex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ahex.getMessage());

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
	 * 権限明細を作る
	 */
	private void setAuthorityDetail() {
		List<AuthorityDetailMst> authorityDetails = this.getModel().getAuthorityDetails();
		String functionCode = null;
		for (int i = 0; i < authorityDetails.size(); i++) {
			
			functionCode = authorityDetails.get(i).getFunctionCode();
			
			if (functionCode.equals(BackofficeConstants.FunctionCode.MEMBER)) {
				setMemberLevel(authorityDetails.get(i).getAuthorityLevel());
				
			} else if (functionCode.equals(BackofficeConstants.FunctionCode.INQUIRY)) {
				setInquiryLevel(authorityDetails.get(i).getAuthorityLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.INVITE)) {
				setInviteLevel(authorityDetails.get(i).getAuthorityLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.CAMPAIGN)) {
				setCampaignLevel(authorityDetails.get(i).getAuthorityLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.SERVICE_POINT)) {
				setServicePointLevel(authorityDetails.get(i).getAuthorityLevel());

			} else if (functionCode.equals(BackofficeConstants.FunctionCode.SALES)) {
				setSalesLevel(authorityDetails.get(i).getAuthorityLevel());
			}
		}
		
	}

	/**
	 * 権限情報を登録する
	 * @return
	 */
	public String update() {
		// 権限明細を作る
		makeAuthorityDetail();
		// 権限情報を登録する
		authorityBusinessLogic.updateAuthorityInfo(this.getModel());
		
		addFieldError("errMessage", getText("common.saveSuccess"));
		
		return "inputAdd";
	}

	/**
	 * 権限一覧画面に案内する
	 * 
	 * @return　権限一覧画面
	 */
	public String inputlist() {
		return "inputlist";
	}
	
	/**
	 * 権限を検索する
	 * @return 権限一覧画面
	 */
	public String search() {
		// 一覧を検索する
		setAuthorityList(authorityBusinessLogic.selectAuthorityList(this.getModel().getAuthority()));
		if (getAuthorityList() == null || getAuthorityList().size() == 0) {
			
			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		return "inputlist";
	}
	
	/**
	 * 権限を削除する
	 * @return
	 */
	public String delete() {
		authorityBusinessLogic.deleteAuthorityMst(selectedAuthoritys);
		return "inputlist";
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
	 * @return the masterInfoBusinessLogic
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
	 * @return the authorityBusinessLogic
	 */
	public IAuthorityBusinessLogic getAuthorityBusinessLogic() {
		return authorityBusinessLogic;
	}

	/**
	 * @param authorityBusinessLogic the authorityBusinessLogic to set
	 */
	public void setAuthorityBusinessLogic(
			IAuthorityBusinessLogic authorityBusinessLogic) {
		this.authorityBusinessLogic = authorityBusinessLogic;
	}

	/**
	 * @return the memberLevel
	 */
	public String getMemberLevel() {
		return memberLevel;
	}

	/**
	 * @param memberLevel
	 *            the memberLevel to set
	 */
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}

	/**
	 * @return the inquiryLevel
	 */
	public String getInquiryLevel() {
		return inquiryLevel;
	}

	/**
	 * @param inquiryLevel
	 *            the inquiryLevel to set
	 */
	public void setInquiryLevel(String inquiryLevel) {
		this.inquiryLevel = inquiryLevel;
	}

	/**
	 * @return the inviteLevel
	 */
	public String getInviteLevel() {
		return inviteLevel;
	}

	/**
	 * @param inviteLevel
	 *            the inviteLevel to set
	 */
	public void setInviteLevel(String inviteLevel) {
		this.inviteLevel = inviteLevel;
	}

	/**
	 * @return the campaignLevel
	 */
	public String getCampaignLevel() {
		return campaignLevel;
	}

	/**
	 * @param campaignLevel
	 *            the campaignLevel to set
	 */
	public void setCampaignLevel(String campaignLevel) {
		this.campaignLevel = campaignLevel;
	}

	/**
	 * @return the servicePointLevel
	 */
	public String getServicePointLevel() {
		return servicePointLevel;
	}

	/**
	 * @param servicePointLevel
	 *            the servicePointLevel to set
	 */
	public void setServicePointLevel(String servicePointLevel) {
		this.servicePointLevel = servicePointLevel;
	}

	/**
	 * @return the salesLevel
	 */
	public String getSalesLevel() {
		return salesLevel;
	}

	/**
	 * @param salesLevel
	 *            the salesLevel to set
	 */
	public void setSalesLevel(String salesLevel) {
		this.salesLevel = salesLevel;
	}

	/**
	 * @return the authorityList
	 */
	public List<AuthorityMst> getAuthorityList() {
		return authorityList;
	}

	/**
	 * @param authorityList the authorityList to set
	 */
	public void setAuthorityList(List<AuthorityMst> authorityList) {
		this.authorityList = authorityList;
	}

	/**
	 * @return the selectedAuthoritys
	 */
	public List<String> getSelectedAuthoritys() {
		return selectedAuthoritys;
	}

	/**
	 * @param selectedAuthoritys the selectedAuthoritys to set
	 */
	public void setSelectedAuthoritys(List<String> selectedAuthoritys) {
		this.selectedAuthoritys = selectedAuthoritys;
	}

}
