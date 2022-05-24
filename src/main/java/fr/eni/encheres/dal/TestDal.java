/**
 * 
 */
package fr.eni.encheres.dal;

import java.sql.Connection;

/**
 * @author ephra
 *
 */
public class TestDal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			System.out.println("Works");
		} catch (Exception e) {
			// TODO: handle exception
		} ;

	}

}
