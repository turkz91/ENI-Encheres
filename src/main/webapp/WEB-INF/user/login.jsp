<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String pageTitle = "Login";
String pageDescription = "Page liste des enchères";
String extraCSS = request.getContextPath() + "/css/loginStyle.css";
%>
<%@ page
	import="java.util.List, fr.eni.encheres.messages.LecteurMessage, fr.eni.encheres.bo.Utilisateur"%>
<!DOCTYPE html>
<html lang="fr">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="ie=edge">
		<meta name="viewport"
			content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta name="description" content="Page liste des enchères">
		<meta name="author"
			content="co-authored by BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain">
		<title>Login</title>
		<link rel="shortcut icon" type="image/x-icon"
			href="<%=request.getContextPath()%>/images/faviconEni.ico">
		<link rel="icon" type="image/png"
			href="<%=request.getContextPath()%>/images/faviconEni.png">
		<link
			href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
			rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/eniStyle.css"
			rel="stylesheet">
		<link href="<%=request.getContextPath()%>/css/login.css"
			rel="stylesheet">
	</head>
	<body>	
		<%@ include file="/WEB-INF/partials/header.jspf"%>	
		<main class="container py-5">
			<div class="row justify-content-center align-items-center">
				<div class="col-12 col-md-7 col-lg-5">
					<div class="col-12 pb-5">
						<%
						@SuppressWarnings("unchecked")
						List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
						if (listeCodesErreur != null) {
						%>
						<p class="text-center text-danger">
							Erreur, nom d'utilisateur ou mot de passe est invalide.
						</p>
						<%
						for (int codeErreur : listeCodesErreur) {
						%>
						<p class="text-center"><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
						<%
						}
						}
						%>
						<form class="form"
							action="<%=request.getContextPath()%>/UtilisateurLogin"
							method="post">
							<div class="form-row pb-2">
								<label for="username"
									class="col-5 col-form-label col-form-label-lg">Identifiant:</label>
								<div class="col-7">
									<input type="text" name="username" id="username"
										class="form-control">
								</div>
							</div>
							<div class="form-row py-2">
								<label for="motDePasse"
									class="col-5 col-form-label col-form-label-lg eni-lbl-login">Mot
									de Passe:</label><br>
								<div class="col-7">
									<input type="password" name="motDePasse" id="motDePasse"
										class="form-control">
								</div>
							</div>
							<div class="form-row pt-3">
								<div class="col-5">
									<input type="submit" name="submit"
										class="btn-success btn-lg btn-block eni-btn-connexion"
										value="Connexion">
								</div>
								<div class="col-7 text-right">
									<label for="souvenir" class="col-form-label"> <input
										id="souvenir" name="souvenir" type="checkbox"> <span
										class="pl-2">Se souvenir de moi</span>
									</label><br> <a href="#">Mot de passe oublié</a>
								</div>
							</div>
						</form>
					</div>
					<div class="col-12 text-center pt-4 eni-col-nvCompte">
						<a class="btn-success btn-lg btn-block mx-auto eni-btn-nvCompte" 
						  href="<%=request.getContextPath()%>/inscription-utilisateur">
							Créer un compte
						</a>
					</div>
				</div>
			</div>
		</main>	
		<%@ include file="../partials/footer.jspf"%>
		<%@ include file="../partials/foot.jspf"%>
	</body>

</html>