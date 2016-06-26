package model;

import enums.Country;

public class Producer {
	
	private int id;
	private String title;
	private Country country;
	
	public int getId() {
		return id;
	}
	public void setId(int producerId) {
		this.id = producerId;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Country getCountry() {
		return country;
	}
	public void setCountry(Country country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return "\n	producerId = " + getId() + ", producerTitle: " + getTitle() + ", producerCountry: " + getCountry();
	}
	
}
