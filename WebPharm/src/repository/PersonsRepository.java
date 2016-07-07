package repository;

import java.util.GregorianCalendar;

import dao.PersonDAO;
import model.Person;

public class PersonsRepository {

public static void completePersonsTable(){
		
		Person person = new Person();
		person.setFirstName("Zoya");
		person.setLastName("Last");
		person.setRole(enums.PersonRole.USER);
		person.setDateOfBirthday(new GregorianCalendar(1980,02,29));
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Olja");
		person.setLastName("Rem");
		person.setRole(enums.PersonRole.USER);
		person.setDateOfBirthday(new GregorianCalendar(1985,02,10));
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Nadia");
		person.setLastName("Del");
		person.setRole(enums.PersonRole.WORKER);
		person.setDateOfBirthday(new GregorianCalendar(1975,06,10));
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Sasha");
		person.setLastName("Old");
		person.setRole(enums.PersonRole.WORKER);
		person.setDateOfBirthday(new GregorianCalendar(1979,02,01));
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Dasha");
		person.setLastName("Das");
		person.setRole(enums.PersonRole.USER);
		person.setDateOfBirthday(new GregorianCalendar(1990,05,05));
		PersonDAO.add(person);
	}
	
	
}
