<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
<jsp:include page='../partials/head.jsp'>
	<jsp:param name="extraCSS"
		value='<%=request.getContextPath() + "/css/listArticles.css"%>' />
	<jsp:param name="pageTitle" value='Accueil' />
	<jsp:param name="pageDescription" value='Eni-Enchères' />
</jsp:include>
<body>
	<jsp:include page='../partials/header.jsp'>
		<jsp:param name="pageTitle" value='Encheres' />
	</jsp:include>

	<main class="py-5">

		<h1 class="text-center h3 mb-4">Liste des enchères</h1>

		<div class="container">
			<h3 class="h4">Filtres :</h3>
			<form action="<%=request.getContextPath()%>/compte" method="post">
				<div class="row align-items-center mb-5">
					<div class="col-12 col-md-6">
						<div class="form-row">
							<input type="search" id="recherche" name="recherche"
								class="form-control " placeholder="Le nom de l'article contient">
						</div>
						<div class="form-row align-items-center mt-3">
							<label for="nom"
								class="col-5 col-sm-4 col-lg-3 col-form-label col-form-label-lg">
								Catégorie : </label> <select
								class="col-6 col-md-4 col-lg-6 custom-select custom-select-md">
								<c:if test="${empty listeCategories}">
									<option selected>ERREUR</option>
								</c:if>

								<c:if test="${!empty listeCategories}">
									<option selected>Toutes</option>
									<c:forEach var="categorie" items="${listeCategories}">
										<option value="${categorie.no_categorie}">${categorie.libelle}</option>
									</c:forEach>
								</c:if>
							</select>
						</div>
					</div>
					<div class="col-12 col-md-5">
						<button type="submit" class="btn btn-lg btn-block eni-btn-rechercher eni-hover-pointer">Rechercher</button>
					</div>
				</div>
			</form>
			<div class="row">
				<div class="card mb-3" style="max-width: 500px;">
							<div class="row g-1">
								<div class="col-md-4">
									<img src="..." class="img-fluid rounded-start" alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h5 class="card-title">${listeAIU.nom_article}</h5>
										<p class="card-text">${listeAIU.description}</p>
										<p class="card-text">
											<small class="text-muted">Fin de l'enchère :
												${listeAIU.date_fin_encheres}
											</small>
										</p>		
		<!--TODO RECUPERER PSEUDO VENDEUR  -->
										<p>Vendeur : ${listeAIU.pseudo}</p>		
									</div>
								</div>
							</div>
						</div>
				
				<c:if test="${!empty listeArticles}">		
					<c:forEach var="article" items="${listeArticles}">		
						
						<div class="card mb-3" style="max-width: 800px;">
							<div class="row g-1">
								<div class="col-md-4">
									<img src="..." class="img-fluid rounded-start" alt="...">
								</div>
								<div class="col-md-8">
									<div class="card-body">
										<h5 class="card-title">${article.key.nom_article}</h5>
										<p class="card-text">${article.key.description}</p>
										<p class="card-text">
											<small class="text-muted">Fin de l'enchère :
												${article.key.date_fin_encheres}
											</small>
										</p>		
										<p>Vendeur : ${article.value[0]}</p>		
									</div>
								</div>
							</div>
						</div>
								
					</c:forEach>		
				</c:if>
				
			</div>
		</div>
			


		<section id="encheres">
			<div class="container mt-5">
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
</html>