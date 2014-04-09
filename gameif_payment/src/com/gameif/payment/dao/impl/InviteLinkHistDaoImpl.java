package com.gameif.payment.dao.impl;

import java.util.HashMap;
import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IInviteLinkHistDao;
import com.gameif.payment.entity.InviteLinkHist;
import com.gameif.payment.entity.MyInviteLink;

public class InviteLinkHistDaoImpl extends AbstractBaseDao<InviteLinkHist, InviteLinkHist> implements IInviteLinkHistDao {

	/**
	 * 子の会員番号より、招待情報を検索する
	 * @param childMemNum 子の会員番号
	 */
	@Override
	public InviteLinkHist selectParentByChildNum(Long childMemNum) {

		return (InviteLinkHist) (getSqlMapClientTemplate().queryForObject(namespace + ".selectParentByChildNum", childMemNum));
	}

	/**
	 * 会員番号より、該当会員がリンクで招待した友達を検索する
	 * @param memNum 会員番号
	 * @return 友達リスト
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<MyInviteLink> selectLinkMembersByMemNum(Long memNum) {
		return (List<MyInviteLink>) (getSqlMapClientTemplate().queryForList(namespace + ".selectLinkMembersByMemNum", memNum));
	}

	@SuppressWarnings("unchecked")
	@Override
	public InviteLinkHist selectForUpdate(Long memNum, Long childMemNum) {
		
		HashMap params = new HashMap();
		params.put("memNum", memNum);
		params.put("childMemNum", childMemNum);

		return (InviteLinkHist) (getSqlMapClientTemplate().queryForObject(namespace + ".selectForUpdate", params));
	}

}
