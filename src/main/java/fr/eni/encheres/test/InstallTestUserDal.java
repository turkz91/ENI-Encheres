package fr.eni.encheres.test;

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
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.CodesResultatDAL;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

/**
 * Servlet implementation class InstallTestUserDal
 */
@WebServlet("/install/2/TestUser")
public class InstallTestUserDal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			UtilisateurDAO daoUser = DAOFactory.getUtilisateurDAO();
			Utilisateur userTest1 = new Utilisateur("testJohn", "Smith", "John", "john@smith.com", "25 Rue des Gens", "08000", "Ayvelles", "testPass", 2500, false);
			Utilisateur userTest2 = new Utilisateur("testJane", "Doe", "Jane", "jane@doe.com", "30 Rue de la Populace", "08000", "Mouron", "testPass1", 5000, true);
			List<Utilisateur> listUser = new ArrayList<>();
			Utilisateur[] usersTest = {userTest1, userTest2};
			for (Utilisateur user : usersTest) {
				user = daoUser.createUser(user);
				listUser.add(user);
			}
			if (listUser.size() == 0) {
				BusinessException businessException = new BusinessException();
				businessException.ajouterErreur(CodesResultatDAL.CREATE_USER_SQL);
				throw businessException;
			}
			request.setAttribute("userList", listUser);
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			request.setAttribute("error", e.getListeCodesErreur());
			e.printStackTrace();
		} catch (Exception e) {
			List<Integer> listeCodesErreur = new ArrayList<>();
			listeCodesErreur.add(CodesResultatDAL.CREATE_USER_SQL);
			request.setAttribute("listeCodesErreur", listeCodesErreur);
			e.printStackTrace();
		}
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/install/userTest.jsp");
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
