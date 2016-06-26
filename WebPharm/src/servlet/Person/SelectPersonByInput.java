package servlet.Person;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import model.Person;
import utils.Formater;

/**
 * Servlet implementation class SelectPersonByInput
 */
@WebServlet("/SelectPersonByInput")
public class SelectPersonByInput extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SelectPersonByInput() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String date = request.getParameter("date");
		boolean isError = false;
		String firstNameErr = "";
		String lastNameErr = "";
		String dateErr = "";

		List<Person> persons = new ArrayList<>();

		if (firstName.isEmpty() && lastName.isEmpty() && date.isEmpty()) {
			request.setAttribute("persons", PersonDAO.getAll());
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		}

		if (firstName.length() > 20) {
			firstNameErr = "name format exception!";
			isError = true;
			request.setAttribute("firstNameErr", firstNameErr);
		}
		if (lastName.length() > 20) {
			lastNameErr = "name format exception!";
			isError = true;
			request.setAttribute("lastNameErr", lastNameErr);
		}

		if (date.length() > 0) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
				Date dte;
				GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
				dte = simpleDateFormat.parse(date);
				gregorianCalendar.setTime(dte);
			} catch (ParseException e) {
				dateErr = "date format exception!";
				isError = true;
				request.setAttribute("dateErr", dateErr);
			}
		}
		
		if (isError == true) {
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("date", date);
			request.setAttribute("persons", PersonDAO.getAll());
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		}

		for (Person person : PersonDAO.getAll()) {
			if (firstName.length() == 0 || person.getFirstName().contains(firstName)) {
				if (lastName.length() == 0 || person.getLastName().contains(lastName)) {
					if (date.length() == 0 || Formater.fromDateToString(person.getDateOfBirthday()).contains(date)) {
						persons.add(person);
					}
				}
			}
		}
		System.out.println("QQQQQQQQQQQQQQQQQQQ" + persons.size());
		if (persons.size() == 0) {
			request.getRequestDispatcher("/parts/message.jsp").forward(request, response);
		} else {
			request.setAttribute("firstName", firstName);
			request.setAttribute("lastName", lastName);
			request.setAttribute("date", date);
			request.setAttribute("persons", persons);
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
