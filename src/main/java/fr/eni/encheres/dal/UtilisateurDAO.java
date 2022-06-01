/**
 * 
 */
package fr.eni.encheres.dal;


import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
public interface UtilisateurDAO {
	public Utilisateur createUser(Utilisateur user) throws BusinessException;


	public Utilisateur selectUser(int no_utilisateur) throws BusinessException;


	public Utilisateur selectUserById(int no_utilisateur) throws BusinessException;
	public String selectUserByPseudo(String pseudo) throws BusinessException;
	public String selectUserByEmail(String email) throws BusinessException;
	public Utilisateur selectUserByDetails(String pseudo, String email) throws BusinessException;


	public void updateUser(Utilisateur user) throws BusinessException;
	public void deleteUser(int no_utilisateur) throws BusinessException;
	public int checkUserDetailsExist(String pseudo, String email) throws BusinessException ;


}
