package com.gameif.common.util;

import java.security.MessageDigest;

import org.apache.log4j.Logger;

public class SecurityUtil {
	
	private final static Logger logger = Logger.getLogger(SecurityUtil.class);

	/**
	 * 指定した文字列をMD5アルゴリズムで暗号化する。
	 * @param text 暗号化前の文字列
	 * @return　暗号化結果の32桁文字列
	 */
	public final static String getMD5String(String text) {
		
		final char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		String md5String = null;
		
		try {
				byte[] txtByte = text.getBytes();
				
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
				
				md5String = new String(str);
				
		} catch (Exception ex) {
			
			logger.error(ex.getMessage(), ex);
		}
				
		return md5String;
	}
}
