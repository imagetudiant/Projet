<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des auteurs</title>
</head>
<body>
<h1>Liste des auteurs</h1>
<%
String nom = (String) (request.getAttribute("nom"));
String prenom = (String) (request.getAttribute("prenom"));
%> 
<div>Auteur 1 : <%= nom + " " + prenom %></div>
</body>
</html>