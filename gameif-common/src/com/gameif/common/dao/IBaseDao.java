package com.gameif.common.dao;

import java.io.Serializable;
import java.util.List;

public interface IBaseDao<T, PK extends Serializable> {

	public T selectByKey(PK pk);
	
	public List<T> selectAll(PK pk);

	public int update(PK pk);

	public void save(PK pk);
}
