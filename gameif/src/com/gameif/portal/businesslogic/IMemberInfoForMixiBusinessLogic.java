package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.MemberInfoForMixi;
import com.gameif.portal.entity.ServerMst;

public interface IMemberInfoForMixiBusinessLogic {
	
	public List<ServerMst> getServersListForMixi(Integer titleId);
	public String checkMemberinfoForMixi(MemberInfoForMixi memberForMixi);
	public Boolean checkIsExistForMixi(Long memNum);

}
