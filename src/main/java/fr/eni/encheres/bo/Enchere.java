package fr.eni.encheres.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Enchere {

	private int no_utilisateur;
	private int no_article;
	private LocalDate date_enchere;
	private int montant_enchere;
	
	public Enchere(int no_utilisateur, int no_article, LocalDate date_enchere, int montant_enchere) {
		setNo_utilisateur(no_utilisateur);
		setNo_article(no_article);
		setDate_enchere(date_enchere);
		setMontant_enchere(montant_enchere);
	}
	
	// Without no_utilisateur
	public Enchere(int no_article, LocalDate date_enchere, int montant_enchere) {
		setNo_article(no_article);
		setDate_enchere(date_enchere);
		setMontant_enchere(montant_enchere);
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

	public LocalDate getDate_enchere() {
		return date_enchere;
	}

	public void setDate_enchere(LocalDate date_enchere) {
		this.date_enchere = date_enchere;
	}

	public int getMontant_enchere() {
		return montant_enchere;
	}

	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}
	
	
}
