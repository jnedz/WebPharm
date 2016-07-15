package servlet.Pharmacy;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MedicineBasket;
import model.Pharmacy;
import service.PharmacyService;

/**
 * Servlet implementation class ClientsBasket
 */
@WebServlet("/ClientsBasket")
public class ClientsBasket extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientsBasket() {
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
		System.out.println("@@@id pharm = " + idPharm);
		Pharmacy pharmacy = PharmacyService.getPharmacyById(idPharm);
		//MedicineBasket medBasket = (MedicineBasket) request.getAttribute("medsBasket");
		MedicineBasket medBasket = new MedicineBasket();
		medBasket.setTitle(request.getParameter("medBasketTitle"));
		medBasket.setCount( Integer.parseInt(request.getParameter("medBasketCount")));
		System.out.println("medBasket = " + medBasket);
		
		request.setAttribute("idPharm", idPharm);
		request.setAttribute("medBasket", medBasket); //!!!
		request.getRequestDispatcher("/pharmacy/clientsBasket.jsp").forward(request, response);

		
	}

}
