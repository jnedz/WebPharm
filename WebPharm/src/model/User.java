package model;

import enums.PersonRole;

public class User {

	private int id;
	private String login;
	private String password;
	private PersonRole role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public PersonRole getRole() {
		return role;
	}
	public void setRole(PersonRole role) {
		this.role = role;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "\nid=" + getId() + " login: " + getLogin().toString() + " password: " + getPassword().toString() + " role: " + getRole();
	}
}
