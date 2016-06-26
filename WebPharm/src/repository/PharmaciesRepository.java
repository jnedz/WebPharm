package repository;

import dao.PharmacyDAO;
import model.Pharmacy;

public class PharmaciesRepository {

	public static void completePharmaciesTable() {

		Pharmacy pharmacy = new Pharmacy();
		pharmacy.setTitle("Apot");
		pharmacy.setDescription("description-1");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("Bingo");
		pharmacy.setDescription("description-2");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("New");
		pharmacy.setDescription("description-3");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("Medical");
		pharmacy.setDescription("description-4");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("New-Apot");
		pharmacy.setDescription("description-5");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("Pharma");
		pharmacy.setDescription("description-6");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("Doctor");
		pharmacy.setDescription("description-7");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("Apot!!!");
		pharmacy.setDescription("description-8");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("Med-Ap");
		pharmacy.setDescription("description-9");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("ApotApot");
		pharmacy.setDescription("description-10");
		PharmacyDAO.add(pharmacy);

		pharmacy = new Pharmacy();
		pharmacy.setTitle("MedFiends");
		pharmacy.setDescription("description-11");
		PharmacyDAO.add(pharmacy);

	}
}
