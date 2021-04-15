<%@page import="bean.UserBean"%>
<%@page import="bean.PostBean"%>
<%@page import="java.util.ArrayList"%>

<%
ArrayList<PostBean> posts = (ArrayList<PostBean>) request.getAttribute("posts");
if (posts != null) {
	for (PostBean post : posts) {
		out.print("<div class='my-post-div'><div class='my-post-info'><p>Post ID: " + post.getPostID() + "</p><p>By: "
		+ post.getCreator() + "</p><p>" + post.getCreatedTime() + "</p></div><section class='my-post'><h6>"
		+ post.getTitle() + "</h6><p>" + post.getContent() + " #" + post.getHashtag() + "</p></section></div>");
	}
} else {
	out.print("NO POSTS");
}
%>