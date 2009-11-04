package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.CbtTester;
import com.gameif.portal.entity.MyTitle;

public interface ICbtTesterBusinessLogic {
	
	public void saveCbtTester(CbtTester cbtTester);
	public List<MyTitle> getCbtTitleList(Long memNum);

}
