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
	
	/** ���O�C�����s���`�F�b�N���鎞�� */
	private int failCheckTime;
	
	/** �����h�c�ŘA�����s����ő�� */
	private int failMaxCountByID;
	
	/** �����h�o�Ŏ��s����݌v�ő�� */
	private int failMaxCountByIp;

	/* �� 2009-09-11 �� �ǉ� ********************************************/
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

					// ���O�C�����s�񐔂��A��10��ȏ㊎�ŐV�̎��s���Ԃ�24���Ԉȓ��̏ꍇ�́A���O�C���֎~
					if (loginFailCnt >= failMaxCountByID && loginFailDt.getTime() + 1000 * 60 * 60 * failCheckTime > System.currentTimeMillis()) {

						doFileLog(username, "login failed over " + failMaxCountByID + " times by ID.", false);

					// 24���Ԉȓ��ɓ����h�o�Ń��O�C�����s�����񐔂��݌v20��ȏ�̏ꍇ�A���O�C���֎~
					} else if (!checkLoginFailIP()) {

						doFileLog(username, "login failed over " + failMaxCountByIp + " times by IP.", false);
						
					} else {

						success = dbPassword.equals(encryptedPassword);
						
						if (success) {
							
							credentials.setUserNo(userNo);
							credentials.setNickName(nickName);

							// ���O�C���������O�o��
							doFileLog(username, "login successed.", true);
							// ���O�C��������ԁi���O�C�����ԁA���O�C���h�o�j�ύX
							doDBLogForSuccess(userNo);
							
						} else {

							// ���O�C�����s��ԁi���O�C�����s���ԁA���O�C�����s�h�o�j�ύX
							doDBLogForFail(userNo);
						}
					}
				}
			}
			
			if (!success) {

				// ���O�C�����s���O�o��
				doFileLog(username, "login failed.", false);
			}
			
		} catch (final IncorrectResultSizeDataAccessException e) {
			
			log.error(e.getMessage(), e);
		}
		
		return success;
	}
	
	/**
	 * ���O�C���������s�����O�ɏo�͂���B
	 * @param username ����ԍ�
	 * @param message �o�̓��b�Z�[�W
	 * @param success �����t���O
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
	 * 24���Ԉȓ��ɓ����h�o�Ń��O�C�����s�����񐔂��݌v20��ȏ�ƂȂ��Ă��邩�`�F�b�N����B<br/>
	 * ���l�̐ݒ�́udeployerConfigContext.xml�v�ŕύX�\�B
	 * @return�@true:�Ȃ��Ă���, false:�Ȃ��Ă��Ȃ�
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
	 * �c�a�Ń��O�C��������ԁi���O�C�����ԁA���O�C���h�o�j��ύX����B
	 * @param userNo�@����ԍ�
	 */
	private final void doDBLogForSuccess(Long userNo) {

		// ���O�C��������ԁi���O�C�����ԁA���O�C���h�o�j�ύX
		getJdbcTemplate().update(successUpSql, new Object[] {new Date(), ClientInfoHolder.getClientInfo().getClientIpAddress(), userNo});
	}
	
	/**
	 * �c�a�Ń��O�C�����s��ԁi���O�C�����s���ԁA���O�C�����s�h�o�j��ύX����B
	 * @param userNo�@����ԍ�
	 */
	private final void doDBLogForFail(Long userNo) {

		// ���O�C�����s��ԁi���O�C�����s���ԁA���O�C�����s�h�o�j�ύX
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
	/* �� 2009-09-11 �� �ǉ� *******************************************/

	/* �� 2009-09-11 �� �폜********************************************/
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
	/* �� 2009-09-11 �� �폜 *******************************************/
}
