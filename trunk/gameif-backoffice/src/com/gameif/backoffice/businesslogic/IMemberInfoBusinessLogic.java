package com.gameif.backoffice.businesslogic;

import com.gameif.backoffice.entity.MemberInfo;

public interface IMemberInfoBusinessLogic {
	public MemberInfo getMemberInfoByMemNum(Long memNum);
	public void freezeMemberInfo(String memId);
}
