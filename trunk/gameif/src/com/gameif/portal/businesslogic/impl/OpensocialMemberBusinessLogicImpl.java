package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IOpensocialInviteDao;
import com.gameif.portal.dao.IOpensocialMemberDao;
import com.gameif.portal.dao.IOpensocialPlaySummaryDao;
import com.gameif.portal.entity.OpensocialInvite;
import com.gameif.portal.entity.OpensocialMember;
import com.gameif.portal.entity.OpensocialPlaySummary;
import com.gameif.portal.util.ContextUtil;

public class OpensocialMemberBusinessLogicImpl extends BaseBusinessLogic implements IOpensocialMemberBusinessLogic {
	
	private static final long serialVersionUID = 1660920329138052444L;
	
	private IOpensocialMemberDao opensocialMemberDao;
	private IOpensocialInviteDao opensocialInviteDao;
	private IOpensocialPlaySummaryDao opensocialPlaySummaryDao;

	@Override
	public OpensocialMember getMemberInfo(Long memNum) {
		
		OpensocialMember member = new OpensocialMember();
		member.setMemNum(memNum);
		
		return opensocialMemberDao.selectByKey(member);
	}

	@Override
	public OpensocialMember getMemberByMemIdAndProviderId(String memId, String providerId) {
		
		return opensocialMemberDao.selectByMemIdAndProviderId(memId, providerId);
	}

	/**
	 * 会員情報が存在する場合更新、存在しない場合は登録
	 */
	@Override
	@Transactional
	public OpensocialMember saveMemberInfo(OpensocialMember memberInfo) {
		
		Date playDate = new Date();
		
		OpensocialMember oldMember = opensocialMemberDao.selectForUpdateByMemIdAndProviderId(memberInfo.getMemId(), memberInfo.getProviderId());
		
		if (oldMember == null) {

			memberInfo.setMemAtbtCd(PortalConstants.MemberAtbtCd.NORMAL);
			memberInfo.setMemValidYNCd(PortalConstants.MemberValidYNCd.VALID);
			memberInfo.setEntryDate(playDate);
			memberInfo.setEntryIp(ContextUtil.getClientIP());
			
			opensocialMemberDao.save(memberInfo);
			
			return memberInfo;
			
		} else {
			
			if(!isEquals(memberInfo.getNickName(), oldMember.getNickName())
					|| !isEquals(memberInfo.getMailPc(), oldMember.getMailPc())
					|| !isEquals(memberInfo.getMailMobile(), oldMember.getMailMobile())
					|| !isEquals(memberInfo.getKanjiFname(), oldMember.getKanjiFname())
					|| !isEquals(memberInfo.getKanjiLname(), oldMember.getKanjiLname())
					|| !isEquals(memberInfo.getKanaFname(), oldMember.getKanaFname())
					|| !isEquals(memberInfo.getKanaLname(), oldMember.getKanaLname())
					|| !isEquals(memberInfo.getSexCd(), oldMember.getSexCd())
					|| !isEquals(memberInfo.getBirthYmd(), oldMember.getBirthYmd())
					|| !isEquals(memberInfo.getAddress(), oldMember.getAddress())
				) {

				oldMember.setNickName(memberInfo.getNickName());
				oldMember.setMailPc(memberInfo.getMailPc());
				oldMember.setMailMobile(memberInfo.getMailMobile());
				oldMember.setKanjiFname(memberInfo.getKanjiFname());
				oldMember.setKanjiLname(memberInfo.getKanjiLname());
				oldMember.setKanaFname(memberInfo.getKanaFname());
				oldMember.setKanaLname(memberInfo.getKanaLname());
				oldMember.setSexCd(memberInfo.getSexCd());
				oldMember.setBirthYmd(memberInfo.getBirthYmd());
				oldMember.setAddress(memberInfo.getAddress());
				oldMember.setLastUpdateDate(playDate);
				oldMember.setLastUpdateIp(ContextUtil.getClientIP());
				oldMember.setLastUpdateUser(String.valueOf(memberInfo.getMemNum()));
				
				opensocialMemberDao.update(oldMember);
			}
			
			return oldMember;
		}
	}
	
	private Boolean isEquals(Object a, Object b) {
		
		boolean isEquals = false;
		
		if ((a == null && b == null) || (a != null && a.equals(b))) {
			
			isEquals = true;
		}
		
		return isEquals;
	}

	@Override
	@Transactional
	public void inviteFriends(String[] friendIds, Long memNum, String providerId, Integer titleId, Integer serverId) {
		
		OpensocialPlaySummary playSummaryCond = new OpensocialPlaySummary();
		
		playSummaryCond.setMemNum(memNum);
		playSummaryCond.setTitleId(titleId);
		
		List<OpensocialPlaySummary> playSummaries = opensocialPlaySummaryDao.selectByMemNumAndTitleId(playSummaryCond);
		
		for (OpensocialPlaySummary playSummary : playSummaries) {
			
			for (String friendId : friendIds) {
				
				OpensocialInvite invite = new OpensocialInvite();
				
				invite.setMemNum(memNum);
				invite.setFriendId(friendId);
				invite.setProviderId(providerId);
				invite.setTitleId(playSummary.getTitleId());
				invite.setServerId(playSummary.getServerId());
				
				OpensocialInvite inviteFromDB = opensocialInviteDao.selectMyInviteForUpdate(invite);
				
				if (inviteFromDB == null) {
					
					invite.setInviteStatus(PortalConstants.InviteStatus.NO_RESPONSE);
					invite.setInviteDate(new Date());
					invite.setCreatedDate(invite.getInviteDate());
					invite.setCreatedUser(String.valueOf(memNum));
					
					opensocialInviteDao.save(invite);
					
				} else {
					
					inviteFromDB.setInviteDate(new Date());
					inviteFromDB.setLastUpdateDate(invite.getInviteDate());
					inviteFromDB.setLastUpdateUser(String.valueOf(memNum));
					
					opensocialInviteDao.update(inviteFromDB);
				}
			}
		}
	}

	@Override
	@Transactional
	public Long getLastInviteMemNumWithUpdate(String friendId, String providerId, Integer titleId, Integer serverId) {
		
		Long inviteMemNum = null;
		
		OpensocialInvite invite = new OpensocialInvite();
		
		invite.setFriendId(friendId);
		invite.setProviderId(providerId);
		invite.setTitleId(titleId);
		invite.setServerId(serverId);
		
		OpensocialInvite inviteFromDB = opensocialInviteDao.selectLastInviteBeforePlayForUpdate(invite);
		
		if (inviteFromDB != null) {
			
			inviteFromDB.setInviteStatus(PortalConstants.InviteStatus.REGISTERED);
			inviteFromDB.setFriendEntryDate(new Date());
			inviteFromDB.setLastUpdateDate(inviteFromDB.getFriendEntryDate());
			inviteFromDB.setLastUpdateUser(String.valueOf(ContextUtil.getExternalMemberNo()));
			
			opensocialInviteDao.update(inviteFromDB);
			
			inviteMemNum = inviteFromDB.getMemNum();
			
		} else {
			
			inviteMemNum = Long.valueOf(0);
		}
		
		return inviteMemNum;
	}

	public void setOpensocialMemberDao(IOpensocialMemberDao opensocialMemberDao) {
		
		this.opensocialMemberDao = opensocialMemberDao;
	}

	public void setOpensocialInviteDao(IOpensocialInviteDao opensocialInviteDao) {
		this.opensocialInviteDao = opensocialInviteDao;
	}

	public void setOpensocialPlaySummaryDao(
			IOpensocialPlaySummaryDao opensocialPlaySummaryDao) {
		this.opensocialPlaySummaryDao = opensocialPlaySummaryDao;
	}
}
