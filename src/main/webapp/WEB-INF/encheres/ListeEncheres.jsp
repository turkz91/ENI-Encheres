<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<jsp:include page='../partials/head.jsp'>
	<jsp:param name="extraCSS"
		value='<%=request.getContextPath() + "/css/listEncheresStyle.css"%>' />
	<jsp:param name="pageTitle" value='Encheres' />
	<jsp:param name="pageDescription" value='Eni-Enchères' />
</jsp:include>
<body>
	<%@ page
		import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.ArticleVendu, fr.eni.encheres.bo.Categorie"%>
	<jsp:include page='../partials/header.jsp'>
		<jsp:param name="pageTitle" value='Liste des enchères' />
	</jsp:include>


	<main class="py-5">

		<h1 class="text-center h3 mb-4">Liste des enchères</h1>

		<%
		@SuppressWarnings("unchecked")
		List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if (listeCodesErreur != null) {
		%>
		<p class="text-center text-danger">Erreur :</p>
		<%
		for (int codeErreur : listeCodesErreur) {
		%>
		<p class="text-center"><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%
		}
		}
		%>

		<form class="container eni-filtresEncheres"
			action="<%=request.getContextPath()%>/Encheres" method="post">

			<div>Filtres :</div>

			<div class="col-md-10 col-lg-6 col-form-label col-form-label-lg">
				<input type="search" id="recherche" name="recherche"
					class="form-control " placeholder="Le nom de l'article contient">
			</div>

			<div class="row">
				<div class="col-lg-3 col-md-4 col-form-label"
					style="font-size: large">Categorie</div>
				<div class="col-lg-3 col-md-6  col-form-label ">
					<select class="custom-select custom-select-md mb-3"
						name="selectCategorie">

						<c:if test="${empty listeCategories}">
							<option selected>ERREUR</option>
						</c:if>


						<c:if test="${!empty listeCategories}">
							<option selected>Toutes</option>
							<c:forEach var="categorie" items="${listeCategories}">
								<option>${categorie.libelle.toString()}</option>
							</c:forEach>
						</c:if>
					</select>
				</div>
			</div>



			<div class="row">
				<div class="col-sm-6 col-lg-4 form-check">
					<input type="radio" class="option" value="achat"
						name="rechercheEnchere" id="radioAchat" onchange="radioDisable()">
					<label for="achat" class="subOption form-check-label">Achats</label><br>
					<div class="form-check">
						<input disabled="disabled" type="checkbox" value="ouvertes"
							name="checkAchat" id="achatsOuveres"> <label
							for="encheresOuvertes" class="subOptionA form-check-label">enchères
							ouvertes</label> <br> <input disabled="disabled" type="checkbox"
							value="enCours" name="checkAchat" id="achatsEnCours"> <label
							for="encheresEnCours" class="subOptionA form-check-label">
							mes enchères en cour</label> <br> <input disabled="disabled"
							type="checkbox" value="remportees" name="checkAchat"
							id="achatsRemportes"> <label for="encheresRemportees"
							class="subOptionA form-check-label"> mes enchères
							remportées</label> <br>
					</div>
				</div>

				<div class="col-sm-6 col-md-4 ">
					<input type="radio" value="ventes" name="rechercheEnchere"
						id="radioVentes" onchange="radioDisable() "> <label
						for="ventes" class="option form-check-label">Mes ventes</label><br>
					<div class="form-check">
						<input disabled="disabled" type="checkbox" value="enCours"
							name="checkVentes" id="venteEnCours"> <label
							for="venteEnCours" class="subOptionV form-check-label">
							mes ventes en cours</label> <br> <input disabled="disabled"
							type="checkbox" value="noDebutées" name="checkVentes"
							id="ventenoDebutées"> <label for="ventenoDebutées"
							class="subOptionV form-check-label"> ventes non débutées</label>
						<br> <input disabled="disabled" type="checkbox"
							value="terminées" name="checkVentes" id="venteTerminées">
						<label for="venteTerminées" class="subOptionV form-check-label">
							ventes terminées</label> <br>
					</div>
				</div>
				<div align="center" class="col-sm-8 col-md-8 col-lg-4">
					<button type="submit" class="btn btn-primary btn-lg">Rechercher</button>
				</div>
			</div>
		</form>

		<c:if test="${empty listeArticles}">
			<p class="text-center text-danger">ERREUR les articles n'ont pas
				pu être récupérés</p>
		</c:if>
		<c:if test="${!empty listeArticles}">


			<c:forEach var="article" items="${listeArticles}">


				<div class="card mb-3" style="max-width: 500px;">
					<div class="row g-1">
						<div class="col-md-4">
							<img src="..." class="img-fluid rounded-start" alt="...">
						</div>
						<div class="col-md-8">
							<div class="card-body">
								<h5 class="card-title">${article.nom_article}</h5>
								<p class="card-text">${article.description}</p>
								<p class="card-text">
									<small class="text-muted">Fin de l'enchère :
										${article.date_fin_encheres}</small>
								</p>
<!-- 								TODO RECUPERER PSEUDO VENDEUR  -->
								<p>Vendeur : ${article.no_utilisateur}</p>
							</div>
						</div>
					</div>
				</div>

			</c:forEach>

		</c:if>

		<section id="encheres">
			<div class="container">
				<div class=row>
					<div class="card mb-3" style="max-width: 500px;">
						<div class="row g-1">
							<div class="col-md-4">
								<img src="..." class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title">Card title</h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.</p>
									<p class="card-text">
										<small class="text-muted">Last updated 3 mins ago</small>
									</p>
								</div>
							</div>
						</div>
					</div>
					<div class="card mb-3" style="max-width: 500px;">
						<div class="row g-2">
							<div class="col-md-4">
								<img src="..." class="img-fluid rounded-start" alt="...">
							</div>
							<div class="col-md-8">
								<div class="card-body">
									<h5 class="card-title"></h5>
									<p class="card-text">This is a wider card with supporting
										text below as a natural lead-in to additional content. This
										content is a little bit longer.</p>
									<p class="card-text">
										<small class="text-muted">Last updated 3 mins ago</small>
									</p>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>



	</main>

	<%@ include file="/WEB-INF/partials/footer.jspf"%>
	<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>
<script>>
	function enable(){
		var radio = document.getElementById("radioAchat");
		var checkV = document.getELementByName("checkVentes");
		var chackA = document.getELementByName("checkAchat");
		if(radio.checked){
			checkV.removeAttribute("disabled");
		}else{
			checkA.removeAttribute("disabled");
		}
	}
	</script>
</html>