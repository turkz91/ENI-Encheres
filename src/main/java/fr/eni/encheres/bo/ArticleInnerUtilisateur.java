package fr.eni.encheres.bo;

public class ArticleInnerUtilisateur {

	private ArticleVendu article;
	private Utilisateur utilisateur;
	public ArticleInnerUtilisateur(ArticleVendu article, Utilisateur utilisateur) {
		super();
		this.article = article;
		this.utilisateur = utilisateur;
	}
	public ArticleVendu getArticle() {
		return article;
	}
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	@Override
	public String toString() {
		return "ArticleInnerUtilisateur [article=" + article + ", utilisateur=" + utilisateur + "]";
	}
	
}
