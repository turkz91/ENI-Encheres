<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author"
	content="co-authored by BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain">

<title>Install Test Users</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<%
String pageTitle = "Profil";
%>
<body>
	<%@ page
		import="fr.eni.encheres.bo.Utilisateur, java.util.List, fr.eni.encheres.messages.LecteurMessage"%>
	<!-- Page Content -->
	<div class="container">
		<%
		@SuppressWarnings("unchecked")
		List<Integer> error = (List<Integer>) request.getAttribute("error");
		if (error != null) {
		%>

		<p style="color: red;">Erreur, les utilisateurs n'ont pas pu être ajouté :</p>
		<%
		for (int codeErreur : error) {
		%>
		<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%
		}
		}
		%>
		<%
		@SuppressWarnings("unchecked")
		List<Integer> listeCodesErreur = (List<Integer>) request.getAttribute("listeCodesErreur");
		if (listeCodesErreur != null) {
		%>
		<p style="color: red;">Erreur, la catégorie n'a pas pu être ajouté :</p>
		<%
		for (int codeErreur : listeCodesErreur) {
		%>
		<p><%=LecteurMessage.getMessageErreur(codeErreur)%></p>
		<%
		}
		}
		%>
		<%
		@SuppressWarnings("unchecked")
		List<Utilisateur> users = (List<Utilisateur>) request.getAttribute("userList");
		if (users != null) {
		%>
		<p class="my-4 text-center" style="color: red;">Les utilisateurs ont été
			ajouté avec succès :</p>
		<%
		for (Utilisateur user : users) {
		%>
		<h3 class="my-4 text-center">Nouvelle Utilisateur</h3>
		<p class="my-4 text-center">Numéro Utilisateur: <%=user.getNo_utilisateur() %></p>
		<p class="my-4 text-center">Nom: <%=user.getNom()%></p>
		<p class="my-4 text-center">Prénom: <%=user.getPrenom()%></p>
		<p class="my-4 text-center">Pseudo: <%=user.getPseudo() %></p>
		<p class="my-4 text-center">Email: <%=user.getEmail() %></p>
		<p class="my-4 text-center">Telephone: <%=user.getTelephone() %></p>
		<p class="my-4 text-center">Rue: <%=user.getRue() %></p>
		<p class="my-4 text-center">Code Postal: <%=user.getCode_postal() %></p>
		<p class="my-4 text-center">Ville: <%=user.getVille() %></p>
		<p class="my-4 text-center">MDP: <%=user.getMot_de_passe() %></p>
		<p class="my-4 text-center">Credit: <%=user.getCredit() %></p>
		<p class="my-4 text-center">Admin:
		<%
		if (user.isAdministrateur()){
		%>
		Oui
		<%
		}
		else {
		%>
		Non
		<%
		}
		%>
		 </p>
		<%
		}
		}
		%>

	</div>
	<!-- §Page Content -->
	<!-- Bootstrap core JavaScript -->
	<script src="<%=request.getContextPath()%>/vendor/jquery/jquery.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<!-- §Bootstrap core JavaScript -->
</body>
</html>