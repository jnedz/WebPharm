package servlet.Pharmacy;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MedicineDAO;
import dao.PharmacyDAO;
import dao.PharmacyMedicineDAO;
import model.Medicine;
import model.Pharmacy;
import service.PharmacyMedicineService;
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

		Pharmacy pharmacy = PharmacyDAO.getPharmacyById(idPharm);
		request.setAttribute("pharmacy", pharmacy);

		PharmacyMedicineService pharmMedService = new PharmacyMedicineService(
				pharmacy);

		long idMed = Long.parseLong(request.getParameter("idMed"));
		request.setAttribute("idMed", idMed);

		PharmacyMedicineService pharmMedServiceWithMed = new PharmacyMedicineService(
				pharmacy, MedicineDAO.getMedicineById(idMed));

		Medicine medicine = pharmMedServiceWithMed.getMedicine();
		request.setAttribute("medicine", medicine);
		request.setAttribute("count",
				PharmacyMedicineDAO.getÑountOfMed(pharmacy, medicine));

		String way = request.getParameter("way");
		System.out.println("#################" + way);
		request.setAttribute("way", way);

		String quantity = request.getParameter("quantity");

		String quantityErr = "";

		int quantityMed = 0;

		System.out.println("~~~~~~~~" + idPharm + "----" + idMed + "~~~~~~~~~~"
				+ medicine.getCount());
System.out.println("quantMed" + PharmacyMedicineDAO.getÑountOfMed(pharmacy, medicine));
		if (ValidatorUtils.isValidNumber(quantity,
				PharmacyMedicineDAO.getÑountOfMed(pharmacy, medicine))) {
			quantityMed = Integer.parseInt(quantity);
			
			// TODO if quantityMed > quantity (delivery from pharmacy) or if
			// quantityMed < quantity (delivery to pharmacy)
			request.setAttribute("quantity", quantityMed);
		} else {
			quantityErr = "not enough quantity!";
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
