package repository;

import dao.PersonDAO;
import dao.PersonPharmacyDAO;
import dao.PharmacyDAO;

public class PersonsPharmasiesRepository {

	public static void completePersonsInfoPharmaciesTable(){
		
		PersonPharmacyDAO.add(PersonDAO.getPersonById(1), PharmacyDAO.getPharmacyById(1), "USER");
		PersonPharmacyDAO.add(PersonDAO.getPersonById(2), PharmacyDAO.getPharmacyById(2), "USER");
		PersonPharmacyDAO.add(PersonDAO.getPersonById(3), PharmacyDAO.getPharmacyById(3), "WORKER");
		PersonPharmacyDAO.add(PersonDAO.getPersonById(4), PharmacyDAO.getPharmacyById(4), "WORKER");
		PersonPharmacyDAO.add(PersonDAO.getPersonById(5), PharmacyDAO.getPharmacyById(5), "USER");
	
	
	}
	
}
