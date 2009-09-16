package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayHist;

public interface IPlayHistDao extends IBaseDao<PlayHist, PlayHist> {
	
	public List<MyTitle> selectTitlesOnlyPlay(Long memNum);

	public List<MyTitle> selectTitlesWithPlay(Long memNum);
}
