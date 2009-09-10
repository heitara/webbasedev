package com.gameif.portal.businesslogic;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoBusinessLogic {

	public void saveMemberInfo(MemberInfo memberInfo);

	public void changePasswd(MemberInfo memberInfo) throws LogicException;

	public void updateMemberInfo(MemberInfo memberInfo) throws LogicException;

	public MemberInfo getMemberInfo(MemberInfo memberInfo);
	
	public int countMembersByIPInTime(String clientIp, int checkTime);
	
	public int countMembersByMemId(String memId);
	
	public int countMembersByNickName(String nickName);
	
	public int countMembersByMailPc(String mailPC);
}
