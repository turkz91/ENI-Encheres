/**
 * 
 */
package fr.eni.encheres.dal;

/**
 * @author ephra
 *
 */
public abstract class DAOFactory {
	public static ArticleEnchereDAO getArticleEnchereDAO() {
		return new ArticleEnchereDAOJdbcImpl();		
	}
}
