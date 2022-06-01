<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
	<jsp:include page='../partials/head.jsp'>
	    <jsp:param name="extraCSS" value='<%=request.getContextPath()+"/css/accueil.css"%>' />
	    <jsp:param name="pageTitle" value='Enchères' />
	    <jsp:param name="pageDescription" value='Eni-Enchères' />
	</jsp:include>

	<body>
		<jsp:include page='../partials/header.jsp'>
		    <jsp:param name="pageTitle" value='Enchères' />
		</jsp:include>
		
		<main class="py-3">
		
		</main>
		
		<%@ include file="../partials/footer.jspf"%>
		<%@ include file="../partials/foot.jspf"%>
	</body>
</html>