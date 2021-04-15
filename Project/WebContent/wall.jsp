<!-- My Main page, when you have successfully logged in you land here -->

<%@page import="bean.UserBean"%>
<%@page import="bean.PostBean"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>Buddies wall</title>

<!-- Bootstrap and CSS links -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6"
	crossorigin="anonymous">

<link href="css/style.css" rel="stylesheet">

<!-- JS to prevent the default behavior -->
<script type="text/javascript">
    //prevents that an identical post is created (when we refresh site)
    //with the information that been store in browser
	if (window.history.replaceState) {
		window.history.replaceState(null, null, window.location.href);
	}
</script>

</head>

<!-- my body-->
<body class="d-flex h-100 text-center text-white bg-dark">


	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">

		<%
		// Checks if the session has an user bean.
		if (session.getAttribute("user") == null) {
			// if ist not an acceptet user it will redirect the person to our Logout servlet
			RequestDispatcher rd = request.getRequestDispatcher("Logout");
			rd.forward(request, response);
		} 
		%>
<!-- My header, keeps headline and logout button -->
		<header class="mb-auto">
			<div>
				<h3 class="float-md-start mb-0 display-5">Welcome to Buddies</h3>
				<nav class="nav nav-masthead justify-content-center float-md-end">
					
					<!-- redirect to logout if user push logoutbutton -->
					<form action="<%=request.getContextPath()%>/Logout" method="post">
						<button
							class="btn btn-lg btn-secondary fw-bold border-white bg-white my-button"
							type="submit">Log out</button>
					</form>
				</nav>
			</div>
		</header>

<!-- My main part, hold the form to make new posts and also presents are posts i DB -->
		<main class="my-main">
			<form action="<%=request.getContextPath()%>/PostController" method="post">
				<h1 class="text-center my-post-headline display-6">Make a post!</h1>
				<div class="my-input">
					<input type="text" class="form-control" id="title"
						placeholder="Title" name="title" maxlength="40">
				</div>

				<div class="my-input">
					<textarea id="textarea" class="form-control"
						placeholder="Wright your post here!" name="content" rows="4"
						maxlength="300"></textarea>
				</div>

				<div class="my-input">
					<input type="text" class="form-control" id="hashtag"
						placeholder="#AddYourHashTaggHere" name="hashtag" maxlength="20">
				</div>

				<button
					class="btn btn-lg btn-secondary fw-bold border-white bg-white my-button"
					type="submit">Post it!</button>
			</form>
			<section class="my-feed">
				<h1 class="display-6">Buddies wall</h1>

				<%
				ArrayList<PostBean> posts = (ArrayList<PostBean>) request.getAttribute("posts");
				if (posts != null) {
					for (PostBean post : posts) {
						out.print("<div class='my-post-div'><div class='my-post-info'><p>Post ID: " + post.getPostID() + "</p><p>By: "
						+ post.getCreator() + "</p><p>" + post.getCreatedTime() + "</p></div><section class='my-post'><h6>"
						+ post.getTitle() + "</h6><p>" + post.getContent() + (post.getHashtag().equals("") ? "" : " #")
						+ post.getHashtag() + "</p></section></div>");
					}
				} 
				%>
				
			</section>
		</main>

		<footer class="mt-auto text-white-50">
			<p class="my-footer-text">
				Buddies created by <a href="https://StalhandskeWebSolutions.com/"
					class="text-white">StålhandskeWebSolutions</a> by Annika
				Stålhandske</a>.
			</p>
		</footer>
	</div>

</body>
</html>