package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.AuthorityDetailMst;
import com.gameif.common.dao.IBaseDao;

public interface IAuthorityDetailMstDao extends IBaseDao<AuthorityDetailMst, AuthorityDetailMst> {
	
	public List<AuthorityDetailMst> selectListByAuthorityCode(String code);
	
	public Integer deleteByAuthorityCode(String code);

}
