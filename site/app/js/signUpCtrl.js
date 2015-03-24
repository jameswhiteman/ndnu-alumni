var app = angular.module('app');

app.controller('signUpCtrl', function($scope, $http, $state)
{
    $scope.submit = function() {
        alert("Submitting...");
        $http.post('http://localhost:8282/ndnualumni-api/users', 'first=Fred&last=Flintstone&email=fflintstone@gmail.com&year=2000&major=CS&phone=8885554444&about=Hello, world!').
          success(function(data, status, headers, config) {
            // this callback will be called asynchronously
            // when the response is available
            alert("success");
              $state.go('home') 
          }).
          error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
              alert("error");
          });
    }
});
