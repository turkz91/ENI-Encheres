package fr.eni.encheres.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bll.ArticleEnchereManager;
import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Retrait;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.ArticleEnchereDAO;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class ServletDetailVente
 */
@WebServlet("/ServletDetailVente")
public class ServletDetailVente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		ArticleEnchereDAO daoArticle = DAOFactory.getArticleEnchereDAO();
		UtilisateurDAO daoUtilisateur = DAOFactory.getUtilisateurDAO();

		List<ArticleVendu> articles = new ArrayList<ArticleVendu>();
	
		ArticleVendu article= null;
		
		try {
			Enchere enchere=(Enchere) daoArticle.selectEnchere(article);
			Integer noArticle= enchere.getNo_article();	
			Integer noUtilisateur= enchere.getNo_utilisateur();
			
			article = daoArticle.selectArticle(noArticle);
			String nomArticle= article.getNom_article();
			String description= article.getDescription();
			Integer prixInit= article.getPrix_initial();
			LocalDate finEnchere = article.getDate_fin_encheres();
			LocalDate DebEnchere = article.getDate_debut_encheres();
			int category = article.getNo_categorie();
			//String rue = rue.getRue();
			//String ville = ville.getVille();
			//String cap = cap.getCode_postal();
		
			Utilisateur utilisateur = daoUtilisateur.selectUserById(noUtilisateur)	;	
			
			
		
			ArticleVendu a= new ArticleVendu(nomArticle, description, DebEnchere, finEnchere, prixInit, noUtilisateur, category );
			request.setAttribute("article", a);
			{
				
			}
		} catch (BusinessException ex) {
			if (ex instanceof BusinessException) {
				request.setAttribute("listeCodesErreur", ((BusinessException) ex).getListeCodesErreur());
				ex.printStackTrace();
			} else {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_CATEGORIE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}
			List<Integer> listeCodesErreur = new ArrayList<>();
			request.setAttribute("listeCodesErreur", listeCodesErreur);
		}
	
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/DetailVente.jsp");
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
