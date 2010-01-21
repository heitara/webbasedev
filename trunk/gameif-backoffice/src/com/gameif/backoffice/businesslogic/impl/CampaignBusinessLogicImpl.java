package com.gameif.backoffice.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.businesslogic.ICampaignBusinessLogic;
import com.gameif.backoffice.dao.ICampaignMstDao;
import com.gameif.backoffice.entity.CampaignMst;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class CampaignBusinessLogicImpl extends BaseBusinessLogic implements ICampaignBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8124369116145465481L;
	
	private ICampaignMstDao campaignMstDao;

	@Transactional
	@Override
	public void createCampaign(CampaignMst campaignMst) {
		
		Date now = new Date();
		
		campaignMst.setCreatedDate(now);
		campaignMst.setCreatedUser(ContextUtil.getUserId());
		campaignMst.setLastUpdateDate(now);
		campaignMst.setLastUpdateUser(ContextUtil.getUserId());
		
		campaignMstDao.save(campaignMst);
	}

	@Override
	public CampaignMst getCampaignById(CampaignMst campaignMst) {
		return campaignMstDao.selectByKey(campaignMst);
	}

	@Transactional
	@Override
	public void updateCampaign(CampaignMst campaignMst) {
		CampaignMst oldCampaign = campaignMstDao.selectForUpdate(campaignMst.getCampaignId());
		
		oldCampaign.setCampaignSubject(campaignMst.getCampaignSubject());
		oldCampaign.setCampaignContents(campaignMst.getCampaignContents());
		oldCampaign.setTitleId(campaignMst.getTitleId());
		oldCampaign.setCampaignStartDate(campaignMst.getCampaignStartDate());
		oldCampaign.setCampaignEndDate(campaignMst.getCampaignEndDate());
		oldCampaign.setLastUpdateDate(new Date());
		oldCampaign.setLastUpdateUser(ContextUtil.getUserId());
		
		campaignMstDao.update(oldCampaign);
	}

	@Override
	public List<CampaignMst> searchCampaignList(CampaignMst campaignMst) {
		return campaignMstDao.selectCampaignList(campaignMst);
	}

	@Transactional
	@Override
	public void deleteCampaignList(List<Integer> selectedCampaignList) {
		campaignMstDao.deleteCampaignList(selectedCampaignList);
	}

	/**
	 * @param campaignMstDao the campaignMstDao to set
	 */
	public void setCampaignMstDao(ICampaignMstDao campaignMstDao) {
		this.campaignMstDao = campaignMstDao;
	}

}
