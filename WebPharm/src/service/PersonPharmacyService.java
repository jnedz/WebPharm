package service;

import enums.PersonRole;
import model.Person;
import model.Pharmacy;

public class PersonPharmacyService {

	/**
	 * 
	 * @param pi
	 * @param ph
	 * @param role
	 */
	public static void add(Person pi, Pharmacy ph, String role) {
		PersonPharmacyService.add(pi, ph, role);
	}

	/**
	 * 
	 * @param Person
	 *            pi
	 * @param Pharmacy
	 *            ph delete Person from Pharmacy (from the table)
	 */
	public static void delete(Person pi, Pharmacy ph) {
		PersonPharmacyService.delete(pi, ph);
	}

	/**
	 * 
	 * @param pi
	 * @param ph
	 * @return role
	 */
	public static PersonRole getRole(Person pi, Pharmacy ph) {
		return PersonPharmacyService.getRole(pi, ph);
	}

	/**
	 * @param personsInfo
	 * @param pharmacy
	 * @param newRole
	 *            {@literal update price in couple pharmacy-medicine}
	 */
	public static void update(Person pi, Pharmacy ph, PersonRole newRole) {
		PersonPharmacyService.update(pi, ph, newRole);
	}
}
