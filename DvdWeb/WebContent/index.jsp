<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dvd Store - Accueil</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1>Accueil</h1>
	<p>Connectez-vous ou inscrivez-vous pour accéder à votre store</p>
	<form method="get" action="connexion.jsp">
		<input type="submit" value="Connexion">
	</form>
	<form method="get" action="inscription.jsp">
		<input type="submit" value="Inscription">
	</form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>