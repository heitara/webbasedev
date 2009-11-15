package com.gameif.portal.action.titleif;

import java.util.Date;
import java.util.List;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IBetaTesterBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.BetaTester;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.TitleMst;
import com.gameif.portal.util.ContextUtil;

public class BetaTesterControlAction  extends
ModelDrivenActionSupport<BetaTester> {

	private static final long serialVersionUID = 579242178680718814L;
	
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IBetaTesterBusinessLogic betaTesterBusinessLogic;
	
	private List<MyTitle> betaTitleList;
	
	private String status;
		
	/**
	 * 該当登録したユーザをβテスターテーブルに登録する
	 * @return
	 */
	public String apply() {
		
		String result = WARNING;
		
		if (isApplyable()) {			

			getModel().setMemNum(ContextUtil.getMemberNo());
			betaTesterBusinessLogic.saveBetaTester(getModel());
			
			result = SUCCESS;
		}
		
		return result;
	}
	
	public boolean isApplyable() {
		
		boolean applyable = false;
		
		TitleMst titleMst = masterInfoBusinessLogic.getValidTitle(getModel().getTitleId());
		
		if (titleMst != null) {
			
			Date now = new Date();
			
			if (titleMst != null
				&& now.after(titleMst.getServiceStartDate())
				&& now.before(titleMst.getServiceEndDate())
				&& (PortalConstants.ServerStatus.CBT.equals(titleMst.getServiceStatus()) 
					|| PortalConstants.ServerStatus.OBT.equals(titleMst.getServiceStatus()))) {
				
				if (PortalConstants.RecruitStatus.RECRUITING.equals(titleMst.getRecruitStatus())
						|| PortalConstants.RecruitStatus.TEST.equals(titleMst.getRecruitStatus())) {
					
					applyable = true;
				}
			}
		}
		
		return applyable;
	}
	
	public String finishApply() {
		
		return "finish";
	}

	/**
	 * @return the betaTesterBusinessLogic
	 */
	public IBetaTesterBusinessLogic getBetaTesterBusinessLogic() {
		return betaTesterBusinessLogic;
	}

	/**
	 * @param betaTesterBusinessLogic the betaTesterBusinessLogic to set
	 */
	public void setBetaTesterBusinessLogic(
			IBetaTesterBusinessLogic betaTesterBusinessLogic) {
		this.betaTesterBusinessLogic = betaTesterBusinessLogic;
	}
	
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * @return the betaTitleList
	 */
	public List<MyTitle> getBetaTitleList() {
		return betaTitleList;
	}

	/**
	 * @param betaTitleList the betaTitleList to set
	 */
	public void setBetaTitleList(List<MyTitle> betaTitleList) {
		this.betaTitleList = betaTitleList;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

