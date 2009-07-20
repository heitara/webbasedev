package com.gameif.portal.dao.memberInfo.impl;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.memberInfo.IMemberInfoDao;
import com.gameif.portal.entity.memberInfo.MemberInfo;

public class MemberInfoDaoImpl extends AbstractBaseDao<MemberInfo, MemberInfo>
		implements IMemberInfoDao {

	@Override
	public int updatePwd(MemberInfo memberInfo) {
		return this.getSqlMapClientTemplate().update(namespace + ".updatePwd",
				memberInfo);
	}

}
