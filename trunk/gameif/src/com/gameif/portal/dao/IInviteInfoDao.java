package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.InviteInfo;

public interface IInviteInfoDao extends IBaseDao<InviteInfo, InviteInfo> {
	
	public List<InviteInfo> selectInviteHistByMemNum(Long memNum);
	public int deleteInvalidInvite(Long memNum, int days);

}
