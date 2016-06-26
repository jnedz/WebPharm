package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import model.Person;
import utils.DbUtils;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import enums.PersonRole;

public class PersonDAO {

	/**
	 * 
	 * @param rs
	 * @return person
	 * @throws SQLException
	 */
	private static Person convert(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setId(rs.getLong(1));
		person.setFirstName(rs.getString(2));
		person.setLastName(rs.getString(3));
		person.setRole(PersonRole.valueOf(rs.getString(4)));
		Date date = Date.valueOf(rs.getDate(5).toString());
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		person.setDateOfBirthday(cal);
		return person;
	}

	public static void add(Person person) {

		String sql = "INSERT INTO Persons (firstName, lastName, role, dateOfBirthday) VALUES (?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection()
					.prepareStatement(sql);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setString(3, person.getRole().name());
			Calendar calendar = person.getDateOfBirthday();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(4, date);

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new person was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in addPerson(Person person)!");
			e.printStackTrace();
		}
	}

	public static void add(String firstName, String lastName, PersonRole role) {
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setRole(role);
		person.setDateOfBirthday(new GregorianCalendar());
		add(person);
	}

	public static void delete(Person person) {
		String sql = "DELETE FROM persons WHERE id = ?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils
					.getConnection().prepareStatement(sql);
			statement.setLong(1, person.getId());
			statement.executeUpdate();
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A person was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(Person person)!");
			ex.printStackTrace();
		}
	}

	public static List<Person> getAll() {
		String sql = "SELECT * FROM persons";
		List<Person> personsList = new ArrayList<>();
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				personsList.add(convert(result));
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAllPersons()!");
			ex.printStackTrace();
		}
		return personsList;
	}

	public static List<Person> getPersonsByFullName(String firstName,
			String lastName) {
		List<Person> personsList = new ArrayList<>();
		Person person = new Person();
		String sql = "SELECT * FROM persons where firstName = '" + firstName
				+ "' and lastName = '" + lastName + "' or firstName = '"
				+ lastName + "' and lastName = '" + firstName + "'";
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				if (personsList.isEmpty()) {
					personsList.add(convert(result));
				}
				boolean isExists = false;
				for (int i = 0; i < personsList.size(); i++) {
					if (person.getDateOfBirthday().equals(
							personsList.get(i).getDateOfBirthday())) {
						isExists = true;
						break;
					}
				}
				if (!isExists) {
					personsList.add(convert(result));
				}
			}
			statement.close();
		} catch (SQLException e) {
			System.out
					.println("Exception in getPersonsByFullName(String firstName, String lastName)!");
			e.printStackTrace();
		}
		return personsList;
	}

	public static void delete(long id) {
		String sql = "DELETE FROM persons WHERE id=?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils
					.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A person was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in deletePerson(long id)!");
			ex.printStackTrace();
		}
	}

	public static Person getPersonById(long id) {
		String sql = "SELECT * FROM persons WHERE id= " + id;
		Person person = new Person();
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				person.setId(rs.getLong(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setRole(PersonRole.valueOf(rs.getString(4)));
				Date date = Date.valueOf(rs.getDate(5).toString());
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				person.setDateOfBirthday(cal);
				return person;
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getPersonById(long id)!");
			e.printStackTrace();
		}
		return person;
	}

	public static void update(Person person) {
		String sql = "UPDATE persons SET firstName = ?, lastName = ?, role = ?, dateOfBirthday = ? WHERE id= "
				+ person.getId();
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils
					.getConnection().prepareStatement(sql);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setString(3, person.getRole().name());
			Calendar calendar = person.getDateOfBirthday();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(4, date);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out
						.println("An existing person was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(Person person)!");
			e.printStackTrace();
		}
	}

	public static List<Person> getPersonsByRole(String role) {
		List<Person> personsList = new ArrayList<>();
		String sql = "SELECT * FROM persons where role = '" + role + "'";
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				personsList.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getPersonsByRole(String role)!");
			e.printStackTrace();
		}
		return personsList;
	}

	public static List<Person> sortByFirstNameAndRole(String order, String role) {
		String sql = "SELECT * FROM persons WHERE role = '" + role
				+ "' order by firstName " + order;
		List<Person> persons = new ArrayList<>();
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				persons.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out
					.println("sortByFirstNameAndRole(String order, String role)!");
			e.printStackTrace();
		}
		return persons;
	}

	public static List<Person> sortByFirstName(String order) {
		String sql = "SELECT * FROM persons order by firstName " + order;
		List<Person> persons = new ArrayList<>();
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				persons.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("sortByFirstName(String order) !");
			e.printStackTrace();
		}
		return persons;
	}

	public static void main(String[] args) {

		System.out.println(Arrays.asList(PersonRole.values()).contains(
				PersonRole.WORKER));
		String str = "WORKER";
		for (PersonRole role : PersonRole.values()) {

			System.out.println(str.equals(role.toString()));
		}
	}

	public static List<Person> sort1(String... args) {
		List<Person> persons = new ArrayList<>();
		// PersonRole role = null;
		String sql = "Select * from persons";
		try {

			for (int i = 0; i < args.length; i++) {
				try {
					PersonRole role = PersonRole.valueOf(args[i].toString());
					sql = sql + " where role = '" + role + "'";
				} catch (Exception e) {
				}
			}
			for (int i = 0; i < args.length; i++) {
				if (args[i].equals("ASC") || args[i].equals("DESC")) {
					String order = args[i].toString();
					sql = sql.concat(" order by firstName " + order);
				}
			}
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				persons.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("exception in PersonDAO.sort1()!");
			e.printStackTrace();
		}
		return persons;
	}

	public static List<Person> sort(String order, String role) {
		List<Person> persons = new ArrayList<>();
		String sql = "SELECT * FROM persons";
		try {
		
			if (!(role.equals("AllPersons"))) {
				sql = sql + " where role = '" + role + "'";
			}

			if (!(order.equals("NoSort"))) {
				sql = sql.concat(" order by firstName " + order);
			}

			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				persons.add(convert(result));
			}
			statement.close();

			return persons;
		} catch (SQLException e) {
			System.out.println("exception in PersonDAO.sort()!");
			e.printStackTrace();
		}
		return persons;
	}
	
	
	public static List<Person> sortByCriteria(String criteria, String order, String role) {
		List<Person> persons = new ArrayList<>();
		String sql = "SELECT * FROM persons";
		try {
		
			if (!(role.equals("AllPersons"))) {
				sql = sql + " where role = '" + role + "'";
			}

			if (!(order.equals("NoSort"))) {
				sql = sql.concat(" order by "+ criteria + " "+ order);
			}

			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				persons.add(convert(result));
			}
			statement.close();

			return persons;
		} catch (SQLException e) {
			System.out.println("exception in PersonDAO.sort()!");
			e.printStackTrace();
		}
		return persons;
	}

	public static List<Person> getPersonsByFullNameAndDate(String firstName,
			String lastName, String date) {
		List<Person> personsList = new ArrayList<>();
		String sql = "SELECT * FROM persons where firstName = '" + firstName
				+ "' and lastName = '" + lastName + "' and dateOfBirthday = '"
				+ date + "'";
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				personsList.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out
					.println("Exception in getPersonsByFullNameAndDate(String firstName, String lastName, String date)!");
			e.printStackTrace();
		}
		return personsList;
	}

}
