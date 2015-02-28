angular
.module('app')
.controller('homeCtrl', ['$scope', 'majors',function($scope, majors){
		$scope.title = "Home";	
		$scope.majors = majors;
}]);