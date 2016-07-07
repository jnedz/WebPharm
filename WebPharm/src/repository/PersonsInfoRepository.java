package repository;

import java.util.GregorianCalendar;

import dao.PersonsInfoDAO;
import model.PersonsInfo;

public class PersonsInfoRepository {

	public static void completePersonsInfoTable(){
		
		PersonsInfo personsInfo = new PersonsInfo();
		personsInfo.setFirstName("Zoya");
		personsInfo.setLastName("Last");
		personsInfo.setRole(enums.PersonRole.USER);
		personsInfo.setDateOfBirthday(new GregorianCalendar(1980,02,29));
		personsInfo.setLogin("aaaa");
		personsInfo.setPassword("aaaa");
		PersonsInfoDAO.add(personsInfo);
		
		personsInfo = new PersonsInfo();
		personsInfo.setFirstName("Olja");
		personsInfo.setLastName("Rem");
		personsInfo.setRole(enums.PersonRole.USER);
		personsInfo.setDateOfBirthday(new GregorianCalendar(1985,02,10));
		personsInfo.setLogin("zzzz");
		personsInfo.setPassword("zzzz");
		PersonsInfoDAO.add(personsInfo);
		
		personsInfo = new PersonsInfo();
		personsInfo.setFirstName("Nadia");
		personsInfo.setLastName("Del");
		personsInfo.setRole(enums.PersonRole.WORKER);
		personsInfo.setDateOfBirthday(new GregorianCalendar(1975,06,10));
		personsInfo.setLogin("ssss");
		personsInfo.setPassword("ssss");
		PersonsInfoDAO.add(personsInfo);
		
		personsInfo = new PersonsInfo();
		personsInfo.setFirstName("Sasha");
		personsInfo.setLastName("Old");
		personsInfo.setRole(enums.PersonRole.WORKER);
		personsInfo.setDateOfBirthday(new GregorianCalendar(1979,02,01));
		personsInfo.setLogin("xxxx");
		personsInfo.setPassword("xxxx");
		PersonsInfoDAO.add(personsInfo);
		
		personsInfo = new PersonsInfo();
		personsInfo.setFirstName("Dasha");
		personsInfo.setLastName("Das");
		personsInfo.setRole(enums.PersonRole.USER);
		personsInfo.setDateOfBirthday(new GregorianCalendar(1990,05,05));
		personsInfo.setLogin("qqqq");
		personsInfo.setPassword("qqqq");
		PersonsInfoDAO.add(personsInfo);
	}
}
 