<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Current Weather</title>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="static/styles/login.css">

</head>
<body>
	
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<div class="col-md-offset-5 col-md-2 col-md-offset-5 text-center verticalCenter">
		<fieldset>
    		<legend>Current weather</legend>
			<c:choose>
				<c:when test="${error == 'error'}">
					<div>
						<h4>We could not find that city</h4>
					</div>
				</c:when>
				<c:otherwise>
					<div>
						<h3>${city} - ${region} (${country})</h3>
						<h3>${temp} &#8451;</h3>
					</div>
				</c:otherwise>
			</c:choose>
		</fieldset>
	</div>
	
</body>
</html>