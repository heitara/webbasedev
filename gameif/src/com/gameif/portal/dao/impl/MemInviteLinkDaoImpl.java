package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemInviteLinkDao;
import com.gameif.portal.entity.MemInviteLink;

public class MemInviteLinkDaoImpl extends
		AbstractBaseDao<MemInviteLink, MemInviteLink> implements
		IMemInviteLinkDao {

	/**
	 * 会員番号より、会員招待リンク情報を取得する
	 * 
	 * @param memNum
	 *            会員番号
	 */
	@Override
	public MemInviteLink selectByMemNum(Long memNum) {
		return (MemInviteLink) getSqlMapClientTemplate().queryForObject(namespace + ".selectByMemNum", memNum);
	}

	@Override
	public MemInviteLink selectByLinkKey(String linkKey) {
		
		return (MemInviteLink) this.getSqlMapClientTemplate().queryForObject(namespace + ".selectByLinkKey", linkKey);
	}

}
