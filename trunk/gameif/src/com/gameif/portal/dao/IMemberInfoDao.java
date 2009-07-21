package com.gameif.portal.dao;

import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberInfo;

public interface IMemberInfoDao extends IBaseDao<MemberInfo, MemberInfo> {
	/**
	 * パースワードの変更
	 * 
	 * @param memberInfo
	 *            会員情報
	 * @return 変更結果
	 */
	public int updatePwd(MemberInfo memberInfo);

}
