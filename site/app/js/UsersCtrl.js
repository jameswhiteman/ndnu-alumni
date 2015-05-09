var app = angular.module('app');

app.controller('UsersCtrl', ['$scope', '$http', '$state', '$mdDialog', function($scope, $http, $state, $mdDialog)
{
   $http.get('users.json').
    success(function(data) {
      $scope.users = data;
    }).
    error(function(data) {
       alert("Error fetching users data!");
    });

$scope.goToPerson = function(user, event) {
    $mdDialog.show(
      $mdDialog.alert()
        .title('Navigating')
        .content('Inspect ' + user)
        .ariaLabel('Person inspected')
        .ok('Neat!')
        .targetEvent(event)
    );
  };

}]);
