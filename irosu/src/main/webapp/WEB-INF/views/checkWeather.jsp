<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Comprobar el tiempo</title>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="static/styles/login.css">

</head>
<body>

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<div class="col-md-offset-5 col-md-2 col-md-offset-5 text-center verticalCenter">
		<h3>Check the weather</h3>

		<form:form id="form" method="post" modelAttribute="weather" action="weather">
		
			<div class="input-group">
				<label for="city">Insert a city name</label>
				<form:input type="text" id="city" name="city" class="form-control" required="required" path="name"/>
			</div>
			<br/>
			
			<input class="btn btn-primary form-control" type="submit" id="tempBtn" value="Get current weather" />
			
		</form:form>	
	</div>
	
</body>
</html>