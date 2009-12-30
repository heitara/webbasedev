package com.gameif.portal.businesslogic.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.portal.businesslogic.ITitlePlayBusinessLogic;
import com.gameif.portal.dao.IGameLoginCountDao;
import com.gameif.portal.dao.IInviteInfoDao;
import com.gameif.portal.dao.IInviteLinkHistDao;
import com.gameif.portal.dao.IPlayGuarantyDao;
import com.gameif.portal.dao.IPlayHistDao;
import com.gameif.portal.entity.GameLoginCount;
import com.gameif.portal.entity.InviteInfo;
import com.gameif.portal.entity.InviteLinkHist;
import com.gameif.portal.entity.MyServer;
import com.gameif.portal.entity.MyTitle;
import com.gameif.portal.entity.PlayGuaranty;
import com.gameif.portal.entity.PlayHist;
import com.gameif.portal.util.ContextUtil;

public class TitlePlayBusinessLogicImpl extends BaseBusinessLogic implements ITitlePlayBusinessLogic {

	private static final long serialVersionUID = 5404743047758769861L;
	
	private IPlayHistDao playHistDao;
	private IGameLoginCountDao gameLoginCountDao;
	private IInviteInfoDao inviteInfoDao;
	private IInviteLinkHistDao inviteLinkHistDao;
	private IPlayGuarantyDao playGuarantyDao;
	
	private Integer limitDays;

	/**
	 * ゲームプレイ履歴を登録する。
	 * @param playHist
	 */
	@Transactional
	public void savePlayHist(PlayHist playHist) {

		Date playDate = new Date();
		playHist.setPlayDate(playDate);
		playHistDao.save(playHist);
		
		// 会員番号とタイトルIDにより、ゲームログイン回数情報を取得する
		GameLoginCount gameLoginCount = gameLoginCountDao.selectByKeyForUpdate(ContextUtil.getMemberNo(), playHist.getTitleId());
		if (gameLoginCount == null) {
			
			gameLoginCount = new GameLoginCount();
			
			// 会員番号
			gameLoginCount.setMemNum(ContextUtil.getMemberNo());
			// タイトルID
			gameLoginCount.setTitleId(playHist.getTitleId());
			// ログイン回数（１を設定する）
			gameLoginCount.setGameLoginCount(1);
			// ログイン日
			gameLoginCount.setLastLoginYmd(playDate);
			gameLoginCount.setCreatedUser(ContextUtil.getMemberNo().toString());
			gameLoginCount.setCreatedDate(playDate);
			gameLoginCount.setLastUpdateUser(ContextUtil.getMemberNo().toString());
			gameLoginCount.setLastUpdateDate(playDate);
			// ゲームログイン回数情報を登録する
			gameLoginCountDao.save(gameLoginCount);
			
		} else {
			
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
			// 前日の日時を取得する
			String yesterday = df.format(new Date(playDate.getTime() - 24 * 60 * 60 * 1000));
			// 同じ日にログイン回数が複数場合、一回だけを加算する
			if (0 == df.format(gameLoginCount.getLastLoginYmd()).compareTo(df.format(playDate))) {

			// 前回のログイン日時は昨日の場合、「ログイン回数 = 前回のログイン回数 + 1」
			} else if (0 == df.format(gameLoginCount.getLastLoginYmd()).compareTo(yesterday)) {
				// ログイン回数 = 前回のログイン回数 + 1
				gameLoginCount.setGameLoginCount(gameLoginCount.getGameLoginCount() + 1);
				// ログイン日
				gameLoginCount.setLastLoginYmd(playDate);
				gameLoginCount.setLastUpdateUser(ContextUtil.getMemberNo().toString());
				gameLoginCount.setLastUpdateDate(playDate);
				// ゲームログイン回数情報を更新する
				gameLoginCountDao.update(gameLoginCount);
			// 連続してゲームにログインしてない場合、ログイン回数を初期化する
			} else {
				// ログイン回数（１を設定する）
				gameLoginCount.setGameLoginCount(1);
				// ログイン日
				gameLoginCount.setLastLoginYmd(playDate);
				gameLoginCount.setLastUpdateUser(ContextUtil.getMemberNo().toString());
				gameLoginCount.setLastUpdateDate(playDate);
				// ゲームログイン回数情報を更新する
				gameLoginCountDao.update(gameLoginCount);
			}
		}
	}

	/**
	 * プレイしたことのあるゲーム一覧を取得する。
	 * @param memNum 会員番号
	 * @return プレイしたことのあるゲーム一覧
	 */
	@Override
	public List<MyTitle> getPlayedTitles(Long memNum) {
		
		return playHistDao.selectTitlesOnlyPlay(memNum);
	}

	/**
	 * ゲーム一覧をプレイ情報付で取得する。
	 * @param memNum 会員番号
	 * @return サーバ一覧
	 */
	@Override
	public List<MyTitle> getTitlesWithPlayInfo(Long memNum) {
		
		return playHistDao.selectTitlesWithPlay(memNum);
	}

	/**
	 * プレイしたことのあるサーバ一覧を取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return プレイしたことのあるサーバ一覧
	 */
	@Override
	public List<MyServer> getPlayedServers(Long memNum, Integer titleId) {
		
		return playHistDao.selectServersOnlyPlay(memNum, titleId);
	}

	/**
	 * サーバ一覧をプレイ情報付で取得する。
	 * @param memNum 会員番号
	 * @param titleId タイトルＩＤ
	 * @return サーバ一覧
	 */
	@Override
	public List<MyServer> getServersWithPlayInfo(Long memNum, Integer titleId) {
		
		return playHistDao.selectServersWithPlay(memNum, titleId);
	}

	/**
	 * 該当会員の紹介者の会員番号を取得する
	 * @return 紹介者の会員番号
	 */
	@Override
	public Long getParentNum() {
		Long parentNum = new Long(0);
		
		// 子の会員番号より、メールで招待テーブルから情報を検索する
		InviteInfo invite = inviteInfoDao.selectParentByChildNum(ContextUtil.getMemberNo());
		if (invite != null) {
			parentNum = invite.getMemNum();
			return parentNum;
		}
		
		InviteLinkHist inviteLink = inviteLinkHistDao.selectParentByChildNum(ContextUtil.getMemberNo());
		if (inviteLink != null) {
			parentNum = inviteLink.getMemNum();
		}
		
		return parentNum;
	}

	@Override
	public Integer getMemCountByIp(String playIp, Long memNum, Integer titleId, Integer serverId) {
		return playHistDao.selectMemCountByIp(playIp, memNum, limitDays, titleId, serverId);
	}

	@Override
	public Integer getGuarantyByMenNum(Long memNum, Integer titleId, Integer serverId) {
		return playGuarantyDao.selectGuarantyByMenNum(memNum, titleId, serverId);
	}

	@Override
	public void createPlayGuaranty(Long memNum, Integer titleId, Integer serverId, String playIp) {
		
		PlayGuaranty playGuaranty = new PlayGuaranty();
		playGuaranty.setMemNum(memNum);
		playGuaranty.setTitleId(titleId);
		playGuaranty.setServerId(serverId);
		playGuaranty.setPlayIp(playIp);
		
		playGuarantyDao.save(playGuaranty);
	}

	public void setPlayHistDao(IPlayHistDao playHistDao) {
		this.playHistDao = playHistDao;
	}

	/**
	 * @param gameLoginCountDao the gameLoginCountDao to set
	 */
	public void setGameLoginCountDao(IGameLoginCountDao gameLoginCountDao) {
		this.gameLoginCountDao = gameLoginCountDao;
	}

	/**
	 * @param inviteInfoDao the inviteInfoDao to set
	 */
	public void setInviteInfoDao(IInviteInfoDao inviteInfoDao) {
		this.inviteInfoDao = inviteInfoDao;
	}

	/**
	 * @param inviteLinkHistDao the inviteLinkHistDao to set
	 */
	public void setInviteLinkHistDao(IInviteLinkHistDao inviteLinkHistDao) {
		this.inviteLinkHistDao = inviteLinkHistDao;
	}

	/**
	 * @param playGuarantyDao the playGuarantyDao to set
	 */
	public void setPlayGuarantyDao(IPlayGuarantyDao playGuarantyDao) {
		this.playGuarantyDao = playGuarantyDao;
	}

	/**
	 * @return the limitDays
	 */
	public Integer getLimitDays() {
		return limitDays;
	}

	/**
	 * @param limitDays the limitDays to set
	 */
	public void setLimitDays(Integer limitDays) {
		this.limitDays = limitDays;
	}
}
