package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import metier.ClientLocal;

/**
 * Servlet implementation class Profil
 */
@WebServlet("/Profil")
public class Profil extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String CLIENT_BEAN_SESSION_KEY = "client";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Récupérer l'EJB à partir de la session
		ClientLocal clientBean = (ClientLocal) request.getSession().getAttribute(CLIENT_BEAN_SESSION_KEY);
		
		RequestDispatcher dispatcher;
		String choix = request.getParameter("action");
		if (choix.equals("get")) {
			String nom = clientBean.getNom();
			String prenom = clientBean.getPrenom();
			String email = clientBean.getEmail();
			String adresse = clientBean.getAdresse();
			String date = clientBean.getDateDeNaissance().toString();
			request.setAttribute("nom", nom);
			request.setAttribute("prenom", prenom);
			request.setAttribute("email", email);
			request.setAttribute("adresse", adresse);
			request.setAttribute("date", date);
			dispatcher = request.getRequestDispatcher("profil.jsp");
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
