package com.gameif.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.validator.DateValidator;

public class DateUtil {

	public final boolean isValidDate(String year, String month, String day) {
				
		return createDate(year, month, day) == null ? false : true;
	}
	
	public final static Date createDate(String year, String month, String day) {
		
		if (year == null || month == null || day == null) {

			return null;
		}

		return createDate(year + "/" + month + "/" + day, "yyyy/MM/dd");
	}
	
	public final static Date createDate(String date, String format) {
		
		return str2Date(date, format);
	}
	
	public final static String date2Str(Date date, String format) {
		
		return new SimpleDateFormat(format).format(date);
	}

	public final static Date str2Date(String dateStr, String format) {

		Date date = null;
		
		try {
			
			if (DateValidator.getInstance().isValid(dateStr, format, false)) {

				date = new SimpleDateFormat(format).parse(dateStr);
			}
			
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}
}
