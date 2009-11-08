package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.portal.entity.BetaTester;
import com.gameif.portal.entity.MyTitle;

public interface IBetaTesterBusinessLogic {
	
	public void saveBetaTester(BetaTester betaTester);
	public List<MyTitle> getMyBetaTestTitleList(Long memNum);
}
