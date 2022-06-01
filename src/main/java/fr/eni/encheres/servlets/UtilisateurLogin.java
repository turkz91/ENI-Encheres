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
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bll.UtilisateurManager;
import fr.eni.encheres.bo.Utilisateur;

/**
 * Servlet implementation class UtilisateurLogin
 */
@WebServlet("/login")
public class UtilisateurLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String pseudo = request.getParameter("username");
		String motDePasse = request.getParameter("motDePasse");
		//TODO Gérer le parametre souvenir
		System.out.println(request.getParameter("souvenir"));

		UtilisateurManager utilisateurManager = new UtilisateurManager();
		Utilisateur utilisateur = null;
		Boolean errorSaver = true;

		try {
			utilisateur = utilisateurManager.loginUtilisateur(pseudo, motDePasse);
		} catch (Exception ex) {
			if (ex instanceof BusinessException) {
				request.setAttribute("listeCodesErreur", ((BusinessException) ex).getListeCodesErreur());
				ex.printStackTrace();				
			} else {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.LOGIN_UTILISATEUR_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);				
			}
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/user/login.jsp");
			rd.forward(request, response);
			errorSaver = false;
		}		
		if (errorSaver) {
			HttpSession session = request.getSession();
			session.setAttribute("user", utilisateur);
			response.sendRedirect(request.getContextPath() + "/compte");
		}
	}

}
