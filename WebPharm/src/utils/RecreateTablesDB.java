package utils;

import java.sql.SQLException;

import repository.MedicinesRepository;
import repository.PersonsRepository;
import repository.PharmaciesMedicinesRepository;
import repository.PharmaciesRepository;
import repository.ProducersRepository;

public class RecreateTablesDB {

	public static void main(String[] args) throws SQLException {
		DbUtils.dropPharmaciesMedicinesTable();
		DbUtils.createPharmaciesMedicinesTable();
		PharmaciesMedicinesRepository.completePharmaciesMedicinesTable();
		DbUtils.dropPersonTable();
		DbUtils.dropPharmaciesMedicinesTable();
		DbUtils.dropMedicineTable();
		DbUtils.dropPharmaciesTable();
		DbUtils.dropProducersTable();

		DbUtils.createProducerTable();
		DbUtils.createMedicineTable();
		DbUtils.createPersonTable();
		DbUtils.createPharmaciesTable();
		DbUtils.createPharmaciesMedicinesTable();

		PersonsRepository.completePersonsTable();
		ProducersRepository.completeProducersTable();
		MedicinesRepository.completeMedicinesTable();
		PharmaciesRepository.completePharmaciesTable();
		PharmaciesMedicinesRepository.completePharmaciesMedicinesTable();
	}
}
