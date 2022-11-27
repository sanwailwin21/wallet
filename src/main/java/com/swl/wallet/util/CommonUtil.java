package com.swl.wallet.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * @author SanWaiLwin
 * 
 */
public class CommonUtil {

	private static Logger logger = Logger.getLogger(CommonUtil.class);

	public static String dateToString(String format, Date date) {
		if (!validDate(date)) {
			return "";
		}

		if (!validString(format)) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		return new SimpleDateFormat(format).format(date);

	}

	public static Date stringToDate(String format, String dateString) {
		if (!validString(format)) {
			return null;
		}

		if (!validString(format)) {
			format = CommonConstant.STD_DATE_TIME_FORMAT;
		}

		try {
			return new SimpleDateFormat(format).parse(dateString);
		} catch (Exception e) {
			logger.error(">>> Exception occurs while converting string into date >>> " + e.getMessage());
		}

		return null;
	}

	public static String ChangeFormatDateToDateString(String fromFormat, String toFormat, String dateString) {
		if (!CommonUtil.validString(fromFormat) || !CommonUtil.validString(toFormat)
				|| !CommonUtil.validString(dateString)) {
			return "";
		}

		Date tempDate;
		try {
			tempDate = new SimpleDateFormat(fromFormat).parse(dateString);
		} catch (ParseException e) {
			return "";
		}
		return new SimpleDateFormat(toFormat).format(tempDate);
	}

	public static Date getStartTimeOfTheDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		return cal.getTime();
	}

	public static Date getEndTimeOfTheDay(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	public static boolean validInteger(Integer value) {
		return null != value && value.intValue() > 0;
	}

	public static boolean validLong(Long value) {
		return null != value && value.longValue() > 0;
	}

	public static boolean validDouble(Double value) {
		return null != value && value.doubleValue() > 0;
	}

	public static boolean validBigDecimal(BigDecimal value) {
		return null != value && value.compareTo(BigDecimal.ZERO) > 0;
	}

	public static boolean validString(String value) {
		return null != value && !value.trim().isEmpty();
	}

	public static boolean validDate(Date value) {
		return null != value;
	}

	public static boolean validBoolean(Boolean value) {
		return null != value;
	}

	public static boolean validDate(String value) {
		return null != value && !value.trim().isEmpty();
	}

	@SuppressWarnings("rawtypes")
	public static boolean validList(List value) {
		return null != value && !value.isEmpty() && value.size() > 0;
	}

	public static String checkValidString(String value) {
		return validString(value) ? value : "";
	}

	public static Integer checkValidInteger(Integer value) {
		return validInteger(value) ? value : Integer.valueOf(0);
	}

	public static Long checkValidLong(Long value) {
		return validLong(value) ? value : Long.valueOf(0);
	}

	public static Double checkValidDouble(Double value) {
		return validDouble(value) ? value : Double.valueOf(0);
	}

	public static BigDecimal checkValidBigDecimal(BigDecimal value) {
		return validBigDecimal(value) ? value : BigDecimal.valueOf(0);
	}

	public static Boolean checkValidBoolean(Boolean value) {
		return validBoolean(value) ? value : Boolean.FALSE;
	}
}
