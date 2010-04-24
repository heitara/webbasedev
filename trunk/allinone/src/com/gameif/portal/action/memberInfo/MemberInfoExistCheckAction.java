package com.gameif.portal.action.memberInfo;

import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.util.ContextUtil;

public class MemberInfoExistCheckAction {

	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private String result;
	private String target;

	public String checkAccount() {

		int count = 0;

		if (ContextUtil.userIsLogin()) {

			count = memberInfoBusinessLogic.countMembersByMemId(target,
					ContextUtil.getMemberNo());

		} else {

			count = memberInfoBusinessLogic.countMembersByMemId(target);
		}

		result = String.valueOf(count);

		return "success";
	}

	public String checkNickName() {

		int count = 0;

		if (ContextUtil.userIsLogin()) {

			count = memberInfoBusinessLogic.countMembersByNickName(target,
					ContextUtil.getMemberNo());

		} else {

			count = memberInfoBusinessLogic.countMembersByNickName(target);
		}

		result = String.valueOf(count);

		return "success";
	}

	public String checkEmail() {

		int count = 0;

		if (ContextUtil.userIsLogin()) {

			count = memberInfoBusinessLogic.countMembersByMailPc(target,
					ContextUtil.getMemberNo());

		} else {

			count = memberInfoBusinessLogic.countMembersByMailPc(target);
		}

		result = String.valueOf(count);

		return "success";
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}
}
