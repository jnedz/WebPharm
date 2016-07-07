package servlet.Pharmacy;

import java.io.IOException;

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
 * Servlet implementation class DeliveryMedicinesMessage
 */
@WebServlet("/DeliveryMedicinesMessage")
public class DeliveryMedicinesMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryMedicinesMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		Pharmacy pharmacy = PharmacyService.getPharmacyById(idPharm);
		
		int idMed = Integer.parseInt(request.getParameter("idMed"));
		
		PharmacyMedicineService pharmMedServ = new PharmacyMedicineService(pharmacy, MedicineService.getMedicineById(idMed));
		Medicine medicineFromPharm = pharmMedServ.getMedicine();
		
		
		String way = request.getParameter("way");
		System.out.println("22222222222222222222222 " + way);
		
		request.setAttribute("idPharm", idPharm);
		request.setAttribute("idMed", idMed);
		request.setAttribute("pharmacy", pharmacy);
		request.setAttribute("medicine", medicineFromPharm);
		
		int count = PharmacyMedicineService.get—ountByMedTitleFromPharm(pharmacy, medicineFromPharm.getTitle());
		request.setAttribute("count", count);
		
		int countAll = MedicineService.get—ountByTitle(medicineFromPharm.getTitle());
		request.setAttribute("countAll", countAll);	
		
		request.setAttribute("way", way);
		request.getRequestDispatcher("/pharmacy/deliveryMedicinesMessage.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
