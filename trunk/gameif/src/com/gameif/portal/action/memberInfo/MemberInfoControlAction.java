package com.gameif.portal.action.memberInfo;

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

	private Integer memNum;

	/**
	 * @param memNum
	 *            the memNum to set
	 */
	public void setMemNum(Integer memNum) {
		this.memNum = memNum;
	}

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

	public String changePwdUrl() {
		return "changePwd";
	}

	/**
	 * Get the memberInfo
	 * 
	 * @return
	 */
	public String show() {
		// search condition
		MemberInfo search = new MemberInfo();
		search.setMemNum(this.memNum);
		// get the member info
		MemberInfo memberInfo = memberInfoBusinessLogic.showDetail(search);

		super.setModel(memberInfo);

		return "showDetail";
	}

	/**
	 * Update memberInfo
	 * 
	 * @return
	 */
	public String update() {
		memberInfoBusinessLogic.updateMemberInfo(this.getModel());
		return "showMenu";
	}
	
	/**
	 * Create a new member
	 * 
	 * @return
	 */
	public String create() {
		memberInfoBusinessLogic.saveMemberInfo(this.getModel());
		return SUCCESS;
	}

}
