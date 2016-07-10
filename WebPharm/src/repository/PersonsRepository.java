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
		person.setLogin("aaaa");
		person.setPassword("aaaa");
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Olja");
		person.setLastName("Rem");
		person.setRole(enums.PersonRole.USER);
		person.setDateOfBirthday(new GregorianCalendar(1985,02,10));
		person.setLogin("zzzz");
		person.setPassword("zzzz");
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Nadia");
		person.setLastName("Del");
		person.setRole(enums.PersonRole.WORKER);
		person.setDateOfBirthday(new GregorianCalendar(1975,06,10));
		person.setLogin("ssss");
		person.setPassword("ssss");
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Sasha");
		person.setLastName("Old");
		person.setRole(enums.PersonRole.WORKER);
		person.setDateOfBirthday(new GregorianCalendar(1979,02,01));
		person.setLogin("xxxx");
		person.setPassword("xxxx");
		PersonDAO.add(person);
		
		person = new Person();
		person.setFirstName("Dasha");
		person.setLastName("Das");
		person.setRole(enums.PersonRole.USER);
		person.setDateOfBirthday(new GregorianCalendar(1990,05,05));
		person.setLogin("qqqq");
		person.setPassword("qqqq");
		PersonDAO.add(person);
	}
}
 