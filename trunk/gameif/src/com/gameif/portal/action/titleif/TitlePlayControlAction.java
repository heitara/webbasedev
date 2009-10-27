package com.gameif.portal.action.titleif;

import java.util.Date;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.common.util.ContextUtil;
import com.gameif.portal.businesslogic.IMasterInfoBusinessLogic;
import com.gameif.portal.businesslogic.ITitlePlayBusinessLogic;
import com.gameif.portal.businesslogic.titleif.entry.EntryParameter;
import com.gameif.portal.businesslogic.titleif.entry.TitleEntry;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.PlayHist;
import com.gameif.portal.entity.ServerMst;

public class TitlePlayControlAction extends BaseActionSupport {
	
	private static final long serialVersionUID = -6317164626114870434L;
	
	private TitleEntry titleEntry;
	private IMasterInfoBusinessLogic masterInfoBusinessLogic;
	private ITitlePlayBusinessLogic titlePlayBusinessLogic;
	
	private Integer titleId;
	private Integer serverId;
	private String playUrl;
	private String server;
	private String service4Login;
	
	@Override
	public String execute() {
		
		String result = SELECT;
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

		// サーバが存在する場合
		if (serverMst != null) {
			
			Date now = new Date();
			
			// サーバが有効期間以内且つ稼動中の場合
			if (PortalConstants.ServerStatus.RUNNING.equals(serverMst.getServiceStatus())
					&& now.after(serverMst.getServiceStartDate())
					&& now.before(serverMst.getServiceEndDate())) {

				// ゲームプレイ用ＵＲＬを生成する。
				EntryParameter parameter = new EntryParameter();
				
				parameter.setMemNum(ContextUtil.getMemberNo());
				parameter.setMemId(ContextUtil.getAccountId());
				parameter.setTitleId(serverMst.getTitleId());
				parameter.setServerId(serverMst.getServerId());
				parameter.setPlayDate(now);
				
				playUrl = serverMst.getPlayUrl() + "?" + titleEntry.getTitleEntryKey(parameter);

				// ゲームプレイ履歴を出力する。
				PlayHist playHist = new PlayHist();

				playHist.setMemNum(ContextUtil.getMemberNo());
				playHist.setTitleId(serverMst.getTitleId());
				playHist.setServerId(serverMst.getServerId());
				playHist.setPlayDate(now);
				
				// プレイ履歴とログイン回数情報を登録する
				titlePlayBusinessLogic.savePlayHist(playHist);
				
				result = SUCCESS;
			}
		}
		
		return result;
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
}