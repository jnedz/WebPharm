package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class ValidatorUtils {

	public static boolean isValidStringByLength(String param, int length) {
		//boolean isValid = false;
		return (param.length() > 0 && param.length() <= length) ;
				/*{
			isValid = true;*/
		/*}
		return isValid;
	*/}

	
	public static boolean isValidDate(String date) {
		boolean isValid = false;
		try {
			Formater.toDateFromString(date);
			isValid = true;
		} catch (InvalidDateException e) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isValidNumber(String number, int max) {
		boolean isValid = false;
		try {
			int n = Integer.parseInt(number);
			if (n > 0 && n <= max) {
				isValid = true;
			}
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

	public static boolean isValidDouble(String param) {
		boolean isValid = false;
		try {
			if (Double.parseDouble(param) > 0.00) {
				isValid = true;
			}
		} catch (Exception e) {
			isValid = false;
		}
		return isValid;
	}

}
