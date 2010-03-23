package com.gameif.portal.businesslogic.impl;

import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoForMixiBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IMemberInfoForMixiDao;
import com.gameif.portal.dao.IServerMstDao;
import com.gameif.portal.entity.MemberInfoForMixi;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.util.ContextUtil;
import com.opensymphony.xwork2.ActionContext;

import edu.yale.its.tp.cas.client.filter.CASFilter;

public class MemberInfoForMixiBusinessLogicImpl extends BaseBusinessLogic implements IMemberInfoForMixiBusinessLogic {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1660920329138052444L;
	
	private IServerMstDao serverMstDao;
	private IMemberInfoForMixiDao memberInfoForMixiDao;

	/**
	 * mixi用すべてサーバを取得する
	 */
	@Override
	public List<ServerMst> getServersListForMixi(Integer titleId) {
		
		return serverMstDao.selectServersListForMixi(titleId);
	}

	/**
	 * 会員情報が存在したら更新する、存在しない場合、登録する
	 */
	@Override
	@Transactional
	public String checkMemberinfoForMixi(MemberInfoForMixi memberForMixi) {
		Date now = new Date();
		String memAtbtCd;
		
		MemberInfoForMixi oldMember = memberInfoForMixiDao.selectForUpdateByMemId(memberForMixi.getMemId());
		if (oldMember == null) {
			oldMember = new MemberInfoForMixi();
			
			oldMember.setMemId(memberForMixi.getMemId());
			oldMember.setMemAtbtCd(PortalConstants.MemberAtbtCd.NORMAL);
			oldMember.setMemValidYNCd(PortalConstants.MemberValidYNCd.VALID);
			oldMember.setNickName(memberForMixi.getNickName());
			oldMember.setAddress(memberForMixi.getAddress());
			oldMember.setAge(memberForMixi.getAge());
			oldMember.setBirthYmd(memberForMixi.getBirthYmd());
			oldMember.setSexCd(memberForMixi.getSexCd());
			oldMember.setBloodType(memberForMixi.getBloodType());
			oldMember.setEntryDate(now);
			oldMember.setEntryIp(ContextUtil.getClientIP());
			oldMember.setLoginDate(now);
			oldMember.setLoginIp(ContextUtil.getClientIP());
			oldMember.setLastUpdateDate(now);
			oldMember.setLastUpdateIp(ContextUtil.getClientIP());
			
			memberInfoForMixiDao.save(oldMember);
			
			memAtbtCd = oldMember.getMemAtbtCd();
		} else {
			
			oldMember.setNickName(memberForMixi.getNickName());
			oldMember.setAddress(memberForMixi.getAddress());
			oldMember.setAge(memberForMixi.getAge());
			oldMember.setBirthYmd(memberForMixi.getBirthYmd());
			oldMember.setSexCd(memberForMixi.getSexCd());
			oldMember.setBloodType(memberForMixi.getBloodType());
			oldMember.setLoginDate(now);
			oldMember.setLoginIp(ContextUtil.getClientIP());
			oldMember.setLastUpdateDate(now);
			oldMember.setLastUpdateIp(ContextUtil.getClientIP());
			
			memberInfoForMixiDao.update(oldMember);
			
			memAtbtCd = oldMember.getMemAtbtCd();
		}
		
		String sessionInfo = oldMember.getMemNum().toString().concat(",")
							 .concat(oldMember.getMemId()).concat(",")
							 .concat(oldMember.getNickName());
		
		ActionContext.getContext().getSession().put(CASFilter.CAS_FILTER_USER, sessionInfo);
		
		return memAtbtCd;
	}

	/**
	 * 会員情報が存在するかどうかのチェック
	 */
	@Override
	public Boolean checkIsExistForMixi(Long memNum) {
		Boolean bReturn = false;
		MemberInfoForMixi member = new MemberInfoForMixi();
		member.setMemNum(memNum);
		member = memberInfoForMixiDao.selectByKey(member);
		if (member == null) {
			return bReturn;
		}
		
		String sessionInfo = member.getMemNum().toString().concat(",")
							 .concat(member.getMemId()).concat(",")
							 .concat(member.getNickName());
		
		ActionContext.getContext().getSession().put(CASFilter.CAS_FILTER_USER, sessionInfo);
		
		bReturn = true;
		return bReturn;
	}

	/**
	 * @param serverMstDao the serverMstDao to set
	 */
	public void setServerMstDao(IServerMstDao serverMstDao) {
		this.serverMstDao = serverMstDao;
	}

	/**
	 * @param memberInfoForMixiDao the memberInfoForMixiDao to set
	 */
	public void setMemberInfoForMixiDao(IMemberInfoForMixiDao memberInfoForMixiDao) {
		this.memberInfoForMixiDao = memberInfoForMixiDao;
	}

}
