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
 * Servlet implementation class UtilisateurCompte
 */
@WebServlet("/compte")
public class UtilisateurCompte extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/compte.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no_utilisateur = request.getParameter("no_utilisateur");
		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		try {
			utilisateur = utilisateurManager.findUserbyID(no_utilisateur);
			request.setAttribute("user", utilisateur);
		} catch (BusinessException ex) {
			if (ex instanceof BusinessException) {
				request.setAttribute("listeCodesErreur", ((BusinessException) ex).getListeCodesErreur());
				ex.printStackTrace();				
			} else {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.LOGIN_UTILISATEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);	
			}
		}
		
		doGet(request, response);
	}

}
