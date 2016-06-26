package repository;

import java.util.GregorianCalendar;

import dao.MedicineDAO;
import dao.ProducerDAO;
import model.Medicine;
import model.Producer;

public class MedicinesRepository {

	public static void completeMedicinesTable() {

		Medicine medicine = new Medicine();
		Producer producer = new Producer();
		medicine.setTitle("Sega");
		medicine.setType(enums.MedicineType.SED);
		medicine.setDateOfManufact(new GregorianCalendar(2016, 01, 15));
		medicine.setTerm(48);
		medicine.setPrice(10.5);
		medicine.setCount(10);
		producer = ProducerDAO.getProducerById(2);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Medic");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2014, 05, 15));
		medicine.setTerm(36);
		medicine.setPrice(100.5);
		medicine.setCount(50);
		producer = ProducerDAO.getProducerById(5);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Anti");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2015, 01, 17));
		medicine.setTerm(24);
		medicine.setPrice(240.0);
		medicine.setCount(200);
		producer = ProducerDAO.getProducerById(1);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Anti2");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2016, 01, 17));
		medicine.setTerm(24);
		medicine.setPrice(200.0);
		medicine.setCount(100);
		producer = ProducerDAO.getProducerById(2);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Anti2");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2015, 01, 17));
		medicine.setTerm(24);
		medicine.setPrice(100.0);
		medicine.setCount(200);
		producer = ProducerDAO.getProducerById(2);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Sed");
		medicine.setType(enums.MedicineType.SED);
		medicine.setDateOfManufact(new GregorianCalendar(2015, 01, 17));
		medicine.setTerm(36);
		medicine.setPrice(80.0);
		medicine.setCount(0);
		producer = ProducerDAO.getProducerById(4);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Anti");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2010, 01, 17));
		medicine.setTerm(24);
		medicine.setPrice(240.0);
		medicine.setCount(20);
		producer = ProducerDAO.getProducerById(1);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Anti");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2015, 01, 17));
		medicine.setTerm(24);
		medicine.setPrice(240.0);
		medicine.setCount(10);
		producer = ProducerDAO.getProducerById(1);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Anti");
		medicine.setType(enums.MedicineType.ANTIBIOTIC);
		medicine.setDateOfManufact(new GregorianCalendar(2016, 01, 17));
		medicine.setTerm(24);
		medicine.setPrice(240.0);
		medicine.setCount(200);
		producer = ProducerDAO.getProducerById(1);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Sega");
		medicine.setType(enums.MedicineType.SED);
		medicine.setDateOfManufact(new GregorianCalendar(2016, 01, 15));
		medicine.setTerm(48);
		medicine.setPrice(10.5);
		medicine.setCount(100);
		producer = ProducerDAO.getProducerById(2);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);

		medicine = new Medicine();
		producer = new Producer();
		medicine.setTitle("Sega");
		medicine.setType(enums.MedicineType.SED);
		medicine.setDateOfManufact(new GregorianCalendar(2015, 01, 15));
		medicine.setTerm(48);
		medicine.setPrice(10.5);
		medicine.setCount(110);
		producer = ProducerDAO.getProducerById(2);
		medicine.setProducer(producer);
		MedicineDAO.add(medicine);
	}
}