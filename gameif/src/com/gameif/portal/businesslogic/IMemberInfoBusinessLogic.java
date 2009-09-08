package com.gameif.portal.businesslogic;

import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoBusinessLogic {

	public void saveMemberInfo(MemberInfo memberInfo);

	public int changePwd(MemberInfo memberInfo);

	public int updateMemberInfo(MemberInfo memberInfo);

	public MemberInfo showDetail(MemberInfo memberInfo);
	
	public int countMembersByIPInTime(String clientIp, int checkTime);
}
