package model;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import enums.PersonRole;

public class PersonsInfo {


	private int id;
	private String firstName;
	private String lastName;
	private PersonRole role;
	private GregorianCalendar DateOfBirthday;
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
				+ getLastName().toString() + "; "  + "Role: " + getRole() + "; " + "Date of birthday: " + getDateOfBirthdayInString() + 
				"login: " + getLogin() + " password: " + getPassword();
	}

}
