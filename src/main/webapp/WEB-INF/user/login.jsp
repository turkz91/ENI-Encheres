<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html lang="fr">

	<jsp:include page='../partials/head.jsp'>
	    <jsp:param name="extraCSS" value='<%=request.getContextPath()+"/css/login.css"%>' />
	    <jsp:param name="pageTitle" value='Login' />
	    <jsp:param name="pageDescription" value='Page liste des enchères pour Eni-Enchères' />
	</jsp:include>

	<body>	
		
		<jsp:include page='../partials/header.jsp'>
		    <jsp:param name="pageTitle" value='Login' />
		</jsp:include>	
		
		<main class="container py-5">
			<div class="row justify-content-center align-items-center">
				<div class="col-12 col-md-7 col-lg-5">
					<div class="col-12 pb-5">
						<%
						@SuppressWarnings("unchecked")
						List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
						if (listeCodesErreur != null) {
						%>
						<p class="text-center text-danger">
							Erreur, nom d'utilisateur ou mot de passe est invalide.
						</p>
						<%
						for (int codeErreur : listeCodesErreur) {
						%>
						<p class="text-center"><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
						<%
						}
						}
						%>
						<form class="form"
							action="<%=request.getContextPath()%>/login"
							method="post">
							<div class="form-row pb-2">
								<label for="username"
									class="col-5 col-form-label col-form-label-lg">Identifiant:</label>
								<div class="col-7">
									<input type="text" name="username" id="username"
										class="form-control">
								</div>
							</div>
							<div class="form-row py-2">
								<label for="motDePasse"
									class="col-5 col-form-label col-form-label-lg eni-lbl-login">Mot
									de Passe:</label><br>
								<div class="col-7">
									<input type="password" name="motDePasse" id="motDePasse"
										class="form-control">
								</div>
							</div>
							<div class="form-row pt-3">
								<div class="col-5">
									<input type="submit" name="submit"
										class="btn-success btn-lg btn-block eni-btn-connexion"
										value="Connexion">
								</div>
								<div class="col-7 text-right">
									<label for="souvenir" class="col-form-label"> <input
										id="souvenir" name="souvenir" type="checkbox"> <span
										class="pl-2">Se souvenir de moi</span>
									</label><br> <a href="#">Mot de passe oublié</a>
								</div>
							</div>
						</form>
					</div>
					<div class="col-12 text-center pt-4 eni-col-nvCompte">
						<a class="btn-success btn-lg btn-block mx-auto eni-btn-nvCompte" 
						  href="<%=request.getContextPath()%>/inscription-utilisateur">
							Créer un compte
						</a>
					</div>
				</div>
			</div>
		</main>	
    
		<%@ include file="../partials/footer.jspf"%>
		<%@ include file="../partials/foot.jspf"%>
	</body>

</html>