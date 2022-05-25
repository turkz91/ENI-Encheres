/**
 * 
 */
package fr.eni.encheres.dal;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
public abstract class DAOFactory {
	public static ArticleEnchereDAO getArticleEnchereDAO() {
		return new ArticleEnchereDAOJdbcImpl();		
	}
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOJdbcImpl();
	}
}
