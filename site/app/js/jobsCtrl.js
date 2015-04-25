var app = angular.module('app');

app.controller('jobsCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.jobs = "";
    $http.get('http://localhost:8282/ndnualumni-api/jobs').
    success(function(data) {
      $scope.jobs = data;
    }).
    error(function(data) {
       alert("Error fetching jobs data.");
    });

    $scope.title = "";
    $scope.type = "";
    $scope.company = "";
    $scope.description = "";
    $scope.addJob = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "title="+$scope.title+"&type="+$scope.type+"&company="+$scope.company+"&description="+$scope.description;
        $http.post('http://localhost:8282/ndnualumni-api/jobs', info).
        success(function(data, status, headers, config) {
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("Failed to create job.");
        });
    }
}]);
