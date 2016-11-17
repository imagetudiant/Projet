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

import metier.AuteurLocal;
import metier.entities.Auteur;

/**
 * Servlet implementation class AuteurServlet
 */
@WebServlet("/Auteur")
public class AuteurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private AuteurLocal auteurBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuteurServlet() {
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
			List <Auteur> liste = auteurBean.searchAuteur(nom);
			dispatcher = request.getRequestDispatcher("auteur.jsp");
			if (liste != null) {
				if (!liste.isEmpty()) {
					request.setAttribute("nom", liste.get(0).getNom());
				}
			}
		}
		else if (choix.equals("list")) {
			List <Auteur> liste = auteurBean.listAuteur();
			dispatcher = request.getRequestDispatcher("auteur.jsp");
			//request.setAttribute("liste", liste); 
			if (liste != null) {
				if (!liste.isEmpty()) {
					request.setAttribute("nom", liste.get(0).getNom());
					request.setAttribute("prenom", liste.get(0).getPrenom());
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
