<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html ng-app="loginApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>

<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="static/styles/login.css">

</head>
<body ng-controller="loginController">

	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

	<div class="col-md-offset-5 col-md-2 col-md-offset-5 text-center verticalCenter">
		<h3>Login to the weather app</h3>	
		
		<form:form id="form" method="post" modelAttribute="user" action="login">
		
			<div class="input-group">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-user"></i>
				</span>
				<form:input id="user" type="text" class="form-control" name="user" 
				path="name" placeholder="User" required="required" />
			</div>
			
			<div class="input-group ocultar">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-envelope"></i>
				</span>
				<form:input id="email" type="email" class="form-control regist" name="email" 
				path="email" placeholder="Email" />
			</div>
			
			<div class="input-group">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-lock"></i>
				</span>
				<form:input id="password" type="password" class="form-control" name="password" 
				path="password" placeholder="Password" required="required" />
			</div>
			
			<div class="input-group ocultar">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-lock"></i>
				</span>
				<input id="confPassword" type="password" class="form-control regist" name="confPassword" 
				placeholder="Confirm password" />
			</div>			
			
			<div class="input-group ocultar">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-calendar"></i>
				</span>
				<input id="birthDate" type="text" class="form-control regist" placeholder="Birthday (dd/mm/aaaa)" path="birthDate" />
			</div>		
			
			<div class="input-group ocultar">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-globe"></i>
				</span>
				<select ng-model="selectedCountry" ng-options="item.name as item.name for item in countries track by item.name" 
					id="country" class="form-control regist" name="country" path="country">
					<option value="">Select a country</option>	
				</select>
			</div>			
			
			<div class="button-group">
				<button id="btn" type="submit" class="btn-primary form-control" name="btn">Login</button>
			</div>
			
		</form:form>
			
		<div>
			<a id="register" href="">Register</a>
		</div>
	</div>
	
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.6/angular.min.js"></script>
	<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src="static/scripts/loginAng.js"></script>
	<script type="text/javascript" src="static/scripts/loginJq.js"></script>
	
</body>
</html>