<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dvd Store - Header</title>
</head>
<body>
	<h1>Dvd Store</h1>
	<div>
		<form action = "/DvdWeb/Dvd" method="get">
  			<input type="text" name="titre" value="Titre du dvd">
  			<input type="submit" value="Recherche">
  			<input type="hidden" name="action" value="search"/>
		</form> 
	</div>
	<%
		Object obj = request.getSession().getAttribute("connected");
		if (obj != null) {
			boolean connected = (boolean) obj;
			if (connected == true) {
				%> 
					<a href="/DvdWeb/Profil?action=get">Profil</a>
					<a href="/DvdWeb/Deconnexion">Déconnexion</a>
				<%
			}
			else {
				%>
					<form method="get" action="connexion.jsp">
						<input type="submit" value="Connexion">
					</form>
				<%
			}
		}
		else {
			%>
			<form method="get" action="connexion.jsp">
				<input type="submit" value="Connexion">
			</form>
		<%
		}
	%> 
</body>
</html>