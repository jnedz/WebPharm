package servlet.Person;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Constants;

import model.Person;
import utils.Formatter;
import utils.InvalidDateException;
import validator.ValidatorUtils;
import dao.PersonDAO;
import enums.Country;
import enums.PersonRole;

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

		request.setAttribute("persons", PersonDAO.getAll());
		request.getRequestDispatcher("/person/persons.jsp").forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Person person = new Person();
		boolean isError = false;
		long id = 0;
		try {
			id = Long.parseLong(request.getParameter("id"));
		} catch (Exception e) {
		}
		if (id > 0) {
			person = PersonDAO.getPersonById(id);
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

		String dateOfBirthday = request.getParameter("dateOfBirthday");
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
				PersonDAO.update(person);
			} else {
				PersonDAO.add(person);
			}
				request.setAttribute("persons", PersonDAO.getAll());
				request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/person/addOrEditPerson.jsp").forward(request, response);
		}

	}

}
