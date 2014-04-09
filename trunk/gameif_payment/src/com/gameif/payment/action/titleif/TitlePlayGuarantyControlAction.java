package com.gameif.payment.action.titleif;

import com.gameif.payment.entity.ServerMst;
import com.gameif.payment.util.ContextUtil;

public class TitlePlayGuarantyControlAction extends TitlePlayControlBaseAction {

	private static final long serialVersionUID = 8307010479171625362L;

	public String input() {
		return INPUT;
	}

	public String create() {

		String result = SELECT;
		ServerMst serverMst = getServerMst();

		// サーバが存在する場合
		if (serverMst != null) {

			getTitlePlayBusinessLogic().createPlayGuaranty(ContextUtil.getMemberNo(), serverMst.getTitleId(), serverMst.getServerId(), ContextUtil.getClientIP());
			
			result = doPlay(serverMst);
		}

		return result;
	}
}
