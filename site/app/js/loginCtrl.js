var app = angular.module('app');

app.controller('loginCtrl', ['$scope', '$http', '$state', '$mdToast', '$animate', '$mdDialog', function($scope, $http, $state,$mdToast, $animate,$mdDialog)
{
    $scope.data = [];
    $scope.email = "";
    $scope.password = "";

  $scope.toastPosition = {
    bottom: false,
    top: true,
    left: false,
    right: true
  };
  $scope.getToastPosition = function() {
    return Object.keys($scope.toastPosition)
      .filter(function(pos) { return $scope.toastPosition[pos]; })
      .join(' ');
  };
  $scope.showToast = function() {
    $mdToast.show({
      templateUrl: 'temp/userToast.html',
      hideDelay: 6000,
      position: $scope.getToastPosition()
    })};

     $scope.closeToast = function() {
    $mdToast.hide();
  };

  function DialogController($scope, $mdDialog) {
  $scope.hide = function() {
    $mdDialog.hide();
  };
  $scope.cancel = function() {
    $mdDialog.cancel();
  }};

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
                $scope.showToast();
               $scope.hide();
                $state.go('home')
            }
          }).
          error(function(data, status, headers, config) {
            alert("Error logging in, please try again.");
          });
    }
}]);

