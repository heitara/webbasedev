package com.gameif.portal.action;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoControlAction extends
		ModelDrivenActionSupport<MemberInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

	/**
	 * @param userInfoBusinessLogic
	 *            the userInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	public String creatConfirm() {

		memberInfoBusinessLogic.saveMemberInfo(this.getModel());
		return SUCCESS;
	}
	
	public String changePwd(){
		return SUCCESS;
	}

}
