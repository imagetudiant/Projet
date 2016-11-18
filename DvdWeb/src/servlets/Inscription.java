package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientLocal;

/**
 * Servlet implementation class Inscription
 */
@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientLocal clientBean;
       
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
		String jour = request.getParameter("jour");
		String mois = request.getParameter("mois");
		String annee = request.getParameter("annee");
		String sexe = request.getParameter("sexe");
		
		//Vérification des paramètres
		RequestDispatcher dispatcher = request.getRequestDispatcher("erreur.jsp");
		String error = "";
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
		if (jour.isEmpty()) {
			error = "Veuillez remplir votre jour de naissance";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (mois.isEmpty()) {
			error = "Veuillez remplir votre mois de naissance";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (annee.isEmpty()) {
			error = "Veuillez remplir votre année de naissance";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		if (sexe.isEmpty()) {
			error = "Veuillez indiquer votre sexe";
			request.setAttribute("error", error);
			dispatcher.forward(request, response);		
		}
		
		//Inscription du client
		String date = jour + "/" + mois + "/" + annee;
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date d = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Redirection vers l'accueil
		response.sendRedirect("accueil.jsp");
		
	}

}
