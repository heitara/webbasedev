package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {
	/**
	 * �ѩ`����`�ɤΉ��
	 * 
	 * @param memberInfo
	 *            ��T���
	 * @return ����Y��
	 */
	public int updatePwd(MemberInfo memberInfo);

}
