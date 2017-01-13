package servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientLocal;
import metier.DvdLocal;
import metier.PanierLocal;
import metier.entities.Dvd;

/**
 * Servlet implementation class Panier
 */
@WebServlet("/Panier")
public class Panier extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLIENT_BEAN_SESSION_KEY = "client";
	private static final String PANIER_BEAN_SESSION_KEY = "panier";
	
	@EJB
	private DvdLocal dvdBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Panier() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Object obj = request.getSession().getAttribute("connected");
		ArrayList <Dvd> listDvd;
		RequestDispatcher dispatcher = request.getRequestDispatcher("panier.jsp");
		if (obj != null) {
			boolean connected = (boolean) obj;
			if (connected == true) {
				ClientLocal clientBean = (ClientLocal) request.getSession().getAttribute(CLIENT_BEAN_SESSION_KEY);
				PanierLocal panierBean = (PanierLocal) request.getSession().getAttribute(PANIER_BEAN_SESSION_KEY);
				listDvd = (ArrayList<Dvd>) panierBean.Consulter_Panier();				
			}
			else {
				listDvd = new ArrayList <Dvd> ();
			}
			request.setAttribute("dvds",listDvd);
			dispatcher.forward(request, response);
		}
		else {
			listDvd = new ArrayList <Dvd> ();
			request.setAttribute("dvds",listDvd);
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String choix = request.getParameter("action");
		RequestDispatcher dispatcher;
		if(choix.equals("add")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Dvd d = dvdBean.getDvd(id);
			PanierLocal panierBean = (PanierLocal) request.getSession().getAttribute(PANIER_BEAN_SESSION_KEY);
			metier.entities.Panier p = panierBean.getPanier();
			panierBean.Ajout_Dvd(p, d);
			doGet(request,response);
		}
		else if (choix.equals("remove")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Dvd d = dvdBean.getDvd(id);
			PanierLocal panierBean = (PanierLocal) request.getSession().getAttribute(PANIER_BEAN_SESSION_KEY);
			metier.entities.Panier p = panierBean.getPanier();
			panierBean.supprimerDvd(p,d);
			doGet(request,response);
		}
		else if (choix.equals("validate")) {
			PanierLocal panierBean = (PanierLocal) request.getSession().getAttribute(PANIER_BEAN_SESSION_KEY);
			//panierBean.valider();
			dispatcher = request.getRequestDispatcher("accueil.jsp");
			dispatcher.forward(request, response);
		}
	}

}
