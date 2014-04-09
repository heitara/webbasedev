package com.gameif.payment.action.titleif;

import com.gameif.payment.entity.ServerMst;
import com.gameif.payment.util.ContextUtil;

public class TitlePlayControlAction extends TitlePlayControlBaseAction {

	private static final long serialVersionUID = -6317164626114870434L;

	@Override
	public String execute() {

		String result = SELECT;
		ServerMst serverMst = getServerMst();

		// サーバが存在する場合
		if (serverMst != null) {
			
			// 同一IPに対して、複数プレヤーが存在するかどうかのチェック
			Integer count = getTitlePlayBusinessLogic().getMemCountByIp(ContextUtil.getClientIP(), ContextUtil.getMemberNo(), serverMst.getTitleId(), serverMst.getServerId());
			if (count > 0) {
				// 複数プレヤーが存在する場合
				if (getTitlePlayBusinessLogic().getGuarantyByMenNum(ContextUtil.getMemberNo(), serverMst.getTitleId(), serverMst.getServerId()) < 1) {
					return "guaranty";
				}
			}

			result = doPlay(serverMst);
		}

		return result;
	}
}