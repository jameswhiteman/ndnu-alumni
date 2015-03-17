var app = angular.module('app', ['ngMaterial','ui.router']);

app.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
	$urlRouterProvider.otherwise('/');

	$stateProvider
	  .state('home', {
	  	url:'/',
	  	templateUrl: 'temp/home.html',
	  	controller: 'homeCtrl'
	  		  	})
	   .state('dept', {
	  	url:'/dept',
	  	templateUrl: 'temp/dept.html',
	  	controller: 'deptCtrl'
	  	})

}])
