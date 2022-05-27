<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<% 
	String pageTitle = "Inscription";
	%>
	<%@ include file="../partials/head.jspf"%>

	<body>
	<%@ page
		import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>
		
		<%@ include file="../partials/header.jspf"%>
		
		<% if(session.getAttribute("user") != null) {%>
		<section>
			<h2>TEST de récupération des paramètres</h2>
			<p>Le pseudo saisi :  Le prénom
				saisi : ${ !empty prenom ? prenom : '' } Le nom saisi : ${ !empty nom ? nom : '' }
				L'email saisi : ${ !empty email ? email : '' } Le telephone saisi : ${ !empty telephone ? telephone : '' }
				La rue saisi : ${ !empty rue ? rue : '' } La ville saisi : ${ !empty ville ? ville : '' }
				Le code postal saisi : ${ !empty codePostal ? codePostal : '' } Le mot
				de passe saisi : ${ !empty motDePasse ? motDePasse : '' } La
				confirmation saisi : ${ !empty confirmation ? confirmation : '' }</p>
		</section>
		<% } %>
		<main class="py-5">
			
			<h1 class="text-center h3 mb-4">
				<% if(session.getAttribute("user") != null) {%>
				Créer un compte
				<% }else {%>
				Compte Utilisateur
				<% } %>
			</h1>
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
			<form class="container eni-compteAction" action="<%=request.getContextPath()%>/Inscription" method="post">
				
 				<div class="form-row justify-content-center mb-3"> 
					<label for="pseudo" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Pseudo : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="pseudo" name="pseudo" class="form-control" value="${ !empty pseudo ? pseudo : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="nom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Nom : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="nom" name="nom" class="form-control" value="${ !empty nom ? nom : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="prenom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Prénom : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="prenom" name="prenom" class="form-control" value="${ !empty prenom ? prenom : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="email" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Email : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="email" id="email" name="email" class="form-control" value="${ !empty email ? email : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="telephone" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Téléphone : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="telephone" name="telephone" class="form-control" value="${ !empty telephone ? telephone : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="rue" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Rue : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="rue" name="rue" class="form-control" value="${ !empty rue ? rue : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="code-postal" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Code Postal : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="code-postal" name="code-postal" class="form-control" value="${ !empty codePostal ? codePostal : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="ville" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Ville : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="ville" name="ville" class="form-control" value="${ !empty ville ? ville : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="mot-de-passe" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg eni-mdp-label">Mot de passe : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="password" id="mot-de-passe" name="mot-de-passe" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="confirmation" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg eni-mdp-label">Confirmation : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="password" id="confirmation" name="confirmation" class="form-control">
					</div>
				</div>
				
				<div class="form-row justify-content-center eni-form-footer pb-5 pt-4">
					<div class="col-5 col-md-4 col-lg-3 text-center pb-4">
						<input class="btn btn-success btn-lg btn-block" type="submit" value="Créer">	
					</div>
					<div class="col-1"></div>
					<div class="col-5 col-md-4 col-lg-3 text-center pb-4">
						<a class="btn btn-danger btn-lg btn-block" href="#">Annuler</a>
					</div>
				</div>
	
			</form>
		</main>
		
		
		<%@ include file="../partials/footer.jspf"%>
		<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	</body>
</html>