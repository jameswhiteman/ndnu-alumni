var app = angular.module('app');

app.controller('addProjCtrl', ['$scope', '$http', '$state', 'User', function($scope, $http, $state, $user)
{
    $scope.name="something";
    $scope.year = 2010;
    $scope.description = "somethingelse";
    $scope.members = "john smith, andy richter";
    $scope.details = "a super great project";
    $scope.addProject = function() {
        if ($user.getRole() != "Admin") {
            alert("You must be an administrator to submit this data.");
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
