package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IInviteLinkHistDao;
import com.gameif.portal.entity.InviteLinkHist;

public class InviteLinkHistDaoImpl extends AbstractBaseDao<InviteLinkHist, InviteLinkHist> implements IInviteLinkHistDao {

	/**
	 * 子の会員番号より、招待情報を検索する
	 * @param childMemNum 子の会員番号
	 */
	@Override
	public InviteLinkHist selectParentByChildNum(Long childMemNum) {

		return (InviteLinkHist) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectParentByChildNum", childMemNum));
	}

}
