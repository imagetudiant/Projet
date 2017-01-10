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

import metier.RealisateurLocal;
import metier.entities.Realisateur;

/**
 * Servlet implementation class RealisateurServlet
 */
@WebServlet("/Realisateur")
public class RealisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RealisateurLocal realisateurBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RealisateurServlet() {
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
			String nom = request.getParameter("nom");
			List <Realisateur> liste = realisateurBean.searchRealisateur(nom);
			dispatcher = request.getRequestDispatcher("realisateur.jsp");
			if (liste != null) {
				if (!liste.isEmpty()) {
					request.setAttribute("nom", liste.get(0).getNom());
				}
			}
		}
		else if (choix.equals("list")) {
			List <Realisateur> liste = realisateurBean.listRealisateur();
			dispatcher = request.getRequestDispatcher("realisateur.jsp");
			if (liste != null) {
				if (!liste.isEmpty()) {
					request.setAttribute("liste", liste); 
				}
			}
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
