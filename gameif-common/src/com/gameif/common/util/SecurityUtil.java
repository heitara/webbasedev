package com.gameif.common.util;

import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import sun.misc.BASE64Decoder;

public class SecurityUtil {

	private final static Log logger = LogFactory.getLog(SecurityUtil.class);

	/**
	 * 指定した文字列をMD5アルゴリズムで暗号化する。
	 * 
	 * @param text
	 *            暗号化前の文字列
	 * @return　暗号化結果の32桁文字列
	 */
	public final static String getMD5String(String text) {

		final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
				'9', 'a', 'b', 'c', 'd', 'e', 'f' };
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

	/**
	 * 指定した長さのランダム文字列を取得する
	 * 
	 * @param length
	 *            　　　　　指定した長さ
	 * @return ランダム文字列(数字、小文字、大文字を含む)
	 */
	public final static String getRandomAuthKey(int length) {

		StringBuffer buffer = new StringBuffer(
				"0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
		StringBuffer sb = new StringBuffer();

		try {
			Random r = new Random();
			int range = buffer.length();
			for (int i = 0; i < length; i++) {
				sb.append(buffer.charAt(r.nextInt(range)));
			}
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
		return sb.toString();
	}

	/**
	 * 指定した文字列をSHA-1アルゴリズムで暗号化する。
	 * 
	 * @param text
	 *            暗号化前の文字列
	 * @return　暗号化結果の文字列
	 */
	public final static String getSHAString(String text) {
		String shaString = "";

		try {
			byte[] txtByte = text.getBytes();

			MessageDigest mdTemp = MessageDigest.getInstance("SHA-1");
			mdTemp.update(txtByte);

			byte[] shaByte = mdTemp.digest();

			String temp = "";
			for (int i = 0; i < shaByte.length; i++) {
				temp = (Integer.toHexString(shaByte[i] & 0xFF));
				if (temp.length() == 1) {
					temp += "0";
				}
				shaString += temp;

			}

		} catch (Exception ex) {

			logger.error(ex.getMessage(), ex);
		}

		return shaString;
	}
	
	public final static String encodeParam(String params) {
		
		return encodeBase64(params);
	}
	
	public final static String encodeParam(Map<String, Object> params) {
		
		StringBuffer encBuff = new StringBuffer();
		
		for (Map.Entry<String, Object> entry : params.entrySet()) {

			if (encBuff.length() > 0) {

				encBuff.append('&');
			}
			encBuff.append(entry.getKey());
			encBuff.append('=');
			encBuff.append(entry.getValue());
		}

		return encodeBase64(encBuff.toString());
	}
	
	public final static Map<String, String> decodeParam(String params) {
		
		Map<String, String> paramMap = new HashMap<String, String>();		
		String decoded = decodeBase64(params);
		
		String[] paramarr = decoded.split("&");
		
		for (String parm : paramarr) {
			
			String[] kv = parm.split("=");
			paramMap.put(kv[0], kv[1]);
		}
		
		return paramMap;
	}
	
	public final static String encodeBase64(String src) {
		
		return new sun.misc.BASE64Encoder().encode(src.getBytes());
	}
	
	public final static String decodeBase64(String encoded) {
		
		String decoded = null;
		BASE64Decoder decoder = new BASE64Decoder();
		
		try {
			
			byte[] b = decoder.decodeBuffer(encoded);
			decoded = new String(b);
			
		} catch (Exception e) {
			
		}
		
		return decoded;
	}
}
