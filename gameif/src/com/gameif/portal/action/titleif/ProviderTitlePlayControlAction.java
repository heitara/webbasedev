package com.gameif.portal.action.titleif;

import java.util.Date;
import java.util.List;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.common.util.DateUtil;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.titleif.entry.EntryParameter;
import com.gameif.portal.businesslogic.titleif.entry.TitleEntry;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.TitleMst;

public abstract class ProviderTitlePlayControlAction extends BaseActionSupport {

	private static final long serialVersionUID = -6317164626114870434L;

	private TitleEntry titleEntry;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;

	private String memId;
	private String nickName;
	private String mailPc;
	private String mailMobile;
	private String kanjiFname;
	private String kanjiLname;
	private String kanaFname;
	private String kanaLname;
	private Integer sexCd;
	private String address;
	
	private String birthY;
	private String birthM;
	private String birthD;
	
	private Integer titleId;
	private Integer serverId;
	private String providerId;
		
	public String execute() {
		
		String result = SUCCESS;
		
		ServerMst server = null;
		List<ServerMst> servers = null;
		
		if (providerId != null && titleId != null && memId != null) {
			
			MemberInfo memInfo = saveMemberInfo();
			
			if (serverId == null) {

				// サーバを指定していない場合、タイトルＩＤとプロバイダーＩＤでサーバ一覧を取得
				servers = getServers();
				
				if (servers != null && servers.size() == 1) {
					
					// サーバが一群のみの場合、サーバを設定して一覧はクリア
					server = servers.get(0);
					serverId = server.getServerId();
					servers = null;
				}
				
			} else {

				// サーバを指定した場合サーバを検索
				server = getServer();
			}
			
			// サーバ一群のみの場合
			if (server != null) {
				
				if (isPlayable(server, memInfo)) {
					
					Long inviteMemNum = getInviteMemNum(memInfo.getMemId(), providerId, titleId, server.getServerId());

					String playUrl = doPlay(server, memInfo, inviteMemNum);
					// プレイ画面
					result = postPlay(playUrl, server);
					
				} else {

					// メンテナンス画面
					result = postMaintenance();
				}
			}
			
			// サーバ群が複数ある場合
			else if (servers != null) {
				
				if (isSelectable(servers, memInfo)) {

					// サーバ選択画面
					result = postServerSelect(servers);
					
				} else {

					// メンテナンス画面
					result = postMaintenance();
				}
			}
			
		} else {
			
			logger.warn(new StringBuffer()
						.append("memId: ")
						.append(memId)
						.append(", providerId: ")
						.append(providerId)
						.append(", titleId: ")
						.append(titleId)
						.append(", serverId: ")
						.append(serverId)
						.toString()
						);
			
			result = postError();
		}
		
		return result;
	}

	public Date getBirthYmd() {

		return DateUtil.createDate(birthY, birthM, birthD);
	}
	
	protected abstract MemberInfo saveMemberInfo();
	
	protected abstract void savePlayHist(MemberInfo memberInfo);
	
	protected abstract String postPlay(String playUrl, ServerMst server);
	
	protected abstract String postServerSelect(List<ServerMst> servers);
	
	protected abstract String postMaintenance();
	
	protected abstract String postError();
	
	protected abstract Long getInviteMemNum(String friendId, String providerId, Integer titleId, Integer serverId);
	
	private ServerMst getServer() {

		ServerMst server = null;
		
		if (titleId != null && serverId != null && providerId != null) {

			ServerMst serverSelCond = new ServerMst();
			serverSelCond.setTitleId(titleId);
			serverSelCond.setServerId(serverId);
			serverSelCond.setProviderId(providerId);
						
			server = masterInfoBusinessLogic.getServer(serverSelCond);
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
		
	public String doPlay(ServerMst server, MemberInfo memberInfo, Long inviteMemNum) {
		
		String playUrl = null;
		Date date = new Date();
		
		// ゲームプレイ用ＵＲＬを生成する。
		EntryParameter parameter = new EntryParameter();

		parameter.setMemNum(memberInfo.getMemNum());
		parameter.setMemId(memId);
		parameter.setTitleId(titleId);
		parameter.setServerId(serverId);
		parameter.setPlayDate(date);
		parameter.setParentMemNum(Long.valueOf(0));
		parameter.setParentMemNum(inviteMemNum);

		playUrl = server.getPlayUrl() + "?" + titleEntry.getTitleEntryKey(parameter);

		// ゲームプレイ履歴を出力する。
		savePlayHist(memberInfo);
		
		return playUrl;
	}
	
	private boolean isTestUser(MemberInfo memInfo) {
		
		boolean isTestUser = false;
		
		if (memInfo != null && PortalConstants.MemberAtbtCd.TEST.equals(memInfo.getMemAtbtCd())) {
			
			isTestUser = true;
		}
		
		return isTestUser;
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
	
	private boolean isPlayable (ServerMst server, MemberInfo memInfo) {
		
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
	
	private boolean isSelectable (List<ServerMst> servers, MemberInfo memInfo) {

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

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getMailPc() {
		return mailPc;
	}

	public void setMailPc(String mailPc) {
		this.mailPc = mailPc;
	}

	public String getMailMobile() {
		return mailMobile;
	}

	public void setMailMobile(String mailMobile) {
		this.mailMobile = mailMobile;
	}

	public String getKanjiFname() {
		return kanjiFname;
	}

	public void setKanjiFname(String kanjiFname) {
		this.kanjiFname = kanjiFname;
	}

	public String getKanjiLname() {
		return kanjiLname;
	}

	public void setKanjiLname(String kanjiLname) {
		this.kanjiLname = kanjiLname;
	}

	public String getKanaFname() {
		return kanaFname;
	}

	public void setKanaFname(String kanaFname) {
		this.kanaFname = kanaFname;
	}

	public String getKanaLname() {
		return kanaLname;
	}

	public void setKanaLname(String kanaLname) {
		this.kanaLname = kanaLname;
	}

	public Integer getSexCd() {
		return sexCd;
	}

	public void setSexCd(Integer sexCd) {
		this.sexCd = sexCd;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public Integer getServerId() {
		return serverId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public void setTitleEntry(TitleEntry titleEntry) {
		this.titleEntry = titleEntry;
	}

	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	public void setBirthY(String birthY) {
		this.birthY = birthY;
	}

	public void setBirthM(String birthM) {
		this.birthM = birthM;
	}

	public void setBirthD(String birthD) {
		this.birthD = birthD;
	}

	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}
}