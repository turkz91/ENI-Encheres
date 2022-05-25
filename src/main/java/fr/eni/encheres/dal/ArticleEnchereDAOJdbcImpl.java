/**
 * 
 */
package fr.eni.encheres.dal;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.encheres.bll.BusinessException;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
class ArticleEnchereDAOJdbcImpl implements ArticleEnchereDAO {
	
	private final String CREATE_ARTICLE = "INSERT INTO ARTICLE_VENDUS "
			+ "(nom_article, description, date_debut_encheres, date_fin_encheres, no_utilisateur, no_categorie)"
			+ "VALUES (?,?,?,?,?,?)";
	private final String CREATE_CATEGORIE = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	
	@Override
	public void createArticle(ArticleVendu article) throws BusinessException {
		if (article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_ARTICLE_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(CREATE_ARTICLE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtArticle.setString(1,article.getNom_article());
			pstmtArticle.setString(2,article.getDescription());
			pstmtArticle.setDate(3,Date.valueOf(article.getDate_debut_encheres()));
			pstmtArticle.setDate(4,Date.valueOf(article.getDate_fin_encheres()));
			pstmtArticle.setInt(5,article.getNo_utilisateur());
			pstmtArticle.setInt(6,article.getNo_categorie());
			pstmtArticle.executeUpdate();
			ResultSet rsArticle = pstmtArticle.getGeneratedKeys();
			if (rsArticle.next()) {
				article.setNo_article(rsArticle.getInt(1));
			}
			rsArticle.close();
			pstmtArticle.close();			
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_ARTICLE_SQL);
			throw businessException;
		}
		
	}

	@Override
	public void createEnchere() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categorie createCategorie(Categorie categorie) throws BusinessException {
		if (categorie == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_CATEGORIE_NULL);
			throw businessException;			
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtCategorie = cnx.prepareStatement(CREATE_CATEGORIE, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtCategorie.setString(1, categorie.getLibelle());
			pstmtCategorie.executeUpdate();
			ResultSet rsCategorie = pstmtCategorie.getGeneratedKeys();
			if (rsCategorie.next()) {
				categorie.setNo_categorie(rsCategorie.getInt(1));
			}
			rsCategorie.close();
			pstmtCategorie.close();	
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_CATEGORIE_SQL);
			throw businessException;
		}
		return categorie;
	}

}
