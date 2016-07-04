package service;

import java.util.List;

import dao.PharmacyDAO;
import model.Pharmacy;

public class PharmacyService {
	
	public static void add(Pharmacy pharmacy) {
		PharmacyDAO.add(pharmacy);
	}
	
	public static void add(String title, String description) {
		PharmacyDAO.add(title, description);
	}

	public static void delete(Pharmacy pharmacy) {
		PharmacyDAO.delete(pharmacy);
	}
	
	public static void delete(int id) {
		PharmacyDAO.delete(id);
	}
	
	public static List<Pharmacy> getAll() {
		return PharmacyDAO.getAll();
	}

	public static Pharmacy getPharmacyById(int id) {
		return PharmacyDAO.getPharmacyById(id);
	}
	
	public static List<Pharmacy> getPharmaciesByTitle(String title) {
		return PharmacyDAO.getPharmaciesByTitle(title);
	}


}
