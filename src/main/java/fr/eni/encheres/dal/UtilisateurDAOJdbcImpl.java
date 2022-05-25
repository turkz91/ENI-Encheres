/**
 * 
 */
package fr.eni.encheres.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.eni.encheres.bll.BusinessException;
import fr.eni.encheres.bo.Utilisateur;

/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
class UtilisateurDAOJdbcImpl implements UtilisateurDAO {
	private final String CREATE_USER = "INSERT INTO UTILISATEURS "
			+ "(pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur) "
			+ "VALUES (?,?,?,?,?,?,?,?,?,?,?);";
//	private final String FIND_USER ="SELECT "
//			+ "no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur "
//			+ "FROM UTILISATEURS "
//			+ "WHERE (no_utilisateur = ?)";
//	private final String USERS_EMAILS="SELECT email"
//			+ "FROM UTILISATEURS";
//	private final String USERS_PSEUDOS="SELECT pseudo"
//			+ "FROM UTILISATEURS";
	private final String UPDATE_USER="UPDATE UTILISATEURS "
			+ "SET pseudo=?, nom=?, prenom=?,email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? "
			+ "WHERE no_utilisateur=?";

	@Override
	public Utilisateur createUser(Utilisateur user) throws BusinessException {
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
			pstmtUser.setString(4, user.getEmail());
			pstmtUser.setString(5, user.getTelephone());
			pstmtUser.setString(6, user.getRue());
			pstmtUser.setString(7, user.getCode_postal());
			pstmtUser.setString(8, user.getVille());
			pstmtUser.setString(9, user.getMot_de_passe());
			pstmtUser.setInt(10, user.getCredit());
			pstmtUser.setInt(11, user.getAdministrateur());
			pstmtUser.executeUpdate();
			ResultSet rsUser = pstmtUser.getGeneratedKeys();
			if (rsUser.next()) {
				user.setNo_utilisateur(rsUser.getInt(1));
			}
			rsUser.close();
			pstmtUser.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_USER_SQL);
			throw businessException;
		}
		return user;

	}

	@Override
	public Utilisateur findUser() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Utilisateur updateUser(Utilisateur user) throws BusinessException {
		if (user == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_USER_NULL);
			throw businessException;
		}
		if (Integer.valueOf(user.getNo_utilisateur()) == null) {
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_USER_ID_ERROR);
			throw businessException;			
		}
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtUser = cnx.prepareStatement(CREATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
			pstmtUser.setString(1, user.getPseudo());
			pstmtUser.setString(2, user.getNom());
			pstmtUser.setString(3, user.getPrenom());
			pstmtUser.setString(4, user.getEmail());
			pstmtUser.setString(5, user.getTelephone());
			pstmtUser.setString(6, user.getRue());
			pstmtUser.setString(7, user.getCode_postal());
			pstmtUser.setString(8, user.getVille());
			pstmtUser.setString(9, user.getMot_de_passe());
			pstmtUser.setInt(10, user.getCredit());
			pstmtUser.setInt(11, user.getAdministrateur());
			pstmtUser.setInt(12, user.getNo_utilisateur());
			pstmtUser.executeUpdate();
			pstmtUser.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_USER_SQL);
			throw businessException;
		}
		return user;

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
