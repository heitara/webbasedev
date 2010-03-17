package org.jasig.cas.adaptors.jdbc;

import java.util.Date;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.inspektr.common.ioc.annotation.NotNull;
import org.inspektr.common.web.ClientInfoHolder;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.handler.support.AbstractPreAndPostProcessingAuthenticationHandler;
import org.jasig.cas.authentication.principal.Credentials;
import org.jasig.cas.authentication.principal.OpenIDCredentials;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public final class OpenIDAuthenticationHandler extends AbstractPreAndPostProcessingAuthenticationHandler {
	
	private final static Log log = LogFactory.getLog(OpenIDAuthenticationHandler.class);

    private SimpleJdbcTemplate jdbcTemplate;
    private DataSource dataSource;
	private String successUpSql;
	
	/**
	 * OpenIDログイン履歴を出力する。
	 * @param credentials　OpenID認証情報
	 * @return　true:成功、false：失敗
	 * @throws AuthenticationException
	 */
	protected final boolean authenticateOpenIDInternal(OpenIDCredentials credentials) throws AuthenticationException {
		
		boolean success = true;
		
		// ログイン成功ログ出力
		doFileLog(credentials.getAuthentication().getIdentity(), "login successed.", true);
		// ログイン成功状態（ログイン時間、ログインＩＰ）変更
		doDBLogForSuccess(credentials.getAuthentication().getIdentity());
		
		return success;
	}
	
	/**
	 * ログイン成功失敗をログに出力する。
	 * @param username 会員番号
	 * @param message 出力メッセージ
	 * @param success 成功フラグ
	 */
	private final void doFileLog(String username, String message, boolean success) {

		String logMessage = new StringBuffer()
			.append(ClientInfoHolder.getClientInfo().getClientIpAddress())
			.append(" | ")
			.append(username)
			.append(" | ")
			.append(message)
			.toString();
		
		if (success) {
			
			log.info(logMessage);
			
		} else {
			
			log.warn(logMessage);
		}
	}
	
	/**
	 * ＤＢでログイン成功状態（ログイン時間、ログインＩＰ）を変更する。
	 * @param userNo　会員番号
	 */
	private final void doDBLogForSuccess(String memId) {

		// ログイン成功状態（ログイン時間、ログインＩＰ）変更
		getJdbcTemplate().update(successUpSql, new Object[] {new Date(), ClientInfoHolder.getClientInfo().getClientIpAddress(), memId});
	}
	
    public final void setDataSource(final DataSource dataSource) {
        this.jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        this.dataSource = dataSource;
    }

    protected final SimpleJdbcTemplate getJdbcTemplate() {
        return this.jdbcTemplate;
    }
    
    protected final DataSource getDataSource() {
        return this.dataSource;
    }
    
    protected final boolean doAuthentication(final Credentials credentials) throws AuthenticationException {
    	
	    return authenticateOpenIDInternal((OpenIDCredentials) credentials);
	}
    
    public final boolean supports(final Credentials credentials) {
    	
        return credentials != null
            && (OpenIDCredentials.class.equals(credentials.getClass())
            		|| (OpenIDCredentials.class.isAssignableFrom(credentials.getClass())));
    }

	public void setSuccessUpSql(String successUpSql) {
		this.successUpSql = successUpSql;
	}
}
