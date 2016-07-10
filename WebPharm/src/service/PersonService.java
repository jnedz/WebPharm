package service;

import java.util.GregorianCalendar;
import java.util.List;

import dao.PersonDAO;
import enums.PersonRole;
import model.Person;

public class PersonService {

	public static void add(Person person){
		PersonDAO.add(person);
	}
	
	public static void add(String firstName, String lastName, PersonRole role){
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setRole(role);
		person.setDateOfBirthday(new GregorianCalendar());
		person.setLogin("");
		person.setPassword("");
		PersonDAO.add(person);
	}
	
	public static void delete(int id){
		PersonDAO.delete(id);;
	}
	
	public static void delete(Person person){
		PersonDAO.delete(person.getId());
	}
	
	public static List<Person> getAll(){
		return PersonDAO.getAll();
	}
	
	public static List<Person> getPersonsByFullName(String firstName,
			String lastName) {
		return PersonDAO.getPersonsByFullName(firstName, lastName);
	}
	
	public static Person getPersonById(int id) {
		return PersonDAO.getPersonById(id);
	}
	
	public static void update(Person person) {
		PersonDAO.update(person);
	}
	
	public static void updateAllPerson(Person person) {
		PersonDAO.updateAllPerson(person);
	}
	
	public static List<Person> sortByCriteria(String criteria, String order, String role) {
		if ("NoSort".equals(order)) {
			order = "";
		}
		if ("AllPersons".equals(role)){
			role = "";
		}
		return PersonDAO.sort(criteria, order, role);
	}
	
}
