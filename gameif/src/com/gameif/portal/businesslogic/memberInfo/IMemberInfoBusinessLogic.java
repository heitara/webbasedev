package com.gameif.portal.businesslogic.memberInfo;

import com.gameif.portal.entity.memberInfo.MemberInfo;

public interface IMemberInfoBusinessLogic {

	public void saveMemberInfo(MemberInfo memberInfo);

	public int changePwd(MemberInfo memberInfo);

	public int updateMemberInfo(MemberInfo memberInfo);

	public MemberInfo showDetail(MemberInfo memberInfo);
}
