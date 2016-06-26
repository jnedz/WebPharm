package model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import enums.PersonRole;

public class Person {

	private long id;
	private String firstName;
	private String lastName;
	private PersonRole role;
	private GregorianCalendar DateOfBirthday;

	public GregorianCalendar getDateOfBirthday() {
		return DateOfBirthday;
	}

	public void setDateOfBirthday(GregorianCalendar dateOfBirthday) {
		DateOfBirthday = dateOfBirthday;
	}

	public PersonRole getRole() {
		return role;
	}

	public void setRole(PersonRole role) {
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDateOfBirthdayInString() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String date = format.format(getDateOfBirthday().getTime());
		return date;
	}

	@Override
	public String toString() {
		// SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		// String date = format.format(getDateOfBirthday().getTime());
		return "\nid = " + id + "; " + "First name: " + getFirstName().toString() + "; " + " Last name: "
				+ getLastName().toString() + "; "  + "Role: " + getRole() + "; " + "Date of birthday: " + getDateOfBirthdayInString();
	}

}
