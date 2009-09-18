package com.gameif.portal.businesslogic;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.TempPwdInfo;

public interface ITempPwdRegetBusinessLogic {
	
	public void saveTempPwdInfo(TempPwdInfo tempPwdInfo, MemberInfo memberInfo) throws LogicException ;

}
