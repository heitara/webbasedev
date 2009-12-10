package com.gameif.portal.businesslogic.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.OutOfDateException;
import com.gameif.common.helper.TemplateMailer;
import com.gameif.portal.businesslogic.ITicketBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IServicePointDao;
import com.gameif.portal.dao.IServicePointGiveHistDao;
import com.gameif.portal.dao.ITicketGiveHistDao;
import com.gameif.portal.dao.ITicketInfoDao;
import com.gameif.portal.dao.ITicketModelDetailDao;
import com.gameif.portal.dao.ITicketModelMstDao;
import com.gameif.portal.dao.ITicketUseHistDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.MyTicket;
import com.gameif.portal.entity.MyTicketGiveHist;
import com.gameif.portal.entity.MyTicketUseHist;
import com.gameif.portal.entity.ServicePoint;
import com.gameif.portal.entity.ServicePointGiveHist;
import com.gameif.portal.entity.TicketInfo;
import com.gameif.portal.entity.TicketModelMst;
import com.gameif.portal.entity.TicketUseHist;
import com.gameif.portal.util.ContextUtil;

public class TicketBusinessLogicImpl extends BaseBusinessLogic implements
		ITicketBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1582545586364815483L;
	
	private final static Log logger = LogFactory.getLog(ServicePointBusinessLogicImpl.class);

	private ITicketInfoDao ticketInfoDao;
	private ITicketUseHistDao ticketUseHistDao;
	private ITicketModelMstDao ticketModelMstDao;
	private ITicketModelDetailDao ticketModelDetailDao;
	private IServicePointDao servicePointDao;
	private IServicePointGiveHistDao servicePointGiveHistDao;
	private ITitleMstDao titleMstDao;
	private TemplateMailer templateMailer;
	private ITicketGiveHistDao ticketGiveHistDao;
	
	// 有効期間
	private Integer validDays;

	/**
	 * チケット情報を検索する
	 */
	@Override
	public List<MyTicket> getMyTicketList() {
		return ticketInfoDao.selectMyTicketList(ContextUtil.getMemberNo());
	}

	@Override
	public void useTicket(Integer ticketId, Integer titleId) throws LogicException {
		
		// 今回取得できるポイントを計算する
		BigDecimal actPointAmount = getActPoint(ticketId);
		// チケット情報を更新する
		updateTicketInfo(ticketId, actPointAmount, titleId);
	}
	
	@Transactional
	private void updateTicketInfo(Integer ticketId, BigDecimal actPointAmount, Integer titleId) throws LogicException {
		TicketInfo ticketInfo = ticketInfoDao.selectForUpdate(ContextUtil.getMemberNo(), ticketId);
		if (ticketInfo == null) {
			// データが存在しない
			throw new OutOfDateException("TicketInfo Data does not exist.");
		}
		
		Date now = new Date();
		
		ticketInfo.setTicketCount(ticketInfo.getTicketCount() - 1);
		ticketInfo.setLastUpdateDate(now);
		ticketInfo.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		// チケット残高情報を更新する
		ticketInfoDao.update(ticketInfo);
		
		TicketUseHist ticketUseHist = new TicketUseHist();
		ticketUseHist.setMemNum(ContextUtil.getMemberNo());
		ticketUseHist.setTicketId(ticketInfo.getTicketId());
		ticketUseHist.setTicketUseDate(now);
		ticketUseHist.setTicketStartDate(ticketInfo.getTicketStartDate());
		ticketUseHist.setTicketEndDate(ticketInfo.getTicketEndDate());
		ticketUseHist.setTicketCount(1);
		ticketUseHist.setPointAmount(actPointAmount);
		ticketUseHist.setCreatedDate(now);
		ticketUseHist.setCreatedUser(ContextUtil.getMemberNo().toString());
		ticketUseHist.setLastUpdateDate(now);
		ticketUseHist.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		// チケット使用履歴を登録する
		ticketUseHistDao.save(ticketUseHist);
		
		// サービスポイントを計算する
		updateServicePoint(actPointAmount, titleId, now);

		try {
			// 招待メールを送信する。
			HashMap<String, String> props = new HashMap<String, String>();
			// 名前
			props.put("nickName", ContextUtil.getNickName());
			// ゲーム
			props.put("titleName", titleMstDao.selectNameById(titleId));
			// データID
			props.put("point", actPointAmount.toString());
			// 送信
			templateMailer.sendAsyncMail(ContextUtil.getMemberInfo().getMailPc(), "presentServicePoint", props, true);
		} catch (Exception ex) {
			logger.error("error has occurred in sending presentServicePoint mail. ", ex);
		}
		
	}
	
	/**
	 * 現時点で、ポイントの平均値を計算する
	 * @return
	 */
	private BigDecimal getActPoint(Integer ticketId) {
		BigDecimal actPointAmount = new BigDecimal(0);
		// 現時点で、ポイントの平均値を計算する
		BigDecimal avgPoint = ticketUseHistDao.selectAvgPoint(ticketId);
		if (avgPoint.compareTo(new BigDecimal(1)) < 0) {
			avgPoint = new BigDecimal(0.1);
		}
		// 現時点で使う
		TicketModelMst model = ticketModelMstDao.selectByAvgPoint(ticketId, avgPoint);
		
		// 人数合計を計算する
		Integer personCount = ticketModelDetailDao.selectSumPersonCount(model);
		// ランダム値を取得する（0～人数）
		Integer randomCount = (int)(Math.random() * personCount);
		// 今回取得できるポイントを検索する
		actPointAmount = ticketModelDetailDao.selectActpoint(model, randomCount);
		
		return actPointAmount;
	}
	
	/**
	 * サービスポイント残高とサービスポイント付与履歴を登録する
	 * @param actPointAmount
	 * @param titleId
	 * @param now
	 */
	private void updateServicePoint(BigDecimal actPointAmount, Integer titleId, Date now) {

		Date pointEndDate = new Date();
		// 失効期間を計算する
		Calendar c = Calendar.getInstance();
		c.setTime(now);
		c.add(Calendar.DATE, validDays);
		pointEndDate = c.getTime();
		
		ServicePoint servicePoint = new ServicePoint();
		servicePoint.setMemNum(ContextUtil.getMemberNo());
		servicePoint.setTitleId(titleId);
		
		servicePoint = servicePointDao.selectForUpdate(servicePoint);
		
		if (servicePoint == null) {

			servicePoint = new ServicePoint();

			servicePoint.setMemNum(ContextUtil.getMemberNo());
			servicePoint.setPointEndDate(pointEndDate);
			servicePoint.setTitleId(titleId);
			servicePoint.setPointAmount(actPointAmount);
			servicePoint.setCreatedDate(now);
			servicePoint.setCreatedUser(ContextUtil.getMemberNo().toString());
			servicePoint.setLastUpdateDate(now);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());

			// サービスポイント残高テーブルに登録する
			servicePointDao.save(servicePoint);
			
		} else {
			// 既に期限切れました
			if (now.compareTo(servicePoint.getPointEndDate()) > 0) {
				// 残高 = 今回のポイント数
				servicePoint.setPointAmount(actPointAmount);
			} else {
				// 残高 = 元の残高 + 今回のポイント数
				servicePoint.setPointAmount(servicePoint.getPointAmount().add(actPointAmount));
			}
			servicePoint.setPointEndDate(pointEndDate);
			servicePoint.setLastUpdateDate(now);
			servicePoint.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			
			// 残高を更新する
			servicePointDao.update(servicePoint);
		}
		
		ServicePointGiveHist servicePointGiveHist = new ServicePointGiveHist();
		
		servicePointGiveHist.setMemNum(ContextUtil.getMemberNo());
		servicePointGiveHist.setServicePointTypeId(null);
		servicePointGiveHist.setServicePointTypeCd(PortalConstants.ServicePointTypeCd.TICKET);
		servicePointGiveHist.setTitleId(titleId);
		servicePointGiveHist.setGiveDate(now);
		servicePointGiveHist.setPointEndDate(pointEndDate);
		servicePointGiveHist.setPointAmount(actPointAmount);
		servicePointGiveHist.setCreatedDate(now);
		servicePointGiveHist.setCreatedUser(ContextUtil.getMemberNo().toString());
		servicePointGiveHist.setLastUpdateDate(now);
		servicePointGiveHist.setLastUpdateUser(ContextUtil.getMemberNo().toString());
		
		//　ポイント付与履歴を登録する
		servicePointGiveHistDao.save(servicePointGiveHist);
		
	}

	@Override
	public List<MyTicketGiveHist> getMyGiveHistList() {
		return ticketGiveHistDao.selectMyGiveHistList(ContextUtil.getMemberNo());
	}

	@Override
	public List<MyTicketUseHist> getMyUseHistList() {
		return ticketUseHistDao.selectMyUseHistList(ContextUtil.getMemberNo());
	}

	/**
	 * @param ticketInfoDao
	 *            the ticketInfoDao to set
	 */
	public void setTicketInfoDao(ITicketInfoDao ticketInfoDao) {
		this.ticketInfoDao = ticketInfoDao;
	}

	/**
	 * @param ticketUseHistDao the ticketUseHistDao to set
	 */
	public void setTicketUseHistDao(ITicketUseHistDao ticketUseHistDao) {
		this.ticketUseHistDao = ticketUseHistDao;
	}

	/**
	 * @param ticketModelMstDao the ticketModelMstDao to set
	 */
	public void setTicketModelMstDao(ITicketModelMstDao ticketModelMstDao) {
		this.ticketModelMstDao = ticketModelMstDao;
	}

	/**
	 * @param ticketModelDetailDao the ticketModelDetailDao to set
	 */
	public void setTicketModelDetailDao(ITicketModelDetailDao ticketModelDetailDao) {
		this.ticketModelDetailDao = ticketModelDetailDao;
	}

	/**
	 * @param servicePointDao the servicePointDao to set
	 */
	public void setServicePointDao(IServicePointDao servicePointDao) {
		this.servicePointDao = servicePointDao;
	}

	/**
	 * @param servicePointGiveHistDao the servicePointGiveHistDao to set
	 */
	public void setServicePointGiveHistDao(
			IServicePointGiveHistDao servicePointGiveHistDao) {
		this.servicePointGiveHistDao = servicePointGiveHistDao;
	}

	/**
	 * @param titleMstDao the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	/**
	 * @param ticketGiveHistDao the ticketGiveHistDao to set
	 */
	public void setTicketGiveHistDao(ITicketGiveHistDao ticketGiveHistDao) {
		this.ticketGiveHistDao = ticketGiveHistDao;
	}

	/**
	 * @param templateMailer the templateMailer to set
	 */
	public void setTemplateMailer(TemplateMailer templateMailer) {
		this.templateMailer = templateMailer;
	}

	/**
	 * @return the validDays
	 */
	public Integer getValidDays() {
		return validDays;
	}

	/**
	 * @param validDays the validDays to set
	 */
	public void setValidDays(Integer validDays) {
		this.validDays = validDays;
	}
	
}
