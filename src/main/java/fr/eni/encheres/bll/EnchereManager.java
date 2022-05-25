package fr.eni.encheres.bll;

import java.time.LocalDate;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.dal.ArticleEnchereDAO;
import fr.eni.encheres.dal.DAOFactory;

public class EnchereManager {
	
	private ArticleEnchereDAO articleEnchereDAO;

	public EnchereManager(ArticleEnchereDAO articleEnchereDAO) {
		this.articleEnchereDAO = DAOFactory.getArticleEnchereDAO();
	}

	public ArticleVendu ajouterEnchere(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int no_utilisateur, int no_categorie)
			throws BusinessException {

		BusinessException businessException = new BusinessException();
		this.checkNomArticle(nom_article, businessException);
		this.checkDescription(description, businessException);
		this.checkDateDebutEnchere(date_debut_encheres, businessException);
		this.checkPrixInitial(prix_initial, businessException);
		
		
		
		
		ArticleVendu articleVendu = null;
		
		if (!businessException.hasErreurs()) {
			articleVendu = new ArticleVendu();
			
			// TODO create rules to validate an ArticleVendu
		}

		return articleVendu;

	}
	
	public void checkNomArticle(String nom_article, BusinessException businessException) {
		
		if (nom_article == null || nom_article.length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_NOM_ERREUR);
		}
	}
	
	public void checkDescription(String description, BusinessException businessException) {
		if (description == null || description.length() > 300) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_DESCRIPTION_ERREUR);
		}
	}

	public void checkDateDebutEnchere(LocalDate date_debut_encheres, BusinessException businessException) {
		if (date_debut_encheres == null || date_debut_encheres.isBefore(LocalDate.now())) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_DATE_DEBUT_ENCHERE_ERREUR);
		}
	}
	
	public void checkDateFinEnchere(LocalDate date_debut_encheres, LocalDate date_fin_encheres, BusinessException businessException) {
		if (date_fin_encheres == null || date_fin_encheres.isBefore(date_debut_encheres)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_DATE_FIN_ENCHERE_ERREUR);
		}
	}
	
	public void checkPrixInitial(int prix_initial, BusinessException businessException) {
		if (prix_initial <= 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_PRIX_INITIAL_ERREUR);
		}
	}
	
	public void checkPrixVente (int prix_initial, int prix_vente, BusinessException businessException) {
		if (prix_vente <= 0 || prix_vente < prix_initial) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_PRIX_VENTE_ERREUR);
		}
	}
	

}
