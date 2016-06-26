package service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.PersonDAO;
import enums.PersonRole;
import model.Person;
import utils.DbUtils;

public class PersonService {
	
	public static void add(Person person) {
		PersonDAO.add(person);
	}

	public static void add(String firstName, String lastName, PersonRole role) {
		PersonDAO.add(firstName, lastName, role);
	}

	public static void delete(Person person) {
		PersonDAO.delete(person);
	}

	public static List<Person> getAll() {
		return PersonDAO.getAll();
	}

	public static List<Person> getPersonsByFullName(String firstName, String lastName) {
		return PersonDAO.getPersonsByFullName(firstName, lastName);
	}

	public static void delete(long id) {
		PersonDAO.delete(id);
	}

	public static Person getPersonById(long id) {
		return PersonDAO.getPersonById(id);
	}

	public static void update(Person person) {
		PersonDAO.update(person);
	}
	
	public static List<Person> getPersonsByRole(String role) {
		return PersonDAO.getPersonsByRole(role);
	}
	
	public static List<Person> sortByFirstName(String order, List<Person> list) {
		List<Person> sortedList = list;
		Collections.sort(sortedList, new Comparator<Person>() {
				@Override
				public int compare(Person o1, Person o2) {
					 return o1.getFirstName().compareTo(o2.getFirstName());
				}
		});
		if (order.equals("DESC")){
		Collections.reverse(sortedList);
		}
		return sortedList;
	}
	
	public static List<Person> sortByFirstName(String order, String role) {
		return sortByFirstName(order, getPersonsByRole(role));
	}
	
	public static List<Person> sortByFirstNameAndRole(String order, String role) {
		return PersonDAO.sortByFirstNameAndRole(order, role);
	}
	
	public static List<Person> sortByFirstName(String order) {
		return PersonDAO.sortByFirstName(order);
	}
}
