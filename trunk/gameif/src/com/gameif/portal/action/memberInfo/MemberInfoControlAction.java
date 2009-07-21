package com.gameif.portal.action.memberInfo;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.memberInfo.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.memberInfo.MemberInfo;

public class MemberInfoControlAction extends
		ModelDrivenActionSupport<MemberInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

	/**
	 * @param memberInfoBusinessLogic
	 *            the memberInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	public String creatConfirm() {

		return SUCCESS;
	}

	public String changePwd() {
		int rtn = memberInfoBusinessLogic.changePwd(this.getModel());
		if (rtn != 0) {
			addActionError("Some errors was happened when update Password!");
			return "relogin";
		} else {
			return SUCCESS;
		}
	}

	public String reget() {
		return "reget";
	}

	public String creat() {
		return "new";
	}

	public String changePwdUrl() {
		return "changePwd";
	}

}
