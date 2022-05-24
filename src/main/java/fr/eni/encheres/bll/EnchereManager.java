package fr.eni.encheres.bll;

import fr.eni.encheres.dal.ArticleEnchereDAO;
import fr.eni.encheres.dal.DAOFactory;

public class EnchereManager {
	private ArticleEnchereDAO articleEnchereDAO;

	public EnchereManager(ArticleEnchereDAO articleEnchereDAO) {
		this.articleEnchereDAO = DAOFactory.getArticleEnchereDAO();
	}
	

	
}
