package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.CbtTester;

public interface ICbtTesterDao extends IBaseDao<CbtTester, CbtTester> {
	
	public Integer deleteByKey(CbtTester cbtTester);

}
