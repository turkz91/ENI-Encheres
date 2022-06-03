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
import javax.servlet.http.HttpSession;

import fr.eni.encheres.bll.ArticleEnchereManager;
import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Utilisateur;

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
		ArticleEnchereManager articleManager = new ArticleEnchereManager();		
		List<Categorie> listeCategories = new ArrayList<>();
		Map<ArticleVendu,String[]> listeArticles = new HashMap<>();
		
		try {
			listeCategories = articleManager.selectAllCategorie();
			if (listeCategories != null) {
				request.setAttribute("listeCategories", listeCategories);
			}
			listeArticles = articleManager.getListeArticle();			
			if (listeArticles != null) {
				request.setAttribute("listeArticles", listeArticles);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article/listeArticles.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");		
		ArticleEnchereManager articleManager = new ArticleEnchereManager();		
		List<Categorie> listeCategories = new ArrayList<>();
		Map<ArticleVendu,String[]> listeArticles = new HashMap<>();
		String categorieCheck = request.getParameter("categorie");
		
		try {
			listeCategories = articleManager.selectAllCategorie();
			if (listeCategories != null) {
				request.setAttribute("listeCategories", listeCategories);
			}
			if (!categorieCheck.equalsIgnoreCase("toutes")) {
//				listeArticles = articleManager.getFilteredListeArticle(2);
				int categorie_id = Integer.valueOf(categorieCheck);
				listeArticles = articleManager.getFilteredListeArticle(categorie_id);
				request.setAttribute("selectedCategorie", categorie_id);
			}
			else {
				listeArticles = articleManager.getListeArticle();
			}
			if (listeArticles != null) {
				request.setAttribute("listeArticles", listeArticles);
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/article/listeArticles.jsp");
		rd.forward(request, response);
	}

}
