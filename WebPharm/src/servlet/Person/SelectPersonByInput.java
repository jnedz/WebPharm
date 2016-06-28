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
import utils.Formatter;

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

		String firstNameForSeach = request.getParameter("firstNameForSeach");
		String lastNameForSeach = request.getParameter("lastNameForSeach");
		String dateForSeach = request.getParameter("dateForSeach");
		boolean isError = false;
		String firstNameErr = "";
		String lastNameErr = "";
		String dateErr = "";

		List<Person> persons = new ArrayList<>();

		if (firstNameForSeach.isEmpty() && lastNameForSeach.isEmpty() && dateForSeach.isEmpty()) {
			request.setAttribute("persons", PersonDAO.getAll());
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		}

		if (firstNameForSeach.length() > 20) {
			firstNameErr = "name format exception!";
			isError = true;
			request.setAttribute("firstNameErr", firstNameErr);
		}
		if (lastNameForSeach.length() > 20) {
			lastNameErr = "name format exception!";
			isError = true;
			request.setAttribute("lastNameErr", lastNameErr);
		}

		if (dateForSeach.length() > 0) {
			try {
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
				Date dte;
				GregorianCalendar gregorianCalendar = (GregorianCalendar) GregorianCalendar.getInstance();
				dte = simpleDateFormat.parse(dateForSeach);
				gregorianCalendar.setTime(dte);
			} catch (ParseException e) {
				dateErr = "date format exception!";
				isError = true;
				request.setAttribute("dateErr", dateErr);
			}
		}
		
		if (isError == true) {
			request.setAttribute("firstNameForSeach", firstNameForSeach);
			request.setAttribute("lastNameForSeach", lastNameForSeach);
			request.setAttribute("dateForSeach", dateForSeach);
			request.setAttribute("persons", PersonDAO.getAll());
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		}

		for (Person person : PersonDAO.getAll()) {
			if (firstNameForSeach.length() == 0 || person.getFirstName().contains(firstNameForSeach)) {
				if (lastNameForSeach.length() == 0 || person.getLastName().contains(lastNameForSeach)) {
					if (dateForSeach.length() == 0 || Formatter.fromDateToString(person.getDateOfBirthday()).contains(dateForSeach)) {
						persons.add(person);
					}
				}
			}
		}
		System.out.println("QQQQQQQQQQQQQQQQQQQ" + persons.size());
		if (persons.size() == 0) {
			request.getRequestDispatcher("/parts/message.jsp").forward(request, response);
		} else {
			request.setAttribute("firstNameForSeach", firstNameForSeach);
			request.setAttribute("lastNameForSeach", lastNameForSeach);
			request.setAttribute("dateForSeach", dateForSeach);
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
