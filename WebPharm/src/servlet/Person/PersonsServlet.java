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
import utils.Formater;
import utils.InvalidDateException;
import dao.PersonDAO;
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
			throws ServletException, IOException  {

		Person p = new Person();
		int id = 0;
		try{
		id = Integer.parseInt(request.getParameter("id"));
		}catch(Exception e){
		}
		if (id > 0) {
			p = PersonDAO.getPersonById(Integer.parseInt(request.getParameter("id")));
		}

		String firstName = request.getParameter("firstName") != "" ? request.getParameter("firstName") : "NoFirstName";
		p.setFirstName(firstName);
		String lastName = request.getParameter("lastName") != "" ? request.getParameter("lastName") : "NoLastName";
		p.setLastName(lastName);
		String role = request.getParameter("role") != "" ? request.getParameter("role") : "WORKER";
		p.setRole(PersonRole.valueOf(role));
		/*
		 * SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy"
		 * ); Date dte; try { dte = simpleDateFormat
		 * .parse(request.getParameter("date") != "" ?
		 * request.getParameter("date") : simpleDateFormat.format( new Date()
		 * )); GregorianCalendar gregorianCalendar = (GregorianCalendar)
		 * GregorianCalendar.getInstance(); gregorianCalendar.setTime(dte);
		 * p.setDateOfBirthday(gregorianCalendar);
		 * 
		 * } catch (ParseException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
			p.setDateOfBirthday(Formater.toDateFromString(request.getParameter("date") != "" ? request.getParameter("date")
					: Formater.fromDateToString(new GregorianCalendar())));

		if (id > 0) {
			PersonDAO.update(p);
			request.setAttribute("persons", PersonDAO.getAll());
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		} else {
			PersonDAO.add(p);
			request.setAttribute("persons", PersonDAO.getAll());
			request.getRequestDispatcher("/person/persons.jsp").forward(request, response);
		}
	}

}
