package servlet.Person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import service.PersonService;
import utils.Formatter;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/EditPerson")
public class EditPerson extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditPerson() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (Integer.parseInt(request.getParameter("id")) > 0){
		Person person = PersonService.getPersonById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("id", person.getId());
		request.setAttribute("firstName", person.getFirstName());
		request.setAttribute("lastName", person.getLastName());
		request.setAttribute("dateOfBirthday", Formatter.fromDateToString(person.getDateOfBirthday()));
		request.setAttribute("selectedRole", person.getRole());
		}
		request.getRequestDispatcher("/person/addOrEditPerson.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}