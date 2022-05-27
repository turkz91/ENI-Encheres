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
	private final String SELECT_USER = "SELECT "
			+ "no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe,credit,administrateur"
			+ "FROM UTILISATEURS " + "WHERE (no_utilisateur = ?)";
	private final String SELECT_MAILS_LIST = "SELECT email" + "FROM UTILISATEURS";
	private final String SELECT_PSEUDOS_LIST = "SELECT pseudo" + "FROM UTILISATEURS";
	private final String UPDATE_USER = "UPDATE UTILISATEURS "
			+ "SET pseudo=?, nom=?, prenom=?,email=?, telephone=?, rue=?, code_postal=?, ville=?, mot_de_passe=?, credit=?, administrateur=? "
			+ "WHERE no_utilisateur=?";
	private final String DELETE_USER = "DELETE FROM UTILISATEURS" + "WHERE no_utilisateur = ?";

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
	public Utilisateur selectUser(int no_utilisateur) throws BusinessException {

		Utilisateur utilisateur = null;
		
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pstmtUser = cnx.prepareStatement(SELECT_USER);
			pstmtUser.setInt(1, no_utilisateur);
			
			ResultSet rsUser = pstmtUser.getGeneratedKeys();
			rsUser = pstmtUser.executeQuery();
			
			while (rsUser.next()) {
				utilisateur = new Utilisateur(
						rsUser.getInt("no_utilisateur"),
						rsUser.getString("pseudo"),
						rsUser.getString("nom"),
						rsUser.getString("prenom"),
						rsUser.getString("email"),
						rsUser.getString("email"),
						rsUser.getString("telephone"),
						rsUser.getString("rue"),
						rsUser.getString("code_postal"),
						rsUser.getString("mot_de_passe"),
						rsUser.getInt("credit"),
						rsUser.getBoolean("administrateur")
						);
			}
			rsUser.close();
			pstmtUser.close();
		} catch (Exception e) {
			e.printStackTrace();
			BusinessException businessException = new BusinessException();
			businessException.ajouterErreur(CodesResultatDAL.CREATE_USER_SQL);
			throw businessException;
		}
		return utilisateur;
		
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
			PreparedStatement pstmtUser = cnx.prepareStatement(UPDATE_USER, PreparedStatement.RETURN_GENERATED_KEYS);
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
			businessException.ajouterErreur(CodesResultatDAL.UPDATE_USER_ERROR);
			throw businessException;
		}
		return user;

	}

	@Override
	public void deleteUser(int no_utilisateur) throws BusinessException {
		// TODO Auto-generated method stub
	}

	@Override
	public List<String> selectUsersEmails() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> selectUsersPseuros() throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

}
