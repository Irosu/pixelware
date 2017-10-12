<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprobar el tiempo</title>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

</head>
<body>
	<h1>Comprobar el tiempo</h1>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<form:form id="form" method="post" modelAttribute="weather" action="weather">
	
		<label for="city">Introduce el nombre de una ciudad</label>
		<form:input type="text" id="city" name="city" path="name"/>
		<br/>
		
		<input class="btn btn-primary" type="submit" id="tempBtn" value="Obtener temperatura" />
		
	</form:form>
	
	<!-- <script type="text/javascript" src="static/scripts/weather.js"></script> -->
</body>
</html>