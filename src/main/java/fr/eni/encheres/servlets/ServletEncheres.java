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

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
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

		request.setCharacterEncoding("UTF-8");

		ArticleEnchereDAO daoArticle = DAOFactory.getArticleEnchereDAO();

		// IN ORDER TO HAVE THE LIST OF CATEGORIES

		List<Categorie> listeCategories = new ArrayList();

		try {
			listeCategories = daoArticle.selectAllCategorie();
			if (listeCategories != null) {
				request.setAttribute("listeCategories", listeCategories);
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

//				ANCIENNE VERSION ----------
		// IN ORDER TO HAVE THE COMPLETE LIST OF ARTICLE BEFORE CATEGORY CHOICE

		try {
			List<ArticleVendu> listeArticles = daoArticle.selectAllArticles();
			if (listeArticles != null) {
				request.setAttribute("listeArticles", listeArticles);
			}

		} catch (BusinessException ex) {
			if (ex instanceof BusinessException) {
				request.setAttribute("listeCodesErreur", ((BusinessException) ex).getListeCodesErreur());
				ex.printStackTrace();
			} else {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}
			List<Integer> listeCodesErreur = new ArrayList<>();
			request.setAttribute("listeCodesErreur", listeCodesErreur);
		}

		// IN ORDER TO HAVE THE DURATION BETWEEN CREATION OF ARTICLE_VENDU
		// TODO

		// IN ORDER TO HAVE THE COMPLETE LIST OF ARTICLE BEFORE CATEGORY CHOICE WITH THE
		// SELLER PSEUDO ====> NON FONCTIONNEL
//
//		ArticleInnerUtilisateurDAO daoArticleInnerUtilisateur = DAOFactory.getArticleInnerDAO();
//		List<ArticleInnerUtilisateur> listeAIU = new ArrayList<ArticleInnerUtilisateur>();
//				
//		listeAIU = daoArticleInnerUtilisateur.selectAllArticleInnerUtilisateur();
//		if (listeAIU != null) {
//			request.setAttribute("listeAIU", listeAIU);
//		}

		// TODO

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
		String typeArticle = request.getParameter("rechercheEnchere");
		String[] checkboxAchat = request.getParameterValues("checkAchat");
		// List listA = Arrays.asList(checkboxAchat);
		String[] checkboxVentes = request.getParameterValues("checkVentes");
		// List listV = Arrays.asList("checkVentes");

		ArticleEnchereDAO daoArticle = DAOFactory.getArticleEnchereDAO();

		// IN ORDER TO HAVE ARTICLES'S LIST FILTERED BY KEY WORD

		try {
			List<ArticleVendu> listeArticles = daoArticle.selectListArticlesByKeyWord(motCle);
			if (listeArticles != null) {
				request.setAttribute("listeArticles", listeArticles);
			}

		} catch (BusinessException ex) {
			if (ex instanceof BusinessException) {
				request.setAttribute("listeCodesErreur", ((BusinessException) ex).getListeCodesErreur());
				ex.printStackTrace();
			} else {
				List<Integer> listeCodesErreur = new ArrayList<>();
				listeCodesErreur.add(CodesResultatServlets.FORMAT_ARTICLE_ERREUR);
				request.setAttribute("listeCodesErreur", listeCodesErreur);
			}
			List<Integer> listeCodesErreur = new ArrayList<>();
			request.setAttribute("listeCodesErreur", listeCodesErreur);
		}

		// IN ORDER TO HAVE ARTICLES'S LIST FILTERED BY DATE

		LocalDate today = LocalDate.now();
		LocalDate date_debut_encheres;
		LocalDate date_fin_encheres;

//		boolean before = today.isBefore(today);	
//		boolean after = today.isAfter(today);
//		boolean both = today.isAfter(today);

		String choice = null;
		
		// CASES FOR checkboxAchat
		boolean allOpen = false;
		boolean myOpen = false;
		boolean myWin = false;

		// CASES FOR checkboxVente
		boolean inProgress = false;
		boolean before = false;
		boolean ended = false;

		// VALUE FOR RADIO BUTTON
		if (typeArticle.equals("achat")) {

			// TODO

			// TO KNOW USER'S DATES SELECTION
			for (int i = 0; i < checkboxAchat.length; i++) {
				
				switch (choice) {
				case "ouvertes":
					allOpen = true;
					break;

				case "enCours":
					myOpen = true;
					break;

				case "remportees":
					myWin = true;
					break;
				default:
					System.out.println("nothing selected");
				}
			}

		} else {

			// TODO

			// TO KNOW USER'S DATES SELECTION
			for (int i = 0; i < checkboxVentes.length; i++) {
				switch (choice) {
				case "enCours":
					inProgress = true;
					break;

				case "noDebutées":
					before = true;
					break;

				case "terminées":
					ended = true;
					break;
				default:
					System.out.println("nothing selected");
				}
			}

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/ListeEncheres.jsp");
			rd.forward(request, response);
		}

	}
}
