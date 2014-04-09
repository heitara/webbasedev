package com.gameif.payment.dao.impl;

import java.util.List;

import com.gameif.common.dao.impl.AbstractBaseDao;
import com.gameif.payment.dao.IInviteTemplateDao;
import com.gameif.payment.entity.InviteTemplateMst;

public class InviteTemplateDaoImpl extends
		AbstractBaseDao<InviteTemplateMst, InviteTemplateMst> implements
		IInviteTemplateDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<InviteTemplateMst> selectInviteTemplateByTitleId(Integer titleId) {
		return getSqlMapClientTemplate().queryForList(
				namespace + ".selectInviteTemplateByTitleId", titleId);
	}

}
