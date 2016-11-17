<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
</head>
<body>
	<h1>Inscrivez-vous</h1>
	<form action = "Inscription" method = "post">
		E-mail<br/>
		<input type="text" name="email" value=""><br/>
		Nom<br/>
		<input type="text" name="nom" value=""><br/>
		Prénom<br/>
		<input type="text" name="prenom" value=""><br/>
		<input type="radio" name="sexe" value="Homme" checked>Homme<br>
  		<input type="radio" name="sexe" value="Femme">Femme<br>
  		Adresse<br/>
		<input type="text" name="adresse" value=""><br/>
		Date de naissance<br/>
		<input type="text" name="date" value=""><br/>
		Mot de passe<br/>
		<input type="password" name="password" value=""><br/>
		Confirmez votre mot de passe<br/>
		<input type="password" name="password2" value=""><br/>
  		<input type="submit" value="Inscription">
  		<input type="reset">
	</form> 
</body>
</html>