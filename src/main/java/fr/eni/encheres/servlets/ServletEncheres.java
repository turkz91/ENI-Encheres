package fr.eni.encheres.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEncheres
 */
@WebServlet("/Encheres")
public class ServletEncheres extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/encheres/ListeEncheres.jsp");
		rd.forward(request, response);	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);request.setCharacterEncoding("UTF-8");
		String motCle = request.getParameter("recherche");
		String categorie = request.getParameter("selectCategorie");
		String[] checkboxAchat = request.getParameterValues("checkAchat");
		List listA= Arrays.asList(checkboxAchat);
		String[] checkboxVentes = request.getParameterValues("checkVentes");
		List listV= Arrays.asList("checkVentes");
	}

}
