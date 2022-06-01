package fr.eni.encheres.bll;

	// Les codes disponibles sont compris entre 20000 et 29999

public class CodesResultatBLL {
	
	// Errors from ArticleVendu
	public static final int REGLE_ARTICLE_VENDU_NOM_ERREUR = 20000;
	
	public static final int REGLE_ARTICLE_VENDU_DESCRIPTION_ERREUR = 20001;
	
	public static final int REGLE_ARTICLE_VENDU_DATE_DEBUT_ENCHERE_ERREUR = 20002;
	
	public static final int REGLE_ARTICLE_VENDU_DATE_FIN_ENCHERE_ERREUR = 20003;
	
	public static final int REGLE_ARTICLE_VENDU_PRIX_INITIAL_ERREUR = 20004;
	
	public static final int REGLE_ARTICLE_VENDU_PRIX_VENTE_ERREUR = 20005;
	
	
	// Errors from Utilisateur
	public static final int REGLE_UTILISATEUR_PSEUDO_ERREUR = 20020;
	
	public static final int REGLE_UTILISATEUR_NOM_ERREUR = 20021;
	
	public static final int REGLE_UTILISATEUR_PRENOM_ERREUR = 20022;
	
	public static final int REGLE_UTILISATEUR_EMAIL_ERREUR = 20023;
	
	public static final int REGLE_UTILISATEUR_TELEPHONE_ERREUR = 20024;
	
	public static final int REGLE_UTILISATEUR_RUE_ERREUR = 20025;
	
	public static final int REGLE_UTILISATEUR_CODE_POSTAL_ERREUR = 20026;
	
	public static final int REGLE_UTILISATEUR_VILLE_ERREUR = 20027;
	
	public static final int REGLE_UTILISATEUR_MOT_DE_PASSE_ERREUR = 20028;
	
	public static final int REGLE_UTILISATEUR_NON_EXISTANT = 20029;
	
	public static final int REGLE_UTILISATEUR_MDP_FAUX = 20030;
	
	public static final int REGLE_UTILISATEUR_EXISTE = 20031;

	public static final int REGLE_UTILISATEUR_PSEUDO_UNIQUE = 20032;
	
	public static final int REGLE_UTILISATEUR_EMAIL_UNIQUE = 20033;
			
	public static final int REGLE_UTILISATEUR_PSEUDO_EMAIL_UNIQUE = 2034;
	
	public static final int REGLE_UTILISATEUR_UPDATE_MDP = 20035;
	
	// Errors from Enchere
	
	public static final int REGLE_ENCHERE_MONTANT_ERREUR = 20050;


}
