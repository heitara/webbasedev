package com.gameif.backoffice.action.member;

import com.gameif.backoffice.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.common.action.ModelDrivenActionSupport;

public class MemberInfoControlAction extends ModelDrivenActionSupport<MemberInfo> {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1826168967489324276L;
	
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	
	/**
	 * 会員凍結画面に案内する
	 * @return 会員凍結画面
	 */
	public String inputFreeze() {
		return "inputFreeze";
	}
	
	public String freeze() {
		memberInfoBusinessLogic.freezeMemberInfo(this.getModel().getMemId());
		return "finishedFreeze";
	}
	
	/**
	 * @return the memberInfoBusinessLogic
	 */
	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}
	
	/**
	 * @param memberInfoBusinessLogic the memberInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}
	
}
