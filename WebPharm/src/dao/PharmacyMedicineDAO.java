package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import enums.Country;
import enums.MedicineType;
import model.Medicine;
import model.Pharmacy;
import model.Producer;
import utils.DbUtils;

public class PharmacyMedicineDAO {
	/**
	 * 
	 * @param ph
	 * @param med
	 * @param count
	 *            medicine count which must be in pharmacies_medicines table
	 */
	public static void add(Pharmacy ph, Medicine med, int count) {

		String sql = "INSERT INTO pharmacies_medicines (id_pharmacy, id_medicine, price, count) VALUES (?, ?, ?, ?)";

		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, ph.getId());
			statement.setInt(2, med.getId());
			statement.setDouble(3, med.getPrice());
			statement.setInt(4, count);
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new pharmacy-medicine was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in addPharmacy_medicines(PharmacyMedicine pm)!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 *            delete couple pharmacy-medicine from the table
	 */
	public static void delete(Pharmacy pharmacy, Medicine medicine) {
		String sql = "DELETE FROM pharmacies_medicines WHERE id_pharmacy = ? and id_medicine = ?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, pharmacy.getId());
			statement.setInt(2, medicine.getId());
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A pharmacy_medicine was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in deletePharmacyMedicine(Int id)!");
			ex.printStackTrace();
		}
	}


	/**
	 * 
	 * @param pharmId
	 *            pharmacy id
	 * @return all medicines from one pharmacy with id = pharId
	 */
	public static List<Medicine> getAllMedsByPharmId(int pharmId) {
		List<Medicine> medicines = new ArrayList<>();
		Medicine med = new Medicine();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id where medicines.id in (select distinct id_medicine from pharmacies_medicines where "
				+ "id_pharmacy = " + pharmId + ")";	
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				med = new Medicine();
				med.setId(result.getInt(1));
				med.setTitle(result.getString(2));
				med.setType(MedicineType.valueOf(result.getString(3)));
				Date date = Date.valueOf(result.getDate(4).toString());
				GregorianCalendar cal = new GregorianCalendar();
				cal.setTime(date);
				med.setDateOfManufact(cal);
				med.setTerm(result.getInt(5));
				med.setPrice(getPrice(PharmacyDAO.getPharmacyById(pharmId), med));
				med.setCount(get—ountOfMed(PharmacyDAO.getPharmacyById(pharmId), med));

				Producer producer = new Producer();
				producer.setId(result.getInt("id_producer"));
				producer.setTitle(result.getString("title"));
				producer.setCountry(Country.valueOf(result.getString("country")));
				med.setProducer(producer);

				medicines.add(med);
			}
			Collections.sort(medicines, new Comparator<Medicine>() {

				public int compare(Medicine o1, Medicine o2) {

					if (o1.getType().compareTo(o2.getType()) == 0) {
						return o1.getTitle().compareTo(o2.getTitle());
					} else {
						return (o1.getType().name()).compareTo(o2.getType().name());
					}
				}
			});
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getPharmMedsByPharmId(int pharmId)!");
			e.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @param medTitle
	 *            medicines title
	 * @return a list of Pharmacies that have medicines with title medTitle
	 */
	public static List<Pharmacy> getPharmByMedTitle(String medTitle) {
		List<Pharmacy> list = new ArrayList<>();
		Pharmacy pharmacy = new Pharmacy();
			String sql = "select * from pharmacies where id in (select distinct id_pharmacy from pharmacies_medicines where "
			+ "id_pharmacy in (select id from medicines where title='" + medTitle + "'))";

			try {
				Statement statement = (Statement) DbUtils.getConnection().createStatement();
				ResultSet result = statement.executeQuery(sql);

				while (result.next()) {
					pharmacy = new Pharmacy();
					pharmacy.setId(result.getInt("id"));
					pharmacy.setTitle(result.getString("title"));
					pharmacy.setDescription(result.getString("description"));
					list.add(pharmacy);
				}
				statement.close();
			} catch (SQLException e) {
				System.out.println("Exception in getPharmByMedTitle(medTitile)!");
				e.printStackTrace();
			}
		return list;
	}


	/**
	 * 
	 * @param pharmacy
	 *            pharmacy
	 * @param medTitle
	 *            medicine's title
	 * @return count of medicines with title = medTitle (from one pharmacy =
	 *         pharmacy)
	 */
	public static int get—ountByMedTitleFromPharm(Pharmacy pharmacy, String medTitle) {
		int count = 0;

		for (Medicine med : MedicineDAO.getMedicinesByTitle(medTitle)) {
			int id = med.getId();

			String sql = "SELECT sum(pharmacies_medicines.count) FROM pharmacies_medicines where pharmacies_medicines.id_medicine = "
					+ id + " and pharmacies_medicines.id_pharmacy = " + pharmacy.getId();
			try {
				java.sql.Statement statement = DbUtils.getConnection().createStatement();
				ResultSet result = statement.executeQuery(sql);
				while (result.next()) {
					count += result.getInt(1);
				}
				statement.close();
			} catch (SQLException e) {
				System.out.println("Exception in get—ountByTitleFromPharm(pharmacy, medTitle)!");
			}
		}
		return count;
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @return count of medicine(by one Id) from the pharmacy
	 */
	public static int get—ountOfMed(Pharmacy pharmacy, Medicine medicine) {
		int count = 0;
		String sql = "SELECT count FROM pharmacies_medicines where pharmacies_medicines.id_medicine = "
				+ medicine.getId() + " and pharmacies_medicines.id_pharmacy = " + pharmacy.getId();
		try {
			java.sql.Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				count = result.getInt(1);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in get—ountMed(pharmacy, medicine)!");
		}
		return count;
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @return price of medicine from the couple pharmacy-medicine
	 */
	public static double getPrice(Pharmacy pharmacy, Medicine medicine) {
		double price = 0;
		String sql = "SELECT price FROM pharmacies_medicines where pharmacies_medicines.id_medicine = "
				+ medicine.getId() + " and pharmacies_medicines.id_pharmacy = " + pharmacy.getId();
		try {
			java.sql.Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				price = result.getDouble(1);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in get—ountMed(pharmacy, medicine)!");
		}
		return price;
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @param newPrice
	 *            {@literal update price in couple pharmacy-medicine}
	 */
	public static void update(Pharmacy pharmacy, Medicine medicine, double newPrice) {
		String sql = "UPDATE pharmacies_medicines SET price = ? WHERE id_pharmacy = " + pharmacy.getId()
				+ " and id_medicine = " + medicine.getId();
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setDouble(1, newPrice);

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing pharmacy_medicine was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(pharm, med, price)");
			e.printStackTrace();
		}
	}

	/**
	 * @param ph
	 * @param med
	 * @param newCount
	 *            {@literal update count in couple pharmacy-medicine}
	 */
	public static void update(Pharmacy ph, Medicine med, int newCount) {
		String sql = "UPDATE pharmacies_medicines SET count = ? WHERE id_pharmacy = " + ph.getId()
				+ " and id_medicine = " + med.getId();
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);

			statement.setInt(1, newCount);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing pharmacy_medicine was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(PharmacyMedicine pm)");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @return boolean true if medicine is in pharmacy else return false
	 */
	public static boolean isExists(Pharmacy pharmacy, Medicine medicine) {
		boolean res = false;
		String sql = "SELECT pharmacies_medicines.id_medicine FROM pharmacies_medicines where id_pharmacy = ? and id_medicine = ?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setInt(1, pharmacy.getId());
			statement.setInt(2, medicine.getId());
			ResultSet result = statement.executeQuery();
			res = result.next();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in isExists(Pharmacy pharmacy, Medicine medicine)!");
			e.printStackTrace();
		}
		return res;
	}
}