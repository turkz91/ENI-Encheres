package fr.eni.encheres.bo;
import java.sql.Date;
/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
import java.time.LocalDateTime;

public class Enchere {

	private int no_utilisateur;
	private int no_article;
	private LocalDateTime date_enchere;
	private int montant_enchere;
	
	/**
	 * Constructeur Enchere - sans no_utilisateur
	 * @param no_article
	 * @param date_enchere
	 * @param montant_enchere
	 */
	// Pourquoi? un enchère aurait besoin d'un no_utilisateur toujours non?
	public Enchere(int no_article, LocalDateTime date_enchere, int montant_enchere) {
		setNo_article(no_article);
		setDate_enchere(date_enchere);
		setMontant_enchere(montant_enchere);
	}
	
	/**
	 * Constructeur Enchere 
	 * @param no_utilisateur
	 * @param no_article
	 * @param date_enchere
	 * @param montant_enchere
	 */	
	public Enchere(int no_utilisateur, int no_article, LocalDateTime date_enchere, int montant_enchere) {
		this(no_article,date_enchere,montant_enchere);
		setNo_utilisateur(no_utilisateur);
	}

	public int getNo_utilisateur() {
		return no_utilisateur;
	}

	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public LocalDateTime getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDateTime date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	
	
}
