package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IInviteLinkDao;
import com.gameif.portal.entity.InviteLink;

public class InviteLinkDaoImpl extends AbstractBaseDao<InviteLink, InviteLink>
		implements IInviteLinkDao {

	/**
	 * 会員番号より、会員招待リンク情報を取得する
	 * 
	 * @param memNum
	 *            会員番号
	 */
	@Override
	public InviteLink selectByMemNum(Long memNum) {
		return (InviteLink) getSqlMapClientTemplate().queryForObject(
				namespace + ".selectByMemNum", memNum);
	}

	@Override
	public InviteLink selectByLinkKey(String linkKey) {

		return (InviteLink) this.getSqlMapClientTemplate().queryForObject(
				namespace + ".selectByLinkKey", linkKey);
	}

}
