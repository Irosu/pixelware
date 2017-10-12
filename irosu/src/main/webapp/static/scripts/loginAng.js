/**
 * Acceso a la lista de países
 */
var login = angular.module("loginApp", []);

var controlador = login.controller("loginController", ["$scope", "$http", function($scope, $http) {

	$scope.countries;

	if($scope.countries == null) {
		$http({
			method: 'GET',
			url: 'https://restcountries.eu/rest/v2/all'
		}).then(function (response){
			$scope.countries = response.data;
		}, function (error){
			alert("We could not get the data");
		});
	}
}]);