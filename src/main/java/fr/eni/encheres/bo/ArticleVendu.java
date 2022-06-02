 package fr.eni.encheres.bo;

import java.sql.Date;
import java.time.LocalDate;
/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
/**
 * @author ephra
 *
 */
/**
 * @author ephra
 *
 */
/**
 * @author ephra
 *
 */
/**
 * @author ephra
 *
 */
public class ArticleVendu {
	
	private int no_article;
	private String nom_article;
	private String description;
	private LocalDate date_debut_encheres;
	private LocalDate date_fin_encheres;
	private int prix_initial;
	private int prix_vente;
	private int no_utilisateur;
	private int no_categorie;
	
	/**
	 * Constructeur Article vendu - sans no_article, prix_initial, prix_final
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param no_utilisateur
	 * @param no_categorie
	 */
	public ArticleVendu(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int no_utilisateur, int no_categorie) {
		setNom_article(nom_article);
		setDescription(description);
		setDate_debut_encheres(date_debut_encheres);
		setDate_fin_encheres(date_fin_encheres);
		setNo_utilisateur(no_utilisateur);
		setNo_categorie(no_categorie);
	}
	
	/**
	 * Constructeur Article vendu - sans no_article, prix_final
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param prix_initial
	 * @param no_utilisateur
	 * @param no_categorie
	 */
	public ArticleVendu(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int no_utilisateur, int no_categorie) {
		this(nom_article,description,date_debut_encheres,date_fin_encheres,no_utilisateur,no_categorie);
		setPrix_initial(prix_initial);
	}
	
	/**
	 * Constructeur Article vendu - sans no_article
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param prix_initial
	 * @param prix_vente
	 * @param no_utilisateur
	 * @param no_categorie
	 */
	public ArticleVendu(String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
		this(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,no_utilisateur,no_categorie);setNom_article(nom_article);
		setPrix_vente(prix_vente);
	}
	
	/**
	 * Constructeur Article vendu 
	 * @param no_article
	 * @param nom_article
	 * @param description
	 * @param date_debut_encheres
	 * @param date_fin_encheres
	 * @param prix_initial
	 * @param prix_vente
	 * @param no_utilisateur
	 * @param no_categorie
	 */
	public ArticleVendu(int no_article, String nom_article, String description, LocalDate date_debut_encheres,
			LocalDate date_fin_encheres, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
		this(nom_article,description,date_debut_encheres,date_fin_encheres,prix_initial,prix_vente,no_utilisateur,no_categorie);setNom_article(nom_article);
		setNo_article(no_article);
	}

	public ArticleVendu(String nom_article, String description, Date date_debut_enchere, Date date_fin_enchere, int prix_initial, int prix_vente, int no_utilisateur, int no_categorie) {
		setNom_article(nom_article);
		setDescription(description);
		setDate_debut_encheres(date_debut_encheres);
		setDate_fin_encheres(date_fin_encheres);
		setPrix_initial(prix_initial);
		setPrix_vente(prix_vente);
		setNo_utilisateur(no_utilisateur);
		setNo_categorie(no_categorie);
	}


	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getNom_article() {
		return nom_article;
	}

	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDate_debut_encheres() {
		return date_debut_encheres;
	}

	public void setDate_debut_encheres(LocalDate date_debut_encheres) {
		this.date_debut_encheres = date_debut_encheres;
	}

	public LocalDate getDate_fin_encheres() {
		return date_fin_encheres;
	}

	public void setDate_fin_encheres(LocalDate date_fin_encheres) {
		this.date_fin_encheres = date_fin_encheres;
	}

	public int getPrix_initial() {
		return prix_initial;
	}

	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
