package com.gameif.portal.action.titleif;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gameif.common.action.BaseActionSupport;
import com.gameif.portal.businesslogic.ITitlePlayBusinessLogic;
import com.gameif.portal.entity.MyServer;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.util.ContextUtil;

public class TitleSelectControlAction extends BaseActionSupport {

	private static final long serialVersionUID = -6317164626114870434L;

	private ITitlePlayBusinessLogic titlePlayBusinessLogic;
	private List<MyTitle> titles;

	private Map<Integer, List<MyServer>> serverMap = new HashMap<Integer, List<MyServer>>();

	@Override
	public String execute() {

		Long memNum = ContextUtil.getMemberNo();

		titles = titlePlayBusinessLogic.getTitlesWithPlayInfo(memNum);
	
		for (MyTitle title : titles) {

			List<MyServer> servers = titlePlayBusinessLogic.getServersWithPlayInfo(memNum, title.getTitleId());
			serverMap.put(title.getTitleId(), servers);
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
}