package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.InviteLinkHist;
import com.gameif.payment.entity.MyInviteLink;

public interface IInviteLinkHistDao extends IBaseDao<InviteLinkHist, InviteLinkHist> {
	
	public InviteLinkHist selectParentByChildNum(Long childMemNum);
	
	/**
	 * 会員番号より、該当会員がリンクで招待した友達を検索する
	 * @param memNum 会員番号
	 * @return 友達リスト
	 */
	public List<MyInviteLink> selectLinkMembersByMemNum(Long memNum);
	
	public InviteLinkHist selectForUpdate(Long memNum, Long childMemNum);

}
