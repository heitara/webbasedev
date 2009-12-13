package com.gameif.backoffice.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.backoffice.dao.IInviteInfoDao;
import com.gameif.backoffice.dao.IInviteLinkHistDao;
import com.gameif.backoffice.entity.InviteInfo;
import com.gameif.backoffice.entity.InviteLinkHist;
import com.gameif.backoffice.entity.InviteListInfo;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class InviteInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IInviteInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4552302959458757976L;

	private IInviteInfoDao inviteInfoDao;
	private IInviteLinkHistDao inviteLinkHistDao;

	@Override
	public List<InviteListInfo> getInviteLinkList(
			InviteSearchCondition inviteSearchCondition) {
		return inviteLinkHistDao.selectInviteLinkList(inviteSearchCondition);
	}

	@Override
	public List<InviteListInfo> getInviteMailList(
			InviteSearchCondition inviteSearchCondition) {
		return inviteInfoDao.selectInviteMailList(inviteSearchCondition);
	}

	@Transactional
	@Override
	public void updateInviteInfo(List<String> inviteKeyList, String approveStatus) {
		
		InviteInfo inviteInfo = null;
		Date now = new Date();
		
		for (int i = 0; i < inviteKeyList.size(); i++) {
			
			String[] inviteKey = inviteKeyList.get(i).trim().split(",");
			
			inviteInfo = new InviteInfo();
			inviteInfo.setMemNum(Long.parseLong(inviteKey[0]));
			inviteInfo.setChildMemNum(Long.parseLong(inviteKey[1]));
			inviteInfo.setApproveStatus(approveStatus);
			inviteInfo.setLastUpdateUser(ContextUtil.getUserId());
			inviteInfo.setLastUpdateDate(now);
			
			inviteInfoDao.updateApproveStatus(inviteInfo);
			
		}
	}

	@Transactional
	@Override
	public void updateInviteLink(List<String> inviteKeyList, String approveStatus) {
		
		InviteLinkHist inviteLinkHist = null;
		
		for (int i = 0; i < inviteKeyList.size(); i++) {
			
			String[] inviteKey = inviteKeyList.get(i).trim().split(",");
			
			inviteLinkHist = new InviteLinkHist();
			inviteLinkHist.setMemNum(Long.parseLong(inviteKey[0]));
			inviteLinkHist.setChildMemNum(Long.parseLong(inviteKey[1]));
			inviteLinkHist.setApproveStatus(approveStatus);
			
			inviteLinkHistDao.updateApproveStatus(inviteLinkHist);
			
		}
	}

	/**
	 * @param inviteInfoDao
	 *            the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @param inviteLinkHistDao
	 *            the inviteLinkHistDao to set
	 */
	public void setInviteLinkHistDao(IInviteLinkHistDao inviteLinkHistDao) {
		this.inviteLinkHistDao = inviteLinkHistDao;
	}

}
