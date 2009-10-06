package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.common.exception.LogicException;
import com.gameif.portal.entity.InviteInfo;

public interface IInviteInfoBusinessLogic {

	public void saveInviteInfo(InviteInfo inviteInfo) throws LogicException;
	public List<InviteInfo> selectInviteHistByMemNum(String inviteStatus);
	public void sendMailAgain(List<Long> inviteList);
	public void deleteInviteInfo(List<Long> inviteList);
}
