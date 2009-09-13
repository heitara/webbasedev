package org.jasig.cas.adaptors.jdbc;

import java.security.MessageDigest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jasig.cas.authentication.handler.PasswordEncoder;

public class GameifPasswordEncoder implements PasswordEncoder {
	
	private final static Log log = LogFactory.getLog(GameifPasswordEncoder.class);

	@Override
	public String encode(String password) {
		
		final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		String md5Passwd = null;
		
		try {
				byte[] txtByte = password.getBytes();
				
				MessageDigest mdTemp = MessageDigest.getInstance("MD5");
				mdTemp.update(txtByte);
				
				byte[] md5Byte = mdTemp.digest();
				
				int j = md5Byte.length;
				int k = 0;
				char str[] = new char[j * 2];
				
				for (int i = 0; i < j; i++) {
					byte byte0 = md5Byte[i];
					str[k++] = hexDigits[byte0 >>> 4 & 0xf];
					str[k++] = hexDigits[byte0 & 0xf];
				}
				
				md5Passwd = new String(str);
				
		} catch (Exception ex) {
			
			log.error(ex.getMessage(), ex);
		}
				
		return md5Passwd;
	}

}
