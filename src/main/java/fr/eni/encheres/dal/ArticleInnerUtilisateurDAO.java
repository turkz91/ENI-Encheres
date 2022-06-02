package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bo.ArticleInnerUtilisateur;

public interface ArticleInnerUtilisateurDAO {

	public ArticleInnerUtilisateur selectArticleInnerUtilisateur(int no_utilisateur);
	public List<ArticleInnerUtilisateur> selectAllArticleInnerUtilisateur();
}
