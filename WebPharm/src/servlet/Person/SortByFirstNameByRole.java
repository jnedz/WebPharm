package servlet.Person;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import model.Person;
import service.PharmacyService;

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

		String order = request.getParameter("order");
		List<Person> sortedList = PersonDAO.getAll();
		
		String role = request.getParameter("role");
		
		if (request.getParameter("role")==null){
			role = "AllPersons";
		}
		if (request.getParameter("order") == null) {
			order = "NoSort";
		} 
		
		
		sortedList = PersonDAO.sortByCriteria("dateOfBirthday", order, role);

		
		//String reverseOrder = "ASC";
		if (order.equals("ASC")){
			order="DESC";
		}
		else order = "ASC";
		
		request.setAttribute("order", order);
		
		request.setAttribute("persons", sortedList);
		request.setAttribute("selectRole", role);
		// request.setAttribute("order", order);
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
