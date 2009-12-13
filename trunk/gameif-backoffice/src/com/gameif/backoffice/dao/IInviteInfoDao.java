package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.entity.InviteInfo;
import com.gameif.backoffice.entity.InviteListInfo;
import com.gameif.common.dao.IBaseDao;

public interface IInviteInfoDao extends IBaseDao<InviteInfo, InviteInfo> {

	public List<InviteListInfo> selectInviteMailList(InviteSearchCondition inviteSearchCondition);
	public int updateApproveStatus(InviteInfo inviteInfo);
}
