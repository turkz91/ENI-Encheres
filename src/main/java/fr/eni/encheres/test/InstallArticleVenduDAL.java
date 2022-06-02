package fr.eni.encheres.test;

import java.io.IOException;
import java.sql.Date;
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
import fr.eni.encheres.servlets.CodesResultatServlets;

/**
 * Servlet implementation class InstallArticleVenduDAL
 */
@WebServlet("/Article")
public class InstallArticleVenduDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/install/articleTest.jsp");
	rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		
		// Récupération des paramètres depuis la JSP 
		
		// infos article
		String nom_article = request.getParameter("nom");
		String description = request.getParameter("description");
		LocalDate date_debut_encheres = LocalDate.parse(request.getParameter("debut_enchere"));
		LocalDate date_fin_encheres = LocalDate.parse(request.getParameter("fin_enchere"));
		
		// TEST POUR LE FORMAT DE DATE
		
		System.out.println("La date récupérée" + date_fin_encheres);
		System.out.println(date_fin_encheres.getClass().getSimpleName());
		System.out.println("----------------------");
		
		Date date = Date.valueOf(date_fin_encheres);
		System.out.println("La date avec Date.valueOf() " + date);
		System.out.println(date.getClass().getSimpleName());
		System.out.println("----------------------");
		
		// FIN DE  TEST
		
		int prix_initial = Integer.valueOf(request.getParameter("prix_initial"));
		 //no_utilisateur dans infos utilisateur
		int no_categorie = Integer.valueOf(request.getParameter("categorie"));
		
		// infos utilisateur
		
		// TO DO 
		// => Récupérer l'identifiant de l'utilisateur
		//int no_utilisateur = Integer.valueOf(request.getParameter("no_utilisateur"));
		// POUR LE TEST :
		int no_utilisateur = 2;
		
		String rue = request.getParameter("rue");
		String codePostal = request.getParameter("code_postal");
		String ville = request.getParameter("ville");
		
		ArticleEnchereManager articleManager = new ArticleEnchereManager();
		ArticleVendu article = null;
		
		try {
			article = articleManager.ajouterArticle(
					nom_article,
					description,
					date_debut_encheres,
					date_fin_encheres,
					prix_initial,
					no_utilisateur,
					no_categorie);
		} catch (BusinessException ex) {
			request.setAttribute("listeCodesErreur", ex.getListeCodesErreur());
			ex.printStackTrace();
		} catch (Exception ex) {
			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_ERREUR);
			request.setAttribute("listeCodesErreur", listeCodesErreur);
		}
		
//		// PARTIE TEST
//		
//		// infos article
//		request.setAttribute("nom", nom_article);
//		request.setAttribute("description", description);
//		request.setAttribute("debut_enchere", date_debut_encheres);
//		request.setAttribute("fin_enchere", date_fin_encheres);
//		request.setAttribute("prix", prix_initial);
//		
//		request.setAttribute("categorie", no_categorie);
//		
//		// infos utilisateur
//		request.setAttribute("utilisateur", no_utilisateur);
//		request.setAttribute("rue", rue);
//		request.setAttribute("code_postal", codePostal);
//		request.setAttribute("ville", ville);
//		
//		// FIN PARTIE TEST
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/install/articleTest.jsp");
		rd.forward(request, response);
	}

}
