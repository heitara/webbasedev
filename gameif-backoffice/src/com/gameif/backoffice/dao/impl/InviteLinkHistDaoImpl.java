package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.dao.IInviteLinkHistDao;
import com.gameif.backoffice.entity.InviteLinkHist;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.MyInviteInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class InviteLinkHistDaoImpl extends AbstractBaseDao<InviteLinkHist, InviteLinkHist> implements IInviteLinkHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<MemberInfo> selectInviteList(InviteSearchCondition inviteSearchCondition) {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectInviteList", inviteSearchCondition);
	}

	@Override
	public int updateApproveStatus(InviteLinkHist inviteLinkHist) {
		return getSqlMapClientTemplate().update(namespace + ".updateApproveStatus", inviteLinkHist);
	}

	/**
	 * 会員番号より、該当会員がリンクで招待した友達を検索する
	 * @param memNum 会員番号
	 * @return 友達リスト
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MyInviteInfo> selectLinkMembersByMemNum(Long memNum) {
		return (List<MyInviteInfo>) (getSqlMapClientTemplate().queryForList(namespace + ".selectLinkMembersByMemNum", memNum));
	}

	@Override
	public int updateApproveStatusByMemNum(InviteLinkHist inviteLinkHist) {
		return getSqlMapClientTemplate().update(namespace + ".updateApproveStatusByMemNum", inviteLinkHist);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<InviteLinkHist> selectRewardedListForUpdate(Long memNum) {
		return (List<InviteLinkHist>) (getSqlMapClientTemplate().queryForList(namespace + ".selectRewardedListForUpdate", memNum));
	}

	@Override
	public Integer updateRewardedStatus(Long memNum) {
		return getSqlMapClientTemplate().update(namespace + ".updateRewardedStatus", memNum);
	}

}
