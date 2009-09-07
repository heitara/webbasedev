package com.gameif.portal.action.memberInfo;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.bean.KeyValueInfo;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.MemberInfo;
import com.opensymphony.xwork2.ActionContext;

public class MemberInfoControlAction extends
		ModelDrivenActionSupport<MemberInfo> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

	private List<KeyValueInfo> listquestion;

	/**
	 * @param memberInfoBusinessLogic
	 *            the memberInfoBusinessLogic to set
	 */
	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	/**
	 * @return the listquestion
	 */
	public List<KeyValueInfo> getListquestion() {
		return listquestion;
	}

	/**
	 * @param listquestion
	 *            the listquestion to set
	 */
	public void setListquestion(List<KeyValueInfo> listquestion) {
		this.listquestion = listquestion;
	}

	public String input() {
		this.setListquestion(getQuestionList());
		return INPUT;
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
		// get the member info
		MemberInfo memberInfo = memberInfoBusinessLogic.showDetail(this
				.getModel());

		if (memberInfo != null) {
			setModel(memberInfo);
			return "showdetail";
		} else {
			return "login";
		}

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
		
		HttpServletRequest request = ServletActionContext.getRequest();
		String kaptchaExpected = (String)request.getSession()
							.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
		
		String kaptchaReceived = request.getParameter("kaptcha"); 
		 
		if (kaptchaReceived == null || !kaptchaReceived.equalsIgnoreCase(kaptchaExpected)) 
		{ 
			ActionContext ctx = ActionContext.getContext();
//			ctx.put("kaptcha", getText(""));
			ctx.put("kaptcha", "");
			return INPUT;
		}
		
		memberInfoBusinessLogic.saveMemberInfo(this.getModel());
		return SUCCESS;
	}

	private List<KeyValueInfo> getQuestionList() {
		List<KeyValueInfo> infos = new ArrayList<KeyValueInfo>();

		KeyValueInfo info = new KeyValueInfo();

		info.setKey("00");
		info.setValue(" ");

		infos.add(info);

		info = new KeyValueInfo();
		info.setKey("11");
		info.setValue("test11");

		infos.add(info);

		info = new KeyValueInfo();
		info.setKey("12");
		info.setValue("test12");

		infos.add(info);

		return infos;
	}
}
