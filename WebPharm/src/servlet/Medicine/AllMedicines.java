package servlet.Medicine;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.MedicineType;
import model.Medicine;
import model.Producer;
import service.MedicineService;
import service.ProducerService;
import utils.Formatter;
import validator.ValidatorUtils;



/**
 * Servlet implementation class AllMedicines
 */
@WebServlet("/AllMedicines")
public class AllMedicines extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllMedicines() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("producers",ProducerService.getAll());
		request.setAttribute("medicines", MedicineService.getAllSortedByTypeAndTitle());
		request.getRequestDispatcher("/medicine/medicines.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Medicine med = new Medicine();
		boolean isError = false;
		long id = 0;
		try {
				id = Long.parseLong(request.getParameter("id"));
				med = MedicineService.getMedicineById(Integer.parseInt(request.getParameter("id")));
				request.setAttribute("id", id);
		} catch (Exception e) {
		}

		String titleErr = "";
		String dateErr = "";
		String termErr = "";
		String priceErr = "";
		String countErr = "";

		String title = request.getParameter("title");
		if (ValidatorUtils.isValidStringByLength(title, 21)){
			med.setTitle(title);		}
		else{
			titleErr = "title format exception!";
			isError = true;
			request.setAttribute("titleErr", titleErr);
		}
		request.setAttribute("title", title);

		String dateOfManufact = request.getParameter("dateOfManufact").isEmpty() ? Formatter.fromDateToString(new GregorianCalendar()) : request.getParameter("dateOfManufact");
		if (ValidatorUtils.isValidDate(dateOfManufact)){
			med.setDateOfManufact(Formatter.toDateFromString(dateOfManufact));
		}else{
			dateErr = "date format exception!";
			isError = true;
			request.setAttribute("dateErr", dateErr);
		}
		request.setAttribute("dateOfManufact", dateOfManufact);
		
		String term = request.getParameter("term");
		if(ValidatorUtils.isValidNumber(term, 60)){
			med.setTerm(Integer.parseInt(term));
		}else{
			termErr = "term format exception!";
			isError = true;
			request.setAttribute("termErr", termErr);
		}
		request.setAttribute("term", term);
		
		String price = request.getParameter("price");  
		if(ValidatorUtils.isValidDouble(price)){
			med.setPrice(Double.parseDouble(price));
		}else{
			priceErr = "price format exception!";
			isError = true;
			request.setAttribute("priceErr", priceErr);
		}
		request.setAttribute("price", price);

		String count = request.getParameter("count");
		if (ValidatorUtils.isValidNumber(count, 1999999999)){
			med.setCount(Integer.parseInt(count));
		}else{
			countErr = "count format exception!";
			isError = true;
			request.setAttribute("countErr", countErr);
		}
		request.setAttribute("count", count);

		String producerTitle = request.getParameter("producerTitle");
		Producer p = ProducerService.getProducerByTitle(producerTitle);
		med.setProducer(p);
		request.setAttribute("selectedTitle", producerTitle);

		String type = request.getParameter("type");
		med.setType(MedicineType.valueOf(type));
		request.setAttribute("selectedType", type);

		if (isError == false) {
			if (id > 0) {
				MedicineService.update(med);
			}else {
				MedicineService.add(med);
			}
			request.setAttribute("medicines", MedicineService.getAll());
			request.getRequestDispatcher("/medicine/medicines.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/medicine/addOrEditMedicine.jsp").forward(request, response);
		}

	}

}
