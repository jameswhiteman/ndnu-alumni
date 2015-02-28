var app = angular.module('app', ['ngMaterial','ui.router']);

app.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
	$urlRouterProvider.otherwise('/');

	$stateProvider
	  .state('home', {
	  	url:'/',
	  	templateUrl: 'temp/home.html',
	  	controller: 'homeCtrl',
	  	resolve: {
	  		majors: ['$http' , function($http){
	  			return $http.get('info.json').then(function(response) {
	  				return response.data;

	  			})
	  		}]
	  	}
	  	})
	   .state('dept', {
	  	url:'/dept',
	  	templateUrl: 'temp/dept.html',	
	  	controller: 'deptCtrl'
	  	})

}])

