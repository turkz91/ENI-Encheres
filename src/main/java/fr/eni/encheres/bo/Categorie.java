package fr.eni.encheres.bo;
/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
public class Categorie {

	private int no_categorie;
	private String libelle;
	
	/**
	 * Constructeur Categorie - sans no_categorie
	 * @param libelle
	 */
	public Categorie(String libelle) {
		setLibelle(libelle);
	}
	
	/**
	 * Constructeur Categorie
	 * @param no_categorie
	 * @param libelle
	 */
	public Categorie(int no_categorie, String libelle) {
		this(libelle);
		setNo_categorie(no_categorie);
	}

	public int getNo_categorie() {
		return no_categorie;
	}

	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
}
