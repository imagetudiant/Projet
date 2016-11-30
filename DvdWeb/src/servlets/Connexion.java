package servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import metier.ClientLocal;
import metier.PanierLocal;

/**
 * Servlet implementation class Connexion
 */
@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClientLocal clientBean;
	
	HttpSession session;
	@EJB
	private PanierLocal panierBean;
	private static final String CLIENT_BEAN_SESSION_KEY = "client";
	private static final String PANIER_BEAN_SESSION_KEY = "panier";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Connexion() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		session = request.getSession();
		if (email.isEmpty()) {
			response.sendRedirect("connexion.jsp");
		}
		if (password.isEmpty()) {
			response.sendRedirect("connexion.jsp");
		}
		boolean auth = clientBean.IsPassword(password, email);
		if (auth) {			
			clientBean.login(email);
			panierBean.login(email);
		    request.getSession().setAttribute(CLIENT_BEAN_SESSION_KEY, clientBean);
		    session.setAttribute("panier",panierBean);
		    request.getSession().setAttribute("connected", true);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("accueil.jsp");
		    dispatcher.forward(request, response);
		}
		else {
			response.sendRedirect("connexion.jsp");
		}
	}
}
