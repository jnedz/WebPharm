package utils;

import java.util.GregorianCalendar;

public class InvalidDateException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private GregorianCalendar gc;
	
	public GregorianCalendar getGc() {
		return gc;
	}


	public void setGc(GregorianCalendar gc) {
		this.gc = gc;
	}


	public InvalidDateException(){
		super("Invalid date");
	}
	
	
	public InvalidDateException(GregorianCalendar gc){
		
		super("Invalid date" + gc);
		this.gc = gc;
	}


}
