<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>
</head>
<body>
	<h1>Dvd Store</h1>
	<div>
		<p><a href = "/DvdWeb/Liste?name=dvd">Voir les dvds</a><p>
		<p><a href = "/DvdWeb/Liste?name=auteur">Voir les auteurs</a><p>
		<p><a href = "/DvdWeb/Liste?name=realisateur">Voir les r�alisateurs</a><p>
	</div>
	<div>
		<p>Rechercher un dvd<p>
		<form action = "/DvdWeb/SearchDvd" method="get">
  			<input type="text" name="titre" value="Titre">
  			<input type="submit" value="Recherche">
		</form> 
	</div>
</body>
</html>