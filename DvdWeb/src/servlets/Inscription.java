package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientLocal;
import metier.PanierLocal;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientLocal clientBean;
	@EJB
	private PanierLocal panierBean;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inscription() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupération des paramètres
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String password2 = request.getParameter("password2");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String adresse = request.getParameter("adresse");
		String jourS = request.getParameter("jour");
		String moisS = request.getParameter("mois");
		String anneeS = request.getParameter("annee");
		String sexe = request.getParameter("sexe");
		
		//Vérification des paramètres
		RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.jsp");
		String error = "";
		if (email.isEmpty()) {
			error = "Veuillez saisir votre adresse e-mail";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (email.isEmpty()) {
			error = "Veuillez saisir votre adresse e-mail";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		 if (clientBean.IsClient(email)) {
		 	error = "Cette adresse e-mail est déjà prise";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);
		 }
		if (password.isEmpty()) {
			error = "Veuillez saisir votre mot de passe";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (password2.isEmpty()) {
			error = "Veuillez confirmer votre mot de passe";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (!password2.equals(password)) {
			error = "Les mots de passe saisis ne sont pas identiques";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (nom.isEmpty()) {
			error = "Veuillez rentrer votre nom";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (prenom.isEmpty()) {
			error = "Veuillez rentrer votre prenom";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (adresse.isEmpty()) {
			error = "Veuillez rentrer votre adresse";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (jourS.isEmpty()) {
			error = "Veuillez remplir votre jour de naissance";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		int jour = Integer.parseInt(jourS);
		if (jour < 1 || jour > 31) {
			error = "Votre jour doit être compris entre 1 et 31";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (moisS.isEmpty()) {
			error = "Veuillez remplir votre mois de naissance";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		int mois = Integer.parseInt(moisS);
		if (mois < 1 || mois > 12) {
			error = "Votre mois doit être compris entre 1 et 12";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (anneeS.isEmpty()) {
			error = "Veuillez remplir votre année de naissance";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		int annee = Integer.parseInt(anneeS);
		if (annee < 1900 || annee > Calendar.getInstance().get(Calendar.YEAR)) {
			error = "Votre année de naissance doit être comprise entre 1900 et " + Calendar.getInstance().get(Calendar.YEAR);
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (sexe.isEmpty()) {
			error = "Veuillez indiquer votre sexe";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		
		//Inscription du client
		String date = jourS + "/" + moisS + "/" + anneeS;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		Date d = new Date();
		try {
			d = formatter.parse(date);
			//int panierId = panierBean.addPanier();
			/*clientBean.addClient(email, password, nom, prenom, adresse, d, sexe, panierId);
			*/
		    clientBean.addClient(email, password, nom, prenom, adresse, d, sexe);
		     panierBean.addPanier(email);
			 
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//Redirection vers l'accueil
		response.sendRedirect("accueil.jsp");
		
	}

}
