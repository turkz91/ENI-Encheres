<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">

	<jsp:include page='../partials/head.jsp'>
	    <jsp:param name="extraCSS" value='<%=request.getContextPath()+"/css/inscription.css"%>' />
	    <jsp:param name="pageTitle" value='Inscription' />
	    <jsp:param name="pageDescription" value='Page inscription pour Eni-Enchères' />
	</jsp:include>

	<body>
	<%@ page
		import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>
		
		<jsp:include page='../partials/header.jsp'>
		    <jsp:param name="pageTitle" value='Inscription' />
		</jsp:include>
		<main class="py-5">
			
			<h1 class="text-center h3 mb-4">
				Inscription Utilisateur
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
			<form class="container eni-compteAction" action="<%=request.getContextPath()%>/nouveau-compte" method="post">
				
 				<div class="form-row justify-content-center mb-3"> 
					<label for="pseudo" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Pseudo : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="pseudo" name="pseudo" class="form-control" value="${ !empty requestScope.user.pseudo ? requestScope.user.pseudo : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="nom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Nom : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="nom" name="nom" class="form-control" value="${ !empty requestScope.user.nom ? requestScope.user.nom : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="prenom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Prénom : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="prenom" name="prenom" class="form-control" value="${ !empty requestScope.user.prenom ? requestScope.user.prenom : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="email" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Email : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="email" id="email" name="email" class="form-control" value="${ !empty requestScope.user.email ? requestScope.user.email : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="telephone" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Téléphone : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="telephone" name="telephone" class="form-control" value="${ !empty requestScope.user.telephone ? requestScope.user.telephone : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="rue" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Rue : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="rue" name="rue" class="form-control" value="${ !empty requestScope.user.rue ? requestScope.user.rue : '' }">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="code-postal" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Code Postal : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="code-postal" name="code-postal" class="form-control" value="${ !empty requestScope.user.code_postal ? requestScope.user.code_postal : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="ville" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Ville : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="ville" name="ville" class="form-control" value="${ !empty requestScope.user.ville ? requestScope.user.ville : '' }">
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