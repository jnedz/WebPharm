package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dao.MedicineDAO;
import dao.PharmacyMedicineDAO;
import model.Medicine;
import model.Pharmacy;

public class PharmacyMedicineService {

	private Pharmacy pharmacy;
	private Medicine medicine;

	public PharmacyMedicineService() {
		this.pharmacy = new Pharmacy();
		this.medicine = new Medicine();
	}

	public PharmacyMedicineService(Pharmacy pharmacy, Medicine medicine) {
		this.pharmacy = pharmacy;
		this.medicine = medicine;
	}

	public PharmacyMedicineService(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Pharmacy getPharmacy() {
		return pharmacy;
	}

	public void setPharmacy(Pharmacy pharmacy) {
		this.pharmacy = pharmacy;
	}

	public Medicine getMedicine() {
		return medicine;
	}

	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}

	/**
	 * 
	 * @param pharmacy
	 *            pharmacy which need medicine
	 * @param medicine
	 *            medicine
	 * @param count
	 *            count of medicine which need pharmacy {@literal if
	 *            pharmacy-medicine exists - update it, else - add it}
	 */
	public static void addOrUpdate(Pharmacy pharmacy, Medicine medicine,
			int count) {
		if (PharmacyMedicineDAO.isExists(pharmacy, medicine)) {
			count = PharmacyMedicineDAO.get—ountOfMed(pharmacy, medicine)
					+ count;
			PharmacyMedicineDAO.update(pharmacy, medicine, count);
		} else {
			PharmacyMedicineDAO.add(pharmacy, medicine, count);
		}
	}

	public void addOrUpdate(int count) {
		if (PharmacyMedicineDAO.isExists(pharmacy, medicine)) {
			count = PharmacyMedicineDAO.get—ountOfMed(pharmacy, medicine)
					+ count;
			PharmacyMedicineDAO.update(pharmacy, medicine, count);
		} else {
			PharmacyMedicineDAO.add(pharmacy, medicine, count);
		}
	}

	/**
	 * 
	 * @param title
	 *            medicine title which pharmacy need
	 * @param count
	 *            count of medicine which pharmacy need
	 * @param pharmacy
	 *            pharmacy which need medicine
	 * 
	 */
	public void deliveryMedToPharmacy(String title, int count) {

		List<Medicine> medicines;

		System.out.println("count=" + count);

		int medicinesCount = new MedicineService()
				.getMedicinesCountByTitle(title);
		if (medicinesCount < count || count <= 0) {
			System.out
					.println("Amount of medicament is not enough. Pharmacies has only "
							+ medicinesCount);

		} else {
			medicines = new MedicineService()
					.getMedicinesDateSortedByTitle(title);
			for (Medicine medicine : medicines) {
				if (medicine.getCount() <= count) {
					addOrUpdate(pharmacy, medicine, medicine.getCount());
					count = count - medicine.getCount();
					medicine.setCount(0);
					MedicineDAO.update(medicine);
				} else {
					medicine.setCount(medicine.getCount() - count);
					MedicineDAO.update(medicine);
					addOrUpdate(pharmacy, medicine, count);
					break;
				}
			}
		}
	}

	/**
	 * 
	 * @param title
	 *            title of medicine for delivery from pharmacy
	 * @param count
	 *            count of medicine for delivery from pharmacy
	 */
	public void deliveryMedFromPharmacy(String title, int count) {
		List<Medicine> medicines;

		int medicinesCount = PharmacyMedicineDAO.get—ountByMedTitleFromPharm(
				pharmacy, title);
		if (medicinesCount < count || count <= 0) {
			System.out
					.println("Amount of medicament is not enough. Pharmacy has only "
							+ medicinesCount);

		} else {
			medicines = MedicineService
					.getDateSortedList(getAllMedsByPharmId(pharmacy.getId()));
			List<Medicine> medicinesWhithEqualsTitle = new ArrayList<>();
			for (Medicine medicine : medicines) {
				if (medicine.getTitle().equals(title)) {
					medicinesWhithEqualsTitle.add(medicine);
				}
			}
			for (Medicine medicine : medicinesWhithEqualsTitle) {
				if (medicine.getCount() <= count) {
					MedicineService.addOrUpdate(medicine);
					count = count - medicine.getCount();
					PharmacyMedicineDAO.update(pharmacy, medicine, 0);
				} else {
					int newCount = medicine.getCount() - count;
					PharmacyMedicineDAO.update(pharmacy, medicine, newCount);
					medicine.setCount(count);
					MedicineService.addOrUpdate(medicine);
					break;
				}
			}
		}
	}

	/**
	 * @return list overdue medicines for pharmacy
	 */
	public List<Medicine> overdueMeds() {
		List<Medicine> overdueMeds = new ArrayList<>();
		for (Medicine med : MedicineDAO.overdueMeds()) {
			if (PharmacyMedicineDAO.isExists(pharmacy, med)) {
				overdueMeds.add(med);
			}
		}
		return overdueMeds;
	}

	/**
	 * 
	 * @return all medicines from one pharmacy
	 */
	public List<Medicine> getAllMedsByPharm() {
		int pharmId = pharmacy.getId();
		return PharmacyMedicineDAO.getAllMedsByPharmId(pharmId);
	}

	/**
	 * 
	 * @return all medicines from one pharmacy with id = pharId
	 */
	public static List<Medicine> getAllMedsByPharmId(int pharmId) {
		return PharmacyMedicineDAO.getAllMedsByPharmId(pharmId);
	}

	/**
	 * {@literal delete overdue medicines from one pharmacy}
	 */
	public void deleteOverdueMeds() {
		for (Medicine medicine : overdueMeds()) {
			PharmacyMedicineDAO.delete(pharmacy, medicine);
		}
	}

	/**
	 * {@literal delete medicines with count "0" from one pharmacy}
	 */
	public void deleteMedsWithZeroCount() {
		int pharmId = pharmacy.getId();
		for (Medicine medicine : PharmacyMedicineDAO
				.getAllMedsByPharmId(pharmId)) {
			if (PharmacyMedicineDAO.get—ountOfMed(pharmacy, medicine) == 0) {
				PharmacyMedicineDAO.delete(pharmacy, medicine);
			}
		}
	}

	/**
	 * 
	 * @param markup
	 *            price-coefficient for one pharmacy
	 *            {@literal this method change prices in the pharmacy (pharmacies_medicines table)}
	 */
	public void markup(double markup) {
		int pharmId = pharmacy.getId();
		for (Medicine medicine : PharmacyMedicineDAO
				.getAllMedsByPharmId(pharmId)) {
			PharmacyMedicineDAO.update(pharmacy, medicine, medicine.getPrice()
					* markup);
		}
	}

	/**
	 * 
	 * @param title
	 *            medicine`s title
	 * @param markup
	 *            price-coefficient for one pharmacy
	 *            {@literal this method change prices of medicines with the same title in the pharmacy (pharmacies_medicines table)}
	 */
	public void markupByTitle(String title, double markup) {
		for (Medicine medicine : MedicineDAO.getMedicinesByTitle(title)) {
			if (PharmacyMedicineDAO.isExists(pharmacy, medicine)) {
				double price = PharmacyMedicineDAO.getPrice(pharmacy, medicine)
						* markup;
				PharmacyMedicineDAO.update(pharmacy, medicine, price);
			}
		}
	}

	/**
	 * @param title
	 *            medicine`s title
	 * @param price
	 *            new price for medicines with title
	 *            {@literal this method change prices of medicines with the same title in the pharmacy (pharmacies_medicines table)}
	 */
	public void newPriceByTitle(String title, double newPrice) {
		for (Medicine medicine : MedicineDAO.getMedicinesByTitle(title)) {
			if (PharmacyMedicineDAO.isExists(pharmacy, medicine)) {
				PharmacyMedicineDAO.update(pharmacy, medicine, newPrice);
			}
		}
	}

	/**
	 * 
	 * @param ph
	 * @param med
	 * @param count
	 *            medicine count which must be in pharmacies_medicines table
	 */
	public void add(Pharmacy ph, Medicine med, int count) {
		PharmacyMedicineDAO.add(ph, med, count);
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 *            {@literal delete couple pharmacy-medicine from the table}
	 */
	public void delete(Pharmacy pharmacy, Medicine medicine) {
		PharmacyMedicineDAO.delete(pharmacy, medicine);
	}

	
	/**
	 * 
	 * @param medTitle
	 *            medicines title
	 * @return a list of Pharmacies that have medicines with title medTitle
	 */
	public List<Pharmacy> getPharmByMedTitle(String medTitle) {
		return PharmacyMedicineDAO.getPharmByMedTitle(medTitle);
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
	public static int get—ountByMedTitleFromPharm(Pharmacy pharmacy,
			String medTitle) {
		return PharmacyMedicineDAO.get—ountByMedTitleFromPharm(pharmacy,
				medTitle);
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @return count of medicine(by one Id) from the couple pharmacy-medicine
	 */
	public int get—ountOfMed(Pharmacy pharmacy, Medicine medicine) {
		return PharmacyMedicineDAO.get—ountOfMed(pharmacy, medicine);
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @return price of medicine from the couple pharmacy-medicine
	 */
	public double getPrice(Pharmacy pharmacy, Medicine medicine) {
		return PharmacyMedicineDAO.getPrice(pharmacy, medicine);
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @param newPrice
	 *            {@literal update price in couple pharmacy-medicine}
	 */
	public void update(Pharmacy pharmacy, Medicine medicine, double newPrice) {
		PharmacyMedicineDAO.update(pharmacy, medicine, newPrice);
	}

	/**
	 * @param ph
	 * @param med
	 * @param newCount
	 *            {@literal update count in couple pharmacy-medicine}
	 */
	public void update(Pharmacy ph, Medicine med, int newCount) {
		PharmacyMedicineDAO.update(ph, med, newCount);
	}

	/**
	 * 
	 * @param pharmacy
	 * @param medicine
	 * @return boolean which indicates is couple medicine-pharmacy exist in DB
	 */
	public boolean isExists(Pharmacy pharmacy, Medicine medicine) {
		return PharmacyMedicineDAO.isExists(pharmacy, medicine);
	}

	public static List<Medicine> getMedicinesWithUniqueTitle(Pharmacy pharmacy) {
		
		List<Medicine> medicines = new ArrayList<>();
		boolean addMed = false;
		
		for (Medicine med : getAllMedsByPharmId(pharmacy.getId())){
			if (medicines.isEmpty()) {
				addMed = true;
			} else{
				for (Medicine m : medicines){
					if (m.getTitle().equals(med.getTitle())){
						m.setCount(m.getCount()+med.getCount());
						addMed = false;
					}else{
						addMed = true;
					}
				}}
				if (addMed == true){
					medicines.add(med);
				}
		}
		return medicines;
	}

	public static List<Medicine> getMedicinesSortByDate(int idPharm, String order) {
		List <Medicine> medicines = new ArrayList<>();
		if ("NoSort".equals(order)){
			medicines = PharmacyMedicineDAO.getAllMedsByPharmId(idPharm);
		}
		if ("ASC".equals(order)){
			medicines = MedicineService.getDateSortedList(PharmacyMedicineDAO.getAllMedsByPharmId(idPharm));
		}
		if ("DESC".equals(order)){
			medicines = MedicineService.getDateSortedList(PharmacyMedicineDAO.getAllMedsByPharmId(idPharm));
			Collections.reverse(medicines);
		}
		return medicines;
	}

}
