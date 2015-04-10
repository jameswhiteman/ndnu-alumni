var app = angular.module('app');
app.controller('signUpCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.data = [];
    $scope.first = "";
    $scope.last = "";
    $scope.email = "";
    /* added password & confPass4/8/15 */
    $scope.password = "";
    $scope.confPass = "";
    $scope.year = 2010;
    $scope.major = "";
    $scope.phone = 5555555555;
    $scope.about = "";
<<<<<<< HEAD
    $scope.createProject = function() {
=======
    $scope.submit = function() {
        if (scope.password.length<6) {
            alert("Password must be greater than six characters.");
            return
        }
        if (scope.password!===scope.confPass) {
            alert("Password does not match.");
            return
        }
>>>>>>> 5db812b6e7817e2f043a5bb9891a40c96094dbdd
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "first="+this.first+"&last="+this.last+"&email="+this.email+"&password="+this.password+"&year="+this.year+"&major="+this.major+"&phone="+this.phone+"&about="+this.about;
        $http.post('http://localhost:8282/ndnualumni-api/users', info).
        success(function(data, status, headers, config) {
            alert("success");
            $state.go('home');
        }).
        error(function(data, status, headers, config) {
            alert("error");
        });
    }
}]);
