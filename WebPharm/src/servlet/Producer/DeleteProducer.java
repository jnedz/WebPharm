package servlet.Producer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProducerDAO;
import model.Producer;
import service.ProducerService;

/**
 * Servlet implementation class DeleteProducer
 */
@WebServlet("/DeleteProducer")
public class DeleteProducer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteProducer() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("(for delete) Producer_id = " + request.getParameter("id"));
		Producer p = ProducerDAO.getProducerById(Integer.parseInt(request.getParameter("id")));
		System.out.println(request.getParameter("id"));
		System.out.println(p);
		// request.setAttribute("title", p.getTitle());
		// request.setAttribute("country", p.getCountry());
		request.setAttribute("producer", p);
		request.getRequestDispatcher("/producer/deleteProducer.jsp").forward(request, response);

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
