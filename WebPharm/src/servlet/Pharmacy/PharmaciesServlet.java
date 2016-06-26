package servlet.Pharmacy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicineDAO;
import dao.PersonDAO;
import dao.PharmacyDAO;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/pharmacies")
public class PharmaciesServlet  extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 /**
     * @see HttpServlet#HttpServlet()
     */
    public PharmaciesServlet() {
        super();
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
		request.setAttribute("pharmacies", PharmacyDAO.getAll());
       
        request.getRequestDispatcher("/pharmacy/pharmacies.jsp").forward(request, response); 
		
        }

}
