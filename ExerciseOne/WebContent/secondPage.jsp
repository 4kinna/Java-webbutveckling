<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Annikas Second Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.html"/>

<main id="mainpart" align="center">	
<h1>Request</h1>
<p>
<%
String fname= request.getParameter("fname");
String lname= request.getParameter("lname");
String msg = request.getParameter("msg");

out.print(fname + " " +lname);
%>
</p>
<p>
<%
out.print(msg);
%>
</p>
</main>

<jsp:include page="footer.jsp"/>
</body>