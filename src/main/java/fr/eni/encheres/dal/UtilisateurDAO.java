/**
 * 
 */
package fr.eni.encheres.dal;

import java.util.List;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
public interface UtilisateurDAO {
	public void createUser(Utilisateur user) throws BusinessException;
	public Utilisateur findUser();
	public List<String> userEmails();
	public List<String> userPseudo();
	public Utilisateur updateUser();
	public void deleteUser();
}
