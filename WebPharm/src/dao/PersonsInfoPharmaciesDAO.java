package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import enums.PersonRole;
import model.PersonsInfo;
import model.Pharmacy;
import utils.DbUtils;

public class PersonsInfoPharmaciesDAO {

	
	/**
	 * 
	 * @param pi
	 * @param ph
	 * @param role
	 */
	public static void add(PersonsInfo pi, Pharmacy ph, String role) {

		String sql = "INSERT INTO personsInfo_pharmacies (id_personsInfo, id_pharmacy, role) VALUES (?, ?, ?)";

		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, pi.getId());
			statement.setInt(2, ph.getId());
			statement.setString(3, role);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new personsInfo_pharmacies was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(personsInfo_pharmacies)!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param PersonsInfo pi
	 * @param Pharmacy ph
	 *            delete Person from Pharmacy (from the table)
	 */
	public static void delete(PersonsInfo pi, Pharmacy ph) {
		String sql = "DELETE FROM PersonsInfo_Pharmacy WHERE id_personsInfo = ? and id_pharmacy = ?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, pi.getId());
			statement.setInt(2, ph.getId());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A PersonsInfo_Pharmacy was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(PersonsInfo pi, Pharmacy ph)!");
			ex.printStackTrace();
		}
	}

/**
 * 
 * @param pi
 * @param ph
 * @return role
 */
	public static PersonRole getRole(PersonsInfo pi, Pharmacy ph) {
			String sql = "SELECT role FROM personsInfo_pharmacies where personsInfo_pharmacies.id_personsInfo = "
					+ pi.getId() + " and personsInfo_pharmacies.id_pharmacy = " + ph.getId();
			PersonRole role = null;
			try {
				java.sql.Statement statement = DbUtils.getConnection().createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					role = PersonRole.valueOf(result.getString(1));
				}
				statement.close();
			} catch (SQLException e) {
				System.out.println("Exception in getRole(personInfo, pharmacy)!");
			}
		return role;
	}

	
	/**
	 * @param personsInfo
	 * @param pharmacy
	 * @param newRole
	 *            {@literal update price in couple pharmacy-medicine}
	 */
	public static void update(PersonsInfo pi, Pharmacy ph, PersonRole newRole) {
		String sql = "UPDATE personsInfo_pharmacies SET role = ? WHERE id_pharmacy = " + ph.getId()
				+ " and id_pharmacy = " + ph.getId();
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, newRole.name());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing personsInfo_pharmacy was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(personsInfo, pharmacy, role)");
			e.printStackTrace();
		}
	}

}
