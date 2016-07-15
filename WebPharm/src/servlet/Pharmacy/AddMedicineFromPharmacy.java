package servlet.Pharmacy;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class AddMedicineFromPharmacy
 */
@WebServlet("/AddMedicineFromPharmacy")
public class AddMedicineFromPharmacy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMedicineFromPharmacy() {
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
		List<Medicine> medicines = MedicineService.getMedicinesWithUniqueTitle();
		
		request.setAttribute("idPharm", request.getParameter("idPharm"));
		request.setAttribute("pharmacy", PharmacyService.getPharmacyById(Integer.parseInt(request.getParameter("idPharm"))));
		request.setAttribute("medicines", medicines);
		
		System.out.println("!!!!!!!!!!!!!!!!\n" + PharmacyMedicineService.getAllMedsByPharmId(Integer.parseInt(request.getParameter("idPharm"))));
		System.out.println("2222222222222222222222222222\n" + PharmacyMedicineService.getMedicinesWithUniqueTitle(PharmacyService.getPharmacyById(Integer.parseInt(request.getParameter("idPharm")))));
		
		request.setAttribute("meds", PharmacyMedicineService.getMedicinesWithUniqueTitle(PharmacyService.getPharmacyById(Integer.parseInt(request.getParameter("idPharm")))));
		request.getRequestDispatcher("/pharmacy/addMedicineFromPharmacy.jsp").forward(request, response);
	}

}
