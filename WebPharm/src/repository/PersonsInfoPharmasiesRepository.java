package repository;

import dao.PersonsInfoDAO;
import dao.PersonsInfoPharmaciesDAO;
import dao.PharmacyDAO;

public class PersonsInfoPharmasiesRepository {

	public static void completePersonsInfoPharmaciesTable(){
		
		PersonsInfoPharmaciesDAO.add(PersonsInfoDAO.getPersonsInfoById(1), PharmacyDAO.getPharmacyById(1), "USER");
		PersonsInfoPharmaciesDAO.add(PersonsInfoDAO.getPersonsInfoById(2), PharmacyDAO.getPharmacyById(2), "USER");
		PersonsInfoPharmaciesDAO.add(PersonsInfoDAO.getPersonsInfoById(3), PharmacyDAO.getPharmacyById(3), "WORKER");
		PersonsInfoPharmaciesDAO.add(PersonsInfoDAO.getPersonsInfoById(4), PharmacyDAO.getPharmacyById(4), "WORKER");
		PersonsInfoPharmaciesDAO.add(PersonsInfoDAO.getPersonsInfoById(5), PharmacyDAO.getPharmacyById(5), "USER");
	
	
	}
	
}
