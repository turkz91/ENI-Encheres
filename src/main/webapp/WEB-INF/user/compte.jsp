<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="fr">
<jsp:include page='../partials/head.jsp'>
	<jsp:param name="pageTitle" value='Compte' />
	<jsp:param name="pageDescription"
		value='Profile compte pour Eni-Enchères' />
</jsp:include>

<body>
	<%@ page
		import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>

	<jsp:include page='../partials/header.jsp'>
		<jsp:param name="pageTitle" value='Compte' />
	</jsp:include>
	
	<main class="container py-5">
		<div class="row justify-content-center align-items-center">
			<div class="col-12 col-md-7 col-lg-5">
				<div class="col-12 pb-5">				
							<div class="form-row pb-2">
								<label for="pseudo"
									class="col-5 col-form-label col-form-label-lg">Pseudo:</label>
								<div class="col-7">
									<input type="text" name="pseudo" id="pseudo"
										class="form-control"
										value="${ !empty sessionScope.user.pseudo ? sessionScope.user.pseudo : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="nom"
									class="col-5 col-form-label col-form-label-lg">Nom:</label>
								<div class="col-7">
									<input type="text" name="nom" id="nom"
										class="form-control"
										value="${ !empty sessionScope.user.nom ? sessionScope.user.nom : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="prenom"
									class="col-5 col-form-label col-form-label-lg">Prénom:</label>
								<div class="col-7">
									<input type="text" name="prenom" id="prenom"
										class="form-control"
										value="${ !empty sessionScope.user.prenom ? sessionScope.user.prenom : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="email"
									class="col-5 col-form-label col-form-label-lg">Email:</label>
								<div class="col-7">
									<input type="text" name="email" id="email"
										class="form-control"
										value="${ !empty sessionScope.user.email ? sessionScope.user.email : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="telephone"
									class="col-5 col-form-label col-form-label-lg">Téléphone:</label>
								<div class="col-7">
									<input type="text" name="telephone" id="telephone"
										class="form-control"
										value="${ !empty sessionScope.user.telephone ? sessionScope.user.telephone : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="rue"
									class="col-5 col-form-label col-form-label-lg">Rue:</label>
								<div class="col-7">
									<input type="text" name="rue" id="rue"
										class="form-control"
										value="${ !empty sessionScope.user.rue ? sessionScope.user.rue : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="code-postal"
									class="col-5 col-form-label col-form-label-lg">Code Postal:</label>
								<div class="col-7">
									<input type="text" name="code-postal" id="code-postal"
										class="form-control"
										value="${ !empty sessionScope.user.code_postal ? sessionScope.user.code_postal : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row py-2">
								<label for="ville"
									class="col-5 col-form-label col-form-label-lg">Ville:</label>
								<div class="col-7">
									<input type="text" name="ville" id="ville"
										class="form-control"
										value="${ !empty sessionScope.user.ville ? sessionScope.user.ville : '' }"
										 readonly >
								</div>
							</div>
							
							<div class="form-row justify-content-center pt-3">
								<div class="col-5">
									<a class="btn-success btn-lg btn-block text-center eni-btn-update"
										href="<%=request.getContextPath()%>/compte/update">
										Modifier
									</a>
								</div>
							</div>
				</div>
			</div>
		</div>
	</main>
	
		<%@ include file="../partials/footer.jspf"%>
		<%@ include file="../partials/foot.jspf"%>
	</body>
</html>