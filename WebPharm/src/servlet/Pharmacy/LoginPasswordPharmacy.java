package servlet.Pharmacy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PharmacyDAO;
import dao.UserDAO;
import enums.PersonRole;
import model.User;

/**
 * Servlet implementation class LoginPasswordPharmacy
 */
@WebServlet("/LoginPasswordPharmacy")
public class LoginPasswordPharmacy extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginPasswordPharmacy() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		PersonRole role = PersonRole.valueOf(request.getParameter("role"));
		
		String enter = "";
		try{
		enter = request.getParameter("enter");
		}catch(Exception e){
		}
		
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		user.setRole(role);
		
		boolean userIsExist = false;
		if ("yes".equals(enter)){
			for (User userFromDB : UserDAO.getAll()) {
				if (user.getLogin().equals(userFromDB.getLogin()) && user.getPassword().equals(userFromDB.getPassword())
						&& user.getRole().equals(userFromDB.getRole())) {
					//TODO sessia.setAtribute()
					userIsExist = true;
				}
			request.setAttribute("userIsExist", userIsExist);	
			request.setAttribute("login", login);
			request.setAttribute("role", role);
			request.getRequestDispatcher("/pharmacy/messageEnter.jsp").forward(request, response);
			}
		}

		for (User userFromDB : UserDAO.getAll()) {
			if (user.getLogin().equals(userFromDB.getLogin()) && user.getPassword().equals(userFromDB.getPassword())
					&& user.getRole().equals(userFromDB.getRole())) {
				userIsExist = true;
			}
		}
		
		
		if (userIsExist == false) {
			UserDAO.add(user);
		}

		request.setAttribute("userIsExist", userIsExist);
		request.setAttribute("login", login);
		request.setAttribute("role", role);
		request.getRequestDispatcher("/pharmacy/messageRegistration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
