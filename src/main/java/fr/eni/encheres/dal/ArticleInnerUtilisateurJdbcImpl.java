package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleInnerUtilisateur;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Utilisateur;

public class ArticleInnerUtilisateurJdbcImpl implements ArticleInnerUtilisateurDAO {

	private final String SELECT_ARTICLE_INNER_UTILISATEUR = "SELECT " + "a.no_article as no_article,"
			+ "a.nom_article as nom_article," + "a.description as description,"
			+ "a.date_debut_encheres as date_debut_encheres," + "a.date_fin_encheres as date_fin_encheres,"
			+ "a.prix_initial as prix_initial," + "a.prix_vente as prix_vente," + "a.no_utilisateur as no_utilisateur,"
			+ "a.no_categorie as no_categorie," + "u.pseudo as pseudo," + "u.nom as nom," + "u.prenom as prenom,"
			+ "u.email as email," + "u.telephone as telephone," + "u.rue as rue," + "u.code_postal as code_postal,"
			+ "u.ville as ville," + "u.mot_de_passe as mot_de_passe" + "u.credit as credit,"
			+ "u.administrateur as administrateur," + " a.no_categorie as no_categorie"
			+ "	FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u  ON a.no_utilisateur = u.no_utilisateur"
			+ " WHERE a.no_utilisateur = ? AND no_utilisateur = ?";

	private final String SELECT_ALL_ARTICLE_INNER_UTILISATEUR = "SELECT " + "a.no_article as no_article,"
			+ "a.nom_article as nom_article," + "a.description as description,"
			+ "a.date_debut_encheres as date_debut_encheres," + "a.date_fin_encheres as date_fin_encheres,"
			+ "a.prix_initial as prix_initial," + "a.prix_vente as prix_vente," + "a.no_utilisateur as no_utilisateur,"
			+ "a.no_categorie as no_categorie," + "u.pseudo as pseudo," + "u.nom as nom," + "u.prenom as prenom,"
			+ "u.email as email," + "u.telephone as telephone," + "u.rue as rue," + "u.code_postal as code_postal,"
			+ "u.ville as ville," + "u.mot_de_passe as mot_de_passe" + "u.credit as credit,"
			+ "u.administrateur as administrateur," + " a.no_categorie as no_categorie"
			+ "	FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u  ON a.no_utilisateur = u.no_utilisateur";

	private final String TEST = "SELECT * FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur";

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
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("email"), rs.getString("telephone"),
						rs.getString("rue"), rs.getString("code_postal"), rs.getString("mot_de_passe"),
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

	@Override
	public List<ArticleInnerUtilisateur> selectAllArticleInnerUtilisateur() {

		List<ArticleInnerUtilisateur> listArticlesInnerUtilisateur = null;
		ArticleVendu article = null;
		Utilisateur utilisateur = null;
		ArticleInnerUtilisateur articleInnerUtilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(TEST);

			ResultSet rs = pstmtArticle.executeQuery();
			//rs = pstmtArticle.getGeneratedKeys();
			while (rs.next()) {
				System.out.println("---------- TEST DE RECUPERATION DES PARAMETRES ----------");
				System.out.println("---------- PARAMETRES ARTICLE----------");
				int noArticle = rs.getInt("no_article");
				System.out.println(noArticle);
				String nomArticle = rs.getString("nom_article"); 
				System.out.println(nomArticle);
				String description = rs.getString("description"); 
				System.out.println(description);
				Date dateD = rs.getDate("date_debut_encheres"); 
				System.out.println(dateD);
				Date dateF = rs.getDate("date_fin_encheres"); 
				System.out.println(dateF);
				int prix = rs.getInt("prix_vente"); 
				System.out.println(prix);
				int noUtilisateurA = rs.getInt("no_utilisateur"); 
				System.out.println(noUtilisateurA);
				int noCategorie = rs.getInt("no_categorie"); 
				System.out.println(noCategorie);
				System.out.println("---------- PARAMETRES UTILISATEUR ----------");
				int noUtilisateurU = rs.getInt("no_utilisateur"); 
				System.out.println(noUtilisateurU);
				String pseudo = rs.getString("pseudo"); 
				System.out.println(pseudo);
				String nom = rs.getString("nom"); 
				System.out.println(nom);
				String prenom = rs.getString("prenom"); 
				System.out.println(prenom);
				String email = rs.getString("email"); 
				System.out.println(email);
				String telephone = rs.getString("telephone"); 
				System.out.println(telephone);
				String rue = rs.getString("rue"); 
				System.out.println(rue);
				String cp = rs.getString("code_postal"); 
				System.out.println(cp);
				String ville = rs.getString("ville"); 
				System.out.println(ville);
				String mdp = rs.getString("mot_de_passe"); 
				System.out.println(mdp);
				int credit = rs.getInt("credit"); 
				System.out.println(credit);
				boolean admin = rs.getBoolean("administrateur"); 
				System.out.println(admin);

				System.out.println("---------- FIN DE TEST DE RECUPERATION DES PARAMETRES ----------");
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), (rs.getDate("date_debut_encheres")).toLocalDate(),
						(rs.getDate("date_fin_encheres")).toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				System.out.println(article);
				utilisateur = new Utilisateur(rs.getInt("no_utilisateur"), rs.getString("pseudo"), rs.getString("nom"),
						rs.getString("prenom"), rs.getString("email"), rs.getString("telephone"), rs.getString("rue"),
						rs.getString("code_postal"), rs.getString("ville"), rs.getString("mot_de_passe"),
						rs.getInt("credit"), rs.getBoolean("administrateur"));
				System.out.println(utilisateur);
				articleInnerUtilisateur = new ArticleInnerUtilisateur(article, utilisateur);
				System.out.println(articleInnerUtilisateur);
				listArticlesInnerUtilisateur.add(articleInnerUtilisateur);
			}
			pstmtArticle.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_ARTICLE_INNER_UTILISATEUR_SQL);
		}
		return listArticlesInnerUtilisateur;
	}

}
