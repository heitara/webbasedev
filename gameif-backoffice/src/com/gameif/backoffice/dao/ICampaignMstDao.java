package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.CampaignMst;
import com.gameif.common.dao.IBaseDao;

public interface ICampaignMstDao extends IBaseDao<CampaignMst, CampaignMst> {

	public List<CampaignMst> selectCampaignList(CampaignMst campaignMst);
	public Integer deleteCampaignList(List<Integer> selectedCampaignList);
	public CampaignMst selectForUpdate(Integer campaignId);
}
