package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ArticleEnchereDAO;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ServletEncheres
 */
@WebServlet("/Encheres")
public class ServletEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// TODO Implémentation de la liste des catégories dans la jsp + TESTS FONCTIONNELS
//		request.setCharacterEncoding("UTF-8");
//
//		List<Categorie> listeCategorie = new ArrayList();
//		ArticleEnchereDAO daoArticle = DAOFactory.getArticleEnchereDAO();
//
//		try {
//			listeCategorie = daoArticle.selectAllCategorie();
//		} catch (BusinessException ex) {
//			if (ex instanceof BusinessException) {
//				request.setAttribute("listeCodesErreur", ((BusinessException) ex).getListeCodesErreur());
//				ex.printStackTrace();
//				ex.printStackTrace();
//			} else {
//				List<Integer> listeCodesErreur = new ArrayList<>();
//				listeCodesErreur.add(CodesResultatServlets.FORMAT_CATEGORIE_ERREUR);
//				request.setAttribute("listeCodesErreur", listeCodesErreur);
//			}
//			List<Integer> listeCodesErreur = new ArrayList<>();
//			request.setAttribute("listeCodesErreur", listeCodesErreur);
//		}

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/ListeEncheres.jsp");
		rd.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		request.setCharacterEncoding("UTF-8");
		String motCle = request.getParameter("recherche");
		String categorie = request.getParameter("selectCategorie");
		String[] checkboxAchat = request.getParameterValues("checkAchat");
		List listA = Arrays.asList(checkboxAchat);
		String[] checkboxVentes = request.getParameterValues("checkVentes");
		List listV = Arrays.asList("checkVentes");

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/ListeEncheres.jsp");
		rd.forward(request, response);
	}

}
