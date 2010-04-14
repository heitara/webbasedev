package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.OpensocialMember;

public interface IOpensocialMemberBusinessLogic {

	public OpensocialMember getMemberInfo(Long memNum);
	public OpensocialMember getMemberByMemIdAndProviderId(String memId, String providerId);
	public OpensocialMember saveMemberInfo(OpensocialMember memberInfo);
	public Long getLastInviteMemNumWithUpdate(String friendId, String providerId, Integer titleId, Integer serverId);
	public void inviteFriends(String[] friendIds, Long memNum, String providerId,Integer titleId, Integer serverId);
}
