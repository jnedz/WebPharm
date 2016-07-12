package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import enums.PersonRole;
import model.Person;
import utils.DbUtils;

public class PersonDAO {

	/**
	 * 
	 * @param rs
	 * @return personsInfo
	 * @throws SQLException
	 */
	private static Person convert(ResultSet rs) throws SQLException {
		Person person = new Person();
		person.setId(rs.getInt(1));
		person.setFirstName(rs.getString(2));
		person.setLastName(rs.getString(3));
		person.setRole(PersonRole.valueOf(rs.getString(4)));
		Date date = Date.valueOf(rs.getDate(5).toString());
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		person.setDateOfBirthday(cal);
		person.setLogin(rs.getString(6));
		person.setPassword(rs.getString(7));
		return person;
	}

	public static void add(Person person) {

		String sql = "INSERT INTO Persons (firstName, lastName, role, dateOfBirthday, login, password) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection()
					.prepareStatement(sql);
			statement.setString(1, person.getFirstName());
			statement.setString(2, person.getLastName());
			statement.setString(3, person.getRole().name());
			Calendar calendar = person.getDateOfBirthday();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(4, date);
			statement.setString(5, person.getLogin());
			statement.setString(6, person.getPassword());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out
						.println("A new person was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(Person person)!");
			e.printStackTrace();
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
			System.out.println("Exception in getAllPersonsInfo()!");
			ex.printStackTrace();
		}
		return personsList;
	}

	public static List<Person> getPersonsByFullName(String firstName,
			String lastName) {
		List<Person> personsList = new ArrayList<>();
		Person person = new Person();
		String sql = "SELECT * FROM persons where firstName = '"
				+ firstName + "' and lastName = '" + lastName
				+ "' or firstName = '" + lastName + "' and lastName = '"
				+ firstName + "'";
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				person = new Person();
				person.setId(rs.getInt(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setRole(PersonRole.valueOf(rs.getString(4)));
				Date date = Date.valueOf(rs.getDate(5).toString());
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				person.setDateOfBirthday(cal);
				person.setLogin(rs.getString(6));
				person.setPassword(rs.getString(7));
				
				if (personsList.isEmpty()) {
					personsList.add(person);
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
					personsList.add(person);
				}
			}
			statement.close();
		} catch (SQLException e) {
			System.out
					.println("Exception in getPersonByFullName(String firstName, String lastName)!");
			e.printStackTrace();
		}
		return personsList;
	}

	public static void delete(int id) {
		String sql = "DELETE FROM persons WHERE id=?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils
					.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A person was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(int id) - persons!");
			ex.printStackTrace();
		}
	}

	public static Person getPersonById(int id) {
		String sql = "SELECT * FROM persons WHERE id= " + id;
		Person person = new Person();
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				person.setId(rs.getInt(1));
				person.setFirstName(rs.getString(2));
				person.setLastName(rs.getString(3));
				person.setRole(PersonRole.valueOf(rs.getString(4)));
				Date date = Date.valueOf(rs.getDate(5).toString());
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				person.setDateOfBirthday(cal);
				person.setLogin(rs.getString(6));
				person.setPassword(rs.getString(7));
				return person;
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getPersonsInfoById(int id)!");
			e.printStackTrace();
		}
		return person;
	}

	public static void updateAllPerson(Person person) {
		String sql = "UPDATE persons SET firstName = ?, lastName = ?, role = ?, dateOfBirthday = ? login = ? password = ? WHERE id= "
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
			statement.setString(5, person.getLogin());
			statement.setString(6, person.getPassword());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out
						.println("An existing person was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out
					.println("Exception in updateAllPerson(Person person)!");
			e.printStackTrace();
		}
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

	public static List<Person> sort(String criteria,
			String order, String role) {
		List<Person> persons = new ArrayList<>();
		String sql = "SELECT * FROM persons";
		try {

			if (!(role.equals(""))) {
				sql = sql + " where role = '" + role + "'";
			}

			if (!(order.equals(""))) {
				sql = sql.concat(" order by " + criteria + " " + order);
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

}
