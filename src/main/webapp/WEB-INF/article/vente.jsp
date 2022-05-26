<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Page d'inscription">
		<meta name="author" content="co-authored by BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain">
		<title>Nouvelle Vente</title>
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/faviconEni.ico">
		<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/faviconEni.png">
		<link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/eniStyle.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/inscription.css" rel="stylesheet">
	</head>
	<body>	
		<%@ include file="../partials/header.jspf"%>
		
		<% if(session.getAttribute("user") != null) {%>
		<section>
			<h2>TEST de récupération des paramètres</h2>
			<p>Le pseudo saisi : ${ !empty pseudo ? pseudo : "" } Le prénom
				saisi : ${ !empty prenom ? prenom : "" } Le nom saisi : ${ !empty nom ? nom : "" }
				L'email saisi : ${ !empty email ? email : "" } Le telephone saisi : ${ !empty telephone ? telephone : "" }
				La rue saisi : ${ !empty rue ? rue : "" } La ville saisi : ${ !empty ville ? ville : "" }
				Le code postal saisi : ${ !empty codePostal ? codePostal : "" } Le mot
				de passe saisi : ${ !empty motDePasse ? motDePasse : "" } La
				confirmation saisi : ${ !empty confirmation ? confirmation : "" }</p>
		</section>
		<% } %>
		<main class="py-5">
			
			<h1 class="text-center h2 mb-4">
				Nouvelle Vente
			</h1>
			<form class="container eni-venteAction" action="" method="post">
				
				<div class="row">
					<div class="col-lg-4"> 
						<img src="<%=request.getContextPath()%>/images/articles/articleTest.png" class="img-fluid img-thumbnail">
					</div>
					<div class="col-lg-8">
					 
		 				<div class="form-row mb-3"> 
							<label for="nom" class="col-5 col-sm-4 col-lg-3 col-form-label col-form-label-lg">Article : </label>
							<div class="col-6 col-md-4 col-lg-5">
								<input type="text" id="nom" name="nom" class="form-control">
							</div>
						</div>
						
						<div class="form-row mb-3">
							<label for="description" class="col-5 col-sm-4 col-lg-3 col-form-label col-form-label-lg">Description : </label>
							<div class="col-6 col-md-4 col-lg-5">
								<textarea id="description" name="description" class="form-control" rows="3"></textarea>
							</div>
						</div>
												
						<div class="form-row mb-3">
							<label for="categorie" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Catégorie : </label>
							<div class="col-6 col-md-4 col-lg-4">
								<select id="categorie" name="categorie" class="form-control">
									<option> 1 </option>
									<option> 2 </option>
									<option> 3 </option>
									<option> 4 </option>
								</select>
							</div>
						</div>
												
						<div class="form-row mb-3">
							<label for="photo" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Photo de l'article : </label>
							<div class="col-6 col-md-4 col-lg-4">
								<input type="file" id="photo" name="photo" class="form-control">
							</div>
						</div>
						
						<div class="form-row mb-3">
							<label for="prix_initial" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Mise à prix : </label>
							<div class="col-6 col-md-4 col-lg-2">
								<input type="number" id="prix_initial" name="prix_initial" min="0" class="form-control">
							</div>
						</div>
												
						<div class="form-row mb-3">
							<label for="debut_enchere" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Début de l'enchère:</label>
							<div class="col-6 col-md-4 col-lg-4">
								<input type="date" id="debut_enchere" name="debut_enchere" class="form-control">
							</div>
						</div>
						
						<div class="form-row mb-1">
							<label for="fin_enchere" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Fin de l'enchère :</label>
							<div class="col-6 col-md-4 col-lg-4">
								<input type="date" id="fin_enchere" name="fin_enchere" class="form-control">
							</div>
						</div>
						<label class="col-form-label col-form-label-lg h1 ml-4" style="font-size:1.5rem;">Retrait</label>						
						<div class="form-group col-9 border border-dark rounded">
							<div class="form-row my-3 ml-3">
								<label for="rue" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Rue : </label>
								<div class="col-6 col-md-4 col-lg-6">
									<input type="text" id="rue" name="rue" class="form-control">
								</div>
							</div>
							
							<div class="form-row mb-3 ml-3">
								<label for="code_postal" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Code postal : </label>
								<div class="col-6 col-md-4 col-lg-6">
									<input type="text" id="code_postal" name="code_postal" class="form-control">
								</div>
							</div>
							
							<div class="form-row mb-3 ml-3">
								<label for="ville" class="col-5 col-sm-4 col-lg-4 col-form-label col-form-label-lg">Ville : </label>
								<div class="col-6 col-md-4 col-lg-6">
									<input type="text" id="ville" name="ville" class="form-control">
								</div>
							</div>						
						</div>
						
						<div class="form-row eni-form-footer pb-5 pt-4">
							<div class="col-4 col-md-3 text-center pb-4">
								<input class="btn btn-success btn-lg btn-block" type="submit" value="Créer">	
							</div>
							<div class="col-4 col-md-3 ">
								<a class="btn btn-warning btn-lg btn-block" href="#">Annuler</a>
							</div>
							<div class="col-5 col-md-3 text-center pb-4">
								<a class="btn btn-danger btn-lg btn-block" href="#">Annuler la vente</a>
							</div>
						</div>
						
					</div>
				</div>
	
			</form>
		</main>
		
		
		<%@ include file="../partials/footer.jspf"%>
		<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	</body>
</html>