package repository;

import dao.MedicineDAO;
import dao.PharmacyDAO;
import dao.PharmacyMedicineDAO;

public class PharmaciesMedicinesRepository {

	public static void completePharmaciesMedicinesTable() {

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(1), MedicineDAO.getMedicineById(1), 4);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(3), MedicineDAO.getMedicineById(1), 6);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(2), MedicineDAO.getMedicineById(2), 10);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(5), MedicineDAO.getMedicineById(2), 10);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(8), MedicineDAO.getMedicineById(1), 30);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(3), MedicineDAO.getMedicineById(3), 100);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(7), MedicineDAO.getMedicineById(3), 10);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(5), MedicineDAO.getMedicineById(4), 4);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(1), MedicineDAO.getMedicineById(5), 10);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(1), MedicineDAO.getMedicineById(6), 40);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(6), MedicineDAO.getMedicineById(5), 10);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(9), MedicineDAO.getMedicineById(6), 50);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(10), MedicineDAO.getMedicineById(6), 50);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(6), MedicineDAO.getMedicineById(7), 40);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(4), MedicineDAO.getMedicineById(7), 5);

		PharmacyMedicineDAO.add(PharmacyDAO.getPharmacyById(9), MedicineDAO.getMedicineById(7), 4);

	}

}
