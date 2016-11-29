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
 * Servlet implementation class Deconnexion
 */
@WebServlet("/Deconnexion")
public class Deconnexion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CLIENT_BEAN_SESSION_KEY = "client";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Deconnexion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ClientLocal clientBean = (ClientLocal) request.getSession().getAttribute(CLIENT_BEAN_SESSION_KEY);
		RequestDispatcher dispatcher;
		if (clientBean != null) {
			clientBean.logout();
			request.getSession().setAttribute("connected", false);
		    dispatcher = request.getRequestDispatcher("index.jsp");
		    dispatcher.forward(request, response);
		}
		else {
			String error = "Erreur lors de la déconnexion";
			request.setAttribute("error", error);
			dispatcher = request.getRequestDispatcher("erreur.jsp");
			dispatcher.forward(request, response);	
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
