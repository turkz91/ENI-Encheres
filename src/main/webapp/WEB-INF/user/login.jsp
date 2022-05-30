<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<% 
	String pageTitle = "Login";
	%>
	<%@ page
		import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>
	<%@ include file="../partials/head.jspf"%>

	<body>
		
		<%@ include file="../partials/header.jspf"%>
        <div class="container pt-5">
            <div class="row justify-content-center align-items-center">
                <div class="col-12 col-md-7 col-lg-5">
                    <div class="col-12 pb-5">                    	
					<%
					@SuppressWarnings("unchecked")
					List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
					if (listeCodesErreur != null) {
					%>
					<p class="text-center text-danger">Erreur, l'utilisateur n'a pas pu être ajouté :</p>
					<%
					for (int codeErreur : listeCodesErreur) {
					%>
					<p class="text-center"><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
					<%
					}
					}
					%>
                        <form class="form" action="<%=request.getContextPath()%>/UtilisateurLogin" method="post">
                            <div class="form-row pb-2">
                                <label for="username" class="col-5 col-form-label col-form-label-lg">Identifiant:</label>
                                <div class="col-7">
                                	<input type="text" name="username" id="username" class="form-control">
                                </div>
                            </div>
                            <div class="form-row py-2">
                                <label for="motDePasse" class="col-5 col-form-label col-form-label-lg eni-lbl-login">Mot de Passe:</label><br>
                                <div class="col-7">
                                	<input type="password" name="motDePasse" id="motDePasse" class="form-control">
                            	</div>
                            </div>
                            <div class="form-row pt-3">
                                <div class="col-5">
                                	<input type="submit" name="submit" class="btn-success btn-lg btn-block eni-btn-connexion" value="Connexion">
                                </div>
                                <div class="col-7 text-right">
                               		<label for="souvenir" class="col-form-label"> 
                               			<input id="souvenir" name="souvenir" type="checkbox">
                               			<span class="pl-2">Se souvenir de moi</span>
                               		</label><br>
                                	<a href="#">Mot de passe oublié</a>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="col-12 text-center pt-5 eni-col-nvCompte">
                    	<a href="#">
	                    	<button class="btn-success btn-lg btn-block eni-btn-nvCompte">
	                    		Créer un compte
	                    	</button>
                    	</a>
                    </div>
                </div>
            </div>
        </div>
	
		<%@ include file="../partials/footer.jspf"%>
		<%@ include file="../partials/foot.jspf"%>
	</body>
</html>