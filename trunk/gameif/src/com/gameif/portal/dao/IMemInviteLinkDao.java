package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemInviteLink;

public interface IMemInviteLinkDao extends IBaseDao<MemInviteLink, MemInviteLink> {
	
	public MemInviteLink selectByMemNum(Long memNum);
	public MemInviteLink selectByLinkKey(String linkKey);

}
