package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.dao.IInviteInfoDao;
import com.gameif.backoffice.entity.InviteInfo;
import com.gameif.backoffice.entity.InviteListInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class InviteInfoDaoImpl extends AbstractBaseDao<InviteInfo, InviteInfo> implements IInviteInfoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<InviteListInfo> selectInviteMailList(InviteSearchCondition inviteSearchCondition) {
		return getSqlMapClientTemplate().queryForList(namespace + ".selectInviteMailList", inviteSearchCondition);
	}

	@Override
	public int updateApproveStatus(InviteInfo inviteInfo) {

		return getSqlMapClientTemplate().update(namespace + ".updateApproveStatus", inviteInfo);
	}

}
