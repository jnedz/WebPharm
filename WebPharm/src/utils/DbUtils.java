package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbUtils {

	static final String DB_URL = "jdbc:mysql://localhost/test1";
	static final String USER = "root";
	static final String PASS = "root";
	private static Connection conn = null;

	
	  static { try { Class.forName("com.mysql.jdbc.Driver"); conn =
	  DriverManager.getConnection(DB_URL, USER, PASS); } catch (SQLException |
	  ClassNotFoundException e) { System.out.println("Connection false"); } }
	 

	public static Connection getConnection() {
		return conn;
	}

	public static void createProducerTable() {

		Statement statement = null;
		try {
			String sql = "create table Producers (id INT NOT NULL AUTO_INCREMENT, "
					+ "title varchar(20), country enum('UKRAINE', 'ENGLAND', 'FRANCE', 'NOCOUNTRY') "
					+ "default 'NOCOUNTRY', primary key (id) )";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPersonTable().");
		}
	}

	public static void createMedicineTable() {

		Statement statement = null;
		try {
			String sql = "create table Medicines (id INT NOT NULL AUTO_INCREMENT, title varchar(20) not null, "
					+ "type enum ('NOTYPE', 'SED', 'ANTIBIOTIC') default 'NOTYPE',   "
					+ "dateOfManufact date, term int not null default 60, price double, count int, "
					+ "id_producer int, FOREIGN KEY (id_producer) REFERENCES Producers(id),  primary key (id))";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createMedicineTable().");
		}
	}

	public static void createPharmaciesMedicinesTable() {

		Statement statement = null;
		try {
			String sql = "create table Pharmacies_Medicines (id INT NOT NULL AUTO_INCREMENT, id_pharmacy int, "
					+ "id_medicine int, price double, count int,  "
					+ "foreign key (id_pharmacy) references pharmacies (id),"
					+ "foreign key (id_medicine) references medicines (id),"
					+ " primary key (id) )";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPharmaciesTable().");
		}

	}

	public static void createPharmaciesTable() {

		Statement statement = null;
		try {
			String sql = "create table Pharmacies (id INT NOT NULL AUTO_INCREMENT, "
					+ "title varchar(20) not null, description varchar(200),"
					+ " primary key (id) )";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPharmaciesTable().");
		}

	}
	
	public static void createPersonsTable() {

		Statement statement = null;
		try {
			String sql = "create table Persons (id INT NOT NULL AUTO_INCREMENT, "
					+ "firstName  varchar(20) not null, lastName varchar(20) not null, "
					+ "role enum('WORKER', 'USER') default 'USER', dateOfBirthday date, "
					+ "login varchar(20), password  varchar(20), "
					+ "primary key (id) )";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPersonsTable().");
		}
	}
	
	public static void createPersonsPharmaciesTable() {

		Statement statement = null;
		try {
			String sql = "create table Persons_Pharmacies (id INT NOT NULL AUTO_INCREMENT, id_person int, "
					+ "id_pharmacy int, "
					+ "role enum('WORKER', 'USER'), "
					+ "foreign key (id_person) references persons (id), "
					+ "foreign key (id_pharmacy) references pharmacies (id), "
					+ "primary key (id) )";

			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in createPersonsPharmaciesTable().");
		}

	}
	
	public static void dropPersonsTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Persons";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPersonsTable().");
		}
	}

	public static void dropPersonsPharmaciesTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Persons_Pharmacies";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPersonsPharmaciesTable().");
		}
	}

	public static void dropMedicineTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Medicines";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("Exeption in dropMedicineTable().");
		}
	}

	public static void dropPharmaciesTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Pharmacies";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropPharmaciesTable().");
		}
	}

	public static void dropProducersTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Producers";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out.println("SQL exception in dropProducersTable().");
		}
	}

	public static void dropPharmaciesMedicinesTable() {

		Statement statement = null;
		try {
			String sql = "drop table if exists Pharmacies_Medicines";
			statement = getConnection().createStatement();
			statement.executeUpdate(sql);
			statement.close();
		} catch (SQLException sqlexc) {
			System.out
					.println("SQL exception in dropPharmaciesMedicinesTable().");
		}
	}
	
	public static void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
