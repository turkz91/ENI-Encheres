
<%
String title = "Inscription";
%>
<%@ include file="header.jspf"%>

<header>
	<a href="http://localhost:8080/encheres" class="titre-appli">ENI-Enchères</a>
</header>

<section>
<h2>TEST de récupération des paramètres</h2>
<p>
 Le pseudo saisi : ${ !empty pseudo ? pseudo : "" }
 Le prénom saisi : ${ !empty prenom ? prenom : "" }
 Le nom saisi : ${ !empty nom ? nom : "" }
 L'email saisi : ${ !empty email ? email : "" }
 Le telephone saisi : ${ !empty telephone ? telephone : "" }
 La rue saisi : ${ !empty rue ? rue : "" }
 La ville saisi : ${ !empty ville ? ville : "" }
 Le code postal saisi : ${ !empty codePostal ? codePostal : "" }
 Le mot de passe saisi : ${ !empty motDePasse ? motDePasse : "" }
 La confirmation saisi : ${ !empty confirmation ? confirmation : "" }
</p>
</section>

<main>
	<h1>Mon profil</h1>
	<div class="container">
		<form action="/Eni-Encheres/Inscription" method="post">
			<div class="row">
				<div class="col col-md-2">
					<label for="pseudo">Pseudo : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="pseudo" name="pseudo">
				</div>
				<div class="col col-md-2">
					<label for="nom">Nom : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="nom" name="nom">
				</div>
			</div>
			<div class="row">
				<div class="col col-md-2">
					<label for="prenom">Prénom : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="prenom" name="prenom">
				</div>
				<div class="col col-md-2">
					<label for="email">Email : </label>
				</div>
				<div class="col col-md-3">
					<input type="email" id="email" name="email">
				</div>
			</div>
			<div class="row">
				<div class="col col-md-2">
					<label for="telephone">Téléphone : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="telephone" name="telephone">
				</div>
				<div class="col col-md-2">
					<label for="rue">Rue : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="rue" name="rue">
				</div>
			</div>
			<div class="row">
				<div class="col col-md-2">
					<label for="code-postal">Code Postal : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="code-postal" name="code-postal">
				</div>
				<div class="col col-md-2">
					<label for="ville">Ville : </label>
				</div>
				<div class="col col-md-3">
					<input type="text" id="ville" name="ville">
				</div>
			</div>
			<div class="row">
				<div class="col col-md-2">
					<label for="mot-de-passe">Mot de passe : </label>
				</div>
				<div class="col col-md-3">
					<input type="password" id="mot-de-passe" name="mot-de-passe">
				</div>
				<div class="col col-md-2">
					<label for="confirmation">Confirmation : </label>
				</div>
				<div class="col col-md-3">
					<input type="password" id="confirmation" name="confirmation">
				</div>
			</div>
			<section>
				<div class="row">
					<div class="col"></div>
					<div class="col">
						<input type="submit" value="Créer">

					</div>
					<div class="col annuler">
						<a href="#"><button>Annuler</button></a>
					</div>
					<div class="col"></div>
				</div>
			</section>

		</form>
	</div>
</main>


<%@ include file="footer.jspf"%>