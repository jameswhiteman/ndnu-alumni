var app = angular.module('app');

app.controller('eventsCtrl', function($scope, $http)
{
    $http.get('lectures.json').
    success(function(data) {
      $scope.users = data;
    }).
    error(function(data) {
       alert("error!");
    });
});
