package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.IAuthorityMstDao;
import com.gameif.backoffice.entity.AuthorityMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class AuthorityMstDaoImpl extends
		AbstractBaseDao<AuthorityMst, AuthorityMst> implements IAuthorityMstDao {

	@Override
	public Integer selectAuthorityByCode(String code) {

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectAuthorityByCode", code));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorityMst> selectAuthorityList(AuthorityMst authorityMst) {

		return (List<AuthorityMst>) (getSqlMapClientTemplate().queryForList(
				namespace + ".selectAuthorityList", authorityMst));
	}

	@Override
	public Integer deleteByAuthorityCode(String code) {

		return getSqlMapClientTemplate().delete(
				namespace + ".deleteByAuthorityCode", code);
	}

}
