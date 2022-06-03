<%@page import="fr.eni.encheres.bo.ArticleVendu"%>
<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<jsp:include page='../partials/head.jsp'>
	<jsp:param name="extraCSS"
		value='<%=request.getContextPath() + "/css/listEncheresStyle.css"%>' />
	<jsp:param name="pageTitle" value='Vente' />
	<jsp:param name="pageDescription"
		value='Vente Article pour Eni-Enchères' />
</jsp:include>

<link href="<%=request.getContextPath()%>/css/detailVente.css"
	rel="stylesheet">

</head>


<body>
	<jsp:include page='../partials/header.jsp'>
		<jsp:param name="pageTitle" value='Vente' />
	</jsp:include>

	<main clas  s="py-3">

		<h1 class="text-center h3 mb-4">Détail vente</h1>

		<div class="container-fluid eni-detailVente">
			<div class="row">
				<div class="col-md-3">
					<img
						src="<%=request.getContextPath()%>/images/articles/articleTest.png"
						class="img-fluid rounded-start mt-2" alt="...">
				</div>
				<div class="col-md-8">
					<div class="row">
						<label for="nom"
							class="col-sm-7  col-form-label col-form-label-lg"><% 
							if(request.getAttribute("articleVendu") != null) {
							ArticleVendu articleVendu = request.getAttribute("articleV");
							}
							%>Nom
							Article </label> <label for="nom"
							class="col-sm-1 col-form-label col-form-label-lg"> </label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Description
							: </label> <label for="nom"
							class="col-sm-5 col-md-7 col-lg-6 col-form-label col-form-label-lg">
							Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi
							elementum ornare erat. Duis luctus mi at diam cursus vestibulum.
							Fusce ac enim id diam auctor gravida non sit amet. </label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Catégorie
							: </label> <label for="nom"
							class="col-sm-5 col-md-6 col-form-label col-form-label-lg">
						</label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Meilleure
							offre : </label> <label for="nom"
							class="col-sm-5 col-md-6 col-form-label col-form-label-lg">
						</label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Mise
							à prix : : </label> <label for="nom"
							class="col-sm-5 col-md-6 col-form-label col-form-label-lg">
						</label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Fin
							de l'enchère : </label> <label for="nom"
							class="col-sm-5 col-md-6 col-form-label col-form-label-lg">
						</label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Retrait:
						</label> <label for="nom"
							class="col-sm-5 col-md-6 col-form-label col-form-label-lg"></label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg" id="vendeur">Vendeur
							: </label> <label for="nom"
							class="col-sm-5 col-md-6 col-form-label col-form-label-lg">
						</label>
					</div>
					<div class="row">
						<label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Ma
							proposition: </label>
						<div class="col-sm-1 col-md-2 col-form-label col-form-label-lg">
							<input type="number" id="prix_initial" name="prix_initial"
								min="0" class="form-control">
						</div>
						<div class="col-sm-1 col-md-2 col-form-label col-form-label-lg">
							<button type="submit" id=""class="btn btn-success">Enchérir</button>
						</div>
					</div>



				</div>


</div>
</div>
</main>


				<%@ include file="/WEB-INF/partials/footer.jspf"%>
</body>
</html>