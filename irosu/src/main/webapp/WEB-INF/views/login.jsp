<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Weather</title>

<style type="text/css">

	.hideTemp{
		display: none;
	}

</style>

</head>
<body>
	<h1>Current Weather</h1>

	<%--@ taglib uri="http://www.springframework.org/tags/form" prefix="form" --%>

	<form:form id="form" method="post" modelAttribute="weather" action="weather">
	
		<label for="city">Introduce el nombre de una ciudad</label>
		<form:input type="text" id="city" name="city" path="name"/>
		<br/>
		
		<input type="button" id="tempBtn" value="Obtener temperatura" />
		
	</form:form>
	
	<h3 class="hideTemp">La temperatura actual en ${city} es de ${temp} grados centígrados.</h3>
	
	<!-- jQuery -->
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	
	<script type="text/javascript">
	
		$(document).ready(function() {
			
			$("#tempBtn").click(function() {
				$("#form").submit();
				$("#form").css("display", "none");
				$("h3").show();
				
				return false;
			});
			
		});

	</script>
</body>
</html>