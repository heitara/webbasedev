package com.gameif.portal.dao;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.MemberLoginInfo;

public interface IMemberLoginInfoDao extends IBaseDao<MemberLoginInfo, MemberLoginInfo> {
	
	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * @param searchCondition
	 * @return
	 */
	public int selectCountByIPAndTime(ComSearchCondition searchCondition);
	
	/**
	 * パスワードを更新する
	 * @param memberLoginInfo
	 * @return
	 */
	public int updatePwd(MemberLoginInfo memberLoginInfo);

}
