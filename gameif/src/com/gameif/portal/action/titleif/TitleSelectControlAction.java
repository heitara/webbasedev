package com.gameif.portal.action.titleif;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.portal.businesslogic.IMemberInfoBusinessLogic;
import com.gameif.portal.businesslogic.ITitlePlayBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.MyServer;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.util.ContextUtil;

public class TitleSelectControlAction extends BaseActionSupport {

	private static final long serialVersionUID = -6317164626114870434L;

	private ITitlePlayBusinessLogic titlePlayBusinessLogic;
	private IMemberInfoBusinessLogic memberInfoBusinessLogic;
	private List<MyTitle> titles;
	private boolean testUser;

	private Map<Integer, List<MyServer>> serverMap = new HashMap<Integer, List<MyServer>>();

	@Override
	public String execute() {

		Long memNum = ContextUtil.getMemberNo();

		titles = titlePlayBusinessLogic.getTitlesWithPlayInfo(memNum);
	
		for (MyTitle title : titles) {

			List<MyServer> servers = titlePlayBusinessLogic.getServersWithPlayInfo(memNum, title.getTitleId());
			serverMap.put(title.getTitleId(), servers);
		}
		
		if (ContextUtil.userIsLogin()) {

			MemberInfo memInfo = new MemberInfo();
			memInfo.setMemNum(ContextUtil.getMemberNo());
			memInfo = memberInfoBusinessLogic.getMemberInfo(memInfo);
			
			if (memInfo != null && PortalConstants.MemberAtbtCd.TEST.equals(memInfo.getMemAtbtCd())) {
				
				testUser = true;
			}
		}

		return SUCCESS;
	}

	public void setTitlePlayBusinessLogic(
			ITitlePlayBusinessLogic titlePlayBusinessLogic) {

		this.titlePlayBusinessLogic = titlePlayBusinessLogic;
	}

	public List<MyTitle> getTitles() {
		return titles;
	}

	public Map<Integer, List<MyServer>> getServerMap() {
		return serverMap;
	}

	public boolean isTestUser() {
		return testUser;
	}

	public void setTestUser(boolean testUser) {
		this.testUser = testUser;
	}

	public void setMemberInfoBusinessLogic(
			IMemberInfoBusinessLogic memberInfoBusinessLogic) {
		this.memberInfoBusinessLogic = memberInfoBusinessLogic;
	}
}