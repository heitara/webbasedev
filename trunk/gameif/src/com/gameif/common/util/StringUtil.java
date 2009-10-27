package com.gameif.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class StringUtil {
	private final static Log logger = LogFactory.getLog(SecurityUtil.class);
	


	/**
	 * 指定した文字列をSHA-1アルゴリズムで暗号化する。
	 * 
	 * @param text
	 *            暗号化前の文字列
	 * @return　暗号化結果の文字列
	 */
	public final static String convertToShitjis(String text) {
		String desc = "";

		try {
			
			if (text != null) {
				byte[] txtByte = text.getBytes();
				desc = new String(txtByte, "Shift-JIS");
			}
		} catch (Exception ex) {

			logger.error(ex.getMessage(), ex);
		}

		return desc;
	}
}
