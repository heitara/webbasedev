package com.gameif.backoffice.businesslogic;

import java.util.List;

import com.gameif.backoffice.bean.AuthorityInfo;
import com.gameif.backoffice.entity.AuthorityMst;
import com.gameif.common.exception.LogicException;

public interface IAuthorityBusinessLogic {
	
	public Integer countAuthorityByCode(String code);
	public void createAuthorityInfo(AuthorityInfo authorityInfo);
	public AuthorityInfo getAuthorityinfoByCode(String code) throws LogicException;
	public void updateAuthorityInfo(AuthorityInfo authorityInfo);
	public List<AuthorityMst> selectAuthorityList(AuthorityMst authorityMst);
	public void deleteAuthorityMst(List<String> authorityCodes);
	public List<AuthorityMst> getAll();

}
