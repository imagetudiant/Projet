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
@WebServlet("/Dvd")
public class DvdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DvdLocal dvdBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DvdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		String choix = request.getParameter("action");
		if (choix.equals("search")) {
			String titre = request.getParameter("titre");
			List <Dvd> liste = dvdBean.searchDvd(titre);
			dispatcher = request.getRequestDispatcher("dvd.jsp");
			request.setAttribute("liste", liste);
		}
		else if (choix.equals("list")) {
			List <Dvd> liste = dvdBean.listDvd();
			dispatcher = request.getRequestDispatcher("dvd.jsp");			
			request.setAttribute("liste", liste); 
		}
		else {
			return;
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
