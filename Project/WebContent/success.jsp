
<!-- Success is only the jsp page that forwardar oss to FeedController -->
<%@page import="bean.UserBean"%>
<%@page import="bean.PostBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html class="h-100">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<title>Successful log in</title>
<!-- success.jsp is used to automatically forward the user to Feed Controller without manually pressing a button-->
<jsp:forward page="FeedController">
	<jsp:param name="name" value="test" />
</jsp:forward>

</html>