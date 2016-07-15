package servlet.Pharmacy;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import service.PharmacyMedicineService;
import service.PharmacyService;

/**
 * Servlet implementation class SortByDate
 */
@WebServlet("/SortByDate")
public class SortByDate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortByDate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		String order = request.getParameter("order");
		if (request.getParameter("order") == null) {
			order = "NoSort";
		}
		java.util.List <Medicine> meds = PharmacyMedicineService.getMedicinesSortByDate(idPharm, order);
		
		if (order.equals("ASC")){
			order="DESC";
		}else {
			order = "ASC";
		}
		
		
		request.setAttribute("order", order);
		request.setAttribute("pharmacy", PharmacyService.getPharmacyById(idPharm));
		request.setAttribute("medicines", meds);
		request.setAttribute("idPharm", request.getParameter("idPharm"));
		request.getRequestDispatcher("/pharmacy/pharmacyStorage.jsp").forward(request, response);
	}

}
