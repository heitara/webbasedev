package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.InviteInfo;
import com.gameif.backoffice.entity.MyInviteInfo;
import com.gameif.common.dao.IBaseDao;

public interface IInviteInfoDao extends IBaseDao<InviteInfo, InviteInfo> {

	public int updateApproveStatus(InviteInfo inviteInfo);
	public int updateApproveStatusByMemNum(InviteInfo inviteInfo);
	public List<MyInviteInfo> selectInviteHistByMemNum(Long memNum);
	public List<InviteInfo> selectRewardedListForUpdate(Long memNum);
	public Integer updateRewardedStatus(InviteInfo inviteInfo);
}
