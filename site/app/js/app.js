var app = angular.module('app', ['ngMaterial','ui.router','angularFileUpload','mdDateTime']);

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
        .state('cpanel.AddProjInfo', {
         abstract: true,
        templateUrl: 'temp/addProjInfo.html',
        controller: 'addProjCtrl'
        })

}]);

app.config(function($mdThemingProvider) {
  $mdThemingProvider.theme('default')
    .primaryPalette('light-blue')
    .accentPalette('blue-grey');
});



app.factory('User', function () {
    var identifier, verifier, name, role;
    return {
        getIdentifier: function () {
            return identifier;
        },
        getVerifier: function () {
            return verifier;
        },
        getName: function () {
            return name;
        },
        getRole: function () {
            return role;
        },
        setIdentifier: function(value) {
            identifier = value;
        },
        setVerifier: function(value) {
            verifier = value;
        },
        setName: function(value) {
            name = value;
        },
        setRole: function(value) {
            role = value;
        }
    }
});
app.service('Toast', function () {
    var text = 'First';
    return {
        getText: function () {
            return text;
        },
        setText: function(value) {
            text = value;
        }
    }
});
