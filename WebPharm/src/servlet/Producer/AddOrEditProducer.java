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
import javax.servlet.http.HttpSession;

import dao.MedicineDAO;
import dao.PersonDAO;
import dao.ProducerDAO;
import enums.Country;
import enums.MedicineType;
import enums.PersonRole;
import model.Medicine;
import model.Person;
import model.Producer;
import utils.Formatter;
import validator.ValidatorUtils;

/**
 * Servlet implementation class EditProducer
 */
@WebServlet("/AddOrEditProducer")
public class AddOrEditProducer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddOrEditProducer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("$$$$$$$$$$$$$$$$$$$$" + request.getParameter("id"));
		HttpSession session = request.getSession(true);
		System.out.println("#####################" + session.getAttribute("fromAddMed"));
		if ("yes".equals(session.getAttribute("fromAddMed").toString())) {
			session.setAttribute("fromAddMed", "yes");
		}
		
		if (Integer.parseInt(request.getParameter("id")) > 0) {
		Producer producer = ProducerDAO.getProducerById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("producerTitle", producer.getTitle());
		request.setAttribute("country", producer.getCountry());
		request.setAttribute("selectedCountry", producer.getCountry());
		}
		request.getRequestDispatcher("/producer/addOrEditProducer.jsp").forward(request, response);
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