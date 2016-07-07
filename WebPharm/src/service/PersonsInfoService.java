package service;

import java.util.List;

import dao.PersonDAO;
import dao.PersonsInfoDAO;
import enums.PersonRole;
import model.PersonsInfo;

public class PersonsInfoService {

	public static void add(PersonsInfo person){
		PersonsInfoDAO.add(person);
	}
	
	public static void add(String firstName, String lastName, PersonRole role){
		PersonsInfoDAO.add(firstName, lastName, role);
	}
	
	public static void delete(int id){
		PersonsInfoDAO.delete(id);;
	}
	
	public static void delete(PersonsInfo person){
		PersonsInfoDAO.delete(person);
	}
	
	public static List<PersonsInfo> getAll(){
		return PersonsInfoDAO.getAll();
	}
	
	public static List<PersonsInfo> getPersonsInfoByFullName(String firstName,
			String lastName) {
		return PersonsInfoDAO.getPersonsInfoByFullName(firstName, lastName);
	}
	
	public static PersonsInfo getPersonsInfoById(int id) {
		return PersonsInfoDAO.getPersonsInfoById(id);
	}
	
	public static void update(PersonsInfo person) {
		PersonsInfoDAO.update(person);
	}
	
	public static void updateAllPersonsInfo(PersonsInfo person) {
		PersonsInfoDAO.updateAllPersonsInfo(person);
	}
	
	public static List<PersonsInfo> getPersonsInfoByRole(String role) {
	return PersonsInfoDAO.getPersonsInfoByRole(role);
	}
	
	public static List<PersonsInfo> sortByFirstNameAndRole(String order, String role) {
		return PersonsInfoDAO.sortByFirstNameAndRole(order, role);
	}
	
	public static List<PersonsInfo> sortByFirstName(String order) {
		return PersonsInfoDAO.sortByFirstName(order);
	}
	
	public static List<PersonsInfo> sort1(String... args) {
		return PersonsInfoDAO.sort1(args);
	}
	
	public static List<PersonsInfo> sort(String order, String role) {
		return PersonsInfoDAO.sort(order, role);
	}
	
	public static List<PersonsInfo> sortByCriteria(String criteria, String order, String role) {
		return PersonsInfoDAO.sortByCriteria(criteria, order, role);
	}
	
	public static List<PersonsInfo> getPersonsInfoByFullNameAndDate(String firstName,
			String lastName, String date) {
		return PersonsInfoDAO.getPersonsInfoByFullNameAndDate(firstName, lastName, date);
	}
	
}
