package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import dao.PharmacyDAO;
import model.Pharmacy;
import utils.DbUtils;

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
