package com.gameif.portal.dao.login.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.login.IMemberInfoDao;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoDaoImpl extends AbstractBaseDao<MemberInfo, MemberInfo>
		implements IMemberInfoDao {

	public int updatePwd(MemberInfo memberInfo) {
		return this.getSqlMapClientTemplate().update(namespace + ".updatePwd",
				memberInfo);
	}

}
