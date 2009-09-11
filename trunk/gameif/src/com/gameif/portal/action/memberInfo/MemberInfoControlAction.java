package com.gameif.portal.action.memberInfo;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.LogicException;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.helper.PortalProperties;
import com.opensymphony.xwork2.ActionContext;

public class MemberInfoControlAction extends ModelDrivenActionSupport<MemberInfo> {

	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private PortalProperties portalProperties;
	
	private String confirmPwd;
	private String kaptcha;
	private String agreement;

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getAgreement() {
		return agreement;
	}

	public void setAgreement(String agreement) {
		this.agreement = agreement;
	}

	public String getKaptcha() {
		return kaptcha;
	}

	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

	public PortalProperties getPortalProperties() {
		return portalProperties;
	}

	public void setPortalProperties(PortalProperties portalProperties) {
		this.portalProperties = portalProperties;
	}

	public void setMemberInfoBusinessLogic(IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}


	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}

	/**
	 * 会員情報入力画面に案内する。
	 * @return　会員情報入力画面コード
	 */
	public String registry() {
		
		return INPUT;
	}
	
	/**
	 * 会員情報を登録する。
	 * @return　完了画面コード
	 */
	public String create() {
		
		memberInfoBusinessLogic.saveMemberInfo(getModel());
		
		//TODO:会員登録通知メール送信要実装
		
		return "successCreate";
	}

	/**
	 * 会員情報変更画面に案内する。
	 * @return 会員情報変更画面または警告画面コード
	 */
	public String edit() {

		MemberInfo memberInfo = memberInfoBusinessLogic.getMemberInfo(this.getModel());

		if (memberInfo == null) {

			return "warning";
		}
		
		setModel(memberInfo);
		
		return "edit";
	}

	/**
	 * Update 会員情報を更新する。
	 * @return　完了画面または警告画面コード
	 */
	public String update() {
		
		try {

			memberInfoBusinessLogic.updateMemberInfo(this.getModel());
			
		} catch (LogicException lgex) {
			
			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + lgex.getMessage());

			return "warning";
		}
		
		//TODO:会員情報変更通知メール送信要実装
		
		return "showMenu";
	}

	/**
	 * パスワード変更画面に案内する。
	 * @return パスワード変更画面コード
	 */
	public String editPasswd() {
		
		return "changePasswd";
	}

	/**
	 * Update パスワードを更新する。
	 * @return　完了画面または警告画面コード
	 */
	public String updatePasswd() {
		try {

			memberInfoBusinessLogic.changePasswd(this.getModel());
			
		} catch (LogicException lgex) {
			
			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + lgex.getMessage());

			return "warning";
		}
		
		//TODO:パスワード変更通知メール送信要実装
		
		return SUCCESS;
	}
}
