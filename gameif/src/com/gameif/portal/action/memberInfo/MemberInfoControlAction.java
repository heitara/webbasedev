package com.gameif.portal.action.memberInfo;

import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.AuthorityException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.util.ContextUtil;
import com.gameif.common.util.DateUtil;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.helper.PortalProperties;

public class MemberInfoControlAction extends ModelDrivenActionSupport<MemberInfo> {

	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private PortalProperties portalProperties;
	
	private String newPwd;
	private String confirmPwd;
	private String kaptcha;
	private String agreement;
	
	private String birthY;
	private String birthM;
	private String birthD;
	
	public String getKanjiNameForCheck() {
		
		return StringUtils.trimToEmpty(getModel().getKanjiFname()) + StringUtils.trimToEmpty(getModel().getKanjiLname());
	}
	
	public String getKanaNameForCheck() {
		
		return StringUtils.trimToEmpty(getModel().getKanaFname()) + StringUtils.trimToEmpty(getModel().getKanaLname());
	}
	
	public Date getBirthdayForCheck() {
		
		Date birthDay = DateUtil.createDate(birthY, birthM, birthD);
			
		if (birthDay != null) {

			Date now = new Date();
			
			if (DateUtils.addYears(birthDay, 90).before(now) || birthDay.after(now)) {
				
				birthDay = null;
			}
		}
		
		return birthDay;
	}
	
	public void setBirthYMDForView() {				
		
		if (getModel().getBirthYmd() != null) {

			Calendar cal = Calendar.getInstance();
			cal.setTime(getModel().getBirthYmd());
			
			birthY = String.valueOf(cal.get(Calendar.YEAR));
			birthM = String.valueOf(cal.get(Calendar.MONTH) + 1);
			birthD = String.valueOf(cal.get(Calendar.DATE));
		}
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
		
		return SUCCESS;
	}

	/**
	 * 会員情報変更画面に案内する。
	 * @return 会員情報変更画面または警告画面コード
	 */
	public String editMemberInfo() {

		getModel().setMemNum(ContextUtil.getMemberNo());		
		setModel(memberInfoBusinessLogic.getMemberInfo(getModel()));

		if (getModel() == null) {

			return "warning";
		}
		
		setBirthYMDForView();
		
		return INPUT;
	}
	
	/**
	 * Update 会員情報を更新する。
	 * @return　完了画面または警告画面コード
	 */
	public String updateMemberInfo() {
		
		getModel().setMemNum(ContextUtil.getMemberNo());
		getModel().setMemId(ContextUtil.getAccountId());
		getModel().setBirthYmd(getBirthdayForCheck());
		
		try {
			
			memberInfoBusinessLogic.updateMemberInfo(this.getModel());
		
		} catch (LogicException ex) {
			
			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + ex.getMessage());

			return "warning";
		}
		
		//TODO:会員情報変更通知メール送信要実装
		
		return SUCCESS;
	}

	/**
	 * パスワード変更画面に案内する。
	 * @return パスワード変更画面コード
	 */
	public String editPassword() {

		getModel().setMemNum(ContextUtil.getMemberNo());		
		setModel(memberInfoBusinessLogic.getMemberInfo(getModel()));

		if (getModel() == null) {

			return "warning";
		}
		
		return INPUT;
	}

	/**
	 * Update パスワードを更新する。
	 * @return　完了画面または警告画面コード
	 */
	public String updatePassword() {
		
		String oldPassword = getModel().getMemPwd();
		
		getModel().setMemNum(ContextUtil.getMemberNo());
		getModel().setMemId(ContextUtil.getAccountId());
		getModel().setMemPwd(getNewPwd());
				
		try {

			memberInfoBusinessLogic.changePasswd(getModel(), oldPassword);
			
		} catch (AuthorityException ahex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + ahex.getMessage());
			
			addFieldError("memPwd", getText("memPwd.different"));
			
			return INPUT;
			
		} catch (LogicException lgex) {
			
			logger.warn(ContextUtil.getRequestBaseInfo() + " | " + lgex.getMessage());

			return "warning";
		}
		
		//TODO:パスワード変更通知メール送信要実装
		
		return SUCCESS;
	}

	public String getNewPwd() {
		return newPwd;
	}

	public void setNewPwd(String newPwd) {
		this.newPwd = newPwd;
	}

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

	public String getBirthY() {
		return birthY;
	}

	public void setBirthY(String birthY) {
		this.birthY = birthY;
	}

	public String getBirthM() {
		return birthM;
	}

	public void setBirthM(String birthM) {
		this.birthM = birthM;
	}

	public String getBirthD() {
		return birthD;
	}

	public void setBirthD(String birthD) {
		this.birthD = birthD;
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

	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}
}
