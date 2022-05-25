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
	 * Echec général quand tentative d'ajouter une CATEGORIE null
	 */
	public static final int CREATE_CATEGORIE_NULL=10001;
	
	/**
	 * Echec général quand tentative d'ajouter une USER null
	 */
	public static final int CREATE_USER_NULL=10002;
	
	
	
}
