package com.gameif.backoffice.dao;

import java.util.List;

import com.gameif.backoffice.entity.AuthorityMst;
import com.gameif.common.dao.IBaseDao;

public interface IAuthorityMstDao extends IBaseDao<AuthorityMst, AuthorityMst> {
	
	public Integer selectAuthorityByCode(String code);
	public List<AuthorityMst> selectAuthorityList(AuthorityMst authorityMst);
	public Integer deleteByAuthorityCode(String code);

}
