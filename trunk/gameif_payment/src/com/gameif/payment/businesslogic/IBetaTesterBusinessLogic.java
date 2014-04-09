package com.gameif.payment.businesslogic;

import java.util.List;

import com.gameif.payment.entity.BetaTester;
import com.gameif.payment.entity.MyTitle;

public interface IBetaTesterBusinessLogic {
	
	public void saveBetaTester(BetaTester betaTester);
	public BetaTester getBetaTester(Integer titleId, Long memNum);
	public List<MyTitle> getMyBetaTestTitleList(Long memNum);
}
