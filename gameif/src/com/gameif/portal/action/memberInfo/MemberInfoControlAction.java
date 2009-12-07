package com.gameif.portal.action.memberInfo;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateUtils;

import com.gameif.common.action.ModelDrivenActionSupport;
import com.gameif.common.exception.AuthorityException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfDateException;
import com.gameif.common.util.DateUtil;
import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.TitleMst;
import com.gameif.portal.helper.PortalProperties;
import com.gameif.portal.util.ContextUtil;

public class MemberInfoControlAction extends
		ModelDrivenActionSupport<MemberInfo> {

	private static final long serialVersionUID = 171926714928924158L;

	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private PortalProperties portalProperties;

	private String newPwd;
	private String confirmPwd;
	private String kaptcha;

	private String birthY;
	private String birthM;
	private String birthD;

	private String tempKey;
	private Long inviteId;

	private String authKey;
	private Integer advertNum;
	private String linkKey;

	private Integer title;
	private String apply;
	private String urlAfterLogin;
	private String urlAftLgnGames;
	private String urlAftLgnApplyTest;
	
	private String enc;
	private String mailLoginUrl;
	
	public String getKanjiNameForCheck() {

		return StringUtils.trimToEmpty(getModel().getKanjiFname())
				+ StringUtils.trimToEmpty(getModel().getKanjiLname());
	}

	public String getKanaNameForCheck() {

		return StringUtils.trimToEmpty(getModel().getKanaFname())
				+ StringUtils.trimToEmpty(getModel().getKanaLname());
	}

	public Date getBirthdayForCheck() {

		Date birthDay = DateUtil.createDate(birthY, birthM, birthD);

		if (birthDay != null) {

			Date now = new Date();

			if (DateUtils.addYears(birthDay, 90).before(now)
					|| birthDay.after(now)) {

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
	 * 
	 * @return　会員情報入力画面コード
	 */
	public String registry() {

		return INPUT;
	}

	/**
	 * 臨時会員情報を登録する。
	 * 
	 * @return　登録完了画面コード
	 */
	public String createTemp() {

		memberInfoBusinessLogic.saveTempMemberInfo(getModel(), getInviteId(), getAdvertNum(), getLinkKey(), getTitle());
		
		mailLoginUrl = portalProperties.getMailLoginUrl(getModel().getMailPc());
		enc = SecurityUtil.encodeParam("mailLoginUrl=" + mailLoginUrl + "&mailPc=" + getModel().getMailPc().trim());
		
		return SUCCESS;
	}

	/**
	 * 会員情報登録完了。
	 * 
	 * @return　完了画面コード
	 */
	public String finishedCreate() {
		
		return "finish";
	}
	
	/**
	 * 会員情報有効化画面へ案内する
	 * 
	 * @return 会員情報有効化画面
	 */
	public String activate() {

		try {
			// 会員番号と認証キーがリクエストストリングで渡される
			// 会員情報本登録を行う
			// 本登録された会員番号を画面の会員番号に設定する
			this.getModel().setMemNum(memberInfoBusinessLogic.saveMemberInfo(this.getModel().getMemNum(), getAuthKey()));
			
		} catch (OutOfDateException odEx) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ odEx.getMessage());
			
			return "outOfDate";
			
		} catch (LogicException ex) {
			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());

			return "warning";
		}

		enc = SecurityUtil.encodeParam("memNum=" + getModel().getMemNum());

		return "activate";
	}

	/**
	 * 会員情報有効化完了画面へ案内する
	 * @return 会員情報有効化完了画面
	 */
	public String finishedActivate() {
		
		urlAfterLogin = urlAftLgnGames;
		
		TitleMst titleMst = masterInfoBusinessLogic.getValidTitle(title);
		
		if (titleMst != null) {

			String serviceStatus = titleMst.getServiceStatus();
			String recruitStatus = titleMst.getRecruitStatus();
			
			if (PortalConstants.YES.equals(apply)) {
				
				if (PortalConstants.ServerStatus.CBT.equals(serviceStatus)
						|| PortalConstants.ServerStatus.OBT.equals(serviceStatus)) {
					
					if (PortalConstants.RecruitStatus.RECRUITING.equals(recruitStatus)
							|| PortalConstants.RecruitStatus.TEST.equals(recruitStatus)) {
						
						urlAfterLogin = urlAftLgnApplyTest;
						
						urlAfterLogin = urlAfterLogin.replaceAll("#titleId#", titleMst.getTitleId().toString());
						urlAfterLogin = urlAfterLogin.replaceAll("#status#", serviceStatus);
						
						try {
							
							urlAfterLogin = URLEncoder.encode(urlAfterLogin, "UTF-8");
							
						} catch (UnsupportedEncodingException e) {
							
							logger.warn(e.getMessage());
						}
					}
				}
			}
		}
		
		return "finishedActivate";
	}

	/**
	 * 会員情報変更画面に案内する。
	 * 
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
	 * 
	 * @return　完了画面または警告画面コード
	 */
	public String updateMemberInfo() {

		getModel().setMemNum(ContextUtil.getMemberNo());
		getModel().setMemId(ContextUtil.getAccountId());
		getModel().setBirthYmd(getBirthdayForCheck());

		try {

			memberInfoBusinessLogic.updateMemberInfo(this.getModel());

		} catch (LogicException ex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ex.getMessage());

			return "warning";
		}

		return SUCCESS;
	}

	/**
	 * パスワード変更画面に案内する。
	 * 
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
	 * 
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

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ ahex.getMessage());

			addFieldError("memPwd", getText("memPwd.different"));

			return INPUT;

		} catch (LogicException lgex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());

			return "warning";
		}

		return SUCCESS;
	}

	/**
	 * パスワード再設定画面に案内する。
	 * 
	 * @return パスワード再設定画面コード
	 */
	public String editTempPwd() {

		if (getModel().getMemNum() == null || getTempKey() == null) {

			return "warning";
		}

		return INPUT;
	}

	/**
	 * パスワード再設定機能で会員パスワードを変更する。
	 * 
	 * @return 完了画面または警告画面コード
	 */
	public String updateTempPwd() {

		getModel().setMemPwd(getNewPwd());

		try {
			
			memberInfoBusinessLogic.changeTempPwd(getModel(), tempKey);
			
		} catch (OutOfDateException odEx) {
			addFieldError("errMessage", getText("pwdReget.outOfDate"));
			return INPUT;
		} catch (LogicException lgex) {

			logger.warn(ContextUtil.getRequestBaseInfo() + " | "
					+ lgex.getMessage());

			return "warning";
		}

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

	/**
	 * @return the tempKey
	 */
	public String getTempKey() {
		return tempKey;
	}

	/**
	 * @param tempKey
	 *            the tempKey to set
	 */
	public void setTempKey(String tempKey) {
		this.tempKey = tempKey;
	}

	/**
	 * @return the inviteId
	 */
	public Long getInviteId() {
		return inviteId;
	}

	/**
	 * @return the authKey
	 */
	public String getAuthKey() {
		return authKey;
	}

	/**
	 * @param authKey
	 *            the authKey to set
	 */
	public void setAuthKey(String authKey) {
		this.authKey = authKey;
	}
	
	/**
	 * @return the advertNum
	 */
	public Integer getAdvertNum() {
		return advertNum;
	}

	/**
	 * @param advertNum the advertNum to set
	 */
	public void setAdvertNum(Integer advertNum) {
		this.advertNum = advertNum;
	}

	/**
	 * @return the linkKey
	 */
	public String getLinkKey() {
		return linkKey;
	}

	/**
	 * @param linkKey the linkKey to set
	 */
	public void setLinkKey(String linkKey) {
		this.linkKey = linkKey;
	}

	/**
	 * @param inviteId
	 *            the inviteId to set
	 */
	public void setInviteId(Long inviteId) {
		this.inviteId = inviteId;
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

	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
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

	public String getEnc() {
		return enc;
	}

	public void setEnc(String enc) {
		this.enc = enc;
	}

	public String getMailLoginUrl() {
		return mailLoginUrl;
	}

	public void setMailLoginUrl(String mailLoginUrl) {
		this.mailLoginUrl = mailLoginUrl;
	}

	public Integer getTitle() {
		return title;
	}

	public void setTitle(Integer title) {
		this.title = title;
	}

	public String getApply() {
		return apply;
	}

	public void setApply(String apply) {
		this.apply = apply;
	}

	public String getUrlAfterLogin() {
		return urlAfterLogin;
	}

	public void setUrlAfterLogin(String urlAfterLogin) {
		this.urlAfterLogin = urlAfterLogin;
	}

	public String getUrlAftLgnGames() {
		return urlAftLgnGames;
	}

	public void setUrlAftLgnGames(String urlAftLgnGames) {
		this.urlAftLgnGames = urlAftLgnGames;
	}

	public String getUrlAftLgnApplyTest() {
		return urlAftLgnApplyTest;
	}

	public void setUrlAftLgnApplyTest(String urlAftLgnApplyTest) {
		this.urlAftLgnApplyTest = urlAftLgnApplyTest;
	}
}
