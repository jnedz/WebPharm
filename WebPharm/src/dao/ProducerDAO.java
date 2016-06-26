package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import enums.Country;
import model.Producer;
import utils.DbUtils;

public class ProducerDAO {

	public static void add(Producer producer) {
		String sql = "INSERT INTO producers (title, country) VALUES (?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, producer.getTitle());
			statement.setString(2, producer.getCountry().name());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new producer was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in addProducer(Producer producer)!");
			e.printStackTrace();
		}
	}

	public static void add(String titleProd, Country country) {
		Producer producer = new Producer();
		producer.setTitle(titleProd);
		producer.setCountry(country);
		add(producer);
	}

	/*
	 * @Exception if we can't delete producer used in Medicines table 
	 */
	public static void delete(Producer producer) throws SQLException {
		String sql = "DELETE FROM producers WHERE id = ?";
		PreparedStatement statement = (PreparedStatement) DbUtils.getConnection().prepareStatement(sql);
		statement.setInt(1, producer.getId());
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("A producer was deleted successfully!");
		}
		statement.close();
	}

	/*
	 * @Exception if we can't delete producer used in Medicines table 
	 */
	public static void delete(int id) throws SQLException {
		String sql = "DELETE FROM producers WHERE id=?";
		PreparedStatement statement = (PreparedStatement) DbUtils.getConnection().prepareStatement(sql);
		statement.setInt(1, id);
		int rowsDeleted = statement.executeUpdate();
		if (rowsDeleted > 0) {
			System.out.println("A producer was deleted successfully!");
		}
		statement.close();
	}

	public static List<Producer> getAll() {
		String sql = "SELECT * FROM producers";
		List<Producer> producersList = new ArrayList<>();
		Producer producer = new Producer();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				producer = new Producer();
				producer.setId(result.getInt(1));
				producer.setTitle(result.getString(2));
				producer.setCountry(Country.valueOf(result.getString(3)));
				producersList.add(producer);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAllProducers()!");
			ex.printStackTrace();
		}
		return producersList;
	}

	public static Producer getProducerById(int id) {
		String sql = "SELECT * FROM producers WHERE id= " + id;
		Producer producer = new Producer();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				producer.setId(id);
				producer.setTitle(result.getString(2));
				producer.setCountry(Country.valueOf(result.getString(3)));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getProducerById(int id)!");
			e.printStackTrace();
		}
		return producer;
	}

	public static void update(Producer producer) {
		String sql = "UPDATE producers SET title = ?, country = ? WHERE id= "
				+ producer.getId();
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, producer.getTitle());
			statement.setString(2, producer.getCountry().name());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing produser was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(Producer producer)!");
			e.printStackTrace();
		}
	}

	public static List<Producer> getProducersByTitle(String title) {
		List<Producer> producers = new ArrayList<>();
		Producer producer = new Producer();
		String sql = "SELECT * FROM producers where title = '" + title + "'";
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				producer = new Producer();
				producer.setId(result.getInt(1));
				producer.setTitle(title);
				producer.setCountry(Country.valueOf(result.getString(3)));
				producers.add(producer);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getProducersByTitle(String title)!");
			e.printStackTrace();
		}
		return producers;
	}
	
	public static Producer getProducerByTitle(String title) {
		String sql = "SELECT * FROM producers WHERE title= '" + title + "'";
		Producer producer = new Producer();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				producer.setId(result.getInt(1));
				producer.setTitle(title);
				producer.setCountry(Country.valueOf(result.getString(3)));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getProducerByTitle(title)!");
			e.printStackTrace();
		}
		return producer;
	}
}