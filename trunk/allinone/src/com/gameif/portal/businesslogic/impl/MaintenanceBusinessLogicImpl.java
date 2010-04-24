package com.gameif.portal.businesslogic.impl;

import com.gameif.common.businesslogic.BaseBusinessLogic;
import com.gameif.common.exception.BetaTestException;
import com.gameif.common.exception.LogicException;
import com.gameif.common.exception.MaintenanceException;
import com.gameif.portal.businesslogic.IMaintenanceBusinessLogic;
import com.gameif.portal.constants.PortalConstants;
import com.gameif.portal.dao.IMaintenanceInfoDao;
import com.gameif.portal.dao.IMemberInfoDao;
import com.gameif.portal.dao.ITitleMstDao;
import com.gameif.portal.entity.MaintenanceInfo;
import com.gameif.portal.entity.MemberInfo;
import com.gameif.portal.entity.TitleMst;
import com.gameif.portal.util.ContextUtil;

public class MaintenanceBusinessLogicImpl extends BaseBusinessLogic implements
		IMaintenanceBusinessLogic {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6729159308071707221L;
	
	private ITitleMstDao titleMstDao;
	private IMaintenanceInfoDao maintenanceInfoDao;
	private IMemberInfoDao memberInfoDao;

	/**
	 * メンテナンスチェックを行う
	 * @param titleId タイトルID
	 */
	@Override
	public void maintenanceCheckByTitleId(Integer titleId) throws LogicException {

		// テスト会員の場合、メンテナンスチェックを行わない
		MemberInfo member = new MemberInfo();
		member.setMemNum(ContextUtil.getMemberNo());
		member = memberInfoDao.selectByKey(member);
		if (member != null && member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.TEST)) {
			return;
		}
		
		TitleMst title = titleMstDao.selectValidTitleByKey(titleId);
		if (title != null) {
			String status = title.getServiceStatus();
			// メンテナンス 中
			if (status.equals(PortalConstants.ServerStatus.MAINTENANCE)) {
				throw new MaintenanceException("title is in maintenance.");
			// CBT中,OBT中
			} else if (status.equals(PortalConstants.ServerStatus.CBT) || status.equals(PortalConstants.ServerStatus.OBT)) {
				throw new BetaTestException("title is in CBT or OBT.");
			}
		}
		
	}

	/**
	 * 各機能のメンテナンスチェック
	 * @param functionCd 機能コード
	 * @return true:メンテナンス中、false：メンテナンス無し
	 */
	@Override
	public Boolean maintenanceCheckByFunctionCd(String functionCd) {
		Boolean bReturn = true;
		MaintenanceInfo mainten = maintenanceInfoDao.selectByFunctionCd(functionCd);
		if (mainten != null) {
			// メンテナンス中
			if (mainten.getMaintenStatus().equals(PortalConstants.MaintenanceStatus.MAINTENANCE)) {
				bReturn = true;
			// 稼動中
			} else if (mainten.getMaintenStatus().equals(PortalConstants.MaintenanceStatus.RUNNING)) {
				bReturn = false;
			// テスト会員使用可の場合、会員属性のチェック
			} else if (mainten.getMaintenStatus().equals(PortalConstants.MaintenanceStatus.TEST)) {
				MemberInfo member = new MemberInfo();
				member.setMemNum(ContextUtil.getMemberNo());
				member = memberInfoDao.selectByKey(member);
				if (member != null && member.getMemAtbtCd().equals(PortalConstants.MemberAtbtCd.TEST)) {
					bReturn = false;
				} else {
					bReturn = true;
				}
			}
		}
		return bReturn;
	}

	/**
	 * @return the titleMstDao
	 */
	public ITitleMstDao getTitleMstDao() {
		return titleMstDao;
	}

	/**
	 * @param titleMstDao the titleMstDao to set
	 */
	public void setTitleMstDao(ITitleMstDao titleMstDao) {
		this.titleMstDao = titleMstDao;
	}

	/**
	 * @return the maintenanceInfoDao
	 */
	public IMaintenanceInfoDao getMaintenanceInfoDao() {
		return maintenanceInfoDao;
	}

	/**
	 * @param maintenanceInfoDao the maintenanceInfoDao to set
	 */
	public void setMaintenanceInfoDao(IMaintenanceInfoDao maintenanceInfoDao) {
		this.maintenanceInfoDao = maintenanceInfoDao;
	}

	/**
	 * @return the memberInfoDao
	 */
	public IMemberInfoDao getMemberInfoDao() {
		return memberInfoDao;
	}

	/**
	 * @param memberInfoDao the memberInfoDao to set
	 */
	public void setMemberInfoDao(IMemberInfoDao memberInfoDao) {
		this.memberInfoDao = memberInfoDao;
	}
	
}
