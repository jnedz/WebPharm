package servlet.Person;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.PersonsInfo;
import service.PersonsInfoService;

/**
 * Servlet implementation class DeletePersonYes
 */
@WebServlet("/DeletePersonYes")
public class DeletePersonYes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePersonYes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PersonsInfo p = PersonsInfoService.getPersonsInfoById(Integer.parseInt(request.getParameter("id")));
		PersonsInfoService.delete(p);
		request.setAttribute("persons", PersonsInfoService.getAll());
		request.getRequestDispatcher("/person/persons.jsp").forward(request, response); 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
