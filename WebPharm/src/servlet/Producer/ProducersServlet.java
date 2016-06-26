package servlet.Producer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PersonDAO;
import dao.ProducerDAO;
import enums.Country;
import enums.PersonRole;
import model.Person;
import model.Producer;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/producers")
public class ProducersServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProducersServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("producers", ProducerDAO.getAll());

		request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		System.out.println("***+++*****" + session.getAttribute("fromAddMed"));

		String toMedicine = session.getAttribute("fromAddMed").toString();

		String title = request.getParameter("title") != "" ? request.getParameter("title") : "NoTitle";

		String country = request.getParameter("country") != "" ? request.getParameter("country") : "NOCOUNTRY";

		Producer p = new Producer();

		p.setCountry(Country.valueOf(country));

		p.setTitle(title);

		ProducerDAO.add(p);

		if ("yes".equals(session.getAttribute("fromAddMed").toString())) {
			//session.setAttribute("fromAddMed", "no");
			request.getRequestDispatcher("addOrEditMedicine.jsp").forward(request, response);
		} else {
			request.setAttribute("producers", ProducerDAO.getAll());
			request.getRequestDispatcher("producers.jsp").forward(request, response);
		}

	}
}
