package servlet.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import enums.PersonRole;
import model.Person;

/**
 * Servlet implementation class SortByRole
 */
@WebServlet("/SortByRole")
public class SortByRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SortByRole() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("role", request.getParameter("role"));

		// if (request.getParameter("role").equals("WORKER")){
		List<Person> list = PersonDAO.getAll();

		String role = request.getParameter("role");

		if (!(role.equals("AllPersons"))) {
			list = PersonDAO.getPersonsByRole(role);
		} 

	//	request.setAttribute("buttonRole", request.getParameter("role"));
		request.setAttribute("selectRole", role);
		request.setAttribute("persons", list);
		request.getRequestDispatcher("/person/persons.jsp").forward(request, response);

	}

}
