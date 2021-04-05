<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OpenWeather</title>
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">
<script
	src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<div class="mdc-card intro">
		<h1>See Current Weather</h1>
		<form class="my-form" action="OWservlet" method="get">

			<div class="my-input-div">
				<label
					class="mdc-text-field--filled mdc-text-field--no-label my-input">
					<input class="mdc-text-field__input my-input-text" type="text"
					placeholder="City" name="city" aria-label="Label">
				</label> <label
					class="mdc-text-field--filled mdc-text-field--no-label my-input">
					<input class="mdc-text-field__input my-input-text" type="text"
					placeholder="Country Code" name="country" aria-label="Label">
				</label>
			</div>

			<!-- button style -->
			<div class="my-button-div">
				<button class="mdc-button mdc-button--raised my-button">
					<span class="mdc-button__label">Search</span>
				</button>
			</div>
		</form>

	</div>
	<div class="mdc-card my-card">
		<h3>Previous search:</h3>
		<div id="previous-search"></div>
	</div>


	<script type="text/javascript">
		// this is how you can get a cookie
		let cookie = document.cookie;

		// split out ; = and withspaces from cookie
		cookie = cookie.split(/[;,=,\s]+/);

		let cookieArray = [];
		for (let i = 0; i < cookie.length; i++) {
			if (i % 2 == 0) {
				console.log(cookie[i]);
				cookieArray.push(cookie[i]);
			}
		}

		for (let i = 0; i < cookieArray.length; i++) {
			let child = document.createTextNode(cookieArray[i]);
			let paragraf = document.createElement("p");
			paragraf.appendChild(child)
			document.getElementById("previous-search").appendChild(paragraf);
		}
	</script>


</body>
</html>