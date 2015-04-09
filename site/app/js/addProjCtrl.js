var app = angular.module('app');

app.controller('addProjCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.name = "";
    $scope.year = 2010;
    $scope.description = "";
    $scope.members = "";
    $scope.details = "";
    $scope.submit = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "name="+$scope.name+"&description="+$scope.description+"&year="+$scope.year;
        console.log(info);
        $http.post('http://localhost:8282/ndnualumni-api/projects', info).
        success(function(data, status, headers, config) {
            alert("success");
            $state.go('home')
        }).
        error(function(data, status, headers, config) {
            alert("error");
        });
    }
}]);
