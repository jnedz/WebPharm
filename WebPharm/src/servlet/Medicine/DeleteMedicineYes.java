package servlet.Medicine;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicineDAO;
import dao.ProducerDAO;
import service.MedicineService;
import service.ProducerService;

/**
 * Servlet implementation class DeleteMedicineYes
 */
@WebServlet("/DeleteMedicineYes")
public class DeleteMedicineYes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMedicineYes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			MedicineDAO.delete(MedicineDAO.getMedicineById(Long.parseLong(request.getParameter("id"))));
		} catch (Exception e) {
			request.getRequestDispatcher("/parts/exception.jsp").forward(request, response);
			System.out.println("Exception in deleteMedicine(id)!");
			e.printStackTrace();
		}
		request.setAttribute("medicines", MedicineDAO.getAll());
		request.getRequestDispatcher("/medicine/medicines.jsp").forward(request, response); 
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
