package dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.Statement;

import enums.PersonRole;
import model.Medicine;
import model.Person;
import model.User;
import utils.DbUtils;

public class UserDAO {
	
	/**
	 * 
	 * @param user
	 *            user which is adding into users table
	 */
	public static void add(User user) {
		String sql = "INSERT INTO Users (login, password, role) VALUES (?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, user.getLogin());
			statement.setString(2, user.getPassword());
			statement.setString(3, user.getRole().name());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(User user)!");
			e.printStackTrace();
		}
	}
	
	public static List<User> getAll() {
		String sql = "SELECT * FROM users";
		List<User> usersList = new ArrayList<>();
		User user = new User();
		try {
			Statement statement = (Statement) DbUtils.getConnection()
					.createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				user = new User();
				user.setId(result.getInt(1));
				user.setLogin(result.getString(2));
				user.setPassword(result.getString(3));
				user.setRole(PersonRole.valueOf(result.getString(4)));
				usersList.add(user);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAllUsers()!");
			ex.printStackTrace();
		}
		return usersList;
	}

}
