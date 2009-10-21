package com.gameif.portal.businesslogic;

import java.util.List;
import java.util.Map;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.InviteInfo;

public interface IInviteInfoBusinessLogic {

	public void saveInviteInfo(InviteInfo inviteInfo, Map<String, String> mailToList) throws LogicException;
	public List<InviteInfo> selectInviteHistByMemNum(String inviteStatus);
	public void sendMailAgain(List<Long> inviteList);
	public void deleteInviteInfo(List<Long> inviteList);
}
