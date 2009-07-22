package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {
	/**
	 * 
	 * @param memberInfo
	 * @return
	 */
	public int updatePwd(MemberInfo memberInfo);

}
