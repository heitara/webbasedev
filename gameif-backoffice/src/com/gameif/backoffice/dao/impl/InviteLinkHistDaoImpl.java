package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.dao.IInviteLinkHistDao;
import com.gameif.backoffice.entity.InviteLinkHist;
import com.gameif.backoffice.entity.InviteListInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class InviteLinkHistDaoImpl extends AbstractBaseDao<InviteLinkHist, InviteLinkHist> implements IInviteLinkHistDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<InviteListInfo> selectInviteLinkList(InviteSearchCondition inviteSearchCondition) {
		return this.getSqlMapClientTemplate().queryForList(namespace + ".selectInviteLinkList", inviteSearchCondition);
	}

	@Override
	public int updateApproveStatus(InviteLinkHist inviteLinkHist) {
		return getSqlMapClientTemplate().update(namespace + ".updateApproveStatus", inviteLinkHist);
	}

}
