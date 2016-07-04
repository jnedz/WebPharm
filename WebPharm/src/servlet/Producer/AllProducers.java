package servlet.Producer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Country;
import model.Producer;
import service.ProducerService;
import validator.ValidatorUtils;

/**
 * Servlet implementation class AllProducers
 */
@WebServlet("/AllProducers")
public class AllProducers extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AllProducers() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("producers", ProducerService.getAll());
		request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Producer producer = new Producer();
		boolean isError = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			producer = ProducerService.getProducerById(id);
			request.setAttribute("id", id);
		} catch (Exception e) {
		}

		String producerTitleErr = "";

		String producerTitle = request.getParameter("producerTitle");
		if (ValidatorUtils.isValidStringByLength(producerTitle, 21)) {
			producer.setTitle(producerTitle);
		} else {
			producerTitleErr = "title format exception!";
			isError = true;
			request.setAttribute("producerTitleErr", producerTitleErr);
		}
		request.setAttribute("producerTitle", producerTitle);

		String country = request.getParameter("country");
		producer.setCountry(Country.valueOf(country));
		request.setAttribute("selectedCountry", country);

		if (isError == false) {
			boolean isEqualsProd = false;
			for (Producer prod : ProducerService.getAll()) {
				if (prod.getTitle().equals(producer.getTitle()) && prod.getCountry().equals(producer.getCountry())) {
					isEqualsProd = true;
					System.out.println("!!!!!!!!!!!! isEqualsProd = true!");
					request.setAttribute("producerTitle", producerTitle);
					request.setAttribute("country", country);
					request.getRequestDispatcher("/producer/messageIsEqualsProd.jsp").forward(request, response);
				}
			}
			if (isEqualsProd == false) {
				if (id > 0) {
					ProducerService.update(producer);
					request.setAttribute("producers", ProducerService.getAll());
					request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);
				} else {
					ProducerService.add(producer);

					if ("yes".equals(getServletConfig().getServletContext().getAttribute("fromAddMed"))) {

						request.getRequestDispatcher("/medicine/addOrEditMedicine.jsp").forward(request, response);
					} else {
						request.setAttribute("producers", ProducerService.getAll());
						request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);
					}
				}
			}
		} else {
			request.getRequestDispatcher("/producer/addOrEditProducer.jsp").forward(request, response);
		}
	}
	
}
