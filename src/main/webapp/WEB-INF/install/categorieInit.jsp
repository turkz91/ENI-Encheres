<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="author"
	content="co-authored by BARBATO Marco, EPHRAIM Sean, KUBOTA Teruaki, VAN DE PUTTE Romain">

<title>Install Catégorie</title>

<!-- Bootstrap core CSS -->
<link
	href="<%=request.getContextPath()%>/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>
	<%@ page
		import="fr.eni.encheres.bo.Categorie, java.util.List, fr.eni.encheres.messages.LecteurMessage"%>
	<!-- Page Content -->
	<div class="container">
		<%
		@SuppressWarnings("unchecked")
		List<Integer> error = (List<Integer>) request.getAttribute("error");
		if (error != null) {
		%>

		<p style="color: red;">Erreur, la catégorie n'a pas pu être ajouté :</p>
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
		List<Categorie> categories = (List<Categorie>) request.getAttribute("categorie");
		if (categories != null) {
		%>
		<p class="my-4 text-center" style="color: red;">Les catégories ont été
			ajouté avec succès :</p>
		<%
		for (Categorie categorie : categories) {
		%>
		<p class="my-4 text-center"><%=categorie.getLibelle()%>
			-
			<%=categorie.getNo_categorie()%>
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