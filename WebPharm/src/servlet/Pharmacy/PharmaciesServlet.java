package servlet.Pharmacy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PharmacyDAO;
import model.Medicine;
import model.Pharmacy;
import service.PharmacyMedicineService;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/PharmaciesServlet")
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

		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		Pharmacy pharmacy = PharmacyDAO.getPharmacyById(idPharm);
		
		ArrayList <Medicine> medicines = new ArrayList<>(PharmacyMedicineService.getAllMedsByPharmId(idPharm));
		if (medicines.size()==0){
			request.setAttribute("pharmacy", pharmacy);
			request.getRequestDispatcher("/pharmacy/messageNoMedsInPharm.jsp").forward(request, response);
		}
		request.setAttribute("idPharm", idPharm);
		request.setAttribute("pharmacy", pharmacy);
		request.setAttribute("medicines", medicines);
		request.getRequestDispatcher("/pharmacy/pharmacy.jsp").forward(request, response);
		
		
		
        }

}
