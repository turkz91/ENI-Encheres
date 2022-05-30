package fr.eni.encheres.bll;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import fr.eni.encheres.bo.ArticleVendu;
import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.dal.ArticleEnchereDAO;
import fr.eni.encheres.dal.DAOFactory;

//This class manage ArticleVendu and bids
public class ArticleEnchereManager {

	private ArticleEnchereDAO articleEnchereDAO;

	public ArticleEnchereManager(ArticleEnchereDAO articleEnchereDAO) {
		this.articleEnchereDAO = DAOFactory.getArticleEnchereDAO();
	}

	
	// Methods for Articles
	
	public void ajouterArticle(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int no_utilisateur, int no_categorie)
			throws BusinessException {

		BusinessException businessException = new BusinessException();
		this.checkNomArticle(nom_article, businessException);
		this.checkDescription(description, businessException);
		this.checkDateDebutEnchere(date_debut_encheres, businessException);
		this.checkPrixInitial(prix_initial, businessException);

		ArticleVendu articleVendu = null;

		if (!businessException.hasErreurs()) {
			articleVendu = new ArticleVendu(nom_article, description, date_debut_encheres, date_fin_encheres,
					prix_initial, no_categorie);

			this.articleEnchereDAO.createArticle(articleVendu);
		} else {
			throw businessException;
		}
	}
	
	
	// Methods for bids

	public void ajouterEnchere(int no_utilisateur, int no_article, LocalDateTime date_enchere, int montant_enchere)
			throws BusinessException {

		BusinessException businessException = new BusinessException();

		Enchere enchere = null;
		
		// First sept : check montant > prix_initial
		this.checkMontantPrixInitial(no_article, montant_enchere, businessException);
		
		ArticleVendu article = articleEnchereDAO.selectArticle(no_article);
		
		List<Integer> listeMontants = articleEnchereDAO.selectAllMontantsEncheres(article);
		
		// Second sept : check montant > montant max actuel
		this.checkMontantMaxEncheres(listeMontants, montant_enchere, businessException);

		if (!businessException.hasErreurs()) {
			enchere = new Enchere(no_utilisateur, no_article, date_enchere, montant_enchere);

			this.articleEnchereDAO.createEnchere(enchere);
		} else {
			throw businessException;
		}
	}
	
	// Methods to validate an Article

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

	public void checkDateFinEnchere(LocalDate date_debut_encheres, LocalDate date_fin_encheres,
			BusinessException businessException) {
		if (date_fin_encheres == null || date_fin_encheres.isBefore(date_debut_encheres)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_DATE_FIN_ENCHERE_ERREUR);
		}
	}

	public void checkPrixInitial(int prix_initial, BusinessException businessException) {
		if (prix_initial <= 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_PRIX_INITIAL_ERREUR);
		}
	}

	public void checkPrixVente(int prix_initial, int prix_vente, BusinessException businessException) {
		if (prix_vente <= 0 || prix_vente < prix_initial) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ARTICLE_VENDU_PRIX_VENTE_ERREUR);
		}
	}

	//  TO DO A modifier ou supprimer si tout sera vérifié par la méthode ckeckMontant
	public void checkMontantPrixInitial(int prix_initial, int montant, BusinessException businessException) {
		if (montant <= prix_initial) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_MONTANT_ERREUR);
		}
	}
	
	 // Methods to validate a bid
	
	public void checkMontantMaxEncheres (List<Integer> listeMontants, int montant, BusinessException businessException) {
		
		int montantMax = 0;
		
		for (int valMontant : listeMontants) {
			if(valMontant > montantMax) {
				montantMax = valMontant;
			}
			
			if (montant <= montantMax) {
				businessException.ajouterErreur(CodesResultatBLL.REGLE_ENCHERE_MONTANT_ERREUR);
			}
		}
		
	}
}
