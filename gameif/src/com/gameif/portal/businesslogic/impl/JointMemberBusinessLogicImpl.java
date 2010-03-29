package com.gameif.portal.businesslogic.impl;

import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IJointMemberBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IJointMemberDao;
import com.gameif.portal.entity.JointMember;
import com.gameif.portal.util.ContextUtil;

public class JointMemberBusinessLogicImpl extends BaseBusinessLogic implements IJointMemberBusinessLogic {
	
	private static final long serialVersionUID = 1660920329138052444L;
	
	private IJointMemberDao jointMemberDao;

	@Override
	public JointMember getMemberInfo(Long memNum) {
		
		JointMember member = new JointMember();
		member.setMemNum(memNum);
		
		return jointMemberDao.selectByKey(member);
	}

	@Override
	public JointMember getMemberByMemIdAndProviderId(String memId, String providerId) {
		
		return jointMemberDao.selectByMemIdAndProviderId(memId, providerId);
	}

	@Override
	@Transactional
	public JointMember createMemberInfo(JointMember memberInfo) {

		memberInfo.setMemAtbtCd(PortalConstants.MemberAtbtCd.NORMAL);
		memberInfo.setMemValidYNCd(PortalConstants.MemberValidYNCd.VALID);
		memberInfo.setEntryDate(new Date());
		memberInfo.setEntryIp(ContextUtil.getClientIP());
		
		jointMemberDao.save(memberInfo);
		
		return memberInfo;
	}

	/**
	 * 会員情報が存在する場合更新、存在しない場合は登録
	 */
	@Override
	@Transactional
	public JointMember saveMemberInfo(JointMember memberInfo) {
				
		JointMember oldMember = jointMemberDao.selectForUpdateByMemIdAndProviderId(memberInfo.getMemId(), memberInfo.getProviderId());
		
		if (oldMember == null) {

			return createMemberInfo(memberInfo);
			
		} else {

			memberInfo.setMemNum(oldMember.getMemNum());
			
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
				oldMember.setLastUpdateDate(new Date());
				oldMember.setLastUpdateIp(ContextUtil.getClientIP());
				oldMember.setLastUpdateUser(String.valueOf(memberInfo.getMemNum()));
				
				jointMemberDao.update(oldMember);
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

	public void setJointMemberDao(IJointMemberDao jointMemberDao) {
		this.jointMemberDao = jointMemberDao;
	}
}
