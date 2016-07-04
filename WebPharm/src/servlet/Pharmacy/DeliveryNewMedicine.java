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
import service.MedicineService;
import service.PharmacyMedicineService;
import service.PharmacyService;

/**
 * Servlet implementation class DeliveryNewMedicine
 */
@WebServlet("/DeliveryNewMedicine")
public class DeliveryNewMedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryNewMedicine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//idPharm=1&idMed=3&way=toPharmacy&quantity=111
		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		Pharmacy pharmacy = PharmacyService.getPharmacyById(idPharm);
		long idMed = Long.parseLong(request.getParameter("idMed"));
		int count = Integer.parseInt(request.getParameter("quantity"));
		PharmacyMedicineService apot = new PharmacyMedicineService(pharmacy);
		apot.deliveryMedToPharmacy(MedicineService.getMedicineById(idMed).getTitle(), count);
		
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
