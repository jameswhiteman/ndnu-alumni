var app = angular.module('app');

app.controller('projectsCtrl', ['$scope', '$http', '$state', 'User', function($scope, $http, $state, $user)
{
    // Get
    $scope.projects = "";
    $http.get('http://localhost:8282/ndnualumni-api/projects').
    success(function(data) {
      $scope.projects = data;
    }).
    error(function(data) {
       alert("Error fetching projects data.");
    });

    // Add projects
    $scope.name="";
    $scope.year = 2010;
    $scope.description = "";
    $scope.addProject = function() {
        if ($user.getRole() != "Admin") {
            alert("You must be an administrator to add a new project.");
            return;
        }
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "name="+$scope.name+"&description="+$scope.description+"&year="+$scope.year;
        $http.post('http://localhost:8282/ndnualumni-api/projects', info).
        success(function(data, status, headers, config) {
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("Failed to create project.");
        });
    }
}]);
