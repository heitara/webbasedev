/*
 * Copyright 2007 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.ja-sig.org/products/cas/overview/license/
 */
package org.jasig.cas.adaptors.jdbc;

import java.util.Date;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.inspektr.common.ioc.annotation.NotNull;
import org.inspektr.common.web.ClientInfoHolder;
import org.jasig.cas.authentication.handler.AuthenticationException;
import org.jasig.cas.authentication.principal.UsernamePasswordCredentials;
import org.springframework.dao.IncorrectResultSizeDataAccessException;

import sun.misc.BASE64Decoder;

/**
 * Class that if provided a query that returns a password (parameter of query
 * must be username) will compare that password to a translated version of the
 * password provided by the user. If they match, then authentication succeeds.
 * Default password translator is plaintext translator.
 * 
 * @author Scott Battaglia
 * @author Dmitriy Kopylenko
 * @version $Revision: 42776 $ $Date: 2008-01-04 09:15:42 -0500 (Fri, 04 Jan 2008) $
 * @since 3.0
 */
public final class QueryDatabaseAuthenticationHandler extends
	AbstractJdbcUsernamePasswordAuthenticationHandler {
	
	private final static Log log = LogFactory.getLog(QueryDatabaseAuthenticationHandler.class);

	@NotNull
	private String selSql;
	@NotNull
	private String successUpSql;
	@NotNull
	private String failUpSql;
	@NotNull
	private String countFailByIPSql;
	
	/** ログイン失敗をチェックする時間 */
	private int failCheckTime;
	
	/** 同じＩＤで連続失敗する最大回数 */
	private int failMaxCountByID;
	
	/** 同じＩＰで失敗する累計最大回数 */
	private int failMaxCountByIp;

	/* ▼ 2009-09-11 李 追加 ********************************************/
	@SuppressWarnings("unchecked")
	protected final boolean authenticateUsernamePasswordInternal(
		final UsernamePasswordCredentials credentials)
		throws AuthenticationException {
		
		boolean success = false;
		
		final String username = credentials.getUsername();
		final String password = credentials.getPassword();
		final String encryptedPassword = this.getPasswordEncoder().encode(password);
		
		try {
			
			Map userInfo = getJdbcTemplate().queryForMap(this.selSql, new Object[] {username});
			
			if (userInfo != null) {

				Long userNo = (Long)userInfo.get("userNo"); 
				String dbPassword = (String)userInfo.get("password");
				String nickName = (String)userInfo.get("nickName");
				Date loginFailDt = (Date)userInfo.get("loginFailDt");
				Integer loginFailCnt = (Integer)userInfo.get("loginFailCnt");
				
				if (userNo != null) {

					// ログイン失敗回数が連続10回以上且つ最新の失敗時間が24時間以内の場合は、ログイン禁止
					if (loginFailCnt >= failMaxCountByID && loginFailDt.getTime() + 1000 * 60 * 60 * failCheckTime > System.currentTimeMillis()) {

						doFileLog(username, "login failed over " + failMaxCountByID + " times by ID.", false);

					// 24時間以内に同じＩＰでログイン失敗した回数が累計20回以上の場合、ログイン禁止
					} else if (!checkLoginFailIP()) {

						doFileLog(username, "login failed over " + failMaxCountByIp + " times by IP.", false);
						
					} else {

						success = dbPassword.equals(encryptedPassword);
						
						if (success) {
							
							credentials.setUserNo(userNo);
							credentials.setNickName(ByteUtil.stringToHexString(nickName));

							// ログイン成功ログ出力
							doFileLog(username, "login successed.", true);
							// ログイン成功状態（ログイン時間、ログインＩＰ）変更
							doDBLogForSuccess(userNo);
							
						} else {

							// ログイン失敗状態（ログイン失敗時間、ログイン失敗ＩＰ）変更
							doDBLogForFail(userNo);
						}
					}
				}
			}
			
			if (!success) {

				// ログイン失敗ログ出力
				doFileLog(username, "login failed.", false);
			}
			
		} catch (final IncorrectResultSizeDataAccessException e) {
			
			log.error(e.getMessage(), e);
		}
		
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
	 * 24時間以内に同じＩＰでログイン失敗した回数が累計20回以上となっているかチェックする。<br/>
	 * 数値の設定は「deployerConfigContext.xml」で変更可能。
	 * @return　true:なっている, false:なっていない
	 */
	private final boolean checkLoginFailIP() {
		
		boolean checkOk = true;

		int loginFailCnt = getJdbcTemplate().queryForInt(countFailByIPSql, new Object[] {new Date(System.currentTimeMillis() - 1000 * 60 * 60 * failCheckTime), ClientInfoHolder.getClientInfo().getClientIpAddress()});
		
		if (loginFailCnt >= failMaxCountByIp) {
			
			checkOk = false;
		}
		
		return checkOk;
	}
	
	/**
	 * ＤＢでログイン成功状態（ログイン時間、ログインＩＰ）を変更する。
	 * @param userNo　会員番号
	 */
	private final void doDBLogForSuccess(Long userNo) {

		// ログイン成功状態（ログイン時間、ログインＩＰ）変更
		getJdbcTemplate().update(successUpSql, new Object[] {new Date(), ClientInfoHolder.getClientInfo().getClientIpAddress(), userNo});
	}
	
	/**
	 * ＤＢでログイン失敗状態（ログイン失敗時間、ログイン失敗ＩＰ）を変更する。
	 * @param userNo　会員番号
	 */
	private final void doDBLogForFail(Long userNo) {

		// ログイン失敗状態（ログイン失敗時間、ログイン失敗ＩＰ）変更
		getJdbcTemplate().update(failUpSql, new Object[] {new Date(), ClientInfoHolder.getClientInfo().getClientIpAddress(), userNo});
	}
	
	/**
	 * @param sql The sql to set.
	 */
	public void setSelSql(final String selSql) {
		this.selSql = selSql;
	}

	public void setSuccessUpSql(String successUpSql) {
		this.successUpSql = successUpSql;
	}

	public void setFailUpSql(String failUpSql) {
		this.failUpSql = failUpSql;
	}
	public void setCountFailByIPSql(String countFailByIPSql) {
		this.countFailByIPSql = countFailByIPSql;
	}

	public void setFailCheckTime(int failCheckTime) {
		this.failCheckTime = failCheckTime;
	}

	public void setFailMaxCountByID(int failMaxCountByID) {
		this.failMaxCountByID = failMaxCountByID;
	}

	public void setFailMaxCountByIp(int failMaxCountByIp) {
		this.failMaxCountByIp = failMaxCountByIp;
	}
	/* ▲ 2009-09-11 李 追加 *******************************************/

	/* ▼ 2009-09-11 李 削除********************************************/
	/*
	protected final boolean authenticateUsernamePasswordInternal(
		final UsernamePasswordCredentials credentials)
		throws AuthenticationException {
		final String username = credentials.getUsername();
		final String password = credentials.getPassword();
		final String encryptedPassword = this.getPasswordEncoder().encode(
			password);
		
		try {
			final String dbPassword = getJdbcTemplate().queryForObject(
				this.sql, String.class, username);
			return dbPassword.equals(encryptedPassword);
		} catch (final IncorrectResultSizeDataAccessException e) {
			// this means the username was not found.
			return false;
		}
	}
	*/
	/* ▲ 2009-09-11 李 削除 *******************************************/
}
