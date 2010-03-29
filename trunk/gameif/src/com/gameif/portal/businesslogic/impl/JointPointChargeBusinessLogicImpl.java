package com.gameif.portal.businesslogic.impl;

import com.gameif.common.exception.SystemException;
import com.gameif.portal.businesslogic.IJointPointChargeBusinessLogic;
import com.gameif.portal.dao.IJointMemberDao;
import com.gameif.portal.dao.IJointPlayHistDao;
import com.gameif.portal.dao.IJointSettlementHistDao;
import com.gameif.portal.entity.MemSettlementHist;
import com.gameif.portal.entity.MemSettlementTrns;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.JointMember;
import com.gameif.portal.entity.JointSettlementHist;
import com.gameif.portal.entity.ServerMst;

public class JointPointChargeBusinessLogicImpl extends PointChargeBusinessLogicImpl implements IJointPointChargeBusinessLogic {

	private static final long serialVersionUID = 5064320624553235706L;
		
	private IJointMemberDao jointMemberDao;
	private IJointSettlementHistDao jointSettlementHistDao;
	private IJointPlayHistDao jointPlayHistDao;
	
	@Override
	protected MemberInfo getMemberInfoForUpdate(Long memNum) {

		MemberInfo memberInfo = jointMemberDao.selectForUpdate(memNum);
		
		if (memberInfo == null) {

			// データが存在しない
			throw new SystemException("Data not exists.");
		}
		
		return memberInfo;
	}

	@Override
	protected MemberInfo getMemberInfo(Long memNum) {
		
		JointMember member = new JointMember();
		member.setMemNum(memNum);
		return jointMemberDao.selectByKey(member);
	}

	@Override
	protected void updateMemberInfo(MemberInfo member) {
				
		jointMemberDao.update((JointMember)member);
	}

	@Override
	protected void setSettlementTrnsToHist(MemSettlementHist settlementHist, MemSettlementTrns settleTrns, MemberInfo member) {

		super.setSettlementTrnsToHist(settlementHist, settleTrns, member);
		((JointSettlementHist)settlementHist).setProviderId(settleTrns.getProviderId());
	}

	@Override
	protected void saveSettlementHist(MemSettlementHist settlementHist) {
		
		jointSettlementHistDao.save((JointSettlementHist)settlementHist);
	}

	@Override
	protected void presentServicePoint(MemSettlementHist settlementHist, MemberInfo member) {
		
	}

	@Override
	protected void sendChargeMail(MemSettlementHist settlementHist, MemberInfo member, ServerMst server) {
		
	}
	
	/**
	 * 会員番号とタイトルIDより、ゲームのプレイ回数を取得する
	 * @param memNum 会員番号
	 * @param titleId タイトルID
	 * @return プレイ回数
	 */
	@Override
	public Integer countPlayHist(Long memNum, Integer titleId, Integer serverId) {
		
		return jointPlayHistDao.selectPlayHistCount(memNum, titleId, serverId);
	}

	public void setJointMemberDao(IJointMemberDao jointMemberDao) {
		this.jointMemberDao = jointMemberDao;
	}

	public void setJointSettlementHistDao(
			IJointSettlementHistDao jointSettlementHistDao) {
		this.jointSettlementHistDao = jointSettlementHistDao;
	}

	public void setJointPlayHistDao(IJointPlayHistDao jointPlayHistDao) {
		this.jointPlayHistDao = jointPlayHistDao;
	}
}
