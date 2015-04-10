var app = angular.module('app');

app.controller('loginCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.data = [];
    $scope.email = "";
    $scope.password = "";
    $scope.submit = function() {
        var info = "?email="+this.email+"&password="+this.password;
        $http.get('http://localhost:8282/ndnualumni-api/users' + info).
          success(function(data) {
              console.log(data);
            if (data === "")
            {
                alert("Invalid e-mail/password combination.");
            }
            else
            {
                $state.go('home')
            }
          }).
          error(function(data, status, headers, config) {
            alert("Error logging in, please try again.");
          });
    }
}]);
