package com.gameif.backoffice.dao.impl;

import java.util.List;

import com.gameif.backoffice.dao.IAuthorityDetailMstDao;
import com.gameif.backoffice.entity.AuthorityDetailMst;
import com.gameif.common.dao.impl.AbstractBaseDao;

public class AuthorityDetailMstDaoImpl extends
		AbstractBaseDao<AuthorityDetailMst, AuthorityDetailMst> implements
		IAuthorityDetailMstDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<AuthorityDetailMst> selectListByAuthorityCode(String code) {
		return (List<AuthorityDetailMst>) getSqlMapClientTemplate()
				.queryForList(namespace + ".selectListByAuthorityCode", code);
	}

	@Override
	public Integer deleteByAuthorityCode(String code) {

		return getSqlMapClientTemplate().delete(
				namespace + ".deleteByAuthorityCode", code);
	}

}
