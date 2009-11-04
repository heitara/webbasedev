package com.gameif.portal.action.pwdReget;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.ITempPwdRegetBusinessLogic;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.TempPwdInfo;
import com.gameif.portal.util.ContextUtil;

public class MemberPwdRegetAction extends ModelDrivenActionSupport<TempPwdInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3133230738854595746L;

	private ITempPwdRegetBusinessLogic tempPwdRegetBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	private String memId;

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
	 * @return the memId
	 */
	public String getMemId() {
		return memId;
	}

	/**
	 * @param memId
	 *            the memId to set
	 */
	public void setMemId(String memId) {
		this.memId = memId;
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
	 * 
	 * @return　完了画面のアクション
	 */
	public String create() {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setMemId(getMemId());
		memberInfo.setMailPc(this.getModel().getMailPc());

		try {
			tempPwdRegetBusinessLogic.saveTempPwdInfo(this.getModel(),
					memberInfo);

		} catch (LogicException ex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());

			return "warning";
		}
		return SUCCESS;
	}
	
	/**
	 * 完了画面へ案内する
	 * @return 発行完了画面
	 */
	public String finished() {
		return "finish";
	}

}
