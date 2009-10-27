package com.gameif.portal.businesslogic;

import com.gameif.common.exception.LogicException;

public interface IMaintenanceBusinessLogic {
	
	public void maintenanceCheckByTitleId(Integer titleId) throws LogicException;

}
