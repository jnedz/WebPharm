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
 * Servlet implementation class MainServlet
 */
@WebServlet("/DeletePerson")
public class DeletePerson extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeletePerson() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		System.out.println("Person_id = " + request.getParameter("id"));
		PersonsInfo p = PersonsInfoService.getPersonsInfoById(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("person", p);
		request.getRequestDispatcher("/person/deletePerson.jsp").forward(request, response); 
		
		
        }



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*	Person p = PersonService.getPersonById(Long.parseLong(request.getParameter("id")));
	PersonService.delete(p);
	request.setAttribute("persons", PersonService.getAll());
	request.getRequestDispatcher("/person/persons.jsp").forward(request, response); 
*/ doGet(request, response);	
	}
	
}
