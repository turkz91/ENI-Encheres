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
			<h2 class="h4">Filtres :</h2>
			<form action="<%=request.getContextPath()%>/" method="post">
				<div class="row align-items-center mb-5">
					<div class="col-12 col-md-6">
						<div class="form-row">
							<input type="search" id="recherche" name="recherche"
								class="form-control " placeholder="Le nom de l'article contient">
						</div>
						<div class="form-row align-items-center mt-3">
							<label for="categorie"
								class="col-5 col-sm-4 col-lg-3 col-form-label col-form-label-lg">
								Catégorie : 
							</label>
							<select
								class="col-6 col-md-4 col-lg-6 custom-select custom-select-md"
								name="categorie" id="categorie">
								
								<c:if test="${empty listeCategories}">
									<option value="" selected>ERREUR</option>
								</c:if>

								<c:if test="${!empty listeCategories}">
									<option ${empty selectedCategorie ? 'selected' : '' } value="toutes">Toutes</option>
									<c:forEach var="categorie" items="${listeCategories}">
										
										<option value="${categorie.no_categorie}"
										  ${selectedCategorie == categorie.no_categorie ? 'selected' : '' }>
										  ${categorie.libelle}
										</option>										
										
									</c:forEach>
								</c:if>
								
							</select>
						</div>
						<c:if test="${!empty user}">
							<div class="form-row mt-4">
								<div class="col-6" id="listeRadiosAchat">
									<div class="row text-right" id="buttonRadioAchat">
										<input type="radio" value="radioAchats" name="radioAchats"
											id="radioAchats" checked> 
										<label
											for="radioAchats" class="option form-check-label">Achats
										</label>
									</div>
									<div class="row">
										<div class="col-1"></div>
										<div class="col-11">
											<input
												type="checkbox" value="achatsActifs" name="achatsCheck"
												id="achatsActifs" checked>
											<label
												for="achatsActifs" class="form-check-label">
												enchères ouvertes
											</label>
										</div>
									</div>
									<div class="row">
										<div class="col-1"></div>
										<div class="col-11">
											<input 
												type="checkbox" value="encheresActifs" name="achatsCheck"
												id="encheresActifs">
											<label
												for="encheresActifs" class="form-check-label">
												mes enchères en cours
											</label>
										</div>
									</div>
									<div class="row">
										<div class="col-1"></div>
										<div class="col-11">
											<input
												type="checkbox" value="encheresFinis" name="achatsCheck"
												id="encheresFinis">
											<label
												for="encheresFinis" class="form-check-label">
												mes enchères remportées
											</label>
										</div>
									</div>
								</div>
								<div class="col-6" id="listeRadiosVente">
									<div class="row">
										<div class="row text-right" id="buttonRadioVente">
											<input type="radio" value="radioVentes" name="radioVentes"
												id="radioVentes" onchange="radioDisable()"> 
											<label
												for="radioVentes" class="option form-check-label">Mes Ventes
											</label>
										</div>
									</div>
									<div class="row">
										<div class="col-1"></div>
										<div class="col-11">
											<input disabled="disabled"
												type="checkbox" value="ventesActifs" name="ventesCheck"
												id="ventesActifs">
											<label
												for="ventesActifs" class="form-check-label">
												mes ventes en cours
											</label>
										</div>
									</div>
									<div class="row">								
										<div class="col-1"></div>
										<div class="col-11">
											<input disabled="disabled"
												type="checkbox" value="ventesInactifs" name="ventesCheck"
												id="ventesInactifs">
											<label
												for="ventesInactifs" class="form-check-label">
												ventes non débutées
											</label>
										</div>
									</div>
									<div class="row">
										<div class="col-1"></div>
										<div class="col-11">
											<input disabled="disabled"
												type="checkbox" value="ventesActifs" name="ventesCheck"
												id="ventesFinis">
											<label
												for="ventesFinis" class="form-check-label">
												ventes terminées
											</label>
										</div>
									</div>
								</div>
							</div>
						</c:if>
					</div>
					<div class="col-12 col-md-5 mt-3">
						<button type="submit" class="btn btn-lg btn-block eni-btn-rechercher eni-hover-pointer">Rechercher</button>
					</div>
				</div>
			</form>
			<div class="row">
				
				<c:if test="${!empty listeArticles}">
					<c:forEach var="article" items="${listeArticles}">		
						
						<div class="col-12 col-md-6 my-3">
							<div class="card">
								<div class="row">
									<div class="col-md-4 m-auto formArticle">
										<img
											src="<%=request.getContextPath()%>/images/articles/articleTest.png"
											class="img-fluid rounded-start mx-3">
										<form action="<%=request.getContextPath()%>/article/detail"
														method="post">
											<input type="hidden" value="${article.key.no_article}" name="no_article">													
										
										</form>
									</div>
									<div class="col-md-8">
										<div class="card-body">
											<p class="card-title h3  formArticle">${article.key.nom_article}</p>
											<p class="card-text  formArticle">Prix : 
											  ${ article.key.prix_vente != 0 ? article.key.prix_vente : article.key.prix_initial } points
											 </p>
											<p class="card-text formArticle">
												Fin de l'enchère :
													${article.key.date_fin_encheres}
												
											</p>
											<c:choose>
												<c:when test="${!empty user}">
													<form action="<%=request.getContextPath()%>/compte"
														method="post">
														<input type="hidden" value="${article.value[1]}" name="no_utilisateur">														
														<p class="formConfirm"><span class="font-weight-bold">Vendeur :</span> <span class="font-italic text-info"> ${article.value[0]}</span></p>									
													</form>
												</c:when>
												<c:otherwise>		
													<p><span class="font-weight-bold">Vendeur</span> : <span class="font-italic text-info">${article.value[0]}</span></p>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</div>
								
					</c:forEach>		
				</c:if>
				
			</div>
		</div>			

	</main>

	<%@ include file="/WEB-INF/partials/footer.jspf"%>
	<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath()%>/js/eniScripts.js"></script>
</body>
</html>