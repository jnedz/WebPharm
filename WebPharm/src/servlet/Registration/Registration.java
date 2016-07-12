package servlet.Registration;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.PersonRole;
import model.Person;
import model.Pharmacy;
import service.PersonPharmacyService;
import service.PersonService;
import service.PharmacyService;
import utils.Formatter;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/registration/registrationForm.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirthday = request.getParameter("dateOfBirthday").isEmpty() ? Formatter.fromDateToString(new GregorianCalendar()) : request.getParameter("dateOfBirthday");
		PersonRole role = PersonRole.valueOf(request.getParameter("role"));
		String pharmacyTitle = request.getParameter("pharmacyTitle");
		
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@" + pharmacyTitle);
		
		Pharmacy pharmacy = PharmacyService.getPharmaciesByTitle(pharmacyTitle).get(0);
		int idPharm = pharmacy.getId();
		
		getServletConfig().getServletContext().setAttribute("idPharm", idPharm);
		
		String password=request.getParameter("password");
		String login=request.getParameter("login");
		boolean userIsExist = false;
		for (Person personFromDB : PersonService.getAll()) {
			if ((login.equals(personFromDB.getLogin())) && password.equals(personFromDB.getPassword())) {
				userIsExist = true;
			}
		}
		
		if (userIsExist == false){
		Person person = new Person();
		person.setLogin(login);
		person.setPassword(password);
		person.setRole(role);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setDateOfBirthday(Formatter.toDateFromString(dateOfBirthday));
		PersonService.add(person);
		
		PersonPharmacyService.add(PersonService.getPersonsByFullName(firstName, lastName).get(0), pharmacy);
		getServletConfig().getServletContext().setAttribute("idPharm", idPharm);
		}
	
		request.setAttribute("login", login);
		request.setAttribute("role", role);
		request.setAttribute("userIsExist", userIsExist);
		request.getRequestDispatcher("/registration/messageRegistration.jsp").forward(request, response);
	}

}
