var app = angular.module('app');
app.controller('alumniCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.data = [];
    $scope.firstName = "";
    $scope.lastName = "";
    $scope.year = 2010;
    $scope.major = "";
    $scope.about = "";
    $scope.company = "";
    $scope.title = "";
    $scope.addAlum = function() {
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "first="+this.firstName+"&last="+this.lastName+"&email=&password=&year="+this.year+"&major="+this.major+"&phone=&about="+this.about+"&type=Alum&company="+this.company+"&title="+this.title;
        $http.post('http://localhost:8282/ndnualumni-api/users', info).
        success(function(data, status, headers, config) {
            alert("Successfully added alum.");
            $state.go('home');
        }).
        error(function(data, status, headers, config) {
            alert("error");
        });
    }
}]);
