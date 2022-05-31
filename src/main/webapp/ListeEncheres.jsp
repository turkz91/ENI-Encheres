<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Page liste des enchères">
		<meta name="author" content="co-authored by BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain">
		<title>Liste des Enchères</title>
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/faviconEni.ico">
		<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/faviconEni.png">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="<%=request.getContextPath()%>/css/eniStyle.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/inscription.css" rel="stylesheet">
		
		<link href="<%=request.getContextPath()%>/css/listEncheresStyle.css" rel="stylesheet">
	</head>
	<body>	
		<%@ include file="/WEB-INF/partials/header.jspf"%>
		
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
							   <option selected> Toutes</option>
							   <option value="Informatique">Informatique</option>
							   <option value="Ameublement">Ameublement</option>
							   <option value="Vetêment">Vetêment</option>
							   <option value="Sport">Sport&Loisirs</option>
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