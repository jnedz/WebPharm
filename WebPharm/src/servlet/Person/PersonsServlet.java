package servlet.Person;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.PersonRole;
import model.Person;
import service.PersonService;
import utils.Formatter;
import validator.ValidatorUtils;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/PersonsServlet")
public class PersonsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PersonsServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("persons", PersonService.getAll());
		request.getRequestDispatcher("/person/persons.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Person person = new Person();
		boolean isError = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
		} catch (Exception e) {
		}
		if (id > 0) {
			person = PersonService.getPersonById(id);
			request.setAttribute("id", id);
		}

		String firstNameErr = "";
		String lastNameErr = "";
		String dateErr = "";

		String firstName = request.getParameter("firstName");
		if (ValidatorUtils.isValidStringByLength(firstName, 21)) {
			person.setFirstName(firstName);
		} else {
			firstNameErr = "title format exception!";
			isError = true;
			request.setAttribute("firstNameErr", firstNameErr);
		}
		request.setAttribute("firstName", firstName);

		String lastName = request.getParameter("lastName");
		if (ValidatorUtils.isValidStringByLength(lastName, 21)) {
			person.setLastName(lastName);
		} else {
			lastNameErr = "title format exception!";
			isError = true;
			request.setAttribute("lastNameErr", lastNameErr);
		}
		request.setAttribute("lastName", lastName);

		String dateOfBirthday = request.getParameter("dateOfBirthday").isEmpty() ? Formatter.fromDateToString(new GregorianCalendar()) : request.getParameter("dateOfBirthday");
		if (ValidatorUtils.isValidDate(dateOfBirthday)) {
			person.setDateOfBirthday(Formatter.toDateFromString(dateOfBirthday));
		} else {
			dateErr = "date format exception!";
			isError = true;
			request.setAttribute("dateErr", dateErr);
		}
		request.setAttribute("dateOfBirthday", dateOfBirthday);

		String role = request.getParameter("role");
		person.setRole(PersonRole.valueOf(role));
		request.setAttribute("selectedRole", role);

		if (isError == false) {
			if (id > 0) {
				PersonService.update(person);
			} else {
				PersonService.add(person);
			}
				request.setAttribute("persons", PersonService.getAll());
				request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/person/addOrEditPerson.jsp").forward(request, response);
		}

	}

}
