package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IOpensocialMemberDao;
import com.gameif.portal.entity.OpensocialMember;
import com.gameif.portal.util.ContextUtil;

public class OpensocialMemberBusinessLogicImpl extends BaseBusinessLogic implements IOpensocialMemberBusinessLogic {
	
	private static final long serialVersionUID = 1660920329138052444L;
	
	private IOpensocialMemberDao opensocialMemberDao;

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

	public void setOpensocialMemberDao(IOpensocialMemberDao opensocialMemberDao) {
		
		this.opensocialMemberDao = opensocialMemberDao;
	}
}
