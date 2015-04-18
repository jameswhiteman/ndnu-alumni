var app = angular.module('app');

app.controller('UsersCtrl', function($scope, $http)
{
    $http.get('projects.json').
    success(function(data) {
      $scope.users = data;
    }).
    error(function(data) {
       alert("error!");
    });
});
