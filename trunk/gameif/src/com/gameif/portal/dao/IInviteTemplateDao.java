package com.gameif.portal.dao;

import java.util.List;

import com.gameif.common.bean.KeyValueInfo;
import com.gameif.common.dao.IBaseDao;
import com.gameif.portal.entity.InviteTemplateMst;

public interface IInviteTemplateDao extends
		IBaseDao<InviteTemplateMst, InviteTemplateMst> {

	public List<KeyValueInfo> getInviteTemplateMst(String titleId);
}
