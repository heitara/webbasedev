package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MyServer;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayHist;

public interface IPlayHistDao extends IBaseDao<PlayHist, PlayHist> {
	
	public List<MyTitle> selectTitlesOnlyPlay(Long memNum);

	public List<MyTitle> selectTitlesWithPlay(Long memNum);
	
	public List<MyServer> selectServersOnlyPlay(Long memNum, Integer titleId);
	
	public List<MyServer> selectServersWithPlay(Long memNum, Integer titleId);
	
	public Integer selectPlayHistCount(Long memNum, Integer titleId);
}
