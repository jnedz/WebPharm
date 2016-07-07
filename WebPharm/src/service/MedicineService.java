package service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.GregorianCalendar;
import java.util.List;

import dao.MedicineDAO;
import enums.MedicineType;
import model.Medicine;

public class MedicineService {

	/**
	 * 
	 * @return list of all medicines with unique title from medicines table
	 */
	public static List<Medicine> getMedicinesWithUniqueTitle() {

		return MedicineDAO.getMedicinesWithUniqueTitle();
	}

	/**
	 * 
	 * @param meds
	 *            List<Medicine> which we want to sort
	 * @return sorted by date of manufacture list of medicines
	 */
	public static List<Medicine> getDateSortedList(List<Medicine> meds) {
		List<Medicine> sortedList = new ArrayList<>(meds);
		Collections.sort(sortedList, new Comparator<Medicine>() {

			@Override
			public int compare(Medicine o1, Medicine o2) {
				if (o1.getDateOfManufact().before(o2.getDateOfManufact()))
					return -1;
				else if (o1.getDateOfManufact().after(o2.getDateOfManufact()))
					return 1;
				else
					return 0;
			}
		});

		return sortedList;
	}

	/**
	 * 
	 * @param title
	 *            title of medicine
	 * @param destination
	 *            some string for indicate java-method
	 * @return list of medicines with given title
	 */
	public List<Medicine> getMedicinesDateSortedByTitle(String title, String destination) {
		return getDateSortedList(MedicineDAO.getMedicinesByTitle(title));
	}

	/**
	 * 
	 * @param title
	 *            title of medicine
	 * @return list of medicines with given title (method DAO)
	 */
	public List<Medicine> getMedicinesDateSortedByTitle(String title) {
		return MedicineDAO.getMedicinesDateSortedByTitle(title);
	}

	/**
	 * 
	 * @param title
	 *            title of medicine
	 * @return count of medicines with given title
	 */
	public int getMedicinesCountByTitle(String title) {

		List<Medicine> medicines = MedicineDAO.getMedicinesByTitle(title);
		int count = 0;
		for (Medicine medicine : medicines) {
			count = count + medicine.getCount();
		}
		return count;
	}

	/**
	 * 
	 * @param title
	 *            Title of Medicine that needed for Pharmacy
	 * @param count
	 *            Count
	 */
	public void changeMedicinesCountWithGivenTitle(String title, int count) {

		if (getMedicinesCountByTitle(title) < count) {
			System.out.println(
					"Amount of medicament is not enough. Pharmacies has only " + getMedicinesCountByTitle(title));
		}
		List<Medicine> medicines = getMedicinesDateSortedByTitle(title);
		for (Medicine medicine : medicines) {
			if (medicine.getCount() <= count) {
				count = count - medicine.getCount();
				medicine.setCount(0);
				MedicineDAO.update(medicine);
			} else {
				medicine.setCount(medicine.getCount() - count);
				MedicineDAO.update(medicine);
				break;
			}
		}
	}

	/**
	 * 
	 * @param medicine
	 *            medicine
	 * @param java
	 *            no matter what String
	 * @return list medicines with equals title without matches by date
	 *         {@literal} this method add medicine if list has'nt got medicine
	 *         with the same date. Else it just changes count in the same
	 *         medicine.
	 * 
	 */
	public static List<Medicine> addOrUpdate(Medicine medicine, String java) {

		List<Medicine> medicines = MedicineDAO.getMedicinesByTitle(medicine.getTitle());
		boolean isExists = false;
		for (Medicine med : medicines) {
			if (medicine.getDateOfManufact().equals(med.getDateOfManufact())) {
				System.out.println("A match is found by title and date!");
				med.setType(medicine.getType());
				med.setTerm(medicine.getTerm());
				med.setPrice(medicine.getPrice());
				med.setCount(medicine.getCount() + med.getCount());
				med.setProducer(medicine.getProducer());
				isExists = true;
				break;
			}
		}
		if (!isExists) {
			System.out.println("A match is not found by title and date!");
			medicines.add(medicine);
		}
		return medicines;
	}

	/**
	 * 
	 * @param medicine
	 *            medicine
	 * @return boolean which indicates is medicine exist in DB(table medicines)
	 */
	public static boolean isMedicineExist(Medicine medicine) {
		List<Medicine> medicines = MedicineDAO.getMedicinesByTitle(medicine.getTitle());
		// select * from medicines where title =medicine and dateOfManufact =
		// medicine.getDate()
		boolean isExists = false;
		for (Medicine med : medicines) {
			if (medicine.getDateOfManufact().equals(med.getDateOfManufact())) {
				isExists = true;
				break;
			}
		}
		return isExists;
	}

	/**
	 * 
	 * @param medicine
	 *            This method add medicine in table medicines if table has'nt
	 *            got medicine with the same date. Else it update medicine
	 *            (change count in the same medicine).
	 */
	public static void addOrUpdate(Medicine medicine) {
		MedicineDAO.getMedicinesByTitle(medicine.getTitle());
		if (isMedicineExist(medicine)) {
		}
		boolean isExists = false;
		for (Medicine med : MedicineDAO.getMedicinesByTitle(medicine.getTitle())) {
			if (medicine.getDateOfManufact().equals(med.getDateOfManufact())) {
				System.out.println("A match is found by title and date!");
				med.setCount(medicine.getCount() + med.getCount());
				med.setProducer(medicine.getProducer());
				MedicineDAO.update(med);
				isExists = true;
				break;
			}
		}
		if (!isExists) {
			System.out.println("A match is not found by title and date!");
			MedicineDAO.add(medicine);
		}
	}

	/**
	 * 
	 * @param medicine
	 *            medicine
	 * @return boolean false and update medicine if medicine is exist in the
	 *         table medicine, else boolean true and add medicine in the table
	 *         medicines
	 * 
	 */
	public static boolean addMedicineOrUpdate(Medicine medicine) {
		if (MedicineDAO.isExists(medicine)) {
			Medicine medFromDB = MedicineDAO.getMedicine(medicine);
			medFromDB.setCount(medFromDB.getCount() + medicine.getCount());
			MedicineDAO.update(medFromDB);
			return false;
		} else {
			MedicineDAO.add(medicine);
			return true;
		}

	}

	/**
	 * 
	 * @return list medicine with overdue medicines and medicines with zero
	 *         count
	 * 
	 */
	public List<Medicine> overdueOrAbsentMeds() {
		List<Medicine> overdueOrAbsentMeds = new ArrayList<>();
		Calendar c1 = new GregorianCalendar();
		for (Medicine medicine : MedicineDAO.getAll()) {
			if (c1.after(getLastDate(medicine)) || medicine.getCount() == 0) {
				overdueOrAbsentMeds.add(medicine);
			}
		}
		return overdueOrAbsentMeds;
	}

	/**
	 * 
	 * @return list with all medicines (from table medicines) sorted by last
	 *         term of using medicine
	 */
	public List<Medicine> sortedByLastDate() {
		List<Medicine> sortedList = new ArrayList<>(MedicineDAO.getAll());
		Collections.sort(sortedList, new Comparator<Medicine>() {
			@Override
			public int compare(Medicine o1, Medicine o2) {
				if (getLastDate(o1).before(getLastDate(o2)))
					return -1;
				if (getLastDate(o1).after(getLastDate(o2)))
					return 1;
				else
					return 0;
			}
		});
		return sortedList;
	}

	/**
	 * 
	 * @return list with overdue medicines
	 * 
	 */
	public List<Medicine> overdueMeds() {
		List<Medicine> overdueMeds = new ArrayList<>();
		Calendar c1 = new GregorianCalendar();
		for (Medicine medicine : MedicineDAO.getAll()) {
			if (c1.after(getLastDate(medicine))) {
				overdueMeds.add(medicine);
			}
		}
		return overdueMeds;
	}

	/**
	 * 
	 * @param medicine
	 *            medicine
	 * @return last date of using medicine
	 */
	public GregorianCalendar getLastDate(Medicine medicine) {
		GregorianCalendar gc = new GregorianCalendar();
		gc.set(medicine.getDateOfManufact().get(1), medicine.getDateOfManufact().get(2),
				medicine.getDateOfManufact().get(3));
		gc.add(GregorianCalendar.MONTH, medicine.getTerm());
		return gc;
	}

	/**
	 * 
	 * @param meds
	 *            list medicines which we want to delete
	 */
	public void deleteListMedicines(List<Medicine> meds) {
		for (Medicine medicine : meds) {
			if (MedicineDAO.getAll().contains(medicine)) {
				MedicineDAO.delete(medicine.getId());
				System.out.println("\nMedicine with id " + medicine.getId() + "deleted.");
			} else {
				System.out.println("\nMedicine with id = " + medicine.getId() + " is not found.");
			}
		}
	}

	/**
	 * 
	 * @param medicine
	 *            medicine which is adding into medicines table
	 */
	public static void add(Medicine medicine) {
		MedicineDAO.add(medicine);
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
	public void add(String title, MedicineType type, GregorianCalendar dateOfManufact, int term, double price,
			int count, int producerId) {
		MedicineDAO.add(title, type, dateOfManufact, term, price, count, producerId);
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @return list of medicines with the same title String title
	 */
	public static List<Medicine> getMedicinesByTitle(String title) {
		return MedicineDAO.getMedicinesByTitle(title);
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @return list of medicines with the same title sorted by date of
	 *         manufacture
	 */
	public List<Medicine> getMedicinesDateSortedByTitleDAO(String title) {
		return MedicineDAO.getMedicinesDateSortedByTitle(title);
	}

	/**
	 * 
	 * @param id
	 *            medicine`s id
	 * @return medicine with typed id
	 */
	public static Medicine getMedicineById(int id) {
		return MedicineDAO.getMedicineById(id);
	}

	/**
	 * 
	 * @param medicine
	 *            medicine for delete
	 */
	public static void delete(Medicine medicine) {
		MedicineDAO.delete(medicine);
	}

	/**
	 * 
	 * @param id
	 *            id of medicine which we want delete
	 */
	public void deleteById(int id) {
		MedicineDAO.delete(id);
	}

	/**
	 * 
	 * @param medicine
	 *            medicine for update
	 */
	public static void update(Medicine medicine) {
		MedicineDAO.update(medicine);
	}

	/**
	 * 
	 * @param producerId
	 * @return list of medicines by producer with typed id
	 */
	public List<Medicine> getMedicinesByProducerId(int producerId) {
		return MedicineDAO.getMedicinesByProducerId(producerId);
	}

	/**
	 * 
	 * @return list of all medicines from medicines table
	 */
	public static List<Medicine> getAll() {
		return MedicineDAO.getAll();
	}

	/**
	 * 
	 * @param title
	 * @return sum count of medicines with typed count
	 */
	public static int get—ountByTitle(String title) {
		return MedicineDAO.get—ountByTitle(title);
	}

	/**
	 * 
	 * @return List of medicines where count = 0
	 */
	public static List<Medicine> deleteMedicineWithZeroCount() {
		return MedicineDAO.deleteMedicineWithZeroCount();
	}

	/**
	 * 
	 * @return list overdue medicines
	 */
	public static List<Medicine> overdueMedsDAO() {
		return MedicineDAO.overdueMeds();
	}

	public static List<Medicine> getMedicinesByTypeAndTitle(String type, String title) {
		return MedicineDAO.getMedicinesByTypeAndTitle(type, title);
	}

	public static List <Medicine> getAllSortedByTypeAndTitle() {
		return MedicineDAO.getAllSortedByTypeAndTitle();
	}

	public static List<Medicine> getMedicinesByType(String type) {
		return MedicineDAO.getMedicinesByType(type);
	}
}
