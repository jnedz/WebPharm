package servlet.Person;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Person;
import service.PersonService;

/**
 * Servlet implementation class SortByFirstName
 */
@WebServlet("/SortByFirstNameByRole")
public class SortByFirstNameByRole extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SortByFirstNameByRole() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("555555555555555555");
		System.out.println("~~~" + request.getParameter("role"));
		System.out.println("###" + request.getParameter("order"));
		System.out.println("###111" + request.getParameter("criteria"));
		
		List<Person> sortedList = PersonService.getAll();
		
		String role = request.getParameter("role");
		String order = request.getParameter("order");
		String criteria = request.getParameter("criteria");
		
		if (request.getParameter("role")==null || request.getParameter("role")==""){
			role = "AllPersons";
		}
		
		if (request.getParameter("order") == null) {
			order = "NoSort";
		} 
		
		sortedList = PersonService.sortByCriteria(criteria, order, role);

		if (order.equals("ASC")){
			order="DESC";
		}else {
			order = "ASC";
		}
		
		request.setAttribute("order", order);
		request.setAttribute("selectRole", role);
		request.setAttribute("criteria", criteria);
		request.setAttribute("persons", sortedList);
		request.getRequestDispatcher("/person/persons.jsp").forward(request, response);

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
