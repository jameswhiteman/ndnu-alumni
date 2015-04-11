var app = angular.module('app');

app.controller('homeCtrl', function($scope, $http)
{
     $http.get('info.json')
       .then(function(res){
          $scope.depts = res.data;
        });

   $http.get('http://localhost:8282/ndnualumni-api/projects').
    success(function(data) {
      $scope.projects = data;
    }).
    error(function(data) {
       alert(data + " e");
    });

      $http.get('users.json').
    success(function(data) {
      $scope.users = data;
    }).
    error(function(data) {
       alert("error!");
    });

	 $scope.data = {
      selectedIndex : 0,
      tabLocked : true
    };
    $scope.next = function() {
      $scope.data.selectedIndex = Math.min($scope.data.selectedIndex + 1, 2) ;
    };
    $scope.previous = function() {
      $scope.data.selectedIndex = Math.max($scope.data.selectedIndex - 1, 0);
    };
});

