package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.entity.InviteListInfo;


public interface IInviteInfoBusinessLogic {

	public List<InviteListInfo> getInviteMailList(InviteSearchCondition inviteSearchCondition);
	
	public List<InviteListInfo> getInviteLinkList(InviteSearchCondition inviteSearchCondition);
	
	public void updateInviteInfo(List<String> inviteKeyList, String approveStatus);
	
	public void updateInviteLink(List<String> inviteKeyList, String approveStatus);
	
}
