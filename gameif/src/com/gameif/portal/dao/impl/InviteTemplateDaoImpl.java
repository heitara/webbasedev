package com.gameif.portal.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.portal.dao.IInviteTemplateDao;
import com.gameif.portal.entity.InviteTemplateMst;

public class InviteTemplateDaoImpl extends
		AbstractBaseDao<InviteTemplateMst, InviteTemplateMst> implements
		IInviteTemplateDao {

	@Override
	public List<InviteTemplateMst> selectInviteTemplateByTitleId(Integer titleId) {
		return getSqlMapClientTemplate().queryForList(
				namespace + ".selectInviteTemplateByTitleId", titleId);
	}

}
