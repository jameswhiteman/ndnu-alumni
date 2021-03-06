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
    $scope.phone = "";
    $scope.about = "";
    $scope.company = "";
    $scope.title = "";
    $scope.page = "";
    $scope.image = "";
    $scope.submit = function() {
        if ($scope.password.length<6) {
            alert("Password must be greater than six characters.");
            return;
        }
        if ($scope.password!=$scope.confPass) {
            alert("Password does not match.");
            return;
        }
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        var info = "first="+this.first+"&last="+this.last+"&email="+this.email+"&password="+this.password+"&year="+this.year+"&major="+this.major+"&phone="+this.phone+"&about="+this.about+"&company="+this.company+"&title="+this.title+"&page="+this.page+"&image="+this.image+"&type=Admin";
        $http.post('http://localhost:8282/ndnualumni-api/users', info).
        success(function(data, status, headers, config) {
            alert("Successfully created account.");
            $state.go('home');
        }).
        error(function(data, status, headers, config) {
            alert("Failed to create account.");
        });
    }
}]);
