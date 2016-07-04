package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import enums.Country;
import enums.MedicineType;
import model.Medicine;
import model.Producer;
import service.MedicineService;
import utils.DbUtils;

public class MedicineDAO {

	/**
	 * 
	 * @param rs
	 * @return medicine
	 * @throws SQLException
	 */
	private static Medicine convert(ResultSet rs) throws SQLException {
		Medicine med = new Medicine();
		med.setId(rs.getLong("id"));
		med.setTitle(rs.getString(2));
		med.setType(MedicineType.valueOf(rs.getString(3)));
		Date date = Date.valueOf(rs.getDate(4).toString());
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(date);
		med.setDateOfManufact(cal);
		med.setTerm(rs.getInt(5));
		med.setPrice(rs.getDouble(6));
		med.setCount(rs.getInt(7));

		Producer producer = new Producer();
		producer.setId(rs.getInt("id_producer"));
		producer.setTitle(rs.getString("producers.title"));
		producer.setCountry(Country.valueOf(rs.getString("country")));
		med.setProducer(producer);
		return med;
	}

	/**
	 * 
	 * @param medicine
	 *            medicine which is adding into medicines table
	 */
	public static void add(Medicine medicine) {
		String sql = "INSERT INTO Medicines (title, type, dateOfManufact, term, price, count, id_producer) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			java.sql.PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, medicine.getTitle());
			statement.setString(2, medicine.getType().name());
			Calendar calendar = medicine.getDateOfManufact();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(3, date);
			statement.setInt(4, medicine.getTerm());
			statement.setDouble(5, medicine.getPrice());
			statement.setInt(6, medicine.getCount());
			statement.setInt(7, medicine.getProducer().getId());

			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new medicine was inserted successfully!");
				statement.close();
			}
		} catch (SQLException e) {
			System.out.println("Exception in addMedicine(Medicine medicine)!");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param title
	 * @param type
	 * @param dateOfManufact
	 * @param term
	 * @param price
	 * @param count
	 * @param producerId
	 */
	public static void add(String title, MedicineType type, GregorianCalendar dateOfManufact, int term, double price,
			int count, int producerId) {
		Medicine medicine = new Medicine();
		medicine.setTitle(title);
		medicine.setType(type);
		medicine.setDateOfManufact(dateOfManufact);
		medicine.setTerm(term);
		medicine.setPrice(price);
		medicine.setCount(count);
		Producer p = new Producer();
		p.setId(producerId);
		medicine.setProducer(p);
		add(medicine);
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @return list of medicines with the same title String title
	 */
	public static List<Medicine> getMedicinesByTitle(String title) {
		List<Medicine> medicines = new ArrayList<>();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id  where medicines.title = '"
				+ title + "'";
		try {
			Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				medicines.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicinesByTitle(String title)!");
			e.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @return list of medicines with the same title sorted by date of
	 *         manufacture
	 */
	public static List<Medicine> getMedicinesDateSortedByTitle(String title) {
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id "
				+ "WHERE medicines.title = '" + title + "' order by dateOfManufact ASC";
		List<Medicine> medicines = new ArrayList<>();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				medicines.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicinesDateSortedByTitle(String title)!");
			e.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @param id
	 *            medicine`s id
	 * @return medicine with typed id
	 */
	public static Medicine getMedicineById(long id) {
		Medicine med = new Medicine();
		String sql = "SELECT * FROM medicines join producers ON medicines.id_producer = producers.id WHERE medicines.id = "
				+ id;
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				med = convert(result);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicineById(long id)");
			e.printStackTrace();
		}
		return med;
	}

	/**
	 * 
	 * @param medicine
	 *            medicine for delete
	 */
	public static void delete(Medicine medicine) {
		delete(medicine.getId());
	}

	/**
	 * 
	 * @param id
	 *            id of medicine which we want delete
	 */
	public static void delete(long id) {
		String sql = "DELETE FROM medicines WHERE id=?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setLong(1, id);
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A medicine was deleted successfully!");
			}
			statement.close();
		} catch (SQLException ex) {
			System.out.println("Exception in deleteMedicine(long id)!");
			ex.printStackTrace();
		}
	}

	/**
	 * 
	 * @param medicine
	 *            medicine for update
	 */
	public static void update(Medicine medicine) {
		String sql = "UPDATE medicines SET title = ?, type = ?, dateOfManufact = ?, term = ?, price = ?, count = ? WHERE id= "
				+ medicine.getId();
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, medicine.getTitle());
			statement.setString(2, medicine.getType().name());
			Calendar calendar = medicine.getDateOfManufact();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(3, date);
			statement.setInt(4, medicine.getTerm());
			statement.setDouble(5, medicine.getPrice());
			statement.setInt(6, medicine.getCount());
			// statement.setInt(7, medicine.getProducer().getId());
			// //!!!!!!!!!!!!!!!!!!!!!

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing medicine was updated successfully!");
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in update(Medicine medicine)");
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param producerId
	 * @return list of medicines by producer id
	 */
	public static List<Medicine> getMedicinesByProducerId(int producerId) {
		List<Medicine> medicines = new ArrayList<>();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id WHERE id_producer = "
				+ producerId;
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);

			while (result.next()) {
				medicines.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicinesByProducerId(int producerId)!");
			e.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @return list of all medicines from medicines table
	 */
	public static List<Medicine> getAll() {
		String sql = "SELECT * FROM medicines join producers on medicines.id_producer = producers.id";
		List<Medicine> medicines = new ArrayList<>();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				medicines.add(convert(result));
				System.out.println("////" + convert(result));
			}
			statement.close();
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAll()! (medicines)");
			ex.printStackTrace();
		}
		return medicines;
	}

	// mysql> select type, title, sum(count) from medicines group by title,
	// type;

	public static List<Medicine> getMedicinesWithUniqueTitle() {
		String sql = "SELECT * from medicines join producers on medicines.id_producer = producers.id group by medicines.type, medicines.title";
		List<Medicine> medicines = new ArrayList<>();
		Medicine med = new Medicine();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				med = convert(result);

				boolean addMed = false;

				if (medicines.isEmpty()) {
					med.setCount(get—ountByTitle(med.getTitle()));
					addMed = true;
				} else {
					for (Medicine medicine : medicines) {
						med.setCount(get—ountByTitle(med.getTitle()));
						if (!med.getTitle().equals(medicine.getTitle())) {
							addMed = true;
						}
					}
				}
				if (addMed == true) {
					medicines.add(med);
				}
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
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getMedicinesWithUniqueTitle()! (medicines)");
			ex.printStackTrace();
		}
		return medicines;
	}


	/**
	 * 
	 * @return list of all medicines from medicines table sorted by type and by
	 *         title
	 */
	public static List<Medicine> getAllSortedByTypeAndTitle() {
		String sql = "SELECT * FROM medicines join producers on medicines.id_producer = producers.id";
		List<Medicine> medicines = new ArrayList<>();
		try {
			Statement statement = (Statement) DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				medicines.add(convert(result));
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
			result.close();
		} catch (SQLException ex) {
			System.out.println("Exception in getAllSortedByTypeAndTitle()!");
			ex.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @param medicine
	 * @return true if medicine exists, false if medicine not exists
	 */
	public static boolean isExists(Medicine medicine) {
		boolean res = false;
		String sql = "SELECT medicines.title FROM medicines where medicines.title = ? and medicines.dateOfManufact = ?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, medicine.getTitle());
			Calendar calendar = medicine.getDateOfManufact();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(2, date);
			ResultSet result = statement.executeQuery();
			res = result.next();
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in !");
			e.printStackTrace();
		}
		return res;
	}

	/**
	 * 
	 * @param medicine
	 * @return medicine by title and date of manufacture
	 */
	public static Medicine getMedicine(Medicine medicine) {
		Medicine med = new Medicine();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id  where medicines.title = ? and medicines.dateOfManufact = ?";
		try {
			PreparedStatement statement = DbUtils.getConnection().prepareStatement(sql);
			statement.setString(1, medicine.getTitle());
			Calendar calendar = medicine.getDateOfManufact();
			Date date = new java.sql.Date(calendar.getTimeInMillis());
			statement.setDate(2, date);
			ResultSet result = statement.executeQuery();

			while (result.next()) {
				med = convert(result);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicine(Medicine medicine)!");
			e.printStackTrace();
		}
		return med;
	}

	/**
	 * 
	 * @param title
	 * @return total count of medicines by one title
	 */
	public static int get—ountByTitle(String title) {

		int count = 0;
		String sql = "SELECT sum(medicines.count) FROM medicines where medicines.title = '" + title + "'";
		try {
			Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				count += result.getInt(1);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in get—ountByTitle(String title)!");
		}
		return count;
	}

	/**
	 * 
	 * @return List of medicines where count = 0
	 */
	public static List<Medicine> deleteMedicineWithZeroCount() {
		List<Medicine> medicines = new ArrayList<>();
		Medicine med = new Medicine();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id  where medicines.count = 0";
		try {
			Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				med = convert(result);
				MedicineDAO.delete(med);
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in deleteMedicineWithZeroCount()!");
			e.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @return list overdue medicines
	 */
	public static List<Medicine> overdueMeds() {
		List<Medicine> list = new ArrayList<>();
		Medicine med = new Medicine();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id";
		try {
			Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				med = convert(result);
				if (new GregorianCalendar().after(new MedicineService().getLastDate(med))) {
					list.add(med);
				}
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in overdueMeds()!");
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @return list of medicines with the same title String title
	 */
	public static List<Medicine> getMedicinesByTypeAndTitle(String type, String title) {
		List<Medicine> medicines = new ArrayList<>();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id  where medicines.title = '"
				+ title + "' and medicines.type = '" + type + "'";
		try {
			Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				medicines.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicinesByTypeAndTitle(type, title)!");
			e.printStackTrace();
		}
		return medicines;
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @return list of medicines with the same title String title
	 */
	public static List<Medicine> getMedicinesByType(String type) {
		List<Medicine> medicines = new ArrayList<>();
		String sql = "SELECT * FROM medicines JOIN producers ON medicines.id_producer = producers.id  where "
				+ "medicines.type = '" + type + "'";
		try {
			Statement statement = DbUtils.getConnection().createStatement();
			ResultSet result = statement.executeQuery(sql);
			while (result.next()) {
				medicines.add(convert(result));
			}
			statement.close();
		} catch (SQLException e) {
			System.out.println("Exception in getMedicinesByTypeAndTitle(type, title)!");
			e.printStackTrace();
		}
		return medicines;
	}

}