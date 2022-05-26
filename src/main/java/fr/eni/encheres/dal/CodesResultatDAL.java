package fr.eni.encheres.dal;

/**
 * Les codes disponibles sont entre 10000 et 19999
 */
public abstract class CodesResultatDAL {
	
	/**
	 * Echec général quand tentative d'ajouter un ARTICLE null
	 */
	public static final int CREATE_ARTICLE_NULL=10000;
	
	/**
	 * Echec général quand tentative d'ajouter un ARTICLE dans la DB
	 */
	public static final int CREATE_ARTICLE_SQL=10001;
	
	/**
	 * Echec général quand tentative de récupérer un ARTICLE dans la DB
	 */
	public static final int SELECT_ARTICLE_SQL=10002;
	
	/**
	 * Echec général quand tentative d'ajouter une CATEGORIE null
	 */
	public static final int CREATE_CATEGORIE_NULL=10010;
	
	/**
	 * Echec général quand tentative d'ajouter une CATEGORIE dans la DB
	 */
	public static final int CREATE_CATEGORIE_SQL=10011;
	
	/**
	 * Echec général quand tentative d'ajouter une USER null
	 */
	public static final int CREATE_USER_NULL=10020;
	
	/**
	 * Echec général quand tentative d'ajouter une USER dans la DB
	 */
	public static final int CREATE_USER_SQL=10021;
	
	/**
	 * Echec général quand tentative d'ajouter d'un USER dans la DB
	 */
	public static final int UPDATE_USER_NULL=10022;
	
	/**
	 * Echec général quand tentative d'ajouter d'un USER sans ID dans la DB
	 */
	public static final int UPDATE_USER_ID_ERROR=10023;
	
	/**
	 * Echec général quand tentative d'ajouter une USER dans la DB
	 */
	public static final int UPDATE_USER_ERROR=10024;
	
	/**
	 * Echec général quand tentative d'ajouter une ENCHERE null
	 */
	public static final int CREATE_ENCHERE_NULL = 10030;
	
	/**
	 * Echec général quand tentative d'ajouter une ENCHERE dans la DB
	 */
	public static final int CREATE_ENCHERE_SQL = 10031;
	
	/**
	 * Echec général quand tentative de récupérer une ENCHERE dans la DB
	 */
	public static final int SELECT_ENCHERE_SQL = 10032;
	
	/**
	 * Echec général lors de l'installation des catégories intial 
	 *   - InstallCategorieDAL.java
	 */
	public static final int INSTALL_CATEGORIES_INIT=50000;

	

	
	
	
	
}
