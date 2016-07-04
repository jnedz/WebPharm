package service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.MedicineDAO;
import dao.ProducerDAO;
import enums.Country;
import model.Medicine;
import model.Producer;

public class ProducerService {
	/*
	 * ProducerService.delete();
	 * try { ProducerDAO.delete(new Producer()); // producer with id =
	 * producerId
	 * }
	 * catch (SQLException e){ delete all
	 * MedicineDAO.getMedicinesByProducerId(producerId); ProducerDAO.delete(
	 * producer with id = producerId); }
	 */

	public static void deleteProducer(Producer producer) throws SQLException {
		try {
			ProducerDAO.delete(producer); 
		} catch (SQLException ex) {
			List<Medicine> meds = new ArrayList<Medicine>(MedicineDAO.getMedicinesByProducerId(producer.getId()));
			for (Medicine m : meds) {
				MedicineDAO.delete(m);
			}
			ProducerDAO.delete(producer);
		}
	}

	public static void deleteProducer(int id) throws SQLException {
		try {
			ProducerDAO.delete(id); 
		} catch (SQLException ex) {
			List<Medicine> meds = MedicineDAO.getMedicinesByProducerId(id);
			for (Medicine m : meds) {
				MedicineDAO.delete(m);
			}
			ProducerDAO.delete(id);
		}
	}

	public static void add(Producer producer) {
		ProducerDAO.add(producer);
	}

	public static void add(String titleProd, Country country) {
		ProducerDAO.add(titleProd, country);
	}

	/*
	 * @Exception if we can't delete producer used in Medicines table 
	 */
	public static void delete(Producer producer) throws SQLException {
		ProducerDAO.delete(producer);
	}

	/*
	 * @Exception if we can't delete producer used in Medicines table 
	 */
	public static void delete(int id) throws SQLException {
		ProducerDAO.delete(id);
	}

	public static List<Producer> getAll() {
		return ProducerDAO.getAll();
	}

	public static Producer getProducerById(int id) {
		return ProducerDAO.getProducerById(id);
	}

	public static void update(Producer producer) {
		ProducerDAO.update(producer);
	}

	public static List<Producer> getProducersByTitle(String title) {
		return ProducerDAO.getProducersByTitle(title);
	}

	public static Producer getProducerByTitle(String title) {
		return ProducerDAO.getProducerByTitle(title);
	}

	
	
}
