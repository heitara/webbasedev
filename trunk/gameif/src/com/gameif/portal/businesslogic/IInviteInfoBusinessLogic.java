package com.gameif.portal.businesslogic;

import java.util.List;

import com.gameif.common.bean.KeyValueInfo;
import com.gameif.portal.entity.InviteInfo;

public interface IInviteInfoBusinessLogic {

	public void saveInviteInfo(InviteInfo inviteInfo);

	public List<KeyValueInfo> getTitleList();

	public List<KeyValueInfo> getInviteTemplateList();
}
