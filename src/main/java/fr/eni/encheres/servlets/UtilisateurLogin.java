package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurLogin
 */
@WebServlet("/UtilisateurLogin")
public class UtilisateurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
request.setCharacterEncoding("UTF-8");
		
		String pseudo = request.getParameter("username");
		String motDePasse = request.getParameter("motDePasse");
		System.out.println(request.getParameter("souvenir"));
		
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		
		try {
			utilisateur = utilisateurManager.loginUtilisateur(pseudo, motDePasse);
		} catch (BusinessException ex) {
			request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
			ex.printStackTrace();
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
			rd.forward(request, response);
		} catch (Exception ex) {
			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_UTILISATEUR_ERREUR);
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("user", utilisateur);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/compte.jsp");
		rd.forward(request, response);
	}

}
