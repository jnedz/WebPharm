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
import service.PersonService;
import utils.Formatter;

/**
 * Servlet implementation class RegistrationNewStep2
 */
@WebServlet("/RegistrationNewStep2")
public class RegistrationNewStep2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationNewStep2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Person person = PersonService.getPersonById(id);
		
//		String firstName = request.getParameter("firstName");
//		String lastName = request.getParameter("lastName");
//		String dateOfBirthday = (request.getParameter("dateOfBirthday"));
//		PersonRole role = PersonRole.valueOf(request.getParameter("role"));

		
		
		request.setAttribute("firstName", person.getFirstName());
		request.setAttribute("lastName", person.getLastName());
		request.setAttribute("dateOfBirthday", Formatter.fromDateToString(person.getDateOfBirthday()));
		request.setAttribute("roleSel", person.getRole().name());
		request.getRequestDispatcher("/registration/registrationForm.jsp").forward(request, response);

	}

}
