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
		<title>Login</title>
		<link rel="shortcut icon" type="image/x-icon" href="<%=request.getContextPath()%>/images/faviconEni.ico">
		<link rel="icon" type="image/png" href="<%=request.getContextPath()%>/images/faviconEni.png">
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<link href="<%=request.getContextPath()%>/css/eniStyle.css" rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/loginStyle.css" rel="stylesheet">
		
</head>

<body>

	<%@ include file="/WEB-INF/partials/header.jspf"%>
	
	<main class="py-5">
	
	
	
		<div class="container" >
			<div class="form-row justify-content-center mb-5">
				<form name="login" action="Login" method="post" id="login-form">
					<table class="form-group">
						<tr><td scope="col" style="font-size: medium" class=" col-form-label col-form-label-lg"> Identifiant :</td><td> &nbsp; <input type=text name=txtUsername></td></tr>
						<tr><td scope="col"> Mot de passe :</td><td>  &nbsp; <input type=password name=txtPassword></td></tr>
					</table>
				</form>
			</div>
			
			<div class="form-row justify-content-center mb-5">	
				<div class="col-xs-3 mr-4" >
					<button type="submit" form="login-form" class="btn btn-primary btn-sm"> Connexion</button>
				</div>
				<div class="col-xs-3 form-check"> 
					<input type="checkbox" value="seSouvenir" name="checkSeSouvenir" id="checkSeSouvenir">
				  <label for="checkSeSouvenir" class="form-check-label"></label> Se souvenir de moi<br>
				  &nbsp;  &nbsp;  <a href="#">Mot de pass oublié</a>
				</div>
			</div>
			<div>
			<div class="form-row justify-content-center mb-5">	
				<div class="col-xs-6" >
					<button onclick="location.href='Inscription'" class="btn btn-secondary btn-lg btn-block"> Créer un compte</button>
				</div>
			</div>
		</div>		
	
</main>

		
		<%@ include file="../partials/footer.jspf"%>
		<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
		<script src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
</body>

</html>