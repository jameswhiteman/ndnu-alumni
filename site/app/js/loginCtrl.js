var app = angular.module('app');

app.controller('loginCtrl', ['$scope', '$http', '$state', function($scope, $http, $state)
{
    $scope.data = [];
    $scope.email = "";
    $scope.password = "";
    $scope.submit = function() {
        var info = "?email="+this.email+"&password="+this.password;
        console.log(info + ";");
        $http.get('http://localhost:8282/ndnualumni-api/users' + info).
          success(function(data) {
              if (data == null)
                  {
                      alert("Invalid e-mail/password combination");
                  }
            console.log("success:" + data);
            $state.go('home')
          }).
          error(function(data, status, headers, config) {
            alert("error");
          });
    }
}]);
