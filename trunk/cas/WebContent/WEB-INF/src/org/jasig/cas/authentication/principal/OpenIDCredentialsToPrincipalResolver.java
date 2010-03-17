package org.jasig.cas.authentication.principal;

public final class OpenIDCredentialsToPrincipalResolver extends AbstractPersonDirectoryCredentialsToPrincipalResolver {

	protected String extractPrincipalId(final Credentials credentials) {
		
		String principalId = null;
		
		final OpenIDCredentials openIDCredentials = (OpenIDCredentials) credentials;
		
		if (openIDCredentials != null && openIDCredentials.getAuthentication() != null) {
			
			principalId = new StringBuffer()
							.append(openIDCredentials.getMemNo())
							.append(",")
							.append(openIDCredentials.getAuthentication().getIdentity())
							.append(",")
							.append(openIDCredentials.getNickname())
							.toString();
		}
		
		return principalId;
	}
	
	public boolean supports(final Credentials credentials) {
		
		return credentials != null && OpenIDCredentials.class.isAssignableFrom(credentials.getClass());
	}
}