package org.jasig.cas.authentication.principal;

import org.expressme.openid.Authentication;

public class OpenIDCredentials implements Credentials {

	private static final long serialVersionUID = -5277710613326891827L;
	
	private Authentication authentication;
	private Long memNo;
	private String nickname;

	public Authentication getAuthentication() {
		
		return authentication;
	}

	public void setAuthentication(Authentication authentication) {
		
		this.authentication = authentication;
	}

    public boolean equals(final Object obj) {
        if (obj == null || !obj.getClass().equals(this.getClass())) {
            return false;
        }

        final OpenIDCredentials c = (OpenIDCredentials) obj;

        return this.authentication.equals(c.getAuthentication());
    }

    public int hashCode() {
        return this.authentication.hashCode();
    }

	public Long getMemNo() {
		return memNo;
	}

	public void setMemNo(Long memNo) {
		this.memNo = memNo;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
}