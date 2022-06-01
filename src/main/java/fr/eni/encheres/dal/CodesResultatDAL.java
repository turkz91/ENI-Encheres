package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	//------------------ ERRORS FOR ARTICLES ------------------
	/**
	 * Une tentative d'enregistrement d'un article inexistant a eu lieu.
	 */
	public static final int CREATE_ARTICLE_NULL=10000;
	
	/**
	 * Une erreur est survenue lors de l'enregistrement des informations de l'article dans la DB.
	 */
	public static final int CREATE_ARTICLE_SQL=10001;
	
	/**
	 * Une erreur est survenue lors de la sélection de l'article dans la DB
	 */
	public static final int SELECT_ARTICLE_SQL=10002;
	
	/**
	 * Une erreur est survenue lors de recherche d'articles par mot clés dans la DB
	 *  
	 */
	public static final int SELECT_LIST_ARTICLES_BY_KEY_WORD_SQL = 10003;
	
	/**
	 * Une erreur est survenue lors de la sélection de tous les articles dans la DB
	 *   
	 */
	public static final int SELECT_ALL_ARTICLES_SQL = 10004;
	
	
	
	
	//------------------ ERRORS FOR CATEGORIES ------------------
	
	/**
	 * Une tentative d'enregistrement d'une catégorie inexistante a eu lieu.
	 */
	public static final int CREATE_CATEGORIE_NULL=10010;
	
	/**
	 * Une erreur est survenue lors de l'enregistrement des informations de la catégorie dans la DB.
	 */
	public static final int CREATE_CATEGORIE_SQL=10011;
	
	/**
	 * Erreur lors de la récupération de la liste des catégories en base de données 
	 *   
	 */
	public static final int SELECT_ALL_CATEGORIES_SQL = 10012;
	
	
	//------------------ ERRORS FOR USERS ------------------
	/** CREATE
	 * Une tentative d'enregistrement d'un utilisateur inexistant a eu lieu.
	 */
	public static final int CREATE_USER_NULL=10020;
	
	/**CREATE
	 * Une erreur  est survenue lors de l'enregistrement des informations de l'utilisateur dans la DB.
	 */
	public static final int CREATE_USER_SQL=10021;
	
	/**SELECT
	 * Une erreur est survenue lors de la tentative de récupération d'un USER dans la DB
	 */
	public static final int SELECT_USER_SQL=10022;
	
	/**SELECT
	 * Une erreur est survenue lors de la tentative de récupération de la liste des pseudos dans la DB
	 */
	public static final int SELECT_PSEUDOS_LIST_SQL=10023;
	
	/**SELECT
	 * Une erreur est survenue lors de la tentative de récupération de la liste des emails dans la DB
	 */
	public static final int SELECT_EMAIL_LIST_SQL=10024;
	
	/**SELECT
	 * Une erreur est survenue lors de la recherche par pseudo de l'utilisateur dans la DB
	 */
	public static final int SELECT_USER_BY_PSEUDO_SQL = 10025;
	
	/**SELECT
	 * Une erreur est survenue lors de la recherche par pseudo de l'utilisateur dans la DB
	 */
	public static final int SELECT_USER_BY_EMAIL_SQL = 10026;
	
	/**UPDATE
	 * Une erreur est survenue lors de la tentative de mise à jour d'un USER dans la DB
	 */
	public static final int UPDATE_USER_NULL=10027;
	
	/**UPDATE
	 * Une erreur est survenue lors de la tentative d'ajouter d'un USER sans ID dans la DB
	 */
	public static final int UPDATE_USER_ID_ERROR=10028;
	
	/**UPDATE
	 * Une erreur est survenue lors de la tentative d'ajouter une USER dans la DB
	 */
	public static final int UPDATE_USER_ERROR=10029;
	
	/**DELETE
	 * Une erreur est survenue lors de la tentative de suppression USER dans la DB
	 */
	public static final int DELETE_USER_SQL=10030;

	
	/**CHECK
	 * Une erreur est survenue lors de la tentative de vérification d'un USER dans la DB
	 */
	public static final int CHECK_USER_SQL = 10031;
	
	
	//------------------ ERRORS FOR BIDS ------------------
	/**
	 * Echec général quand tentative d'ajouter une ENCHERE null
	 */
	public static final int CREATE_ENCHERE_NULL = 10100;
	
	/**
	 * Echec général quand tentative d'ajouter une ENCHERE dans la DB
	 */
	public static final int CREATE_ENCHERE_SQL = 10101;
	
	/**
	 * Echec général quand tentative de récupérer une ENCHERE dans la DB
	 */
	public static final int SELECT_ENCHERE_SQL = 10102;
	
	
	/**
	 * Une erreur est survenue lors de la récupération des montants des enchères pour l'article sélectionné dans la DB
	 */
	public static final int SELECT_ALL_MONTANTS_ENCHERES_SQL = 10103;
	
	/**
	 * Une erreur est survenue lors de la récupération des enchères pour l'article sélectionné dans la DB
	 */
	public static final int SELECT_ALL_ENCHERES_SQL = 10104;
	
	/**
	 * Une erreur est survenue lors de la mise à jour d'une enchère innexistante
	 */
	public static final int UPDATE_ENCHERE_NULL = 10105;
	
	/**
	 * Une erreur est survenue lors de la mise à jour d'une enchère pour un numero d'article innexistant
	 */
	public static final int UPDATE_ENCHERE_NO_ARTICLE_NULL = 10106;
	
	/**
	 * Une erreur est survenue lors de la mise à jour d'une enchère pour un numero utilisateur innexistant
	 */
	public static final int UPDATE_ENCHERE_NO_UTILISATEUR_NULL = 10107;
	
	/**
	 * Une erreur est survenue lors de l'enregistrement la mise à jour d'une enchère dans la DB
	 */
	public static final int UPDATE_ENCHERE_SQL = 10108;
	
	//------------------ ERRORS TEST ------------------
	
	/**
	 * Echec général lors de l'installation des catégories intial 
	 *   - InstallCategorieDAL.java
	 */
	public static final int INSTALL_CATEGORIES_INIT=50000;



	



	

	

	

	
	
	
	
}
