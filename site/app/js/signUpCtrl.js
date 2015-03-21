var app = angular.module('app');

app.controller('signUpCtrl', ['$scope', '$http', function($scope, $http)
{
    $scope.data = [];
    $scope.first = "";
    $scope.last = "";
    $scope.email = "";
    $scope.year = 2010;
    $scope.major = "";
    $scope.phone = 5555555555;
    $scope.about = "";
    $scope.submit = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "first="+this.first+"&last="+this.last+"&email="+this.email+"&year="+this.year+"&major="+this.major+"&phone="+this.phone+"&about="+this.about;
        $http.post('http://localhost:8282/ndnualumni-api/users', info).
          success(function(data, status, headers, config) {



          }).
          error(function(data, status, headers, config) {


          });
    }
}]);
