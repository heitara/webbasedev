package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.MyInviteInfo;


public interface IInviteInfoBusinessLogic {
	public List<MemberInfo> getInviteList(InviteSearchCondition inviteSearchCondition);
	
	public void updateInviteInfo(List<Long> inviteKeyList, String approveStatus);
	
	public List<MyInviteInfo> selectLinkMembersByMemNum(Long memNum);
	
	public List<MyInviteInfo> selectInviteHistByMemNum(Long memNum);
	
	public void updateInviteInfoWithMemNum(List<Long> inviteInfoList, List<Long> inviteLinkList, String approveStatus, Long memNum);
	
	public void giveTicket(List<Long> inviteKeyList);
	
}
