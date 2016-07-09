package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import enums.PersonRole;
import model.PersonsInfo;
import utils.DbUtils;

public class PersonsInfoDAO {

	/**
	 * 
	 * @param rs
	 * @return personsInfo
	 * @throws SQLException
	 */
	private static PersonsInfo convert(ResultSet rs) throws SQLException {
		PersonsInfo person = new PersonsInfo();
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

	public static void add(PersonsInfo person) {

		String sql = "INSERT INTO PersonsInfo (firstName, lastName, role, dateOfBirthday, login, password) VALUES (?, ?, ?, ?, ?, ?)";
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
						.println("A new personsInfo was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(PersonsInfo person)!");
			e.printStackTrace();
		}
	}

	public static void add(String firstName, String lastName, PersonRole role) {
		PersonsInfo person = new PersonsInfo();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setRole(role);
		person.setDateOfBirthday(new GregorianCalendar());
		person.setLogin("");
		person.setPassword("");
		add(person);
	}

	public static void delete(PersonsInfo person) {

		// delete(person.getId());
		String sql = "DELETE FROM personsInfo WHERE id = ?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils
					.getConnection().prepareStatement(sql);
			statement.setInt(1, person.getId());
			statement.executeUpdate();
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A personsInfo was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(PersonsInfo person)!");
			ex.printStackTrace();
		}
	}

	public static List<PersonsInfo> getAll() {
		String sql = "SELECT * FROM personsInfo";
		List<PersonsInfo> personsList = new ArrayList<>();
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

	public static List<PersonsInfo> getPersonsInfoByFullName(String firstName,
			String lastName) {
		List<PersonsInfo> personsList = new ArrayList<>();
		PersonsInfo person = new PersonsInfo();
		String sql = "SELECT * FROM personsInfo where firstName = '"
				+ firstName + "' and lastName = '" + lastName
				+ "' or firstName = '" + lastName + "' and lastName = '"
				+ firstName + "'";
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
					.println("Exception in getPersonsInfoByFullName(String firstName, String lastName)!");
			e.printStackTrace();
		}
		return personsList;
	}

	public static void delete(int id) {
		String sql = "DELETE FROM personsInfo WHERE id=?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils
					.getConnection().prepareStatement(sql);
			statement.setInt(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A personsInfo was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(int id) - personsInfo!");
			ex.printStackTrace();
		}
	}

	public static PersonsInfo getPersonsInfoById(int id) {
		String sql = "SELECT * FROM personsInfo WHERE id= " + id;
		PersonsInfo person = new PersonsInfo();
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

	public static void updateAllPersonsInfo(PersonsInfo person) {
		String sql = "UPDATE personsInfo SET firstName = ?, lastName = ?, role = ?, dateOfBirthday = ? login = ? password = ? WHERE id= "
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
						.println("An existing personsInfo was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out
					.println("Exception in updateAllPersonsInfo(PersonsInfo person)!");
			e.printStackTrace();
		}
	}

	public static void update(PersonsInfo person) {
		String sql = "UPDATE personsInfo SET firstName = ?, lastName = ?, role = ?, dateOfBirthday = ? WHERE id= "
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
						.println("An existing personsInfo was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(PersonsInfo person)!");
			e.printStackTrace();
		}
	}

	public static List<PersonsInfo> getPersonsInfoByRole(String role) {
		List<PersonsInfo> personsList = new ArrayList<>();
		String sql = "SELECT * FROM personsInfo where role = '" + role + "'";
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
					.println("Exception in getPersonsInfoByRole(String role)!");
			e.printStackTrace();
		}
		return personsList;
	}

	public static List<PersonsInfo> sortByFirstNameAndRole(String order,
			String role) {
		String sql = "SELECT * FROM personsInfo WHERE role = '" + role
				+ "' order by firstName " + order;
		List<PersonsInfo> persons = new ArrayList<>();
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

	public static List<PersonsInfo> sortByFirstName(String order) {
		String sql = "SELECT * FROM personsInfo order by firstName " + order;
		List<PersonsInfo> persons = new ArrayList<>();
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

	public static List<PersonsInfo> sort1(String... args) {
		List<PersonsInfo> persons = new ArrayList<>();
		// PersonRole role = null;
		String sql = "Select * from personsInfo";
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
			System.out.println("exception in PersonsInfoDAO.sort1()!");
			e.printStackTrace();
		}
		return persons;
	}

	public static List<PersonsInfo> sort(String order, String role) {
		List<PersonsInfo> persons = new ArrayList<>();
		String sql = "SELECT * FROM personsInfo";
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
			System.out.println("exception in PersonsInfoDAO.sort()!");
			e.printStackTrace();
		}
		return persons;
	}

	public static List<PersonsInfo> sortByCriteria(String criteria,
			String order, String role) {
		List<PersonsInfo> persons = new ArrayList<>();
		String sql = "SELECT * FROM personsInfo";
		try {

			if (!(role.equals("AllPersons"))) {
				sql = sql + " where role = '" + role + "'";
			}

			// TODO if (!(order.equals(""))) {
			if (!(order.equals("NoSort"))) {
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
			System.out.println("exception in PersonsInfoDAO.sort()!");
			e.printStackTrace();
		}
		return persons;
	}

	public static List<PersonsInfo> getPersonsInfoByFullNameAndDate(
			String firstName, String lastName, String date) {
		List<PersonsInfo> personsList = new ArrayList<>();
		String sql = "SELECT * FROM personsInfo where firstName = '"
				+ firstName + "' and lastName = '" + lastName
				+ "' and dateOfBirthday = '" + date + "'";
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
					.println("Exception in getPersonsInfoByFullNameAndDate(String firstName, String lastName, String date)!");
			e.printStackTrace();
		}
		return personsList;
	}

}
