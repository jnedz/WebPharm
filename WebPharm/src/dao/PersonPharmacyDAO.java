package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import enums.PersonRole;
import model.Person;
import model.Pharmacy;
import utils.DbUtils;

public class PersonPharmacyDAO {

	
	/**
	 * 
	 * @param pi
	 * @param ph
	 * @param role
	 */
	public static void add(Person pi, Pharmacy ph) {

		String sql = "INSERT INTO persons_pharmacies (id_person, id_pharmacy, role) VALUES (?, ?, ?)";

		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, pi.getId());
			statement.setInt(2, ph.getId());
			statement.setString(3, pi.getRole().name());
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new persons_pharmacies was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in add(persons_pharmacies)!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param Person pi
	 * @param Pharmacy ph
	 *            delete Person from Pharmacy (from the table)
	 */
	public static void delete(Person pi, Pharmacy ph) {
		String sql = "DELETE FROM Persons_Pharmacy WHERE id_person = ? and id_pharmacy = ?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, pi.getId());
			statement.setInt(2, ph.getId());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A Persons_Pharmacy was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in delete(Person pi, Pharmacy ph)!");
			ex.printStackTrace();
		}
	}

/**
 * 
 * @param pi
 * @param ph
 * @return role
 */
	public static PersonRole getRole(Person pi, Pharmacy ph) {
			String sql = "SELECT role FROM persons_pharmacies where persons_pharmacies.id_person = "
					+ pi.getId() + " and persons_pharmacies.id_pharmacy = " + ph.getId();
			PersonRole role = null;
			try {
				java.sql.Statement statement = DbUtils.getConnection().createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					role = PersonRole.valueOf(result.getString(1));
				}
				statement.close();
			} catch (SQLException e) {
				System.out.println("Exception in getRole(person, pharmacy)!");
			}
		return role;
	}

	/**
	 * @param person
	 * @return pharmacies
	 */
		public static List<Pharmacy> getPharmacies(Person person) {
				String sql = "SELECT id_pharmacy FROM persons_pharmacies where id_person = "
						+ person.getId() + " and role = '" + person.getRole().name() + "'";
				
				Pharmacy pharmacy = new Pharmacy();
				List<Pharmacy>pharmacies = new ArrayList<>();
				try {
					java.sql.Statement statement = DbUtils.getConnection().createStatement();
					ResultSet result = statement.executeQuery(sql);
					while (result.next()) {
						pharmacy = PharmacyDAO.getPharmacyById(result.getInt("id_pharmacy"));
						pharmacies.add(pharmacy);
					}
					statement.close();
				} catch (SQLException e) {
					System.out.println("Exception in getPharmacies(person)!");
				}
			return pharmacies;
		}
		
	/**
	 * @param personsInfo
	 * @param pharmacy
	 * @param newRole
	 *            {@literal update price in couple pharmacy-medicine}
	 */
	public static void update(Person pi, Pharmacy ph, PersonRole newRole) {
		String sql = "UPDATE persons_pharmacies SET role = ? WHERE id_pharmacy = " + ph.getId()
				+ " and id_person = " + pi.getId();
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, newRole.name());

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing persons_pharmacy was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(person pharmacy, role)");
			e.printStackTrace();
		}
	}

}
