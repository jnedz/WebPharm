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
import model.User;
import service.PersonService;
import service.UserService;
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
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String dateOfBirthday = request.getParameter("dateOfBirthday").isEmpty() ? Formatter.fromDateToString(new GregorianCalendar()) : request.getParameter("dateOfBirthday");
		PersonRole role = PersonRole.valueOf(request.getParameter("role"));
		
		boolean userIsExist = false;
		for (User userFromDB : UserService.getAll()) {
			if ((userFromDB.getLogin().equals(login)) && userFromDB.getPassword().equals(password)) {
				userIsExist = true;
			}
		}
		
		if (userIsExist == false){
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(role);
		UserService.add(user);
		
		Person person = new Person();
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setDateOfBirthday(Formatter.toDateFromString(dateOfBirthday));
		person.setRole(role);
		PersonService.add(person);
		
		}
	
		request.setAttribute("login", login);
		request.setAttribute("role", role);
		request.setAttribute("userIsExist", userIsExist);
		request.getRequestDispatcher("/registration/messageRegistration.jsp").forward(request, response);
	}

}
