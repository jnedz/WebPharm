package utils;

import static utils.Constants.format;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

public class Formatter {

//	public static final String dateFormat = "dd.MM.yyyy";

	public static final GregorianCalendar toDateFromString(String dt) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);

		GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar
				.getInstance();
		Date dte;
		try {
			dte = simpleDateFormat.parse(dt);
		} catch (ParseException e) {
			throw new InvalidDateException();
		}
		gregorianCalendar.setTime(dte);
		return gregorianCalendar;
	}

	public static final String fromDateToString(GregorianCalendar date) {

		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		String dte = simpleDateFormat.format(date.getTime());
		return dte;
	}

}
