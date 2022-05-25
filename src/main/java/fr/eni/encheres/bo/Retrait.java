/**
 * 
 */
package fr.eni.encheres.bo;
/**
 * @author BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain
 *
 */
public class Retrait {
	
	private int no_article;
	private String rue;
	private String code_postal;
	private String ville;
	
	public Retrait(int no_article, String rue, String code_postal, String ville) {
		setNo_article(no_article);
		setRue(rue);
		setCode_postal(code_postal);
		setVille(ville);
	}

	public int getNo_article() {
		return no_article;
	}

	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	

}
