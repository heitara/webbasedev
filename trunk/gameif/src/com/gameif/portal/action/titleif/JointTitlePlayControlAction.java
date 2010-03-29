package com.gameif.portal.action.titleif;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.gameif.portal.businesslogic.IJointMemberBusinessLogic;
import com.gameif.portal.businesslogic.IJointTitlePlayBusinessLogic;
import com.gameif.portal.entity.JointMember;
import com.gameif.portal.entity.JointPlayHist;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.util.ContextUtil;

public class JointTitlePlayControlAction extends ProviderTitlePlayControlAction {

	private static final long serialVersionUID = -6317164626114870434L;

	private IJointTitlePlayBusinessLogic jointTitlePlayBusinessLogic;
	private IJointMemberBusinessLogic jointMemberBusinessLogic;
	
	private String playUrl;
	private String maintenanceUrl;
	private String errorUrl;
	
	@Override
	protected MemberInfo saveMemberInfo() {
		
		JointMember memberInfo = new JointMember();
		
		memberInfo.setMemId(getMemId());
		memberInfo.setProviderId(ServletActionContext.getRequest().getParameter("providerId"));
		memberInfo.setNickName(getNickName());
		memberInfo.setMailPc(getMailPc());
		memberInfo.setMailMobile(getMailMobile());
		memberInfo.setKanjiFname(getKanjiFname());
		memberInfo.setKanjiLname(getKanjiLname());
		memberInfo.setKanaFname(getKanaFname());
		memberInfo.setKanaLname(getKanaLname());
		memberInfo.setSexCd(getSexCd());
		memberInfo.setBirthYmd(getBirthYmd());
		memberInfo.setAddress(getAddress());
		
		return jointMemberBusinessLogic.saveMemberInfo(memberInfo);
	}

	@Override
	protected void savePlayHist(MemberInfo memberInfo) {
		
		// ゲームプレイ履歴を出力する。
		JointPlayHist playHist = new JointPlayHist();

		playHist.setMemNum(memberInfo.getMemNum());
		playHist.setTitleId(getTitleId());
		playHist.setServerId(getServerId());
		playHist.setPlayDate(new Date());
		playHist.setPlayIp(ContextUtil.getClientIP());

		// プレイ履歴とログイン回数情報を登録する
		jointTitlePlayBusinessLogic.savePlayHist(playHist);
	}

	@Override
	protected String postPlay(String playUrl) {
		
		this.playUrl = playUrl;
		
		return SUCCESS;
	}

	@Override
	protected String postServerSelect(List<ServerMst> servers) {
		
		return ERROR;
	}

	@Override
	protected String postMaintenance() {
		
		return "maintenance";
	}

	@Override
	protected String postError() {
		
		return ERROR;
	}

	public String getPlayUrl() {
		return playUrl;
	}

	public void setJointTitlePlayBusinessLogic(
			IJointTitlePlayBusinessLogic jointTitlePlayBusinessLogic) {
		this.jointTitlePlayBusinessLogic = jointTitlePlayBusinessLogic;
	}

	public void setJointMemberBusinessLogic(
			IJointMemberBusinessLogic jointMemberBusinessLogic) {
		this.jointMemberBusinessLogic = jointMemberBusinessLogic;
	}

	public String getMaintenanceUrl() {
		return maintenanceUrl;
	}

	public void setMaintenanceUrl(String maintenanceUrl) {
		this.maintenanceUrl = maintenanceUrl;
	}

	public String getErrorUrl() {
		return errorUrl;
	}

	public void setErrorUrl(String errorUrl) {
		this.errorUrl = errorUrl;
	}
}