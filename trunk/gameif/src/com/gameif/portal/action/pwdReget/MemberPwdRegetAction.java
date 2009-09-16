package com.gameif.portal.action.pwdReget;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.ITempPwdRegetBusinessLogic;
import com.gameif.portal.entity.TempPwdInfo;
import com.gameif.portal.helper.PortalProperties;

public class MemberPwdRegetAction extends ModelDrivenActionSupport<TempPwdInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133230738854595746L;

	private ITempPwdRegetBusinessLogic tempPwdRegetBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	/**
	 * @return the tempPwdRegetBusinessLogic
	 */
	public ITempPwdRegetBusinessLogic getTempPwdRegetBusinessLogic() {
		return tempPwdRegetBusinessLogic;
	}

	/**
	 * @param tempPwdRegetBusinessLogic
	 *            the tempPwdRegetBusinessLogic to set
	 */
	public void setTempPwdRegetBusinessLogic(
			ITempPwdRegetBusinessLogic tempPwdRegetBusinessLogic) {
		this.tempPwdRegetBusinessLogic = tempPwdRegetBusinessLogic;
	}

	/**
	 * @return the masterInfoBusinessLogic
	 */
	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	/**
	 * @param masterInfoBusinessLogic
	 *            the masterInfoBusinessLogic to set
	 */
	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	/**
	 * 会員情報入力画面に案内する。
	 * 
	 * @return　会員情報入力画面コード
	 */
	public String input() {

		return INPUT;
	}
	
	/**
	 * 仮キー発行記録をDBに登録する
	 * @return　成功画面
	 */
	public String create() {
		
		return SUCCESS;
	}

}
