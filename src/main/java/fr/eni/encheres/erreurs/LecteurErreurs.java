package fr.eni.encheres.erreurs;

import java.util.ResourceBundle;

public abstract class LecteurErreurs {

	// Cette classe permet de lire les erreurs contenues dans le fichier
	// erreurs.properties

	private static ResourceBundle rb;

	static {
		try {

			rb = ResourceBundle.getBundle("fr.eni.encheres.erreurs.messages_erreur");

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static String getMessageErreur(int code) {

		String message = "";

		try {
			if (rb != null) {
				message = rb.getString(String.valueOf(code));
			} else {
				message = "Problème à la lecture du fichier messages_erreur";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			message = "Une erreur inconnue est survenue";
		}

		return message;

	}

}
