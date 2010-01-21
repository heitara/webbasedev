package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.ICampaignMstDao;
import com.gameif.backoffice.entity.CampaignMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class CampaignMstDaoImpl extends AbstractBaseDao<CampaignMst, CampaignMst> implements ICampaignMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CampaignMst> selectCampaignList(CampaignMst campaignMst) {

		return (List<CampaignMst>) (getSqlMapClientTemplate().queryForList(namespace + ".selectCampaignList", campaignMst));
	}

	@Override
	public Integer deleteCampaignList(List<Integer> selectedCampaignList) {
		return getSqlMapClientTemplate().delete(namespace + ".deleteCampaignList", selectedCampaignList);
	}

	@Override
	public CampaignMst selectForUpdate(Integer campaignId) {
		return (CampaignMst) (getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", campaignId));
	}

}
