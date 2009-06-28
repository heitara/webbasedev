package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoBusinessLogic {

	public MemberInfo checkLoginInfo(MemberInfo ui);
	
	public void saveMemberInfo(MemberInfo memberInfo);
}
