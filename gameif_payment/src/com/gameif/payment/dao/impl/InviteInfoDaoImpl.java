package com.gameif.payment.dao.impl;

import java.util.List;

import com.gameif.common.bean.ComSearchCondition;
import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IInviteInfoDao;
import com.gameif.payment.entity.InviteInfo;

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

	/**
	 * 会員番号により、一定時間内無効なデータを削除する
	 * @param memNum 会員番号
	 * @param days 削除期間を指定する
	 */
	@Override
	public int deleteInvalidInvite(Long memNum, int days) {
		ComSearchCondition cond = new ComSearchCondition();
		cond.setMemNum(memNum);
		cond.setDays(days);

		return getSqlMapClientTemplate().delete(
				namespace + ".deleteInvalidInvite", cond);
	}

	/**
	 * 一定時間内招待人数を計算する
	 * @param inviteInfo 招待情報
	 */
	@Override
	public int selectCountByMemNumInTime(InviteInfo inviteInfo) {

		return (Integer) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectCountByMemNumInTime", inviteInfo));
	}

	/**
	 * 招待情報を検索する（For Update）
	 * @param inviteId 招待情報ID
	 */
	@Override
	public InviteInfo selectForUpdate(Long inviteId) {

		return (InviteInfo) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectForUpdate", inviteId));
	}

	/**
	 * 子の会員番号より、招待情報を検索する
	 * @param childMemNum 子の会員番号
	 */
	@Override
	public InviteInfo selectParentByChildNum(Long childMemNum) {

		return (InviteInfo) (getSqlMapClientTemplate().queryForObject(namespace
				+ ".selectParentByChildNum", childMemNum));
	}

}
