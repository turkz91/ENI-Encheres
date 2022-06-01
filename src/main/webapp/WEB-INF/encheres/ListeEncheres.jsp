<%@page import="javax.swing.text.Document"%>
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
		
		<%@ include file="../partials/head.jspf"%>
		
				<main class="py-5">
			
			<h1 class="text-center h3 mb-4">Liste des enchères</h1>
			
				<form class="container eni-filtresEncheres" action="" method="get">		
				
					<div>Filtres : </div>
					
					<div class="col-md-10 col-lg-6 col-form-label col-form-label-lg">
 						<input type="search" id="recherche" name="recherche" class="form-control "  placeholder="Le nom de l'article contient">
 						
 					</div>
 					
					<div class="row">
						<div class = "col-lg-3 col-md-4 col-form-label" style="font-size: large"> Categorie </div>
						<div class= "col-lg-3 col-md-6  col-form-label "> 
							<select class="custom-select custom-select-md mb-3" name="selectCategorie">
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
								<input type="radio" class="option" value="achat" name="rechercheEnchere" id="radioAchat" onclick="enableCheckbox()" > 
								  <label for="achat" class="subOption form-check-label" >Achats</label><br>
									<div class="form-check">
									  <input type="checkbox" value="ouvertes" name="checkAchat" id="achatsOuveres"> 
								 		<label for="encheresOuvertes" class="subOptionA form-check-label">enchères ouvertes</label>
								 		<br>
									  <input type="checkbox" value="enCours" name="checkAchat"id="achatsEnCours">
								 		<label for="encheresEnCours" class="subOptionA form-check-label"> mes enchères en cour</label>
								 		<br>
									  <input type="checkbox" value="remportees" name="checkAchat"id="achatsRemportes"> 
								 		<label for="encheresRemportees" class="subOptionA form-check-label"> mes enchères remportées</label>
								 		<br>
									 </div>
							 	</div>
						
							<div class = "col-sm-6 col-md-4 "> 
						   	   	<input type="radio" value="ventes" name="rechercheEnchere" id="radioVentes"  ">
						   	   	<label for="ventes" class="option form-check-label">Mes ventes</label><br>
						   	   		<div class="form-check">
						   		 	  <input type="checkbox" value="enCours" name="checkVentes" id="venteEnCours">
						   		 		<label for="venteEnCours" class="subOptionV form-check-label"> mes ventes en cours</label>
						   		 		<br>
						    		 <input type="checkbox" value="noDebutées" name="checkVentes" id="ventenoDebutées">
						    	 	 	<label for="ventenoDebutées" class="subOptionV form-check-label"> ventes non débutées</label>
						    	 	 	<br>
									 <input type="checkbox" value="terminées"name="checkVentes" id="venteTerminées">  
								 		<label for="venteTerminées"class="subOptionV form-check-label"> ventes terminées</label>
								 		<br>
								 	</div>
							</div>
						<div align="center" class="col-sm-10 col-md-10 col-lg-4">
						<button type="submit" class="btn btn-primary btn-lg" >Rechercher</button>
						</div>
						</div>
				</form>	
				
				  
				  <section id="encheres">
					<div class="container">
						<div class=row>
							<div class="card mb-3 mt-4 col-sm-10 col-md-5 col-lg-5  " style="width: 20rem;" id="cardAchat">
				 				 <div class="row g-1 ml-2">
				    				<div class="col-md-4">
				     					 <img src="<%=request.getContextPath()%>/images/articles/articleTest.png" class="img-fluid rounded-start img-thumbnail mt-4" alt="...">
				   					 </div>
				    				<div class="col-md-8">
				      					<div class="card-body">
				        					<p class="souligne mb-1"><u>Nom article</u></p>
									        <p class="card-text mb-2">Prix :</p>
									          <p class="card-text">Fin de l'enchere :</p>
									        <p class="card-text">Vendeur :</p>
									     </div>
									  </div>
				 				 </div>
				 			 </div>
							<div class="card mb-3 me-4 mt-4 ml-5  col-sm-10 col-md-5 col-lg-5" style="width: 28rem; id="cardVent"">
							 <div class="row g-1 ml-2">
				    				<div class="col-md-4">
				     					 <img src="<%=request.getContextPath()%>/images/articles/articleTest.png" class="img-fluid rounded-start img-thumbnail mt-4" alt="...">
				   					 </div>
				    				<div class="col-md-8">
				      					<div class="card-body">
				        					<p class="souligne" mb-2><u>Nom article</u></p>
									        <p class="card-text mb-2">Prix :</p>
									          <p class="card-text mb-1">Retrait : 10 alle des Alouettes 44800 Saint Herbain</p>
									        <p class="card-text">Vendeur :</p>
									        <p class="card-text">
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