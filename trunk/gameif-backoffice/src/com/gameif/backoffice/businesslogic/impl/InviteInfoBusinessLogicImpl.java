package com.gameif.backoffice.businesslogic.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.bean.InviteSearchCondition;
import com.gameif.backoffice.businesslogic.IInviteInfoBusinessLogic;
import com.gameif.backoffice.constants.BackofficeConstants;
import com.gameif.backoffice.dao.IInviteInfoDao;
import com.gameif.backoffice.dao.IInviteLinkHistDao;
import com.gameif.backoffice.dao.ITicketGiveHistDao;
import com.gameif.backoffice.dao.ITicketInfoDao;
import com.gameif.backoffice.dao.ITicketMstDao;
import com.gameif.backoffice.entity.InviteInfo;
import com.gameif.backoffice.entity.InviteLinkHist;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.MyInviteInfo;
import com.gameif.backoffice.entity.TicketGiveHist;
import com.gameif.backoffice.entity.TicketInfo;
import com.gameif.backoffice.entity.TicketMst;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;

public class InviteInfoBusinessLogicImpl extends BaseBusinessLogic implements
		IInviteInfoBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4552302959458757976L;

	private IInviteInfoDao inviteInfoDao;
	private IInviteLinkHistDao inviteLinkHistDao;
	private ITicketGiveHistDao ticketGiveHistDao;
	private ITicketInfoDao ticketInfoDao;
	private ITicketMstDao ticketMstDao;

	@Override
	public List<MemberInfo> getInviteList(InviteSearchCondition inviteSearchCondition) {
		return inviteLinkHistDao.selectInviteList(inviteSearchCondition);
	}

	@Transactional
	@Override
	public void updateInviteInfo(List<Long> inviteKeyList, String approveStatus) {
		
		InviteInfo inviteInfo = null;
		
		InviteLinkHist inviteLinkHist = null;
		Date now = new Date();
		
		for (int i = 0; i < inviteKeyList.size(); i++) {
			
			inviteInfo = new InviteInfo();
			inviteInfo.setMemNum(inviteKeyList.get(i));
			inviteInfo.setApproveStatus(approveStatus);
			inviteInfo.setLastUpdateUser(ContextUtil.getUserId());
			inviteInfo.setLastUpdateDate(now);
			
			inviteInfoDao.updateApproveStatusByMemNum(inviteInfo);
			
			inviteLinkHist = new InviteLinkHist();
			inviteLinkHist.setMemNum(inviteKeyList.get(i));
			inviteLinkHist.setApproveStatus(approveStatus);
			
			inviteLinkHistDao.updateApproveStatusByMemNum(inviteLinkHist);
			
		}
	}
	
	@Transactional
	@Override
	public void updateInviteInfoWithMemNum(List<Long> inviteInfoList, List<Long> inviteLinkList, String approveStatus, Long memNum) {
		// メールで紹介する情報を「承認・却下」する
		InviteInfo inviteInfo = null;
		Date now = new Date();
		
		if (inviteInfoList != null) {
			for (int i = 0; i < inviteInfoList.size(); i++) {
				
				inviteInfo = new InviteInfo();
				inviteInfo.setMemNum(memNum);
				inviteInfo.setChildMemNum(inviteInfoList.get(i));
				inviteInfo.setApproveStatus(approveStatus);
				inviteInfo.setLastUpdateUser(ContextUtil.getUserId());
				inviteInfo.setLastUpdateDate(now);
				
				inviteInfoDao.updateApproveStatus(inviteInfo);
				
			}
		}

		// リンクで紹介する情報を「承認・却下」する
		InviteLinkHist inviteLinkHist = null;
		
		if (inviteLinkList != null) {
			for (int i = 0; i < inviteLinkList.size(); i++) {
				
				inviteLinkHist = new InviteLinkHist();
				inviteLinkHist.setMemNum(memNum);
				inviteLinkHist.setChildMemNum(inviteLinkList.get(i));
				inviteLinkHist.setApproveStatus(approveStatus);
				
				inviteLinkHistDao.updateApproveStatus(inviteLinkHist);
				
			}
		}
	}

	/**
	 * 会員番号より、該当会員がリンクで招待した友達を検索する
	 * @param memNum 会員番号
	 * @return 友達リスト
	 */
	@Override
	public List<MyInviteInfo> selectLinkMembersByMemNum(Long memNum) {
		return inviteLinkHistDao.selectLinkMembersByMemNum(memNum);
	}

	/**
	 * 紹介者IDより、友達紹介履歴を取得する。
	 * 
	 * @param inviteStatus
	 */
	@Override
	public List<MyInviteInfo> selectInviteHistByMemNum(Long memNum) {

		return inviteInfoDao.selectInviteHistByMemNum(memNum);
	}

	@Transactional
	@Override
	public void giveTicket(List<Long> inviteKeyList) {
		List<InviteInfo> inviteRewardedList = null;
		InviteInfo inviteInfo = null;
		
		List<InviteLinkHist> inviteLinkRewardedList = null;
		InviteLinkHist inviteLinkHist = null;
		
		Date now = new Date();

		TicketMst ticket = new TicketMst();
		ticket.setTicketId(1);
		ticket = ticketMstDao.selectByKey(ticket);
		if (ticket == null) {
			return;
		}

		TicketMst ticketRandom = new TicketMst();
		ticketRandom.setTicketId(3);
		ticketRandom = ticketMstDao.selectByKey(ticketRandom);
		if (ticketRandom == null) {
			return;
		}
		
		for (int i = 0; i < inviteKeyList.size(); i++) {
			Integer rewardedCount = 0;
			Integer bonusCount = 0;
			Integer bonusInviteCnt = 0;
			Integer bonusInviteLinkCnt = 0;
			Integer inviteRest = 0;
			Integer inviteLinkRest = 0;
			
			inviteInfo = new InviteInfo();
			inviteInfo.setMemNum(inviteKeyList.get(i));
			inviteInfo.setApproveStatus(BackofficeConstants.ApproveStatus.REWARDED);
			inviteInfo.setLastUpdateDate(now);
			inviteInfo.setLastUpdateUser(ContextUtil.getUserId());
			rewardedCount = inviteInfoDao.updateRewardedStatus(inviteInfo);
			
			rewardedCount = rewardedCount + inviteLinkHistDao.updateRewardedStatus(inviteKeyList.get(i));
			
			// 定の100PTのチケットを付与する
			updateTicketInfo(rewardedCount, ticket, inviteKeyList.get(i));
			
			// メールで紹介する情報
			inviteRewardedList = inviteInfoDao.selectRewardedListForUpdate(inviteKeyList.get(i));
			if (inviteRewardedList != null && inviteRewardedList.size() > 0) {
				bonusInviteCnt = inviteRewardedList.size() / 5;
				inviteRest = inviteRewardedList.size() % 5;
				
				for (int j = 0; j < bonusInviteCnt; j++){
					for(int k = 0; k < 5 ; k++){
						inviteInfo = inviteRewardedList.get(j*5 + k);
						inviteInfo.setApproveStatus(BackofficeConstants.ApproveStatus.BONUS_REWARDED);
						inviteInfo.setLastUpdateDate(now);
						inviteInfo.setLastUpdateUser(ContextUtil.getUserId());
						inviteInfoDao.update(inviteInfo);
					}
				}
			}
			
			// リンクで紹介する情報
			inviteLinkRewardedList = inviteLinkHistDao.selectRewardedListForUpdate(inviteKeyList.get(i));
			if (inviteRewardedList != null && inviteRewardedList.size() > 0) {
				bonusInviteLinkCnt = inviteLinkRewardedList.size() / 5;
				inviteLinkRest = inviteLinkRewardedList.size() % 5;
				
				for (int j = 0; j < bonusInviteLinkCnt; j++){
					for(int k = 0; k < 5 ; k++){
						inviteLinkHist = inviteLinkRewardedList.get(j*5 + k);
						inviteLinkHist.setApproveStatus(BackofficeConstants.ApproveStatus.BONUS_REWARDED);
						inviteLinkHistDao.update(inviteLinkHist);
					}
				}
			}
			bonusCount = bonusInviteCnt + bonusInviteLinkCnt;
			
			if (inviteRest + inviteLinkRest > 5) {
				bonusCount = bonusCount + 1;
				
				for (int cnt = 1; cnt <= inviteRest; cnt++ ) {
					inviteInfo = inviteRewardedList.get(bonusInviteCnt * 5 -1 + cnt);
					inviteInfo.setApproveStatus(BackofficeConstants.ApproveStatus.BONUS_REWARDED);
					inviteInfo.setLastUpdateDate(now);
					inviteInfo.setLastUpdateUser(ContextUtil.getUserId());
					inviteInfoDao.update(inviteInfo);
				}
				
				for (int j = 1; j <= (5 - inviteRest); j++) {
					inviteLinkHist = inviteLinkRewardedList.get(bonusInviteLinkCnt * 5 - 1 + j);
					inviteLinkHist.setApproveStatus(BackofficeConstants.ApproveStatus.BONUS_REWARDED);
					inviteLinkHistDao.update(inviteLinkHist);
				}
			}
			
			if (bonusCount > 0) {
				
				// 運の150PTのチケットを付与する
				updateTicketInfo(bonusCount, ticketRandom, inviteKeyList.get(i));
				
			}
		}
		
	}
	
	/**
	 * チケット残高情報を更新する
	 * @param rewardedCount
	 * @param ticket
	 * @param memNum
	 */
	private void updateTicketInfo(Integer rewardedCount, TicketMst ticket, Long memNum) {
		
		Date now = new Date();
		Date startDate = new Date();
		Date endDate = new Date();
		
		// 失効期間を計算する
		// 開始日時
		Calendar cStart = Calendar.getInstance();
		cStart.setTime(now);
		cStart.add(Calendar.DATE, ticket.getDelayDays());
		startDate = cStart.getTime();
		// 終了日時
		Calendar cEnd = Calendar.getInstance();
		cEnd.setTime(now);
		cEnd.add(Calendar.DATE, ticket.getValidDays());
		endDate = cEnd.getTime();
		
		TicketGiveHist newGivehist = null;
		TicketInfo ticketInfo = null;
		ticketInfo = ticketInfoDao.selectForUpdate(memNum, ticket.getTicketId());
		if (ticketInfo == null) {
			
			ticketInfo = new TicketInfo();
			
			ticketInfo.setMemNum(memNum);
			ticketInfo.setTicketId(ticket.getTicketId());
			ticketInfo.setTicketStartDate(startDate);
			ticketInfo.setTicketEndDate(endDate);
			ticketInfo.setTicketCount(rewardedCount);
			ticketInfo.setCreatedDate(now);
			ticketInfo.setCreatedUser(ContextUtil.getUserId());
			ticketInfo.setLastUpdateDate(now);
			ticketInfo.setLastUpdateUser(ContextUtil.getUserId());

			// チケット残高情報を登録する
			ticketInfoDao.save(ticketInfo);
		} else {
			// 既に期限切れ
			if (now.compareTo(ticketInfo.getTicketEndDate()) > 0) {
				
				ticketInfo.setTicketStartDate(startDate);
				// 残高　＝　今回の枚数
				ticketInfo.setTicketCount(rewardedCount);
				
			} else {

				// 残高　＝　元の枚数　+　今回の枚数
				ticketInfo.setTicketCount(ticketInfo.getTicketCount() + rewardedCount);
			}
			
			ticketInfo.setTicketEndDate(endDate);
			ticketInfo.setLastUpdateDate(now);
			ticketInfo.setLastUpdateUser(ContextUtil.getUserId());
			// チケット残高情報を更新する
			ticketInfoDao.update(ticketInfo);
		}
		
		newGivehist = new TicketGiveHist();
		newGivehist.setMemNum(memNum);
		newGivehist.setTicketId(ticket.getTicketId());
		newGivehist.setTicketTypeCd(1);
		newGivehist.setTicketGiveDate(now);
		newGivehist.setTicketStartDate(startDate);
		newGivehist.setTicketEndDate(endDate);
		newGivehist.setTicketCount(rewardedCount);
		newGivehist.setCreatedDate(now);
		newGivehist.setCreatedUser(ContextUtil.getUserId());
		newGivehist.setLastUpdateDate(now);
		newGivehist.setLastUpdateUser(ContextUtil.getUserId());
		
		// チケット付与履歴を登録する
		ticketGiveHistDao.save(newGivehist);
	}

	/**
	 * @param inviteInfoDao
	 *            the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @param inviteLinkHistDao
	 *            the inviteLinkHistDao to set
	 */
	public void setInviteLinkHistDao(IInviteLinkHistDao inviteLinkHistDao) {
		this.inviteLinkHistDao = inviteLinkHistDao;
	}

	/**
	 * @param ticketGiveHistDao the ticketGiveHistDao to set
	 */
	public void setTicketGiveHistDao(ITicketGiveHistDao ticketGiveHistDao) {
		this.ticketGiveHistDao = ticketGiveHistDao;
	}

	/**
	 * @param ticketInfoDao the ticketInfoDao to set
	 */
	public void setTicketInfoDao(ITicketInfoDao ticketInfoDao) {
		this.ticketInfoDao = ticketInfoDao;
	}

	/**
	 * @param ticketMstDao the ticketMstDao to set
	 */
	public void setTicketMstDao(ITicketMstDao ticketMstDao) {
		this.ticketMstDao = ticketMstDao;
	}

}
