package com.gameif.portal.action;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoAction extends ModelDrivenActionSupport<MemberInfo> {

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

	public String login() {

		MemberInfo result = memberInfoBusinessLogic.checkLoginInfo(this
				.getModel());

		if (result != null) {
			return SUCCESS;
		} else {
			addActionError("Your MemberId or Password are not right! Please try again!");
			return INPUT;
		}
	}

	public String reget() {
		return "reget";
	}

	public String creat() {
		return "new";
	}

	public String changePwd() {
		return "changePwd";
	}
	
	public String updatePwd(){
		int rtn = memberInfoBusinessLogic.changePwd(this.getModel());
		if (rtn != 0){
			addActionError("Some errors was happened when update Password!");
			return "relogin";
		}else{
			return SUCCESS;
		}
	}

}
