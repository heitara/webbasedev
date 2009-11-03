package com.gameif.portal.action.titleif;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.ICbtTesterBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.entity.CbtTester;

public class CBTTesterControlAction  extends
ModelDrivenActionSupport<CbtTester> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 579242178680718814L;
	
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private ICbtTesterBusinessLogic cbtTesterBusinessLogic;
	
	/**
	 * CBT募集画面へ案内する
	 * return CBT募集画面
	 */
	public String input() {
		return INPUT;
	}
	
	/**
	 * 該当登録したユーザをCBTテスターテーブルに登録する
	 * @return
	 */
	public String create() {
		cbtTesterBusinessLogic.saveCbtTester(this.getModel());
		return SUCCESS;
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * @return the cbtTesterBusinessLogic
	 */
	public ICbtTesterBusinessLogic getCbtTesterBusinessLogic() {
		return cbtTesterBusinessLogic;
	}

	/**
	 * @param cbtTesterBusinessLogic the cbtTesterBusinessLogic to set
	 */
	public void setCbtTesterBusinessLogic(
			ICbtTesterBusinessLogic cbtTesterBusinessLogic) {
		this.cbtTesterBusinessLogic = cbtTesterBusinessLogic;
	}

}

