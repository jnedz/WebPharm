package servlet.Pharmacy;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import service.MedicineService;

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
		
		List<Medicine> medicines = MedicineService.getMedicinesWithUniqueTitle();
		System.out.println("@@@@@@@" + MedicineService.getAll());
		System.out.println("___________\n" + medicines);
		//List<Medicine> medicines = MedicineService.getAll();
		System.out.println("##########" + request.getParameter("idPharm"));
		
		request.setAttribute("idPharm", request.getParameter("idPharm"));
		request.setAttribute("medicines", medicines);
		request.getRequestDispatcher("/pharmacy/addMedicineFromPharmacy.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
