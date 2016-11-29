<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dvd Store - Profil</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>Votre profil</h2>
	<%
		String nom = (String) (request.getAttribute("nom"));
		String prenom = (String) (request.getAttribute("prenom"));
		String email = (String) (request.getAttribute("email"));
		String adresse = (String) (request.getAttribute("adresse"));
		String date = (String) (request.getAttribute("date"));
	%> 	
	<p>Nom : <%= nom %></p>
	<p>Prénom : <%= prenom %></p>
	<p>Adresse e-mail : <%= email %></p>
	<p>Adresse : <%= adresse %></p>
	<p>Date de naissance : <%= date %></p>
	
	<p><a href="accueil.jsp">Retour à l'accueil</a></p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>