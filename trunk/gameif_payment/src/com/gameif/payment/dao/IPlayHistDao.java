package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.MyServer;
import com.gameif.payment.entity.MyTitle;
import com.gameif.payment.entity.PlayHist;

public interface IPlayHistDao extends IBaseDao<PlayHist, PlayHist> {
	
	public List<MyTitle> selectTitlesOnlyPlay(Long memNum);

	public List<MyTitle> selectTitlesWithPlay(Long memNum);
	
	public List<MyServer> selectServersOnlyPlay(Long memNum, Integer titleId);
	
	public List<MyServer> selectServersWithPlay(Long memNum, Integer titleId);
	
	public Integer selectPlayHistCount(Long memNum, Integer titleId, Integer serverId);
	
	public Integer selectPlayDaysByMemNum(Long memNum);
	
	public Integer selectMemCountByIp(String playIp, Long memNum, Integer limitDays, Integer titleId, Integer serverId);
}

