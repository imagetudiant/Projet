package servlets;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.DvdLocal;
import metier.entities.Dvd;

/**
 * Servlet implementation class SearchDvd
 */
@WebServlet("/SearchDvd")
public class SearchDvd extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DvdLocal dvdBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDvd() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titre = request.getParameter("titre");
		RequestDispatcher dispatcher;
		List <Dvd> d = dvdBean.searchDvd(titre);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
