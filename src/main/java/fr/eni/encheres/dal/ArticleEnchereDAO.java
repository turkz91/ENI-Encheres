/**
 * 
 */
package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain 
 *
 */
public interface ArticleEnchereDAO {

	// ARTICLES
	public void createArticle(ArticleVendu article) throws BusinessException ;
	public ArticleVendu selectArticle(int no_article) throws BusinessException;	
	public List<ArticleVendu> selectAllArticles () throws BusinessException;
	
	// ENCHERES
	public void createEnchere(Enchere enchere) throws BusinessException;
	public Enchere selectEnchere(ArticleVendu article) throws BusinessException;
	public List<Integer> selectAllMontantsEncheres (ArticleVendu article) throws BusinessException;
	public List<Enchere> selectAllEncheres() throws BusinessException;
	public void updateEnchere(Enchere enchere) throws BusinessException;
	// CATEGORIES
	public Categorie createCategorie(Categorie categorie) throws BusinessException;

	// TO DO SelectCategorie
	
}
