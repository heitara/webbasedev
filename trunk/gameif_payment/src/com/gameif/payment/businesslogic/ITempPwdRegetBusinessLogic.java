package com.gameif.payment.businesslogic;

import com.gameif.common.exception.LogicException;
import com.gameif.payment.entity.MemberInfo;
import com.gameif.payment.entity.TempPwdInfo;

public interface ITempPwdRegetBusinessLogic {
	
	public void saveTempPwdInfo(TempPwdInfo tempPwdInfo, MemberInfo memberInfo) throws LogicException ;

}
