package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.InviteLink;

public interface IInviteLinkDao extends IBaseDao<InviteLink, InviteLink> {
	
	public InviteLink selectByMemNum(Long memNum);
	public InviteLink selectByLinkKey(String linkKey);
	
}
