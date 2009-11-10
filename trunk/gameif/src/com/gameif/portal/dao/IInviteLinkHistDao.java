package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.InviteLinkHist;

public interface IInviteLinkHistDao extends IBaseDao<InviteLinkHist, InviteLinkHist> {
	
	public InviteLinkHist selectParentByChildNum(Long childMemNum);

}
