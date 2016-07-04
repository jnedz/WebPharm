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
import validator.ValidatorUtils;

/**
 * Servlet implementation class DeliveryMedicines
 */
@WebServlet("/DeliveryMedicines")
public class DeliveryMedicines extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeliveryMedicines() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		request.setAttribute("idPharm", idPharm);
		request.setAttribute("id", idPharm);

		Pharmacy pharmacy = PharmacyService.getPharmacyById(idPharm);
		request.setAttribute("pharmacy", pharmacy);

		PharmacyMedicineService pharmMedService = new PharmacyMedicineService(
				pharmacy);

		long idMed = Long.parseLong(request.getParameter("idMed"));
		request.setAttribute("idMed", idMed);

		PharmacyMedicineService pharmMedServiceWithMed = new PharmacyMedicineService(
				pharmacy, MedicineService.getMedicineById(idMed));

		Medicine medicine = pharmMedServiceWithMed.getMedicine();
		request.setAttribute("medicine", medicine);
		
		int count = PharmacyMedicineService.get—ountByMedTitleFromPharm(pharmacy, medicine.getTitle());
		request.setAttribute("count", count);
		
		int countAll = MedicineService.get—ountByTitle(medicine.getTitle());
		request.setAttribute("countAll", countAll);

		String way = request.getParameter("way");
		System.out.println("#################" + way);
		request.setAttribute("way", way);

		String quantity = request.getParameter("quantity");

		String quantityErr = "";

		int quantityMed = 0;

	/*	System.out.println("~~~~~~~~" + idPharm + "----" + idMed + "~~~~~~~~~~"
				+ medicine.getCount());
System.out.println("quantMed" + PharmacyMedicineService.get—ountOfMed(pharmacy, medicine));*/
		int maxCount = 0;
		if (way.equals("toPharmacy")){
			maxCount = countAll;
		}
		if (way.equals("fromPharmacy")){
			maxCount = count;
		}
		
		if (ValidatorUtils.isValidNumber(quantity, maxCount)) {
			quantityMed = Integer.parseInt(quantity);
			request.setAttribute("quantity", quantityMed);
		} else {
			quantityErr = "incorrect quantity!";
			request.setAttribute("quantityErr", quantityErr);
			request.getRequestDispatcher(
					"/pharmacy/deliveryMedicinesMessage.jsp").forward(request,
					response);
		}

		if (way.equals("fromPharmacy")) {
			pharmMedService.deliveryMedFromPharmacy(medicine.getTitle(),
					quantityMed);
		} else {
			pharmMedService.deliveryMedToPharmacy(medicine.getTitle(),
					quantityMed);
		}

		java.util.List<Medicine> medicines = pharmMedService
				.getAllMedsByPharm();
		request.setAttribute("medicines", medicines);
		request.getRequestDispatcher("/pharmacy/pharmacy.jsp").forward(request,
				response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
