/**
 * Acceso a la lista de países
 */
var login = angular.module("loginApp", []);

var controlador = login.controller("loginController", ["$scope", "$http", function($scope, $http) {

	$scope.countries = {};
	$scope.names = ["aaaaaaaaaa", "bbbbbbbbbb", "ccccccccccc"];
	

	$http({
		method : 'GET',
		url : 'http://services.groupkt.com/country/get/all'
	}).success(function(data, status, headers, config) {
		$scope.countries = data;

	}).error(function(datos, status, headers, config) {
		alert("Error carga de datos servicio $http\n"
				+ "Código HTTP error: " + status);
	});		
}]);