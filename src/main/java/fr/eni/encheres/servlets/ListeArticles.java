package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleInnerUtilisateur;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.dal.ArticleEnchereDAO;
import fr.eni.encheres.dal.ArticleInnerUtilisateurDAO;
import fr.eni.encheres.dal.DAOFactory;

/**
 * Servlet implementation class ArticlesListe
 */
@WebServlet("")
public class ListeArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");

		ArticleEnchereDAO daoArticle = DAOFactory.getArticleEnchereDAO();

		// IN ORDER TO HAVE THE LIST OF CATEGORIES

		List<Categorie> listeCategories = new ArrayList<>();
		Map<ArticleVendu,String[]> listeArticles = new HashMap<>();
		
		try {
			listeCategories = daoArticle.selectAllCategorie();
			if (listeCategories != null) {
				request.setAttribute("listeCategories", listeCategories);
			}
			listeArticles = daoArticle.selectAllArticlesUser();
			if (listeArticles != null) {
				request.setAttribute("listeArticles", listeArticles);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
//		if ( != null) {
//			request.setAttribute("", );
//		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article/listeArticles.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
