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
		<title>Inscription</title>
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/faviconEni.ico">
		<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/faviconEni.png">
		<link href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/eniStyle.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/inscription.css" rel="stylesheet">
	</head>
	<body>	
		<%@ include file="partials/header.jspf"%>
		
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
		
		<main>
			<h1 class="text-center h3 mb-4">Créer un compte</h1>
			<form class="container" action="/Eni-Encheres/Inscription" method="post">
				
				<div class="form-row justify-content-center mb-3">
					<label for="pseudo" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Pseudo : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="pseudo" name="pseudo" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-lg-block col-lg-1"></div>
					<label for="nom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Nom : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="nom" name="nom" class="form-control">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="prenom" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Prénom : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="prenom" name="prenom" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-lg-block col-lg-1"></div>
					<label for="email" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Email : </label>
					<div class="col-6 col-lg-3">
						<input type="email" id="email" name="email" class="form-control">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="telephone" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Téléphone : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="telephone" name="telephone" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-lg-block col-lg-1"></div>
					<label for="rue" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Rue : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="rue" name="rue" class="form-control">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="code-postal" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Code Postal : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="code-postal" name="code-postal" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-lg-block col-lg-1"></div>
					<label for="ville" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Ville : </label>
					<div class="col-6 col-lg-3">
						<input type="text" id="ville" name="ville" class="form-control">
					</div>
				</div>
				
				<div class="form-row justify-content-center mb-3">
					<label for="mot-de-passe" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Mot de passe : </label>
					<div class="col-6 col-lg-3">
						<input type="password" id="mot-de-passe" name="mot-de-passe" class="form-control">
					</div>
					<div class="w-100 d-block d-md-none"></div>
					<div class="d-none d-lg-block col-lg-1"></div>
					<label for="confirmation" class="col-5 col-sm-4 col-lg-2 col-form-label col-form-label-lg">Confirmation : </label>
					<div class="col-6 col-lg-3">
						<input type="password" id="confirmation" name="confirmation" class="form-control">
					</div>
				</div>
				
				<div class="form-row justify-content-center eni-form-footer">
					<div class="col-4 col-sm-5 col-md-4 col-lg-3 text-center">
						<input class="btn btn-success btn-lg btn-block" type="submit" value="Créer">	
					</div>
					<div class="col-1"></div>
					<div class="col-4 col-sm-5 col-md-4 col-lg-3 text-center">
						<a class="btn btn-danger btn-lg btn-block" href="#">Annuler</a>
					</div>
				</div>
	
			</form>
		</main>
		
		
		<%@ include file="partials/footer.jspf"%>
		<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	</body>
</html>