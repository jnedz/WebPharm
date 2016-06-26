package servlet.Person;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import model.Person;
import dao.PersonDAO;
import enums.PersonRole;




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
		Person p = PersonDAO.getPersonById(Long.parseLong(request.getParameter("id")));
		request.setAttribute("person", p);
		request.getRequestDispatcher("/person/deletePerson.jsp").forward(request, response); 
		
		
        }



protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

/*	Person p = PersonDAO.getPersonById(Long.parseLong(request.getParameter("id")));
	PersonDAO.delete(p);
	request.setAttribute("persons", PersonDAO.getAll());
	request.getRequestDispatcher("/person/persons.jsp").forward(request, response); 
*/ doGet(request, response);	
	}
	
}
