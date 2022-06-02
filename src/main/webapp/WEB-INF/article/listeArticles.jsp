<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="fr">
	<jsp:include page='../partials/head.jsp'>
	    <jsp:param name="extraCSS" value='<%=request.getContextPath()+"/css/listEncheresStyle.css"%>' />
	    <jsp:param name="pageTitle" value='Accueil' />
	    <jsp:param name="pageDescription" value='Eni-Enchères' />
	</jsp:include>
	<body>	
		<jsp:include page='../partials/header.jsp'>
		    <jsp:param name="pageTitle" value='Encheres' />
		</jsp:include>
		
				<main class="py-5">
			
			<h1 class="text-center h3 mb-4">Liste des enchères</h1>
			
				<form class="container eni-filtresEncheres" action="" method="get">		
				
					<div>Filtres : </div>
					
					<div class="col-md-10 col-lg-6 col-form-label col-form-label-lg">
 						<input type="search" id="recherche" name="recherche" class="form-control " placeholder="Le nom de l'article contient">
 					</div>
 					
					<div class="row">
						<div class = "col-lg-3 col-md-4 col-form-label" style="font-size: large"> Categorie </div>
						<div class= "col-lg-3 col-md-6  col-form-label "> 
							<select class="custom-select custom-select-md mb-3">
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
								
						<div class="row" >		
							<div class = "col-sm-6 col-lg-4 form-check"> 
								<input type="radio" class="option" value="achat" name="radio" id="achat" checked  > 
								  <label for="achat" class="subOption form-check-label">Achats</label><br>
									<div class="form-check">
									  <input type="checkbox" value="ouvertes" name="encheresOuvertes" id="encheresOuvertes" checked> 
								 		<label for="encheresOuvertes" class="subOption form-check-label">enchères ouvertes</label>
								 		<br>
									  <input type="checkbox" value="enCours" name="encheresEnCours" id="encheresEnCours">
								 		<label for="encheresEnCours" class="subOption form-check-label"> mes enchères en cour</label>
								 		<br>
									  <input type="checkbox" value="remportees" name="encheresRemportees" id="encheresRemportees"> 
								 		<label for="encheresRemportees" class="form-check-label"> mes enchères remportées</label>
								 		<br>
									 </div>
							 	</div>
						
							<div class = "col-sm-6 col-md-4 "> 
						   	   	<input type="radio" value="ventes" name="radio" id="ventes" >
						   	   	<label for="ventes" class="option form-check-label">Mes ventes</label><br>
						   	   		<div class="form-check">
						   		 	  <input type="checkbox" value="enCours" name="venteEnCours" id="venteEnCours">
						   		 		<label for="venteEnCours" class="subOption form-check-label"> mes ventes en cours</label>
						   		 		<br>
						    		 <input type="checkbox" value="noDebutées" name="ventenoDebutées" id="ventenoDebutées">
						    	 	 	<label for="ventenoDebutées" class="subOption form-check-label"> ventes non débutées</label>
						    	 	 	<br>
									 <input type="checkbox" value="terminées"name="venteTerminées" id="venteTerminées">  
								 		<label for="venteTerminées"class="subOption form-check-label"> ventes terminées</label>
								 		<br>
								 	</div>
							</div>
								
						<div align="center" class="col-sm-8 col-md-8 col-lg-4">
						<button type="submit" class="btn btn-primary btn-lg" >Rechercher</button>
						</div>
						</div>
				</form>	
				
				  
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
									        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
									        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
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
								        <p class="card-text">This is a wider card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>
								        <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>
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
		<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	</body>
</html>