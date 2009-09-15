package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.entity.InviteInfo;

public class InviteInfoDaoImpl extends AbstractBaseDao<InviteInfo, InviteInfo>
		implements IInviteInfoDao {

	/**
	 * 紹介者IDより、友達紹介履歴を取得する。
	 * 
	 * @param memNum
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<InviteInfo> selectInviteHistByMemNum(InviteInfo entity) {
		return (List<InviteInfo>) getSqlMapClientTemplate().queryForList(
				namespace + ".selectInviteHistByMemNum", entity);
	}

	@Override
	public int deleteInvalidInvite(Long memNum, int days) {
		ComSearchCondition cond = new ComSearchCondition();
		cond.setMemNum(memNum);
		cond.setDays(days);

		return getSqlMapClientTemplate().delete(
				namespace + ".deleteInvalidInvite", cond);
	}

}
