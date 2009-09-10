package com.gameif.portal.dao.impl;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.entity.MemberInfo;

public class MemberInfoDaoImpl extends AbstractBaseDao<MemberInfo, MemberInfo> implements IMemberInfoDao {

	@Override
	public MemberInfo selectForUpdate(Long memNum) {

		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", memNum));
	}

	/**
	 * 同じIPで指定時間内に、会員連続登録回数を計算する
	 * @param searchCondition
	 * @return
	 */
	@Override
	public int selectCountByIPAndTime(ComSearchCondition searchCondition) {
		
		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByIPAndTime", searchCondition));
	}
	
	/**
	 * アカウントＩＤで会員情報を検索する。
	 * @param memId
	 * @return MemberInfo
	 */
	@Override
	public MemberInfo selectByMemId(String memId) {
		
		return (MemberInfo) (getSqlMapClientTemplate().queryForObject(namespace + ".selectByMemId", memId));
	}
	
	/**
	 * 指定したアカウントＩＤの件数を検索する。
	 * @param memId
	 * @return
	 */
	@Override
	public int selectCountByMemId(String memId) {
		
		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByMemId", memId));
	}
	
	/**
	 * 指定したニックネームの件数を検索する。
	 * @param nickName
	 * @return
	 */
	@Override
	public int selectCountByNickName(String nickName) {
		
		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByNickName", nickName));
	}
	
	/**
	 * 指定したパソコンメールの件数を検索する。
	 * @param searchCondition
	 * @return
	 */
	@Override
	public int selectCountByMailPc(String mailPc) {
		
		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace + ".selectCountByMailPc", mailPc));
	}

}
