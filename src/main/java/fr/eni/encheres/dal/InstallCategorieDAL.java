package fr.eni.encheres.dal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bll.BusinessException;

/**
 * Servlet implementation class TestDAL
 * 
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
@WebServlet("/setup/1/InstallCategorie")
public class InstallCategorieDAL extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			ArticleEnchereDAO daoArticle = DAOFactory.getArticleEnchereDAO();
			String[] categories = { "Ameublement", "Informatique", "Sport&Loisirs", "Vêtement" };
			List<Categorie> listCategories = new ArrayList<>();
			for (String categorieString : categories) {
				Categorie categorie = new Categorie(categorieString);
				categorie = daoArticle.createCategorie(categorie);
				listCategories.add(categorie);
			}
			if (listCategories.size() == 0) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.INSTALL_CATEGORIES_INIT);
				throw businessException;
			}
			request.setAttribute("categorie", listCategories);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getListeCodesErreur());
			e.printStackTrace();
		} catch (Exception e) {
			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatDAL.INSTALL_CATEGORIES_INIT);
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/install/categorieInit.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
