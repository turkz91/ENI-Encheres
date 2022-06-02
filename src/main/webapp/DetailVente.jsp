<%@page import="javax.swing.text.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<% 
	String pageTitle = "Detail Vente";
	%>
	<%@ include file="/WEB-INF/partials/head.jspf"%>
	
		<link href="<%=request.getContextPath()%>/css/detailVente.css" rel="stylesheet">
	
	</head>
	
	
	<body>	
		<%@ include file="/WEB-INF/partials/header.jspf"%>
		
			<main class="py-3">
			
			<h1 class="text-center h3 mb-4">Détail vente</h1>

			<div class="container-fluid eni-detailVente">
			  <div class="row">
				<div class="col-md-3">
				   <img src="<%=request.getContextPath()%>/images/articles/articleTest.png" class="img-fluid rounded-start mt-2" alt="...">
				</div>
				<div class="col-md-8">
					<div class="row">
				 		 <label for="nom" class="col-sm-7  col-form-label col-form-label-lg">Nom Article  </label>
				 		 <label for="nom" class="col-sm-1 col-form-label col-form-label-lg"> </label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Description : </label>
				 		 <label for="nom" class="col-sm-5 col-md-7 col-lg-6 col-form-label col-form-label-lg"> Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi elementum ornare erat. Duis luctus mi at diam cursus vestibulum. Fusce ac enim id diam auctor gravida non sit amet.  </label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Catégorie : </label>
				 		 <label for="nom" class="col-sm-5 col-md-6 col-form-label col-form-label-lg">  </label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Meilleure offre : </label>
				 		 <label for="nom" class="col-sm-5 col-md-6 col-form-label col-form-label-lg">  </label>
				 	</div>
				 		<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Mise à prix : : </label>
				 		 <label for="nom" class="col-sm-5 col-md-6 col-form-label col-form-label-lg"> </label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Fin de l'enchère : </label>
				 		 <label for="nom" class="col-sm-5 col-md-6 col-form-label col-form-label-lg"> </label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Retrait:  </label>
				 		 <label for="nom" class="col-sm-5 col-md-6 col-form-label col-form-label-lg"></label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Vendeur :  </label>
				 		 <label for="nom" class="col-sm-5 col-md-6 col-form-label col-form-label-lg"> </label>
				 	</div>
				 	<div class="row">
				 		 <label for="nom" class="col-sm-3 col-form-label col-form-label-lg">Ma proposition:  </label>
				 		 <div class="col-sm-1 col-md-2 col-form-label col-form-label-lg"> 
						 <input type="number" id="prix_initial" name="prix_initial" min="0" class="form-control">
						 </div>
						 <div class="col-sm-1 col-md-2 col-form-label col-form-label-lg"> 
						 <button type="submit" class="btn btn-success"> Enchérir</button>
						</div>
						</div>
				 	
				 	
				
			</div>
			




	<%@ include file="/WEB-INF/partials/footer.jspf"%>
</body>
</html>