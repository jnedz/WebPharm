package utils;

import java.sql.SQLException;

import repository.MedicinesRepository;
import repository.PersonsInfoPharmasiesRepository;
import repository.PersonsInfoRepository;
import repository.PersonsRepository;
import repository.PharmaciesMedicinesRepository;
import repository.PharmaciesRepository;
import repository.ProducersRepository;

public class RecreateTablesDB {

	public static void main(String[] args) throws SQLException {

		 DbUtils.dropPersonTable();
		
		 DbUtils.dropPersonsInfoPharmaciesTable();
		 DbUtils.dropPersonsInfoTable();
		 DbUtils.dropPharmaciesMedicinesTable();
		 DbUtils.dropPharmaciesTable(); DbUtils.dropMedicineTable();
		 DbUtils.dropProducersTable();
		
		 DbUtils.dropPersonsUsersTable();
		 DbUtils.dropUsersTable();

		DbUtils.createProducerTable();
		DbUtils.createMedicineTable();
		DbUtils.createPersonsInfoTable(); // DbUtils.createPersonTable();
		DbUtils.createPharmaciesTable();
		DbUtils.createPharmaciesMedicinesTable();
		DbUtils.createPersonsInfoPharmaciesTable();

		PersonsInfoRepository.completePersonsInfoTable();
		 ProducersRepository.completeProducersTable();
		 MedicinesRepository.completeMedicinesTable();
		 PharmaciesRepository.completePharmaciesTable();
		 PharmaciesMedicinesRepository.completePharmaciesMedicinesTable();
		 PersonsInfoPharmasiesRepository.completePersonsInfoPharmaciesTable();

//		 DbUtils.createUsersTable();
//		 DbUtils.createPersonsUsersTable();

	}
}
