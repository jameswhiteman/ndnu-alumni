var app = angular.module('app');

app.controller('loginCtrl', ['$scope', '$http', '$state', '$mdToast', '$animate', '$mdDialog', 'Toast', 'User', function($scope, $http, $state,$mdToast, $animate,$mdDialog, $toast, $user)
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
        var currentEmail = this.email;
        var currentPassword = this.password;
        var info = "identifier="+this.email+"&verifier="+this.password;
        $http.defaults.headers.post['Content-Type'] = 'application/x-www-form-urlencoded;charset=utf-8';
        $http.post('http://localhost:8282/ndnualumni-api/login', info).
        success(function(data, status, headers, config) {
            if (!data || !data.type)
            {
                $toast.setText("Invalid e-mail/password combination");
                $scope.showToast();
            }
            else
            {
                $toast.setText("Login successful");
                $user.setIdentifier(currentEmail);
                $user.setVerifier(currentPassword);
                $user.setName(data.firstName + " " + data.lastName);
                $user.setRole(data.type);
                console.log(currentEmail + currentPassword + data.firstName + data.lastName + data.type);
                $scope.showToast();
                $scope.hide();
                $state.go('home')
            }
        }).
        error(function(data, status, headers, config) {
            $toast.setText("Invalid e-mail/password combination");
            $scope.showToast();
        });
    }
}]);

