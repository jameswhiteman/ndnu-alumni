var app = angular.module('app');

app.controller('barCtrl', ['$scope','$mdDialog', '$state', 'User', function($scope, $mdDialog, $state, $user)
{
    $scope.loginText = "Log In";
	 $scope.showAdvanced = function(ev) {
         console.log($scope.identifier + ";" + $scope.verifier);
         if ($user.getIdentifier() != "" && $user.getVerifier() != "") {
             $user.setIdentifier("");
             $user.setVerifier("");
             $user.setName("");
             $user.setRole("");
             $scope.loginText = "Log In";
             $scope.updateControlPanelText();
             return;
         }
    $mdDialog.show({
      controller: DialogController,
      templateUrl: 'temp/logIn.html',
      targetEvent: ev,
    })
    .then(function(answer) {
      $scope.alert =  answer;
      $scope.updateControlPanelText();
      $scope.loginText = "Log Out";
    }, function() {
      $scope.alert = 'You cancelled the dialog.';
      $scope.updateControlPanelText();
      $scope.loginText = "Log Out";
    });
  };

  $scope.showControlPanel = function() {
      if ($user.getRole() === "User")
          $state.go("cpanel");
  };
$scope.cpanelText = "";
  $scope.updateControlPanelText = function() {
      if ($user.getRole() == "User") {
          $scope.cpanelText = "Control Panel";
      }
      else {
          $scope.cpanelText = "";
      }
  }
}]);

function DialogController($scope, $mdDialog) {
  $scope.hide = function() {
    $mdDialog.hide();
  };
  $scope.cancel = function() {
    $mdDialog.cancel();
  };
  $scope.answer = function(answer) {
    $mdDialog.hide(answer);
  };
}
