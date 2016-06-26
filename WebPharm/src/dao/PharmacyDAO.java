package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.Pharmacy;
import utils.DbUtils;

public class PharmacyDAO {
	
	public static void add(Pharmacy pharmacy) {
		String sql = "INSERT INTO pharmacies (title, description) VALUES (?, ?)";
		
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, pharmacy.getTitle());
			statement.setString(2, pharmacy.getDescription());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new pharmacy was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in addPharmacy(Pharmacy pharmacy)!");
			e.printStackTrace();
		}
	}
	
	public static void add(String title, String description) {
		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setTitle(title);
		pharmacy.setDescription(description);
		add(pharmacy);
	}

	public static void delete(Pharmacy pharmacy) {
		String sql = "DELETE FROM pharmacies WHERE id = ?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, pharmacy.getId());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A pharmasy was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in deletePharmacy(Pharmacy pharmacy)");
		}
	}
	
	public static void delete(int id) {
		String sql = "DELETE FROM pharmacies WHERE id = ?";
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A pharmasy was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in deletePharmacy(int id)");
			ex.printStackTrace();
		}
	}
	
	public static List<Pharmacy> getAll() {
		String sql = "SELECT * FROM pharmacies";
		List<Pharmacy> pharmaciesList = new ArrayList<>();
		Pharmacy pharmacy = new Pharmacy();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				pharmacy = new Pharmacy();
				pharmacy.setId(result.getInt(1));
				pharmacy.setTitle(result.getString(2));
				pharmacy.setDescription(result.getString(3));
				pharmaciesList.add(pharmacy);
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAllPharmacies()!");
			ex.printStackTrace();
		}
		return pharmaciesList;
	}

	public static Pharmacy getPharmacyById(int id) {
		String sql = "SELECT * FROM pharmacies WHERE id = " + id;
		Pharmacy pharmacy = new Pharmacy();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				pharmacy.setId(id);
				pharmacy.setTitle(result.getString(2));
				pharmacy.setDescription(result.getString(3));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getPharmacyById(int id)!");
			e.printStackTrace();
		}
		return pharmacy;
	}

	public static void update(Pharmacy pharmacy) {
		String sql = "UPDATE pharmacies SET title = ?, description = ? WHERE id= "
				+ pharmacy.getId();
		try {
			PreparedStatement statement = (PreparedStatement) DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, pharmacy.getTitle());
			statement.setString(2, pharmacy.getDescription());
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing pharmacy was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(Pharmacy pharmacy)!");
			e.printStackTrace();
		}
	}
	
	public static List<Pharmacy> getPharmaciesByTitle(String title) {
		List<Pharmacy> pharmacies = new ArrayList<>();
		Pharmacy pharmacy = new Pharmacy();
		String sql = "SELECT * FROM pharmacies where title = '" + title + "'";
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				pharmacy = new Pharmacy();
				pharmacy.setId(result.getInt(1));
				pharmacy.setTitle(title);
				pharmacy.setDescription(result.getString(3));
				pharmacies.add(pharmacy);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getProducersByTitle(String title)!");
			e.printStackTrace();
		}
		return pharmacies;
	}

}
