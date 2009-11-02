package com.gameif.backoffice.bean;

import java.util.List;

import com.gameif.backoffice.entity.AuthorityDetailMst;
import com.gameif.backoffice.entity.AuthorityMst;
import com.gameif.common.entity.BaseEntity;

public class AuthorityInfo extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1992071806620051880L;

	private AuthorityMst authority;

	private List<AuthorityDetailMst> authorityDetails;

	/**
	 * @return the authority
	 */
	public AuthorityMst getAuthority() {
		return authority;
	}

	/**
	 * @param authority
	 *            the authority to set
	 */
	public void setAuthority(AuthorityMst authority) {
		this.authority = authority;
	}

	/**
	 * @return the authorityDetails
	 */
	public List<AuthorityDetailMst> getAuthorityDetails() {
		return authorityDetails;
	}

	/**
	 * @param authorityDetails
	 *            the authorityDetails to set
	 */
	public void setAuthorityDetails(List<AuthorityDetailMst> authorityDetails) {
		this.authorityDetails = authorityDetails;
	}

}
