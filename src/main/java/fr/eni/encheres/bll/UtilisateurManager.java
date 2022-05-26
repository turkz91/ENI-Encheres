package fr.eni.encheres.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse, String confirmation) {

		BusinessException businessException = new BusinessException();

		Utilisateur utilisateur = null;
		int credit = 0;
		boolean administrateur = false;

		this.checkPseudo(pseudo, businessException);
		this.checkNom(nom, businessException);
		this.checkPrenom(prenom, businessException);
		this.checkEmail(email, businessException);
		this.checkTelephone(telephone, businessException);
		this.checkRue(rue, businessException);
		this.checkCodePostal(codePostal, businessException);
		this.checkVille(ville, businessException);
		this.checkMotDePasse(motDePasse, confirmation, businessException);

		// TO DO create rules to validate an utilisateur

		if (!businessException.hasErreurs()) {
			utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse,
					credit, administrateur);
		}

		return utilisateur;
	}

	public void checkPseudo(String pseudo, BusinessException businessException) {

		// Only alphanumerisch characters accepted for pseudo
		String regex = "^[A-Za-z0-9]{1,30}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pseudo);
		if (pseudo == null || matcher.matches() == false) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
		}

	}

	public void checkNom(String nom, BusinessException businessException) {

		// Only letters accepted for lastname
		String regex = "^[A-Za-z]{1,30}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(nom);
		if (nom == null || matcher.matches() == false) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_NOM_ERREUR);
		}

	}

	public void checkPrenom(String prenom, BusinessException businessException) {

		// Only letters and "-" accepted for firstname ( in case of composed first name)
		String regex = "^[A-Za-z-]{1,30}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(prenom);
		if (prenom == null || matcher.matches() == false) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PRENOM_ERREUR);
		}
	}

	public void checkEmail(String email, BusinessException businessException) {

		// Only letters and "-" accepted for firstname ( in case of composed first name)
				String regex = "^[A-Za-z0-9-_]+@+[A-Za-z0-9-_]+.+[A-Za-z]{2,4}$";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(email);
				if (email == null || email.length() > 20 || matcher.matches() == false) {
					businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_ERREUR);
				}
		
	}

	public void checkTelephone(String telephone, BusinessException businessException) {

		// Only numbers accepted
		String regex = "(^[0-9]{9,15}$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(telephone);
		if (telephone == null || matcher.matches() == false) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_TELEPHONE_ERREUR);
		}
	}

	public void checkRue(String rue, BusinessException businessException) {
		if (rue == null || rue.length() > 30) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_RUE_ERREUR);
		}
	}

	public void checkCodePostal(String codePostal, BusinessException businessException) {
		// Only numbers accepted
		String regex = "(^[0-9]{5,10}$)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(codePostal);
		if (codePostal == null || matcher.matches() == false) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_CODE_POSTAL_ERREUR);
		}
	}

	public void checkVille(String ville, BusinessException businessException) {
		
		// Only letters accepted
				String regex = "(^[a-zA-Z]{1,30}$)";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(ville);
				if (ville == null || matcher.matches() == false) {
					businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_VILLE_ERREUR);
				}
	}

	public void checkMotDePasse(String motDePasse, String confirmation, BusinessException businessException) {

		if (motDePasse == null || !motDePasse.equals(confirmation)) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MOT_DE_PASSE_ERREUR);
		}
	}
}
