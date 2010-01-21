package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.entity.InviteLinkHist;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.MyInviteInfo;
import com.gameif.common.dao.IBaseDao;

public interface IInviteLinkHistDao extends IBaseDao<InviteLinkHist, InviteLinkHist> {
	public List<MemberInfo> selectInviteList(InviteSearchCondition inviteSearchCondition);
	public int updateApproveStatus(InviteLinkHist inviteLinkHist);
	public int updateApproveStatusByMemNum(InviteLinkHist inviteLinkHist);
	public List<MyInviteInfo> selectLinkMembersByMemNum(Long memNum);
	public List<InviteLinkHist> selectRewardedListForUpdate(Long memNum);
	public Integer updateRewardedStatus(Long memNum);
}
