<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html lang="fr">
	<jsp:include page='../partials/head.jsp'>
	    <jsp:param name="extraCSS" value='<%=request.getContextPath()+"/css/inscription.css"%>' />
	    <jsp:param name="pageTitle" value='Compte' />
	    <jsp:param name="pageDescription" value='Profile compte pour Eni-Enchères' />
	</jsp:include>

	<body>
	<%@ page
		import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>
				
		<jsp:include page='../partials/header.jsp'>
		    <jsp:param name="pageTitle" value='Compte' />
		</jsp:include>	
		<main class="py-3">
			
			<h1 class="text-center h3 mb-4">
				Information Compte - ${ !empty sessionScope.user.pseudo ? sessionScope.user.pseudo : '' }
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
			<form class="container eni-compteAction" action="<%=request.getContextPath()%>/compte" method="post">
				
 				<div class="form-row align-items-center justify-content-center mb-3"> 
					<label for="pseudo" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Pseudo : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="pseudo" name="pseudo" class="form-control" value="${ !empty sessionScope.user.pseudo ? sessionScope.user.pseudo : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="nom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Nom : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="nom" name="nom" class="form-control" value="${ !empty sessionScope.user.nom ? sessionScope.user.nom : '' }">
					</div>
				</div>
				
				<div class="form-row align-items-center justify-content-center mb-3">
					<label for="prenom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Prénom : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="prenom" name="prenom" class="form-control" value="${ !empty sessionScope.user.prenom ? sessionScope.user.prenom : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="email" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Email : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="email" id="email" name="email" class="form-control" value="${ !empty sessionScope.user.email ? sessionScope.user.email : '' }">
					</div>
				</div>
				
				<div class="form-row align-items-center justify-content-center mb-3">
					<label for="telephone" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Téléphone : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="telephone" name="telephone" class="form-control" value="${ !empty sessionScope.user.telephone ? sessionScope.user.telephone : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="rue" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Rue : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="rue" name="rue" class="form-control" value="${ !empty sessionScope.user.rue ? sessionScope.user.rue : '' }">
					</div>
				</div>
				
				<div class="form-row align-items-center justify-content-center mb-3">
					<label for="code-postal" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Code Postal : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="code-postal" name="code-postal" class="form-control" value="${ !empty sessionScope.user.code_postal ? sessionScope.user.code_postal : '' }">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label for="ville" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Ville : </label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="text" id="ville" name="ville" class="form-control" value="${ !empty sessionScope.user.ville ? sessionScope.user.ville : '' }">
					</div>
				</div>
				
				<div class="form-row align-items-center justify-content-center mb-3">
					<label for="ancien-mot-de-passe" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg eni-mdp-label">Mot de passe actuel:</label>
					<div class="col-6 col-md-4 col-lg-3">
						<input type="password" id="ancien-mot-de-passe" name="ancien-mot-de-passe" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label class="col-5 col-sm-4 col-lg-2"></label>				
					<div class="col-6 col-md-4 col-lg-3">
					</div>
				</div>
				
				<div class="form-row align-items-center justify-content-center mb-3">
					<label for="mot-de-passe" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg eni-mdp-label">Nouveau mot de passe:</label>
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
				
				<div class="form-row align-items-center justify-content-center mb-3">
					<label for="mot-de-passe" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg eni-mdp-label">
						Crédit : ${ !empty sessionScope.user.credit ? sessionScope.user.credit : '' }
					</label>
					<div class="col-6 col-md-4 col-lg-3"></div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-md-block col-lg-1"></div>
					<label class="col-5 col-sm-4 col-lg-2"></label>
					<div class="col-6 col-md-4 col-lg-3">
					</div>
				</div>
				
				<div class="form-row align-items-center justify-content-center eni-form-footer pb-5 pt-4">
					<div class="col-5 col-md-4 col-lg-3 text-center pb-4">
						<input class="btn btn-success btn-lg btn-block" type="submit" value="Enregistrer">	
					</div>
					<div class="col-1"></div>
					<div class="col-5 col-md-4 col-lg-3 text-center pb-4">
						<a class="btn btn-danger btn-lg btn-block" 
						 onclick="return confirm('Êtes vous sur de vouloir supprimer vôtre compte?');" 
						 href="#" >
						 	Supprimer mon compte
						</a>
					</div>
				</div>
	
			</form>
		</main>
		
		
		<%@ include file="../partials/footer.jspf"%>
		<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	</body>
</html>