package com.app.bookingcare.exceptions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.util.Strings;
@SuppressWarnings("deprecation")
public class Utils {
	
	public static String convertStringFood(String dateString) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (dateString == null || Strings.isEmpty(dateString)) {
			return "";
		} else {
			Date dateFormat = sdf.parse(dateString);
			return new SimpleDateFormat("yyyy-MM-dd").format(dateFormat);
		}
	}
}
