package servlet.Producer;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProducerDAO;
import service.ProducerService;

/**
 * Servlet implementation class DeleteProducerYes
 */
@WebServlet("/DeleteProducerYes")
public class DeleteProducerYes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteProducerYes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ProducerService.deleteProducer(ProducerDAO.getProducerById(Integer.parseInt(request.getParameter("id"))));
		} catch (Exception e) {
			request.getRequestDispatcher("/parts/exception.jsp").forward(request, response);
			System.out.println("Exception in deleteProducer(id)!");
			e.printStackTrace();
		}
		request.setAttribute("producers", ProducerDAO.getAll());
		request.getRequestDispatcher("/producer/producers.jsp").forward(request, response); 
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
