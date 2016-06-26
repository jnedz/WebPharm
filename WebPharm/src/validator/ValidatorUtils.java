package validator;

import utils.Formater;
import utils.InvalidDateException;

public class ValidatorUtils {

	public static boolean isValidStringByLength(String param, int length) {
		return (param.length() > 0 && param.length() <= length);
	}

	public static boolean isValidDate(String date) {
		boolean isValid = false;
		try {
			Formater.toDateFromString(date);
			isValid = true;
		} catch (InvalidDateException e) {
			isValid = false;
			System.out.println(e);
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
