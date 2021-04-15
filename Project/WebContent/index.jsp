<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
// check if there is a session with an user
if (session.getAttribute("user") != null) {
	// there is one goto the login servlet
	RequestDispatcher rd = request.getRequestDispatcher("Login");
	rd.forward(request, response);// this lands on the GET in the servlet
}
%>

<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">

<title>Log in</title>

<!-- Bootstrap and CSS  -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">
<link href="css/style.css" rel="stylesheet">

<!-- <link href="css/signin.css" rel="stylesheet"> -->
</head>
<!-- My body -->
<body class="text-center d-flex h-100 text-center text-white bg-dark">
<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
<!-- My header -->
		<header class="mb-auto">
			<h1 class="display-3">Welcome Buddies</h1>
		</header>
		<!-- My main -->
		<main class="form-signin">
		<!-- Form to loggin -->
			<form action="<%=request.getContextPath()%>/Login" method="post">

				<div class="my-input">
					<input type="text" class="form-control" id="floatingInput"
						placeholder="Username" name="username">
				</div>
				<div class="my-input">
					<input type="password" class="form-control" id="Password"
						placeholder="Password" name="password">
				</div>
				<button
					class="btn btn-lg btn-secondary fw-bold border-white bg-white my-button"
					type="submit">Log in</button>
			</form>
		</main>
<!-- My footer -->
		<footer class="footer mt-auto text-white-50">
			<p class="my-footer-text text-center">
				Buddies created by <a href="https://StalhandskeWebSolutions.com/"
					class="text-white">StålhandskeWebSolutions</a>, by Annika
				Stålhandske</a>.
			</p>
		</footer>
	</div>
</body>
</html>