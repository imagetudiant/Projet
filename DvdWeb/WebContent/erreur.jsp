<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>DvD Store - Erreur</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Erreur</h1>
	<p>Une erreur est survenue lors du traitement de votre requête.</p>
	<%
		String error = (String) (request.getAttribute("error"));
	%> 
	<p><%= error %></p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>