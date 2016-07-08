package servlet.Registration;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonsInfo;
import service.PersonsInfoService;


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

		boolean userIsExist = false;
		for (PersonsInfo userFromDB : PersonsInfoService.getAll()) {
			if (login.equals(userFromDB.getLogin()) && password.equals(userFromDB.getPassword())) {
				request.setAttribute("roleReg", userFromDB.getRole().name());
				System.out.println("userFromDB.getRole().name()= " + userFromDB.getRole().name());
				userIsExist = true;
			}
		}
		request.setAttribute("userIsExist", userIsExist);
		request.setAttribute("login", login);
		request.getRequestDispatcher("/registration/messageEnter.jsp").forward(request, response);
	}

}
