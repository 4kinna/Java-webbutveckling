<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Annikas index sida</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
<jsp:include page="header.html"/>

<main id="mainpart">
<form method="get" action="redirectFile.jsp">

<input name="fname" required placeholder="Name">
<input name="lname" required placeholder="Lastname">

<select required name="subject">
<option disabled selected>-- select an option --</option>
<option value="request">Request</option>
<option value="opinion">Opinion</option>
<option value="other">Other</option>
</select>


<textarea placeholder="Enter your message.." rows="4" name="msg"></textarea>

<input type="submit" value="Submit">
</form>
</main>


<jsp:include page="footer.jsp"/>
</body>
</html>