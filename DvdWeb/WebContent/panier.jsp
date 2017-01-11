<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.math.BigDecimal"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dvd Store - Panier</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h2>Votre panier</h2>
	<c:forEach var="dvd" items="${dvds}">
    	<c:out value="${dvd.titre}" />
     	<c:out value="${dvd.prix}" />
     	<form action="/DvdWeb/Panier?action=remove&id=${dvd.id}" method="post">
			<input type="submit" value="Enlever">
		</form>
     	<br/>
	</c:forEach>
	<c:if test="${not empty dvds}">
		<form action="/DvdWeb/Panier?action=validate" method="post">
			<input type="submit" value="Valider mon panier">
		</form>
	</c:if>
	<p><a href="accueil.jsp">Retour à l'accueil</a></p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>