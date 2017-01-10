<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.math.BigDecimal"%>
<%@page import="metier.entities.Dvd"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dvd Store - Panier</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>Votre panier</h2>
	<%
		Object listeObj = request.getAttribute("dvds");
		if (listeObj != null) {
			ArrayList <Dvd> liste = (ArrayList <Dvd>) listeObj;
			if (!liste.isEmpty()) {
				Iterator <Dvd> it = liste.iterator();
				while (it.hasNext()) {
					Dvd d = it.next();
					String titre = d.getTitre();
					String prix = d.getPrix().toString();
					%>
					<div>
						Titre : <%= titre %>
						Prix : <%= prix %>
					</div>
					<%
				}
			}
		}
	%>
	<p><a href="accueil.jsp">Retour à l'accueil</a></p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>