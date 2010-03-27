package com.gameif.portal.action.titleif;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialMemberBusinessLogic;
import com.gameif.portal.businesslogic.IOpensocialTitlePlayBusinessLogic;
import com.gameif.portal.businesslogic.titleif.entry.EntryParameter;
import com.gameif.portal.businesslogic.titleif.entry.TitleEntry;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.OpensocialMember;
import com.gameif.portal.entity.OpensocialPlayHist;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.TitleMst;
import com.gameif.portal.helper.OpensocialPageTemplater;
import com.gameif.portal.util.ContextUtil;

public class OpensocialTitlePlayControlAction extends BaseActionSupport {

	private static final long serialVersionUID = -6317164626114870434L;

	private TitleEntry titleEntry;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private IOpensocialTitlePlayBusinessLogic opensocialTitlePlayBusinessLogic;
	private IOpensocialMemberBusinessLogic opensocialMemberBusinessLogic;
	private OpensocialPageTemplater opensocialPageTemplater;

	private String memId;
	private String nickName;
	private String mailPc;
	private String mailMobile;
	private String kanjiFname;
	private String kanjiLname;
	private String kanaFname;
	private String kanaLname;
	private Integer sexCd;
	private Date birthYmd;
	private String address;
	
	private Integer titleId;
	private Integer serverId;
	private String providerId;
	
	private String htmlText;
	
	public String execute() {
				
		ServerMst server = null;
		List<ServerMst> servers = null;
		
		if (providerId != null && titleId != null && memId != null) {
			
			OpensocialMember memInfo = saveMemberInfo();
			
			if (serverId == null) {

				// サーバを指定していない場合、タイトルＩＤとプロバイダーＩＤでサーバ一覧を取得
				servers = getServers();
				
				if (servers != null && servers.size() == 1) {
					
					// サーバが一群のみの場合、サーバを設定して一覧はクリア
					server = servers.get(0);
					servers = null;
				}
				
			} else {

				// サーバを指定した場合サーバを検索
				server = getServer();	
			}
			
			// サーバ一群のみの場合
			if (server != null) {
				
				if (isPlayable(server, memInfo)) {

					String playUrl = doPlay(server, memInfo);
					// プレイ画面
					renderPlayHtml(playUrl);
					
				} else {

					// メンテナンス画面
					renderMaintenanceHtml();
				}
			}
			
			// サーバ群が複数ある場合
			else if (servers != null) {
				
				if (isSelectable(servers, memInfo)) {

					// サーバ選択画面
					renderServerSelectHtml(servers);
					
				} else {

					// メンテナンス画面
					renderMaintenanceHtml();
				}
			}
			
		} else {
			
			renderErrorHtml();
		}
		
		return SUCCESS;
	}
	
	private ServerMst getServer() {

		ServerMst server = new ServerMst();
		server.setTitleId(titleId);
		server.setServerId(serverId);
		
		server = masterInfoBusinessLogic.getServer(server);
		
		if (providerId == null || server == null || !providerId.equals(server.getProviderId())) {
					
			server = null;
		}
		
		return server;
	}
	
	private List<ServerMst> getServers() {

		List<ServerMst> servers = null;
		
		if (titleId != null && providerId != null) {
			
			ServerMst serverMst = new ServerMst();
			serverMst.setTitleId(titleId);
			serverMst.setProviderId(providerId);
			
			servers = masterInfoBusinessLogic.getAllValidServerListTitleAndProvider(serverMst);
		}
		
		return servers;
	}
		
	public String doPlay(ServerMst server, OpensocialMember memberInfo) {
		
		String playUrl = null;
		Date date = new Date();
		
		// ゲームプレイ用ＵＲＬを生成する。
		EntryParameter parameter = new EntryParameter();

		parameter.setMemNum(ContextUtil.getMemberNo());
		parameter.setMemId(memId);
		parameter.setTitleId(titleId);
		parameter.setServerId(serverId);
		parameter.setPlayDate(date);
		parameter.setParentMemNum(Long.valueOf(0));

		playUrl = server.getPlayUrl() + "?" + titleEntry.getTitleEntryKey(parameter);

		// ゲームプレイ履歴を出力する。
		OpensocialPlayHist playHist = new OpensocialPlayHist();

		playHist.setMemNum(memberInfo.getMemNum());
		playHist.setTitleId(titleId);
		playHist.setServerId(serverId);
		playHist.setPlayDate(date);
		playHist.setPlayIp(ContextUtil.getClientIP());

		// プレイ履歴とログイン回数情報を登録する
		opensocialTitlePlayBusinessLogic.savePlayHist(playHist);
		
		return playUrl;
	}
	
	private void renderMaintenanceHtml() {

		Map<String, Object> props = new HashMap<String, Object>();
		htmlText = opensocialPageTemplater.getRenderedText(String.valueOf(providerId), "maintenance", props);
	}
	
	private void renderPlayHtml(String playUrl) {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("playUrl", playUrl);
		htmlText = opensocialPageTemplater.getRenderedText(String.valueOf(providerId), "playGame", props);
	}
	
	private void renderServerSelectHtml(List<ServerMst> servers) {

		Map<String, Object> props = new HashMap<String, Object>();
		props.put("servers", servers);
		htmlText = opensocialPageTemplater.getRenderedText(String.valueOf(providerId), "selectServer", props);
	}
	
	private void renderErrorHtml() {

		Map<String, Object> props = new HashMap<String, Object>();
		htmlText = opensocialPageTemplater.getRenderedText(String.valueOf(providerId), "error", props);
	}
	
	private boolean isTestUser(OpensocialMember memInfo) {
		
		boolean isTestUser = false;
		
		if (memInfo != null && PortalConstants.MemberAtbtCd.TEST.equals(memInfo.getMemAtbtCd())) {
			
			isTestUser = true;
		}
		
		return isTestUser;
	}
	
	private OpensocialMember saveMemberInfo() {
		
		OpensocialMember memberInfo = new OpensocialMember();
		
		memberInfo.setMemId(memId);
		memberInfo.setNickName(nickName);
		memberInfo.setMailPc(mailPc);
		memberInfo.setMailMobile(mailMobile);
		memberInfo.setKanjiFname(kanjiFname);
		memberInfo.setKanjiLname(kanjiLname);
		memberInfo.setKanaFname(kanaFname);
		memberInfo.setKanaLname(kanaLname);
		memberInfo.setSexCd(sexCd);
		memberInfo.setBirthYmd(birthYmd);
		memberInfo.setAddress(address);
		
		return opensocialMemberBusinessLogic.saveMemberInfo(memberInfo);
	}
	
	private boolean isValidTitle(Integer titleId) {
		
		boolean isValidTitle = false;
		Date date = new Date();
		
		TitleMst titleMst = masterInfoBusinessLogic.getValidTitle(titleId);

		// タイトルが有効期間以内且つメンテナンス状態ではない場合
		if (titleMst != null
				&& !PortalConstants.ServerStatus.MAINTENANCE.equals(titleMst.getServiceStatus())
				&& date.after(titleMst.getServiceStartDate())
				&& date.before(titleMst.getServiceEndDate())) {

			isValidTitle = true;
		}
		
		return isValidTitle;
	}
	
	private boolean isPlayable (ServerMst server, OpensocialMember memInfo) {
		
		boolean playable = false;
		
		Date date = new Date();
			
		// サーバ一群のみの場合
		if (server != null) {

			if (isTestUser(memInfo)) {
				
				// テストユーザの場合
				playable = true;
				
			} else {
				
				// 一般ユーザの場合
				if (PortalConstants.ServerStatus.RUNNING.equals(server.getServiceStatus())
						&& date.after(server.getServiceStartDate())
						&& date.before(server.getServiceEndDate())
						&& isValidTitle(titleId)) {

					// サーバとタイトルがが有効期間以内且つ稼動中の場合
					playable = true;
				}
			}
		}
		
		return playable;
	}
	
	private boolean isSelectable (List<ServerMst> servers, OpensocialMember memInfo) {

		boolean isSelectable = false;

		// サーバ群が複数ある場合
		if (servers != null) {
			
			if (isValidTitle(titleId)) {

				// タイトルが有効期間以内且つメンテナンス状態ではない場合
				isSelectable = true;
			
			} else {
				
				if (isTestUser(memInfo)) {

					// テストユーザの場合
					isSelectable = true;
				}
			}
		}
		
		return isSelectable;
	}

	public String getHtmlText() {
		return htmlText;
	}

	public void setHtmlText(String htmlText) {
		this.htmlText = htmlText;
	}

	public void setTitleEntry(TitleEntry titleEntry) {
		this.titleEntry = titleEntry;
	}

	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
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

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public void setMailPc(String mailPc) {
		this.mailPc = mailPc;
	}

	public void setMailMobile(String mailMobile) {
		this.mailMobile = mailMobile;
	}

	public void setKanjiFname(String kanjiFname) {
		this.kanjiFname = kanjiFname;
	}

	public void setKanjiLname(String kanjiLname) {
		this.kanjiLname = kanjiLname;
	}

	public void setKanaFname(String kanaFname) {
		this.kanaFname = kanaFname;
	}

	public void setKanaLname(String kanaLname) {
		this.kanaLname = kanaLname;
	}

	public void setSexCd(Integer sexCd) {
		this.sexCd = sexCd;
	}

	public void setBirthYmd(Date birthYmd) {
		this.birthYmd = birthYmd;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}
}