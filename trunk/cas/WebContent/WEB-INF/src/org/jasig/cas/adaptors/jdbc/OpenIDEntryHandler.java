package org.jasig.cas.adaptors.jdbc;

import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.authentication.principal.OpenIDCredentials;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public final class OpenIDEntryHandler {

	private final static Log log = LogFactory.getLog(OpenIDEntryHandler.class);

	private SimpleJdbcTemplate jdbcTemplate;
	private DataSource dataSource;
	private String selMemInfoSql;
	
	/**
	 * 会員IDより会員情報テーブルから会員番号とニックネームを抽出して、OpenID認証情報に設定する。
	 * @param credentials OpenID認証情報
	 * @return OpenID認証情報
	 */
	@SuppressWarnings("unchecked")
	public OpenIDCredentials setMemberInfoForCredentials(OpenIDCredentials credentials) {
		
		try {
			
			Map userInfo = getJdbcTemplate().queryForMap(this.selMemInfoSql, new Object[] {credentials.getAuthentication().getIdentity()});
			
			if (userInfo != null) {
				
				credentials.setMemNo((Long)userInfo.get("userNo"));
				credentials.setNickname(ByteUtil.stringToHexString((String)userInfo.get("nickName")));
			}
			
		} catch (EmptyResultDataAccessException ex) {
			
			log.info(ex.getMessage());
		}
		
		return credentials;
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

	public void setSelMemInfoSql(String selMemInfoSql) {
		
		this.selMemInfoSql = selMemInfoSql;
	}
}
