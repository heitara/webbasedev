package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.bean.KeyValueInfo;
import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IInviteTemplateDao;
import com.gameif.portal.entity.InviteTemplateMst;

public class InviteTemplateDaoImpl extends
		AbstractBaseDao<InviteTemplateMst, InviteTemplateMst> implements
		IInviteTemplateDao {

	@SuppressWarnings("unchecked")
	public List<KeyValueInfo> getInviteTemplateMst(String titleId) {
		return getSqlMapClientTemplate().queryForList(
				namespace + ".getInviteTemplateMst", titleId);
	}

}
