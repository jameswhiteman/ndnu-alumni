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
	  			return $http.get('http://localhost:8282/ndnualumni-api/projects').then(function(response) {
                    alert(response.data);
	  			});
	  		}]
	  	}
	  	})
	   .state('dept', {
	  	url:'/dept',
	  	templateUrl: 'temp/dept.html',
	  	controller: 'deptCtrl'
	  	})

}])
