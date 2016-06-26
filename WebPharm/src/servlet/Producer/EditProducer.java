package servlet.Producer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PersonDAO;
import dao.ProducerDAO;
import enums.Country;
import enums.PersonRole;
import model.Person;
import model.Producer;

/**
 * Servlet implementation class EditProducer
 */
@WebServlet("/EditProducer")
public class EditProducer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditProducer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producer p = ProducerDAO.getProducerById(Integer.parseInt(request.getParameter("id")));

		request.setAttribute("producer", p);
		request.getRequestDispatcher("/producer/editProducer.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Producer p = ProducerDAO.getProducerById(Integer.parseInt(request.getParameter("id")));
System.out.println(p);
		String title = request.getParameter("title") != "" ? request.getParameter("title") : p.getTitle();
		p.setTitle(title);
		p.setCountry(Country.valueOf(request.getParameter("country")));
		ProducerDAO.update(p);
		System.out.println("!!!!!!!upd");
		request.setAttribute("producers", ProducerDAO.getAll());
		request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);

	}

}
