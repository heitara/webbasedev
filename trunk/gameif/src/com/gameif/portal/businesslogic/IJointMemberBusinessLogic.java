package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.JointMember;

public interface IJointMemberBusinessLogic {

	public JointMember getMemberInfo(Long memNum);
	public JointMember getMemberByMemIdAndProviderId(String memId, String providerId);
	public JointMember createMemberInfo(JointMember memberInfo);
	public JointMember saveMemberInfo(JointMember memberInfo);
}
