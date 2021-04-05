<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.WeatherBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Weather</title>
<link
	href="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.css"
	rel="stylesheet">
<script
	src="https://unpkg.com/material-components-web@latest/dist/material-components-web.min.js"></script>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<%
	WeatherBean wBean = (WeatherBean) request.getAttribute("wBean");
	out.print("<div class='weather-div'><h2 class='weather-update'>The current weather in " + wBean.getCityStr() + "</h2> <p class='info'>" + wBean.getCloudsStr() + " and "
			+ wBean.getTempStr() + "&#8451" + "</p><p class='last-update'>Lastupdate: " + wBean.getLastupdateStr()+"</p></div>");
		%>


</body>
</html>