<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header class="pb-5">
	<nav class="navbar navbar-expand-lg navbar-light eni-bg-light">
		<div class="container">
			<a href="<%=request.getContextPath()%>" class="navbar-brand">
				<img src="<%=request.getContextPath()%>/images/logoEni.png" height="40">
				ENI-Enchères
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigateur" aria-controls="navigateur" aria-expanded="false" aria-label="Navigateur">
				<span class="navbar-toggler-icon"></span>
		  	</button>
		  	<div class="collapse navbar-collapse" id="navigateur">
		  		<ul class="navbar-nav ml-auto">		  			
		  			<li class="nav-item">
		  				<a 
		  				  class="nav-link ${param.pageTitle == 'Encheres' ? 'active' : '' }"
		  				  href="<%=request.getContextPath()%>">Enchères</a>
		  			</li>
		  			<c:choose>
			  			<c:when test="${!empty sessionScope.user}">
				  			<li class="nav-item">
				  				<a 
				  				  class="nav-link  ${param.pageTitle == 'Vente' ? 'active' : '' }"
				  				  href="<%=request.getContextPath()%>/nouvelleVente">
				  				    Vendre un Article
				  				</a>
				  			</li>
				  			<li class="nav-item">
				  				<a 
				  				  class="nav-link  ${param.pageTitle == 'Compte' ? 'active' : '' }"
				  				  href="<%=request.getContextPath()%>/compte">Mon Profil
				  				</a>
				  			</li>
				  			<li class="nav-item">
				  				<a class="nav-link" href="<%=request.getContextPath()%>/logoff">Déconnexion</a>
				  			</li>			  		
			  			</c:when>
			  			<c:otherwise>
				  			<li class="nav-item">
				  				<a 
				  				  class="nav-link  ${param.pageTitle == 'Login' ? 'active' : '' }"
				  				  href="<%=request.getContextPath()%>/login">Login
				  				</a>
				  			</li>		
				  			<li class="nav-item">
				  				<a 
				  				  class="nav-link  ${param.pageTitle == 'Inscription' ? 'active' : '' }"
				  				  href="<%=request.getContextPath()%>/nouveau-compte">S'Inscrire
				  				</a>
				  			</li>			  			
					    </c:otherwise>
			  		</c:choose>
		  			
		  		</ul>
		  	</div>
	  	</div>
	</nav>
</header>

