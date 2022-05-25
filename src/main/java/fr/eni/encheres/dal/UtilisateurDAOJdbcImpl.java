/**
 * 
 */
package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private final String CREATE_USER = "INSERT INTO UTILISATEURS "
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
//	private final String FIND_USER ="SELECT "
//			+ "no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur "
//			+ "FROM UTILISATEURS "
//			+ "WHERE (no_utilisateur = ?)";
//	private final String USER_EMAILS="SELECT email"
//			+ "FROM UTILISATEURS";
//	private final String USER_PSEUDO="SELECT pseudo"
//			+ "FROM UTILISATEURS";
//	private final String UPDATE_USER="";

	@Override
	public void createUser(Utilisateur user) throws BusinessException {
		if (user == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_USER_NULL);
			throw businessException;
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtUser = cnx.prepareStatement(CREATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtUser.setString(1, user.getPseudo());
			pstmtUser.setString(2, user.getNom());
			pstmtUser.setString(3, user.getPrenom());
			pstmtUser.setString(4, user.getTelephone());
			pstmtUser.setString(5, user.getRue());
			pstmtUser.setString(6, user.getCode_postal());
			pstmtUser.setString(7, user.getVille());
			pstmtUser.setString(8, user.getMot_de_passe());
			pstmtUser.setInt(9, user.getCredit());
			pstmtUser.setInt(10, user.getAdministrateur());
			ResultSet rsUser = pstmtUser.getGeneratedKeys();
			if (rsUser.next()) {
				user.setNo_utilisateur(rsUser.getInt(1));
			}
			rsUser.close();
			pstmtUser.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();

			throw businessException;
		}

	}

	@Override
	public Utilisateur findUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur updateUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> userEmails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> userPseudo() {
		// TODO Auto-generated method stub
		return null;
	}

}
