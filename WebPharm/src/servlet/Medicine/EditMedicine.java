package servlet.Medicine;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import service.MedicineService;
import utils.Formatter;

/**
 * Servlet implementation class EditMedicine
 */
@WebServlet("/EditMedicine")
public class EditMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMedicine() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (Long.parseLong(request.getParameter("id")) > 0) {
			Medicine m = MedicineService.getMedicineById(Integer.parseInt(request.getParameter("id")));
			request.setAttribute("id", m.getId());
			request.setAttribute("title", m.getTitle());
			request.setAttribute("dateOfManufact", Formatter.fromDateToString(m.getDateOfManufact()));
			request.setAttribute("term", m.getTerm());
			request.setAttribute("price", m.getPrice());
			request.setAttribute("count", m.getCount());
			request.setAttribute("selectedTitle", m.getProducer().getTitle());
			request.setAttribute("selectedType", m.getType());
			request.setAttribute("producerTitle", m.getProducer().getTitle());
			request.setAttribute("type", m.getType());
		}
		request.getRequestDispatcher("/medicine/addOrEditMedicine.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
