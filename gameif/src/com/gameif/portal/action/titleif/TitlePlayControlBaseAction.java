package com.gameif.portal.action.titleif;

import java.util.Date;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.portal.businesslogic.IBetaTesterBusinessLogic;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.businesslogic.ITitlePlayBusinessLogic;
import com.gameif.portal.businesslogic.titleif.entry.EntryParameter;
import com.gameif.portal.businesslogic.titleif.entry.TitleEntry;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.BetaTester;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.PlayHist;
import com.gameif.portal.entity.ServerMst;
import com.gameif.portal.entity.TitleMst;
import com.gameif.portal.util.ContextUtil;

public class TitlePlayControlBaseAction extends BaseActionSupport {

	private static final long serialVersionUID = -6317164626114870434L;

	private TitleEntry titleEntry;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private ITitlePlayBusinessLogic titlePlayBusinessLogic;
	private IBetaTesterBusinessLogic betaTesterBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;

	private Integer titleId;
	private Integer serverId;
	private String playUrl;
	private String server;
	private String service4Login;
	
	protected ServerMst getServerMst() {

		ServerMst serverMst = null;
		
		if (titleId != null && serverId != null) {

			// タイトルＩＤとサーバＩＤがパラメータで指定された場合、それを検索条件でサーバマスタを検索する。
			ServerMst serverMstForSel = new ServerMst();

			serverMstForSel.setTitleId(titleId);
			serverMstForSel.setServerId(serverId);

			serverMst = masterInfoBusinessLogic.getServer(serverMstForSel);

		} else if (server != null) {

			// サーバ名が指定された場合、それを検索条件でサーバマスタを検索する。
			serverMst = masterInfoBusinessLogic.getServerByDomain(server);
		}
		
		return serverMst;
	}
	
	protected String doPlay(ServerMst serverMst) {
		
		String result = SELECT;
		Date now = new Date();
		
		if (isPlayable(serverMst, now)) {
		
			// ゲームプレイ用ＵＲＬを生成する。
			EntryParameter parameter = new EntryParameter();
	
			parameter.setMemNum(ContextUtil.getMemberNo());
			parameter.setMemId(ContextUtil.getAccountId());
			parameter.setTitleId(serverMst.getTitleId());
			parameter.setServerId(serverMst.getServerId());
			parameter.setPlayDate(now);
			parameter.setParentMemNum(titlePlayBusinessLogic.getParentNum());
	
			playUrl = serverMst.getPlayUrl() + "?" + titleEntry.getTitleEntryKey(parameter);
	
			// ゲームプレイ履歴を出力する。
			PlayHist playHist = new PlayHist();
	
			playHist.setMemNum(ContextUtil.getMemberNo());
			playHist.setTitleId(serverMst.getTitleId());
			playHist.setServerId(serverMst.getServerId());
			playHist.setPlayDate(now);
			playHist.setPlayIp(ContextUtil.getClientIP());
	
			// プレイ履歴とログイン回数情報を登録する
			titlePlayBusinessLogic.savePlayHist(playHist);
	
			result = SUCCESS;
		}
		
		return result;
	}
	
	protected boolean isPlayable (ServerMst serverMst, Date date) {
		
		boolean playable = false;

		// サーバが有効期間以内且つ稼動中の場合
		if (serverMst != null 
				&& PortalConstants.ServerStatus.RUNNING.equals(serverMst.getServiceStatus())
				&& date.after(serverMst.getServiceStartDate())
				&& date.before(serverMst.getServiceEndDate())) {

			playable = true;
			
			TitleMst titleMst = masterInfoBusinessLogic.getValidTitle(serverMst.getTitleId());
			
			if (titleMst != null) {

				// メンテナンス時、テストユーザはプレイ可能
				MemberInfo memInfo = new MemberInfo();
				memInfo.setMemNum(ContextUtil.getMemberNo());
				memInfo = memberInfoBusinessLogic.getMemberInfo(memInfo);
				
				if (memInfo != null && PortalConstants.MemberAtbtCd.TEST.equals(memInfo.getMemAtbtCd())) {
					
					playable = true;
					return playable;
				}
			}

			// タイトルが有効期間以外或いはメンテナンス中の場合、プレイ不可
			if (titleMst == null
					|| PortalConstants.ServerStatus.MAINTENANCE.equals(titleMst.getServiceStatus())
					|| date.before(titleMst.getServiceStartDate())
					|| date.after(titleMst.getServiceEndDate())) {
				
				playable = false;
				
			} else {
				
				// タイトルがβテスト状態の場合
				if (PortalConstants.ServerStatus.CBT.equals(titleMst.getServiceStatus())
						|| PortalConstants.ServerStatus.OBT.equals(titleMst.getServiceStatus())) {
					
					// 「テスター募集・プレイ不可」状態の場合、プレイ不可
					if (PortalConstants.RecruitStatus.RECRUITING.equals(titleMst.getRecruitStatus())) {

						playable = false;
						
					// 「テスター募集・当選者プレイ可」或いは「募集終了・当選者プレイ可」状態の場合
					} else if (PortalConstants.RecruitStatus.TEST.equals(titleMst.getRecruitStatus())
							|| PortalConstants.RecruitStatus.COMPLETE.equals(titleMst.getRecruitStatus())) {
						
						BetaTester betaTester = betaTesterBusinessLogic.getBetaTester(titleId, ContextUtil.getMemberNo());
						
						// ユーザがテスターに応募していない、或いは応募したが当選されていない場合、プレイ不可
						if (betaTester == null || !PortalConstants.ElectStatus.ELECTED.equals(betaTester.getElectStatus())) {

							playable = false;
						}
					}
				}
			}
		}
		
		return playable;
	}

	public String getPlayUrl() {
		return playUrl;
	}

	public String getService4Login() {
		return service4Login;
	}

	public void setTitleEntry(TitleEntry titleEntry) {
		this.titleEntry = titleEntry;
	}

	public void setMasterInfoBusinessLogic(
			IMasterInfoBusinessLogic masterInfoBusinessLogic) {
		this.masterInfoBusinessLogic = masterInfoBusinessLogic;
	}

	public void setBetaTesterBusinessLogic(
			IBetaTesterBusinessLogic betaTesterBusinessLogic) {
		this.betaTesterBusinessLogic = betaTesterBusinessLogic;
	}

	public void setTitlePlayBusinessLogic(
			ITitlePlayBusinessLogic titlePlayBusinessLogic) {
		this.titlePlayBusinessLogic = titlePlayBusinessLogic;
	}

	public void setTitleId(Integer titleId) {
		this.titleId = titleId;
	}

	public void setServerId(Integer serverId) {
		this.serverId = serverId;
	}

	public void setServer(String server) {
		this.server = server;
	}

	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}

	public TitleEntry getTitleEntry() {
		return titleEntry;
	}

	public IMasterInfoBusinessLogic getMasterInfoBusinessLogic() {
		return masterInfoBusinessLogic;
	}

	public ITitlePlayBusinessLogic getTitlePlayBusinessLogic() {
		return titlePlayBusinessLogic;
	}

	public IBetaTesterBusinessLogic getBetaTesterBusinessLogic() {
		return betaTesterBusinessLogic;
	}

	public IMemberInfoBusinessLogic getMemberInfoBusinessLogic() {
		return memberInfoBusinessLogic;
	}

	public Integer getTitleId() {
		return titleId;
	}

	public Integer getServerId() {
		return serverId;
	}

	public String getServer() {
		return server;
	}
	
}