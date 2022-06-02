package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleInnerUtilisateur;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleInnerUtilisateurJdbcImpl implements ArticleInnerUtilisateurDAO{

	private final String SELECT_ARTICLE_INNER_UTILISATEUR = "SELECT " + "a.no_article," + "a.nom_article,"
			+ "a.description," + "a.date_debut_encheres," + "a.date_fin_encheres," + "a.prix_initial," + "a.prix_vente,"
			+ "a.no_utilisateur," + "a.no_categorie," + "u.pseudo," + "u.nom," + "u.prenom," + "u.email,"
			+ "u.telephone," + "u.rue," + "u.code_postal," + "u.ville," + "u.credit," + "u.administrateur,"
			+ " a.no_categorie"
			+ "	FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u  ON a.no_utilisateur = u.no_utilisateur"
			+ " WHERE a.no_utilisateur = ? AND no_utilisateur = ?";
	
	@Override
	public ArticleInnerUtilisateur selectArticleInnerUtilisateur(int no_utilisateur) {
		ArticleVendu article = null;
		Utilisateur utilisateur = null;
		ArticleInnerUtilisateur articleInnerUtilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_ARTICLE_INNER_UTILISATEUR);
			pstmtArticle.setInt(1, no_utilisateur);
			pstmtArticle.setInt(2, no_utilisateur);
			ResultSet rs = pstmtArticle.executeQuery();
			if (rs.next()) {
				article = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_enchere"), rs.getDate("date_fin_enchere"), rs.getInt("prix_initial"),
						rs.getInt("prix_initial"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"),
						rs.getString("nom"), rs.getString("prenom"), rs.getString("email"),
						rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
			}
			pstmtArticle.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLE_SQL);
		}
		
		articleInnerUtilisateur = new ArticleInnerUtilisateur(article, utilisateur);
		
		return articleInnerUtilisateur;
	}

}
