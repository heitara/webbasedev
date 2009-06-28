package com.gameif.common.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.gameif.common.dao.IBaseDao;



public abstract class AbstractBaseDao<T, PK extends Serializable> extends
		SqlMapClientDaoSupport implements IBaseDao<T, PK> {

	protected String namespace;

	/**
	 * @param namespace
	 *            the namespace to set
	 */
	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	@SuppressWarnings("unchecked")
	public T selectByKey(PK pk) {
		return (T) getSqlMapClientTemplate().queryForObject(
				namespace + ".selectByKey", pk);
	}
	@SuppressWarnings("unchecked")
	public List<T> selectAll(PK pk) {
		return getSqlMapClientTemplate().queryForList(namespace + ".selectAll",
				pk);
	}

	public int update(PK pk) {
		return getSqlMapClientTemplate().update(namespace + ".update", pk);
	}

	public void save(PK pk) {
		getSqlMapClientTemplate().insert(namespace + ".save", pk);
	}
}
