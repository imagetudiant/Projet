<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dvd Store - R�alisateurs</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Liste des r�alisateurs</h1>
	<%
		String nom = (String) (request.getAttribute("nom"));
		String prenom = (String) (request.getAttribute("prenom"));
	%> 
	<div>R�alisateur 1 : <%= nom + " " + prenom %></div>
	<p><a href="accueil.jsp">Retour � l'accueil</a></p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>