/**
 * Acceso a la lista de países
 */
var login = angular.module("loginApp", []);

var controlador = login.controller("loginController", ["$scope", "$http", function($scope, $http) {

	$scope.countries = {};

	if($scope.countrie == null) {
		$http({
			method: 'GET',
			url: 'http://services.groupkt.com/country/get/all'
		}).then(function (response){
			$scope.countries = response.data;
		}, function (error){
			alert("Error al cargar los datos");
		});
	}
}]);