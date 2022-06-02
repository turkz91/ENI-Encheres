package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurLogOff
 */
@WebServlet("/logoff")
public class UtilisateurLogOff extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.invalidate();
		response.sendRedirect(request.getContextPath());		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int no_utilisateur = ((Utilisateur) session.getAttribute("user")).getNo_utilisateur();
		UtilisateurManager utilisateurManager = new UtilisateurManager();
				
		try {
			utilisateurManager.deleteUtilisateur(no_utilisateur);
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
