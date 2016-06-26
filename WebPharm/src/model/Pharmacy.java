package model;

import java.util.List;

public class Pharmacy {

	private int id;
	private String description;
	private String title;
	
	private List<Person> persons;
	private List<Medicine> medicines;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public List<Medicine> getMedicines() {
		return medicines;
	}
	public void setMedicines(List<Medicine> medicines) {
		this.medicines = medicines;
	}
	
	@Override
	public String toString() {
		return "\nId Pharmacy = " + getId() + "; Title: " + getTitle() + "; Description: " + getDescription(); 
	}
}
