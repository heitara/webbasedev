package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.IInviteInfoDao;
import com.gameif.backoffice.entity.InviteInfo;
import com.gameif.backoffice.entity.MyInviteInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class InviteInfoDaoImpl extends AbstractBaseDao<InviteInfo, InviteInfo> implements IInviteInfoDao {
	
	@Override
	public int updateApproveStatus(InviteInfo inviteInfo) {

		return getSqlMapClientTemplate().update(namespace + ".updateApproveStatus", inviteInfo);
	}
	/**
	 * 紹介者IDより、友達紹介履歴を取得する。
	 * 
	 * @param memNum
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MyInviteInfo> selectInviteHistByMemNum(Long memNum) {
		return (List<MyInviteInfo>) getSqlMapClientTemplate().queryForList(namespace + ".selectInviteHistByMemNum", memNum);
	}
	
	@Override
	public int updateApproveStatusByMemNum(InviteInfo inviteInfo) {
		return getSqlMapClientTemplate().update(namespace + ".updateApproveStatusByMemNum", inviteInfo);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InviteInfo> selectRewardedListForUpdate(Long memNum) {
		return (List<InviteInfo>) getSqlMapClientTemplate().queryForList(namespace + ".selectRewardedListForUpdate", memNum);
	}
	
	@Override
	public Integer updateRewardedStatus(InviteInfo inviteInfo) {
		return getSqlMapClientTemplate().update(namespace + ".updateRewardedStatus", inviteInfo);
	}

}
