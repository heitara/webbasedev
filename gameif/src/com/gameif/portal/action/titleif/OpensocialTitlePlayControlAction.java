package com.gameif.portal.action.titleif;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.gameif.common.util.SecurityUtil;
import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialTitlePlayBusinessLogic;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.OpensocialMember;
import com.gameif.portal.entity.OpensocialPlayHist;
import com.gameif.portal.entity.ProviderTitleMst;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.helper.OpensocialPageTemplater;
import com.gameif.portal.util.ContextUtil;

public class OpensocialTitlePlayControlAction extends ProviderTitlePlayControlAction {

	private static final long serialVersionUID = -6317164626114870434L;

	private IOpensocialTitlePlayBusinessLogic opensocialTitlePlayBusinessLogic;
	private IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic;
	private OpensocialPageTemplater opensocialPageTemplater;
	
	private String htmlText;
	private String act;
	
	public String execute() {
		
		String result = SUCCESS;
		
		if ("charge".equals(act)) {
			
			htmlText = createChargeUrl(getMemId(), getProviderId(), getTitleId(), getServerId());
			
		} else {
			
			result = super.execute();
		}
		
		return result;
	}
	
	@Override
	protected MemberInfo saveMemberInfo() {
		
		OpensocialMember memberInfo = new OpensocialMember();
		
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
		
		return opensocialMemberBusinessLogic.saveMemberInfo(memberInfo);
	}

	@Override
	protected void savePlayHist(MemberInfo memberInfo) {
		
		// ゲームプレイ履歴を出力する。
		OpensocialPlayHist playHist = new OpensocialPlayHist();

		playHist.setMemNum(memberInfo.getMemNum());
		playHist.setTitleId(getTitleId());
		playHist.setServerId(getServerId());
		playHist.setPlayDate(new Date());
		playHist.setPlayIp(ContextUtil.getClientIP());

		// プレイ履歴とログイン回数情報を登録する
		opensocialTitlePlayBusinessLogic.savePlayHist(playHist);
	}

	@Override
	protected String postPlay(String playUrl, ServerMst server) {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("playUrl", playUrl);
		props.put("server", server);
		htmlText = opensocialPageTemplater.getRenderedText(getProviderId(), "playGame", props);
		
		return SUCCESS;
	}

	@Override
	protected String postServerSelect(List<ServerMst> servers) {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("servers", servers);
		htmlText = opensocialPageTemplater.getRenderedText(getProviderId(), "selectServer", props);
		
		return SUCCESS;
	}

	@Override
	protected String postMaintenance() {

		Map<String, Object> props = new HashMap<String, Object>();
		htmlText = opensocialPageTemplater.getRenderedText(String.valueOf(getProviderId()), "maintenance", props);
		
		return SUCCESS;
	}

	@Override
	protected String postError() {

		Map<String, Object> props = new HashMap<String, Object>();
		htmlText = opensocialPageTemplater.getRenderedText(String.valueOf(getProviderId()), "error", props);
		
		return SUCCESS;
	}
	
	private String createChargeUrl(String memId, String providerId, Integer titleId, Integer serverId) {
		
		long time = System.currentTimeMillis() / 1000;
		
		return new StringBuffer()
			.append(ServletActionContext.getRequest().getSession().getServletContext().getInitParameter("portalTopUrl"))
			.append("/opensocial/chargeEntry.html?memId=")
			.append(memId)
			.append("&providerId=")
			.append(providerId)
			.append("&titleId=")
			.append(titleId)
			.append("&serverId=")
			.append(serverId)
			.append("&time=")
			.append(time)
			.append("&sign=")
			.append(createSign(memId, providerId, titleId, serverId, time))
			.toString();
	}
	
	private String createSign(String memId, String providerId, Integer titleId, Integer serverId, long time) {
		
		return SecurityUtil.getMD5String(new StringBuffer()
				.append(memId)
				.append(providerId)
				.append(titleId)
				.append(serverId)
				.append(time)
				.append(getProviderTitle(providerId, titleId).getSecurityCode())
				.toString());
	}
	
	private ProviderTitleMst getProviderTitle(String providerId, Integer titleId) {
		
		ProviderTitleMst providerTitle = new ProviderTitleMst();			
		providerTitle.setProviderId(providerId);
		providerTitle.setTitleId(Integer.valueOf(titleId));			
		providerTitle = getMasterInfoBusinessLogic().getProviderTitleMstByKey(providerTitle);
		
		return providerTitle;
	}

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	public void setOpensocialTitlePlayBusinessLogic(
			IOpensocialTitlePlayBusinessLogic opensocialTitlePlayBusinessLogic) {
		this.opensocialTitlePlayBusinessLogic = opensocialTitlePlayBusinessLogic;
	}

	public void setOpensocialMemberBusinessLogic(
			IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic) {
		this.opensocialMemberBusinessLogic = opensocialMemberBusinessLogic;
	}

	public void setOpensocialPageTemplater(
			OpensocialPageTemplater opensocialPageTemplater) {
		this.opensocialPageTemplater = opensocialPageTemplater;
	}

	public void setAct(String act) {
		this.act = act;
	}
}