var app = angular.module('app');

app.controller('loginCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.data = [];
    $scope.email = "";
    $scope.password = "";
    $scope.submit = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "?email="+this.email+"&password="+this.password;
        $http.get('http://localhost:8282/ndnualumni-api/users' + info).
          success(function(data, status, headers, config) {
            alert("success");
            $state.go('home')
          }).
          error(function(data, status, headers, config) {
            alert("error");
          });
    }
}]);
