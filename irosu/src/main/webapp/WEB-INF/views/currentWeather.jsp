<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Weather</title>

<style type="text/css">

</style>

</head>
<body>
	<h1>Current Weather</h1>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<c:choose>
		<c:when test="${error == 'error'}">
			<h3>No se ha encontrado esa ciudad.</h3>
		</c:when>
		<c:otherwise>
			<h3>${city} - ${region}(${country})</h3>
			<h3>${temp}</h3>
		</c:otherwise>
	</c:choose>
	
</body>
</html>