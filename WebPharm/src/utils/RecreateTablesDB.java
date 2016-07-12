package utils;

import java.sql.SQLException;

import repository.MedicinesRepository;
import repository.PersonsPharmaciesRepository;
import repository.PersonsRepository;
import repository.PharmaciesMedicinesRepository;
import repository.PharmaciesRepository;
import repository.ProducersRepository;

public class RecreateTablesDB {

	public static void main(String[] args) throws SQLException {

		DbUtils.dropPersonsPharmaciesTable();
		DbUtils.dropPersonsTable();
		DbUtils.dropPharmaciesMedicinesTable();
		DbUtils.dropPharmaciesTable();
		DbUtils.dropMedicineTable();
		DbUtils.dropProducersTable();

		DbUtils.createProducerTable();
		DbUtils.createMedicineTable();
		DbUtils.createPersonsTable();
		DbUtils.createPharmaciesTable();
		DbUtils.createPharmaciesMedicinesTable();
		DbUtils.createPersonsPharmaciesTable();

		PersonsRepository.completePersonsTable();
		ProducersRepository.completeProducersTable();
		MedicinesRepository.completeMedicinesTable();
		PharmaciesRepository.completePharmaciesTable();
		PharmaciesMedicinesRepository.completePharmaciesMedicinesTable();
		PersonsPharmaciesRepository.completePersonsInfoPharmaciesTable();

	}
}
