package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.entity.InviteLinkHist;
import com.gameif.backoffice.entity.InviteListInfo;
import com.gameif.common.dao.IBaseDao;

public interface IInviteLinkHistDao extends IBaseDao<InviteLinkHist, InviteLinkHist> {
	public List<InviteListInfo> selectInviteLinkList(InviteSearchCondition inviteSearchCondition);
	public int updateApproveStatus(InviteLinkHist inviteLinkHist);
}
