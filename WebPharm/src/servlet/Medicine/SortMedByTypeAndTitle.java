package servlet.Medicine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Medicine;
import service.MedicineService;

/**
 * Servlet implementation class SortByTypeAndTytle
 */
@WebServlet("/SortMedByTypeAndTitle")
public class SortMedByTypeAndTitle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SortMedByTypeAndTitle() {
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
		System.out.println("33333333333333333333333333333333333");
		System.out.println(request.getParameter("type") + " " + request.getParameter("title"));
		
		List<Medicine> meds = new ArrayList<>();
		
		String type = request.getParameter("type");
		request.setAttribute("selectType", type);
		
		String title = request.getParameter("title");
		request.setAttribute("selectTitle", title);
		
		if ( type.equals("AllTypes") && title.equals("AllTitles")){
			meds = MedicineService.getAll();
		} 
		if (type.equals("AllTypes") && !(title.equals("AllTitles")) ){
			meds = MedicineService.getMedicinesByTitle(request.getParameter("title"));
		} 
		if (title.equals("AllTitles") && !(type.equals("AllTypes")) ){
			meds = MedicineService.getMedicinesByType(request.getParameter("type"));
		} 
		
		if (!(title.equals("AllTitles")) && !(type.equals("AllTypes"))){
			meds = MedicineService.getMedicinesByTypeAndTitle(request.getParameter("type"), request.getParameter("title"));
		}
		if (meds.size()==0){
			request.getRequestDispatcher("/parts/message.jsp").forward(request, response); 
		}
		
		
		request.setAttribute("medicines", meds);
		request.getRequestDispatcher("/medicine/medicines.jsp").forward(request, response); 
	
	}

}
