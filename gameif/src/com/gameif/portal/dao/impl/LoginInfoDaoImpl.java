package com.gameif.portal.dao.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.ILoginInfoDao;
import com.gameif.portal.entity.LoginInfo;

public class LoginInfoDaoImpl extends AbstractBaseDao<LoginInfo, LoginInfo>
		implements ILoginInfoDao {

	public int updatePwd(LoginInfo loginInfo) {
		return this.getSqlMapClientTemplate().update(namespace + ".updatePwd",
				loginInfo);
	}

}
