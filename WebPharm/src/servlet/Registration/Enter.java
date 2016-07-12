package servlet.Registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.descriptor.web.ApplicationParameter;

import dao.PersonPharmacyDAO;
import model.Person;
import service.PersonPharmacyService;
import service.PersonService;
import service.PharmacyService;


/**
 * Servlet implementation class Enter
 */
@WebServlet("/Enter")
public class Enter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Enter() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/registration/enterForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		
		for (Person userFromDB : PersonService.getAll()) {
			if (login.equals(userFromDB.getLogin()) && password.equals(userFromDB.getPassword())) {
				
				getServletConfig().getServletContext().setAttribute("roleReg", userFromDB.getRole().name());
				getServletConfig().getServletContext().setAttribute("firstName", userFromDB.getFirstName());
				getServletConfig().getServletContext().setAttribute("lastName", userFromDB.getLastName());
				try{
				getServletConfig().getServletContext().setAttribute("idPharm", PersonPharmacyService.getPharmacies(userFromDB).get(0).getId());
				System.out.println("idPharm = " + PersonPharmacyService.getPharmacies(userFromDB).get(0).getId());
				}catch(Exception ex){
					System.out.println("Exception: idPharm dont founded! " + ex);
				}
				
				getServletConfig().getServletContext().setAttribute("registration", "yes");
				request.setAttribute("pharmacies", PharmacyService.getAll());
				request.getRequestDispatcher("/pharmacy/pharmacies.jsp").forward(request, response);
				
			}
		}
		
		request.getRequestDispatcher("/registration/messageEnter.jsp").forward(request, response);
	}

}
