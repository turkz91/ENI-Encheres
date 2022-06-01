package fr.eni.encheres.bll;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.DAOFactory;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurManager {

	private UtilisateurDAO utilisateurDAO = DAOFactory.getUtilisateurDAO();

	public Utilisateur ajouterUtilisateur(String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String ancien_motDePasse,
			String motDePasse, String confirmation) throws BusinessException {

		BusinessException businessException = new BusinessException();

		Utilisateur utilisateur = null;
		int credit = 0;
		boolean administrateur = false;
		int userExistance;

		checkPseudo(pseudo, businessException);
		checkNom(nom, businessException);
		checkPrenom(prenom, businessException);
		checkEmail(email, businessException);
		checkTelephone(telephone, businessException);
		checkRue(rue, businessException);
		checkCodePostal(codePostal, businessException);
		checkVille(ville, businessException);
		checkMotDePasse(motDePasse, confirmation, businessException);
		userExistance = checkUserExistance(pseudo, email, businessException);
		if (userExistance != 0) {
			userExistsException(userExistance, businessException);
		}

		if (!businessException.hasErreurs()) {
			utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, credit, administrateur);
			this.utilisateurDAO.createUser(utilisateur);
		} else {
			System.out.println("Erreur survenue" + businessException.getListeCodesErreur());
			throw businessException;
		}

		return utilisateur;
	}
	public Utilisateur loginUtilisateur(String userDetails, String motDePasse) throws BusinessException {

		BusinessException businessException = new BusinessException();
		Utilisateur utilisateur = null;
		int userExistance = checkUserExistance(userDetails, userDetails, businessException);
		if (userDetails == null || motDePasse == null || userExistance == 0) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
		} else {
			utilisateur = utilisateurDAO.selectUserByDetails(userDetails, userDetails);
		}
		if (utilisateur.getMot_de_passe().equals(motDePasse)) {
			return utilisateur;
		} else {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_MDP_FAUX);
		}
		throw businessException;
	}

	public Utilisateur updateUtilisateur(String pseudo, String nom, String prenom, String email,
			String telephone, String rue, String codePostal, String ville, String motDePasse,
			String confirmation, String ancien_mdp, Utilisateur oldUser) throws BusinessException {

		BusinessException businessException = new BusinessException();
		Utilisateur utilisateur = null;
		
		checkPseudo(pseudo, businessException);
		checkNom(nom, businessException);
		checkPrenom(prenom, businessException);
		checkEmail(email, businessException);
		checkTelephone(telephone, businessException);
		checkRue(rue, businessException);
		checkCodePostal(codePostal, businessException);
		checkVille(ville, businessException);
		if (motDePasse == null || motDePasse.isEmpty()) {	
			motDePasse = checkAncienMDP(ancien_mdp,oldUser ,businessException);
			System.out.println(motDePasse);
		}
		else {
			checkMotDePasse(motDePasse, confirmation, businessException);
			checkAncienMDP(ancien_mdp,oldUser ,businessException);
		}
		if (!businessException.hasErreurs()) {
			utilisateur = new Utilisateur(oldUser.getNo_utilisateur(),pseudo, nom, prenom, email, telephone, rue, codePostal, ville,
					motDePasse, oldUser.getCredit(), oldUser.isAdministrateur());
			this.utilisateurDAO.updateUser(utilisateur);
		} else {
			System.out.println("Erreur survenue" + businessException.getListeCodesErreur());
			throw businessException;
		}


		return utilisateur;
	}

	public void checkPseudo(String pseudo, BusinessException businessException) throws BusinessException {
		// Only alphanumeric characters accepted for pseudo
		String regex = "^[A-Za-z0-9]{1,30}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pseudo);
		if (pseudo == null || matcher.matches() == false) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_ERREUR);
		}
	}


	public void checkNom(String nom, BusinessException businessException) {
		// Only letters accepted for lastname
		String regex = "^[A-Za-z_ ]{1,30}$";
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

	public void checkEmail(String email, BusinessException businessException) throws BusinessException {
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
		String regex = "(^[a-zA-Z_ ]{1,30}$)";
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

	public int checkUserExistance(String pseudo, String email, BusinessException businessException)
			throws BusinessException {
		return this.utilisateurDAO.checkUserDetailsExist(pseudo, email);

	}

	public void userExistsException(int exceptionType, BusinessException businessException)
			throws BusinessException {
		switch (exceptionType) {
		case 1:
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_EMAIL_UNIQUE);
			break;
		case 2:
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_UNIQUE);
			break;
		case 3:
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_PSEUDO_EMAIL_UNIQUE);
			break;
		}
	}
	
	public String checkAncienMDP(String ancienMDP,Utilisateur oldUser ,BusinessException businessException) throws BusinessException {
		if (ancienMDP == null || ancienMDP.isEmpty() ) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_UPDATE_MDP);
		}
		if (!(oldUser.getMot_de_passe().equals(ancienMDP))) {
			businessException.ajouterErreur(CodesResultatBLL.REGLE_UTILISATEUR_UPDATE_MDP);
		}
		return ancienMDP;
	}
}
