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
	public Utilisateur createUser(Utilisateur user) throws BusinessException;
	public Utilisateur selectUser(int no_utilisateur) throws BusinessException;
	public List<String> selectUsersEmails() throws BusinessException;
	public List<String> selectUsersPseuros() throws BusinessException;
	public Utilisateur updateUser(Utilisateur user) throws BusinessException;
	public void deleteUser(int no_utilisateur) throws BusinessException;
}
