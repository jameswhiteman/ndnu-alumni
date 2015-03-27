var app = angular.module('app', ['ngMaterial','ui.router']);

app.config(['$urlRouterProvider','$stateProvider',function($urlRouterProvider,$stateProvider) {
	$urlRouterProvider.otherwise('/');

	$stateProvider
	  .state('home', {
	  	url:'/',
	  	templateUrl: 'temp/home.html',
	  	controller: 'homeCtrl'
        })
	   .state('signup', {
	  	url:'/signup',
	  	templateUrl: 'temp/signup.html',
	  	controller: 'signUpCtrl'
	  	})
	   .state('cpanel', {
	  	url:'/cpanel',
	  	templateUrl: 'temp/cpanel.html',
	  	controller: 'cpanelCtrl'
	  	})
        .state('cpanel.AddProjBasicInfo', {
            templateUrl: '/temp/AddProjBasicInfo.html'
        })
        .state('cpanel.AddProjInfo', {
            templateUrl: '/temp/AddProjInfo.html'
        })
        .state('cpanel.AddProjPreview', {
            templateUrl: '/temp/AddProjPreview.html'
        })

}]);

