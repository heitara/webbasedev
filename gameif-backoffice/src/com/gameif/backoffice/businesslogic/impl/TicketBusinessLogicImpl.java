package com.gameif.backoffice.businesslogic.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.backoffice.businesslogic.ITicketBusinessLogic;
import com.gameif.backoffice.dao.IMemberInfoDao;
import com.gameif.backoffice.dao.ITicketGiveHistDao;
import com.gameif.backoffice.dao.ITicketInfoDao;
import com.gameif.backoffice.dao.ITicketMstDao;
import com.gameif.backoffice.entity.MemberInfo;
import com.gameif.backoffice.entity.TicketGiveHist;
import com.gameif.backoffice.entity.TicketInfo;
import com.gameif.backoffice.entity.TicketMst;
import com.gameif.backoffice.util.ContextUtil;
import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.DataNotExistsException;
import com.gameif.common.exception.LogicException;

public class TicketBusinessLogicImpl extends BaseBusinessLogic implements ITicketBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4822092852605111942L;
	
	private ITicketMstDao ticketMstDao;
	private IMemberInfoDao memberInfoDao;
	private ITicketGiveHistDao ticketGiveHistDao;
	private ITicketInfoDao ticketInfoDao;

	@Override
	public List<TicketMst> getTicketListByTitleId(Integer titleId) {
		return ticketMstDao.selectTicketListByTitleId(titleId);
	}

	@Transactional
	@Override
	public void giveTicket(TicketGiveHist ticketGiveHist, String memId) throws LogicException {

		TicketMst ticket = new TicketMst();
		ticket.setTicketId(ticketGiveHist.getTicketId());
		ticket = ticketMstDao.selectByKey(ticket);
		if (ticket == null) {

			// データが存在しない
			throw new DataNotExistsException("TicketInfo Data does not exist.");
		}
		
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
		
		String[] memberList = memId.split(",");

		TicketGiveHist newGivehist = null;
		TicketInfo ticketInfo = null;
		MemberInfo member = null;
		
		for (int i = 0; i < memberList.length; i++) {
			member = memberInfoDao.selectByMemId(memberList[i]);
			if (member == null) {
				continue;
			}
			ticketInfo = ticketInfoDao.selectForUpdate(member.getMemNum(), ticketGiveHist.getTicketId());
			if (ticketInfo == null) {
				
				ticketInfo = new TicketInfo();
				
				ticketInfo.setMemNum(member.getMemNum());
				ticketInfo.setTicketId(ticketGiveHist.getTicketId());
				ticketInfo.setTicketStartDate(startDate);
				ticketInfo.setTicketEndDate(endDate);
				ticketInfo.setTicketCount(ticketGiveHist.getTicketCount());
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
					ticketInfo.setTicketCount(ticketGiveHist.getTicketCount());
					
				} else {

					// 残高　＝　元の枚数　+　今回の枚数
					ticketInfo.setTicketCount(ticketInfo.getTicketCount() + ticketGiveHist.getTicketCount());
				}
				
				ticketInfo.setTicketEndDate(endDate);
				ticketInfo.setLastUpdateDate(now);
				ticketInfo.setLastUpdateUser(ContextUtil.getUserId());
				// チケット残高情報を更新する
				ticketInfoDao.update(ticketInfo);
			}
			
			newGivehist = new TicketGiveHist();
			newGivehist.setMemNum(member.getMemNum());
			newGivehist.setTicketId(ticketGiveHist.getTicketId());
			newGivehist.setTicketTypeCd(ticketGiveHist.getTicketTypeCd());
			newGivehist.setTicketGiveDate(now);
			newGivehist.setTicketStartDate(startDate);
			newGivehist.setTicketEndDate(endDate);
			newGivehist.setTicketCount(ticketGiveHist.getTicketCount());
			newGivehist.setCreatedDate(now);
			newGivehist.setCreatedUser(ContextUtil.getUserId());
			newGivehist.setLastUpdateDate(now);
			newGivehist.setLastUpdateUser(ContextUtil.getUserId());
			
			// チケット付与履歴を登録する
			ticketGiveHistDao.save(newGivehist);
			
		}
		
	}

	/**
	 * @param ticketMstDao the ticketMstDao to set
	 */
	public void setTicketMstDao(ITicketMstDao ticketMstDao) {
		this.ticketMstDao = ticketMstDao;
	}

	/**
	 * @param memberInfoDao the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
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
	
}
