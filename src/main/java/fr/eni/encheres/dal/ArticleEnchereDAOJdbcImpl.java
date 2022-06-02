/**
* 
*/
package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Categorie;
import fr.eni.encheres.bo.Enchere;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
class ArticleEnchereDAOJdbcImpl implements ArticleEnchereDAO {

	// SQL REQUESTS FOR ARTICLES
	private final String CREATE_ARTICLE = "INSERT INTO ARTICLES_VENDUS "
			// prix_initial can be null, but if the user inform a price, it wont be recorded
			// ?
			+ "(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, no_utilisateur, no_categorie) "
			+ "VALUES (?,?,?,?,?,?, ?)";
	private final String SELECT_ARTICLE = "SELECT nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie "
			+ "FROM ARTICLES_VENDUS WHERE no_article = ?";
	
	private final String SELECT_ALL_ARTICLES_INNER_UTILISATEUR = "SELECT a.no_article as no_article , a.nom_article as nom_article, a.description as description, a.date_debut_encheres as date_debut_encheres, a.date_fin_encheres as date_fin_encheres, a.prix_initial as prix_initial, a.prix_vente as prix_vente, a.no_utilisateur as no_utilisateur,a.no_categorie as no_categorie,u.pseudo as pseudo FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u  ON a.no_utilisateur = u.no_utilisateur;";
	
	private final String SELECT_ALL_ARTICLES = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie "
			+ "FROM ARTICLES_VENDUS";
	
	private final String SELECT_ALL_ARTICLES_INNER_UTILISATEUR_CATEGORIE = "SELECT a.no_article as no_article , a.nom_article as nom_article, a.description as description, a.date_debut_encheres as date_debut_encheres, a.date_fin_encheres as date_fin_encheres, a.prix_initial as prix_initial, a.prix_vente as prix_vente, a.no_utilisateur as no_utilisateur,a.no_categorie as no_categorie,u.pseudo as pseudo FROM ARTICLES_VENDUS a INNER JOIN UTILISATEURS u  ON a.no_utilisateur = u.no_utilisateur WHERE no_categorie = ?;";

	// TODO
	private final String SELECT_LIST_ARTICLES_BY_KEY_WORD = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie "
			+ "FROM ARTICLES WHERE nom_article LIKE ?";

	private final String SELECT_LIST_ARTICLES_BY_CATEGORIE = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie "
			+ "FROM ARTICLES WHERE no_categorie = ?";

	private final String UPDATE_ARTICLE = ""; // TO DO
	private final String DELETE_ARTICLE = ""; // TO DO

	// SQL REQUESTS FOR CATEGORIES
	private final String CREATE_CATEGORIE = "INSERT INTO CATEGORIES (libelle) VALUES (?)";
	private final String SELECT_CATEGORIE = "SELECT libelle FROM CATEGORIES WHERE no_categorie = ?";
	private final String SELECT_ALL_CATEGORIES = "SELECT libelle, no_categorie FROM CATEGORIES";
	private final String UPDATE_CATEGORIE = ""; // TO DO
	private final String DELETE_CATEGORIE = ""; // TO DO

	// SQL REQUESTS FOR ENCHERES
	private final String CREATE_ENCHERE = "INSERT INTO ENCHERES"
			+ "(no_utilisateur, no_article, date_enchere, montant_enchere)" + "VALUES (?,?,?,?)";
	private final String SELECT_ENCHERE = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_utilisateur = ? AND no_article = ?";
	private final String SELECT_ALL_MONTANTS_ENCHERES = "SELECT montant FROM ENCHERES";
	private final String SELECT_ALL_ENCHERES = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES";
	private final String UPDATE_ENCHERE = "UPDATE ENCHERES"
			+ "SET no_utilisateur = ?, no_article = ?, date_enchere = ?, montant_enchere = ?"
			+ "WHERE no_utilisateur = ? AND no_enchere = ?";
	private final String DELETE_ENCHERE = ""; // TO DO

	// METHODS FOR ARTICLES

	@Override
	public void createArticle(ArticleVendu article) throws BusinessException {
		if (article == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_ARTICLE_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(CREATE_ARTICLE,
					PreparedStatement.RETURN_GENERATED_KEYS);
			System.out.println("Affichage des données articles depuis AEImpl : " + article);
			pstmtArticle.setString(1, article.getNom_article());
			pstmtArticle.setString(2, article.getDescription());
			pstmtArticle.setDate(3, Date.valueOf(article.getDate_debut_encheres()));
			pstmtArticle.setDate(4, Date.valueOf(article.getDate_fin_encheres()));
			pstmtArticle.setInt(5, article.getPrix_initial());
			pstmtArticle.setInt(6, article.getNo_utilisateur());
			pstmtArticle.setInt(7, article.getNo_categorie());
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
	public ArticleVendu selectArticle(int no_article) throws BusinessException {
		ArticleVendu article = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_ARTICLE,
					PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtArticle.setInt(1, no_article);
			ResultSet rs = pstmtArticle.executeQuery();
			if (rs.next()) {
				article = new ArticleVendu(rs.getString("nom_article"), rs.getString("description"),
						rs.getDate("date_debut_enchere"), rs.getDate("date_fin_enchere"),
						rs.getInt("prix_initial"), rs.getInt("prix_initial"), rs.getInt("no_utilisateur"),
						rs.getInt("no_categorie"));
			}
			pstmtArticle.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ARTICLE_SQL);
			throw businessException;
		}
		return article;
	}
	
	@Override
	public Map<ArticleVendu,String[]> selectAllArticlesUser() throws BusinessException {
		
		Map<ArticleVendu,String[]> listeArticles = new HashMap<>();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_ALL_ARTICLES_INNER_UTILISATEUR);
			ResultSet rs = pstmtArticle.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), (rs.getDate("date_debut_encheres")).toLocalDate(),
						(rs.getDate("date_fin_encheres")).toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				String[] infoUser = {rs.getString("pseudo"), String.valueOf(rs.getInt("no_utilisateur"))};
				listeArticles.put(article, infoUser);
			}
			pstmtArticle.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_ARTICLES_SQL);
			throw businessException;
		}
		
		return listeArticles;
	}
	
	@Override
	public Map<ArticleVendu,String[]> selectAllArticlesCategorie(int no_categorie) throws BusinessException {
		
		Map<ArticleVendu,String[]> listeArticles = new HashMap<>();
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_ALL_ARTICLES_INNER_UTILISATEUR_CATEGORIE);
			pstmtArticle.setInt(1, no_categorie);
			ResultSet rs = pstmtArticle.executeQuery();
			while (rs.next()) {
				ArticleVendu article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), (rs.getDate("date_debut_encheres")).toLocalDate(),
						(rs.getDate("date_fin_encheres")).toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				String[] infoUser = {rs.getString("pseudo"), String.valueOf(rs.getInt("no_utilisateur"))};
				listeArticles.put(article, infoUser);
			}
			pstmtArticle.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_ARTICLES_SQL);
			throw businessException;
		}
		
		return listeArticles;
	}
	
	
	@Override
	public List<ArticleVendu> selectAllArticles() throws BusinessException {

		List<ArticleVendu> listeArticles = new ArrayList<ArticleVendu>();

		ArticleVendu article = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_ALL_ARTICLES);
			ResultSet rs = pstmtArticle.executeQuery();
			while (rs.next()) {
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), (rs.getDate("date_debut_encheres")).toLocalDate(),
						(rs.getDate("date_fin_encheres")).toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				listeArticles.add(article);
			}
			pstmtArticle.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_ARTICLES_SQL);
		}
		return listeArticles;
	}

	@Override
	public List<ArticleVendu> selectListArticlesByKeyWord(String motCle) throws BusinessException {

		List<ArticleVendu> listeFiltreeArticles = new ArrayList<ArticleVendu>();

		ArticleVendu article = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_LIST_ARTICLES_BY_KEY_WORD);
			pstmtArticle.setString(1, "%motCle%");
			ResultSet rs = pstmtArticle.executeQuery();
			while (rs.next()) {
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), (rs.getDate("date_debut_enchere")).toLocalDate(),
						(rs.getDate("date_fin_enchere")).toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				listeFiltreeArticles.add(article);
			}
			pstmtArticle.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_LIST_ARTICLES_BY_KEY_WORD_SQL);
		}
		return listeFiltreeArticles;

	}

	@Override
	public List<ArticleVendu> selectListArticlesByCategorie(int no_categorie) throws BusinessException {

		List<ArticleVendu> listeArticlesByCategorie = new ArrayList<ArticleVendu>();

		ArticleVendu article = null;

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtArticle = cnx.prepareStatement(SELECT_LIST_ARTICLES_BY_KEY_WORD);
			pstmtArticle.setString(1, "no_categorie");
			ResultSet rs = pstmtArticle.executeQuery();
			while (rs.next()) {
				article = new ArticleVendu(rs.getInt("no_article"), rs.getString("nom_article"),
						rs.getString("description"), (rs.getDate("date_debut_enchere")).toLocalDate(),
						(rs.getDate("date_fin_enchere")).toLocalDate(), rs.getInt("prix_initial"),
						rs.getInt("prix_vente"), rs.getInt("no_utilisateur"), rs.getInt("no_categorie"));
				listeArticlesByCategorie.add(article);
			}
			pstmtArticle.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_LIST_ARTICLES_BY_CATEGORIE_SQL);
		}
		return listeArticlesByCategorie;
	}

	
	// METHODS FOR BIDS

	@Override
	public void createEnchere(Enchere enchere) throws BusinessException {
		if (enchere == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_ENCHERE_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtEnchere = cnx.prepareStatement(CREATE_ENCHERE);

			pstmtEnchere.setInt(1, enchere.getNo_utilisateur());
			pstmtEnchere.setInt(2, enchere.getNo_article());
			pstmtEnchere.setObject(3, enchere.getDate_enchere());
			pstmtEnchere.setInt(4, enchere.getMontant_enchere());
			pstmtEnchere.executeUpdate();
			pstmtEnchere.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_ENCHERE_SQL);
			throw businessException;
		}
	}

	@Override
	public Enchere selectEnchere(ArticleVendu article) throws BusinessException {

		Enchere enchere = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtEnchere = cnx.prepareStatement(SELECT_ENCHERE);
			pstmtEnchere.setInt(1, article.getNo_utilisateur());
			pstmtEnchere.setInt(2, article.getNo_article());
			ResultSet rs = pstmtEnchere.executeQuery();
			if (rs.next()) {
				enchere = new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						(LocalDateTime) rs.getObject("date_enchere"), rs.getInt("montant_enchere"));
			}
			pstmtEnchere.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ENCHERE_SQL);
		}
		return enchere;
	}

	@Override
	public List<Integer> selectAllMontantsEncheres(ArticleVendu article) throws BusinessException {

		List<Integer> listeMontants = new ArrayList<Integer>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtEnchere = cnx.prepareStatement(SELECT_ALL_MONTANTS_ENCHERES);
			ResultSet rs = pstmtEnchere.executeQuery();
			if (rs.next()) {
				int montant = rs.getInt("montant_enchere");
				listeMontants.add(montant);
			}
			pstmtEnchere.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_MONTANTS_ENCHERES_SQL);
		}
		return listeMontants;
	}

	@Override
	public List<Enchere> selectAllEncheres() throws BusinessException {

		List<Enchere> listeEncheres = new ArrayList<Enchere>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtEnchere = cnx.prepareStatement(SELECT_ALL_ENCHERES);
			ResultSet rs = pstmtEnchere.executeQuery();
			if (rs.next()) {
				Enchere enchere = new Enchere(rs.getInt("no_utilisateur"), rs.getInt("no_article"),
						(LocalDateTime) rs.getObject("date_enchere"), rs.getInt("montant_enchere"));
				listeEncheres.add(enchere);
			}
			pstmtEnchere.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_ENCHERES_SQL);
		}
		return listeEncheres;
	}

	@Override
	public void updateEnchere(Enchere enchere) throws BusinessException {
		if (enchere == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_NULL);
			throw businessException;
		}
		if (Integer.valueOf(enchere.getNo_article()) == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_NO_ARTICLE_NULL);
			throw businessException;
		}
		if (Integer.valueOf(enchere.getNo_utilisateur()) == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_NO_UTILISATEUR_NULL);
			throw businessException;
		}

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtEnchere = cnx.prepareStatement(UPDATE_ENCHERE);

			pstmtEnchere.setInt(1, enchere.getNo_utilisateur());
			pstmtEnchere.setInt(2, enchere.getNo_article());
			pstmtEnchere.setObject(3, enchere.getDate_enchere());
			pstmtEnchere.setInt(4, enchere.getMontant_enchere());
			pstmtEnchere.setInt(5, enchere.getNo_utilisateur());
			pstmtEnchere.setInt(6, enchere.getNo_article());

			pstmtEnchere.executeUpdate();
			pstmtEnchere.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_ENCHERE_SQL);
			throw businessException;
		}
		;
	}

	// METHODS FOR CATEGORIES

	@Override
	public Categorie createCategorie(Categorie categorie) throws BusinessException {
		if (categorie == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_CATEGORIE_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtCategorie = cnx.prepareStatement(CREATE_CATEGORIE,
					PreparedStatement.RETURN_GENERATED_KEYS);
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

	@Override
	public List<Categorie> selectAllCategorie() throws BusinessException {
		List<Categorie> listeCategories = new ArrayList<>();

		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtCategorie = cnx.prepareStatement(SELECT_ALL_CATEGORIES);
			ResultSet rs = pstmtCategorie.executeQuery();
			while (rs.next()) {
				Categorie categorie = new Categorie(rs.getInt("no_categorie"), rs.getString("libelle"));
				listeCategories.add(categorie);
			}
			pstmtCategorie.close();
			cnx.close();

		} catch (Exception ex) {
			ex.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.SELECT_ALL_CATEGORIES_SQL);
		}
		return listeCategories;
	}
	
}
