<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta charset="UTF-8">
<%
String fname= request.getParameter("fname");
String lname= request.getParameter("lname");
String msg = request.getParameter("msg");


String subject=request.getParameter("subject");

String url= String.format("?fname=%s&lname=%s&msg=%s", fname, lname, msg); //lname gör att å inte kommer in

switch(subject){

case "request":
	response.sendRedirect("secondPage.jsp"+url);	
	break;
case "opinion":
	response.sendRedirect("thirdPage.jsp"+url);	
	break;
case "other":
	response.sendRedirect("fourthPage.jsp"+url);	
	break;
default:
	break;
}
%>
