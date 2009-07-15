package com.gameif.portal.businesslogic.login;

import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoBusinessLogic {

	public MemberInfo checkLoginInfo(MemberInfo ui);
	
	public void saveMemberInfo(MemberInfo memberInfo);
	
	public int changePwd(MemberInfo member);
}
