package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.entity.CampaignMst;

public interface ICampaignBusinessLogic {

	public void createCampaign(CampaignMst campaignMst);
	public CampaignMst getCampaignById(CampaignMst campaignMst); 
	public void updateCampaign(CampaignMst campaignMst);
	public List<CampaignMst> searchCampaignList(CampaignMst campaignMst);
	public void deleteCampaignList(List<Integer> selectedCampaignList);
}
