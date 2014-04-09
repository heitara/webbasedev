package com.gameif.payment.dao;

import java.util.List;

import com.gameif.common.dao.IBaseDao;
import com.gameif.payment.entity.InviteTemplateMst;

public interface IInviteTemplateDao extends
		IBaseDao<InviteTemplateMst, InviteTemplateMst> {

	public List<InviteTemplateMst> selectInviteTemplateByTitleId(Integer titleId);
}
