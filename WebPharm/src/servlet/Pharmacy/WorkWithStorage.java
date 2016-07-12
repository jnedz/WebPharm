package servlet.Pharmacy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import model.Pharmacy;
import service.PharmacyMedicineService;
import service.PharmacyService;

/**
 * Servlet implementation class WorkWithStorage
 */
@WebServlet("/WorkWithStorage")
public class WorkWithStorage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WorkWithStorage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		System.out.println("id pharm = " + idPharm);
		Pharmacy pharmacy = PharmacyService.getPharmacyById(idPharm);
		
		ArrayList <Medicine> medicines = new ArrayList<>(PharmacyMedicineService.getAllMedsByPharmId(idPharm));
		request.setAttribute("idPharm", idPharm);
		request.setAttribute("pharmacy", pharmacy);
		request.setAttribute("medicines", medicines);
		request.getRequestDispatcher("/pharmacy/pharmacyStorage.jsp").forward(request, response);
	}

}
