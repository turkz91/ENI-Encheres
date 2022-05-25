/**
 * 
 */
package fr.eni.encheres.dal;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain 
 *
 */
public interface ArticleEnchereDAO {

	public void createArticle(ArticleVendu article) throws BusinessException ;
	public void createEnchere();
	public Categorie createCategorie(Categorie categorie) throws BusinessException;
}
