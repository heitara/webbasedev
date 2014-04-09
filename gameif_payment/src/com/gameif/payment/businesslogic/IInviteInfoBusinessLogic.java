package com.gameif.payment.businesslogic;

import java.util.List;
import java.util.Map;

import com.gameif.common.exception.LogicException;
import com.gameif.payment.entity.InviteInfo;
import com.gameif.payment.entity.MyInviteLink;

public interface IInviteInfoBusinessLogic {

	public void saveInviteInfo(InviteInfo inviteInfo, Map<String, String> mailToList) throws LogicException;
	public List<InviteInfo> selectInviteHistByMemNum(String inviteStatus);
	public void sendMailAgain(List<Long> inviteList);
	public void deleteInviteInfo(List<Long> inviteList);
	public String createMemInviteLink(Integer titleId);
	public List<MyInviteLink> selectLinkMembersByMemNum(Long memNum);
	public void checkMailStatus(Long inviteId) throws LogicException;
	public void checkLinkStatus(Long memNum, Long childMemNum) throws LogicException;
}
