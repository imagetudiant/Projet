<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
</head>
<body>
	<h1>Connectez-vous</h1>
	<form action = "Connexion" method = "post">
		E-mail <br/>
		<input type="text" name="email" value=""><br/>
		Mot de passe <br/>
		<input type="password" name="password" value=""><br/>
  		<input type="submit" value="Connexion">
	</form>
	<jsp:include page="footer.jsp"></jsp:include> 
</body>
</html>