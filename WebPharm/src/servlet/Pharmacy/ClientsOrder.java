package servlet.Pharmacy;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import model.MedicineBasket;
import model.Pharmacy;
import service.PharmacyMedicineService;
import service.PharmacyService;

/**
 * Servlet implementation class ClientsOrder
 */
@WebServlet("/ClientsOrder")
public class ClientsOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsOrder() {
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
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int idPharm = Integer.parseInt(request.getParameter("idPharm"));
		System.out.println("id pharm = " + idPharm);
		Pharmacy pharmacy = PharmacyService.getPharmacyById(idPharm);
		String titleMed = request.getParameter("titleMed");
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int counter = 0;
		try{
		counter = Integer.parseInt(request.getParameter("counter"));
		}catch(Exception e){
		}
		request.setAttribute("counter", ++counter);
		System.out.println("counter = " + counter);
		
		/*ArrayList<MedicineBasket> medsBasket = new ArrayList<>();
		MedicineBasket medBasket = new MedicineBasket();
		medBasket.setTitle(titleMed);
		medBasket.setCount(quantity);
		medsBasket.add(medBasket);*/
		/*try{
			medsBasket = (ArrayList<MedicineBasket>) request.getAttribute("medsBasket");
			for (int i = 1; i<=counter; i++) {
				medBasket = new MedicineBasket();
				medBasket.setTitle(medBasket.getTitle());
				medBasket.setCount(medBasket.getCount());
				medsBasket.add(medBasket);
			}
		}catch(Exception e){
		}*/
		request.setAttribute("medBasketTitle", titleMed);
		request.setAttribute("medBasketCount", quantity);
		
		
		ArrayList <Medicine> medicines = new ArrayList<>(PharmacyMedicineService.getMedicinesWithUniqueTitle(pharmacy));
		request.setAttribute("idPharm", idPharm);
		request.setAttribute("pharmacy", pharmacy);
		request.setAttribute("titleMed", titleMed);
		request.setAttribute("medicines", medicines);
		request.getRequestDispatcher("/pharmacy/pharmacyClients.jsp").forward(request, response);

		
		
	}

}
