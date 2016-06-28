package servlet.Producer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProducerDAO;
import enums.Country;
import model.Producer;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("producers", ProducerDAO.getAll());
		request.getRequestDispatcher("/producer/producers.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Producer producer = new Producer();
		System.out.println(request.getParameter("id"));
		boolean isError = false;
		int id = 0;
		try {
			id = Integer.parseInt(request.getParameter("id"));
			producer = ProducerDAO.getProducerById(id);
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
			if (id > 0) {
				ProducerDAO.update(producer);
				request.setAttribute("producers", ProducerDAO.getAll());
				request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);
			} else {
				ProducerDAO.add(producer);
				
				
				//System.out.println("APPLICATION" + request.application.getAttribute("fromAddMed").toString());
				
				//if ("yes".equals(session.getAttribute("fromAddMed").toString())) {
					if ("yes".equals(getServletConfig().getServletContext().getAttribute("fromAddMed"))){
					
					request.getRequestDispatcher("/medicine/addOrEditMedicine.jsp").forward(request, response);
				} else {
					request.setAttribute("producers", ProducerDAO.getAll());
					request.getRequestDispatcher("/producer/producers.jsp").forward(request, response);
				}
			}
		} else {
			request.getRequestDispatcher("/producer/addOrEditProducer.jsp").forward(request, response);
		}

	}


}
