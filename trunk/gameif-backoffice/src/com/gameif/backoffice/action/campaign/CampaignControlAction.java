package com.gameif.backoffice.action.campaign;

import java.util.List;

import com.gameif.backoffice.businesslogic.ICampaignBusinessLogic;
import com.gameif.backoffice.entity.CampaignMst;
import com.gameif.common.action.ModelDrivenActionSupport;

public class CampaignControlAction extends ModelDrivenActionSupport<CampaignMst> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5366737457928438017L;

	private ICampaignBusinessLogic campaignBusinessLogic;

	private List<CampaignMst> campaignList;
	private List<Integer> selectedCampaignList;

	public String inputList() {
		return "inputList";
	}

	public String search() {
		setCampaignList(campaignBusinessLogic.searchCampaignList(this.getModel()));
		if (getCampaignList() == null || getCampaignList().size() == 0) {
			addFieldError("errMessage", getText("common.dataNotExist"));
		}
		return "inputList";
	}

	public String inputAdd() {
		return "inputAdd";
	}

	public String create() {
		campaignBusinessLogic.createCampaign(this.getModel());
		addFieldError("errMessage", getText("common.saveSuccess"));
		return "inputAdd";
	}

	public String inputEdit() {
		this.setModel(campaignBusinessLogic.getCampaignById(this.getModel()));
		return "inputEdit";
	}

	public String update() {
		campaignBusinessLogic.updateCampaign(this.getModel());
		return "inputEdit";
	}
	
	public String delete() {
		campaignBusinessLogic.deleteCampaignList(getSelectedCampaignList());
		return "inputList";
	}

	/**
	 * @return the campaignBusinessLogic
	 */
	public ICampaignBusinessLogic getCampaignBusinessLogic() {
		return campaignBusinessLogic;
	}

	/**
	 * @param campaignBusinessLogic
	 *            the campaignBusinessLogic to set
	 */
	public void setCampaignBusinessLogic(
			ICampaignBusinessLogic campaignBusinessLogic) {
		this.campaignBusinessLogic = campaignBusinessLogic;
	}

	/**
	 * @return the campaignList
	 */
	public List<CampaignMst> getCampaignList() {
		return campaignList;
	}

	/**
	 * @param campaignList
	 *            the campaignList to set
	 */
	public void setCampaignList(List<CampaignMst> campaignList) {
		this.campaignList = campaignList;
	}

	/**
	 * @return the selectedCampaignList
	 */
	public List<Integer> getSelectedCampaignList() {
		return selectedCampaignList;
	}

	/**
	 * @param selectedCampaignList the selectedCampaignList to set
	 */
	public void setSelectedCampaignList(List<Integer> selectedCampaignList) {
		this.selectedCampaignList = selectedCampaignList;
	}

}
