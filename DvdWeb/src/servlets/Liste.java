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

import metier.AuteurRemote;
import metier.DvdRemote;
import metier.RealisateurRemote;
import metier.entities.Auteur;
import metier.entities.Dvd;
import metier.entities.Realisateur;

/**
 * Servlet implementation class Liste
 */
@WebServlet("/Liste")
public class Liste extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private DvdRemote dvdBean;
	@EJB
	private AuteurRemote auteurBean;
	@EJB
	private RealisateurRemote realisateurBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Liste() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String choix = request.getParameter("name");
		RequestDispatcher dispatcher;
		if (choix.equals("dvd")) {
			List <Dvd> liste = dvdBean.listDvd();
			dispatcher = request.getRequestDispatcher("dvd.jsp");
			request.setAttribute("liste", liste); 
			if (liste != null) {
				if (!liste.isEmpty()) {
					request.setAttribute("titre", liste.get(0).getTitre());
				}
			}
		}
		else if (choix.equals("auteur")) {
			List <Auteur> liste = auteurBean.listAuteur();
			dispatcher = request.getRequestDispatcher("auteur.jsp");
			request.setAttribute("liste", liste);
			if (liste != null) {
				if (!liste.isEmpty()) {
					request.setAttribute("nom", liste.get(0).getNom());
					request.setAttribute("prenom", liste.get(0).getPrenom());
				}
			}
		}
		else if (choix.equals("realisateur")) {
			List <Realisateur> liste = realisateurBean.listRealisateur();
			dispatcher = request.getRequestDispatcher("realisateur.jsp");
			request.setAttribute("liste", liste);
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
