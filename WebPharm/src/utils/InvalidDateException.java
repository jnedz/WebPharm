package utils;

import java.util.GregorianCalendar;

public class InvalidDateException extends RuntimeException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String gc;
	
	public String getGc() {
		return gc;
	}


	public void setGc(String gc) {
		this.gc = gc;
	}


	public InvalidDateException(){
		super("Invalid date");
	}
	
	
	public InvalidDateException(String gc){
		
		super("Invalid date" + gc);
		this.gc = gc;
	}


}
